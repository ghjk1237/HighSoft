package sys.common.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sys.common.dao.RoleDao;
import sys.common.dao.UserDao;
import sys.common.model.TBRole;
import sys.common.model.TBUser;
import sys.common.page.model.DataGrid;
import sys.common.page.model.User;
import sys.common.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	private static final Logger logger = Logger
			.getLogger(UserServiceImpl.class);
	private UserDao userDao;
	private RoleDao roleDao;
	
	public RoleDao getRoleDao() {
		return roleDao;
	}
	@Autowired
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public TBUser save(User user) {
		TBUser innerUser = new TBUser();
		BeanUtils.copyProperties(user, innerUser);
		innerUser.setId(UUID.randomUUID().toString());
		userDao.save(innerUser);
		// BeanUtils.copyProperties(innerUser, user);
		return innerUser;
	}

	@Override
	public User update(User user) {
		TBUser innerUser = new TBUser();
		innerUser = userDao.get(TBUser.class, user.getId());
		//BeanUtils.copyProperties(user, innerUser);
		innerUser.setCode(user.getCode());
		innerUser.setName(user.getName());
		innerUser.setEnable(user.isEnable());
		innerUser.setSex(user.getSex());
		innerUser.setBirth(user.getBirth());
		innerUser.setPassword(user.getPassword());
		String [] stringArr= user.getRoles().split(",");
		List<String> list = java.util.Arrays.asList(stringArr);
		Set<TBRole> tbRoles = new HashSet<TBRole>();
		for (String roleId : list) {
			TBRole tbRole = new TBRole();
			tbRole = roleDao.get(TBRole.class, roleId);
			if (tbRole != null) {
				tbRoles.add(tbRole);
			}
		}
		innerUser.setRoles(tbRoles);
		userDao.update(innerUser);
		return user;
	}

	@Override
	public DataGrid list(User user) {
		List<User> users = new ArrayList<User>();
		DataGrid grid = new DataGrid();
		String hql = "from TBUser";
		int total = userDao.count("select count(*) "+hql, null);
		grid.setTotal(total);
		grid.setPageCurrent(user.getPageCurrent());
		grid.setPageSize(user.getPageSize());
		List<TBUser> tbusers = userDao.find(hql + " order by code",null,user.getPageCurrent(),user.getPageSize());
		if (tbusers != null && tbusers.size() > 0) {
			for (TBUser tbuser : tbusers) {
				User u = new User();
				u.setId(tbuser.getId());
				u.setCode(tbuser.getCode());
				u.setName(tbuser.getName());
				u.setSex(tbuser.getSex());
				u.setBirth(tbuser.getBirth());
				u.setPassword(tbuser.getPassword());
				u.setEnable(tbuser.isEnable());
				String roles = "";
				if (tbuser.getRoles() != null && tbuser.getRoles().size()>0) {
					for (TBRole tbrole : tbuser.getRoles()) {
						roles = roles + tbrole.getId() + ",";
					}
					if (roles.length()>0) {
						roles = roles.substring(0, roles.length()-1);
					}
				} else {
					roles = "";
				}
				user.setRoles(roles);
				users.add(u);
			}
		}
		grid.setRows(users);
		return grid;
	}
	@Override
	public User add(User user) {
		TBUser tbUser = new TBUser();
		BeanUtils.copyProperties(user, tbUser);
		tbUser.setId(UUID.randomUUID().toString());
		if (user.getRoles() != null && user.getRoles().length() > 0) {
			Set<TBRole> roles = new HashSet();
			String[] arrRoles = user.getRoles().split(",");
			for (String roleid : arrRoles) {
				TBRole tbRole = roleDao.get(TBRole.class, roleid);
				if (tbRole != null) {
					roles.add(tbRole);
				}
			}
			tbUser.setRoles(roles);
		}
		userDao.save(tbUser);
		user.setId(tbUser.getId());
		return user;
	}
	@Override
	public User ListById(String id) {
		logger.info("get user by id begin");
		TBUser tbUser = userDao.get(TBUser.class,id);
		User user = new User();
		user.setId(tbUser.getId());
		user.setCode(tbUser.getCode());
		user.setName(tbUser.getName());
		user.setSex(tbUser.getSex());
		user.setBirth(tbUser.getBirth());
		user.setPassword(tbUser.getPassword());
		user.setEnable(tbUser.isEnable());
		String roles = "";
		if (tbUser.getRoles() != null) {
			logger.info("none role");
		} else {
			logger.info("with role");
		}
		if (tbUser.getRoles() != null) {
			for (TBRole role : tbUser.getRoles()) {
				roles = roles + role.getId() + ",";
			}
		}
		if (roles.length() > 0) {
			roles.substring(0, roles.length() - 1);
		}
		user.setRoles(roles);
		return user;
	}
	@Override
	public User find(String code, String password) {
		User user = new User();
		TBUser tbUser;
		String hql = "from TBUser t where code=:code and password=:password and enable=:enable";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", code);
		params.put("password", password);
		params.put("enable", true);
		tbUser = userDao.get(hql, params);
		if (tbUser != null) {
			user.setId(tbUser.getId());
			user.setCode(tbUser.getCode());
			user.setName(tbUser.getName());
			user.setSex(tbUser.getSex());
			user.setBirth(tbUser.getBirth());
			user.setEnable(tbUser.isEnable());
			String roles = "";
			if (tbUser.getRoles() != null && tbUser.getRoles().size()>0) {
				for (TBRole tbRole : tbUser.getRoles()) {
					roles = roles + tbRole.getId() + ",";
				}
				if (roles.length()>0) {
					roles = roles.substring(0, roles.length()-1);
				}
			}
			user.setRoles(roles);
		} else {
			user = null;
		}
		return user;
	}
	@Override
	public DataGrid selectUser(User user) {
		List<User> users = new ArrayList<User>();
		DataGrid grid = new DataGrid();
		String hql;
		if (user.getCode() == null ||user.getCode().toString().trim().equals("")) {
			hql = "from TBUser";
		} else {
			hql = "from TBUser where code like '%"+user.getCode().toString().trim()+"%'";
		}		
		int total = userDao.count("select count(*) "+hql, null);
		grid.setTotal(total);
		grid.setPageCurrent(user.getPageCurrent());
		grid.setPageSize(user.getPageSize());
		List<TBUser> tbusers = userDao.find(hql + " order by code",null,user.getPageCurrent(),user.getPageSize());
		if (tbusers != null && tbusers.size() > 0) {
			for (TBUser tbuser : tbusers) {
				User u = new User();
				u.setId(tbuser.getId());
				u.setCode(tbuser.getCode());
				u.setName(tbuser.getName());
				u.setSex(tbuser.getSex());
				u.setBirth(tbuser.getBirth());
				u.setPassword(tbuser.getPassword());
				u.setEnable(tbuser.isEnable());
				String roles = "";
				if (tbuser.getRoles() != null && tbuser.getRoles().size()>0) {
					for (TBRole tbrole : tbuser.getRoles()) {
						roles = roles + tbrole.getId() + ",";
					}
					if (roles.length()>0) {
						roles = roles.substring(0, roles.length()-1);
					}
				} else {
					roles = "";
				}
				user.setRoles(roles);
				users.add(u);
			}
		}
		grid.setRows(users);
		return grid;
	}
}
