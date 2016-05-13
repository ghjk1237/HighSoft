package sys.common.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sys.common.dao.MenuDao;
import sys.common.dao.RoleDao;
import sys.common.dao.UserDao;
import sys.common.model.TBMenu;
import sys.common.model.TBRole;
import sys.common.model.TBUser;
import sys.common.page.model.DataGrid;
import sys.common.page.model.Role;
import sys.common.service.RoleService;

@Repository("roleService")
public class RoleServiceImpl implements RoleService {
	private static final Logger logger = Logger.getLogger(RoleServiceImpl.class);
	private RoleDao roleDao;
	private UserDao userDao;
	private MenuDao menuDao;
	

	public MenuDao getMenuDao() {
		return menuDao;
	}
	@Autowired
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	@Autowired
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public DataGrid list(Role role) {
		List<Role> roles = new ArrayList<Role>();
		List<TBRole> tbRoles = new ArrayList<TBRole>();
		DataGrid grid = new DataGrid();
		String hql = "from TBRole";
		int total = roleDao.count("select count(*) "+hql, null);
		grid.setTotal(total);
		grid.setPageCurrent(role.getPageCurrent());
		grid.setPageSize(role.getPageSize());
		tbRoles = roleDao.find(hql + " order by code",null,role.getPageCurrent(),role.getPageSize());
		if (tbRoles != null && tbRoles.size() > 0) {
			for (TBRole tbRole : tbRoles) {
				Role r = new Role();
				r.setId(tbRole.getId());
				r.setCode(tbRole.getCode());
				r.setName(tbRole.getName());
				r.setEnable(tbRole.isEnable());
				String menus = "";
				if (tbRole.getMenus() != null) {
					logger.info("none menu");
				} else {
					logger.info("with menu");
				}
				if (tbRole.getMenus() != null) {
					for (TBMenu menu : tbRole.getMenus()) {
						menus = menus + menu.getId() + ",";
					}
				}
				if (menus.length() > 0) {
					menus.substring(0, menus.length() - 1);
				}
				role.setMenus(menus);
				roles.add(r);
			}
		}
		grid.setRows(roles);
		return grid;
	}

	@Override
	public Role add(Role role) {
		logger.info("add role begin");
		TBRole tbRole = new TBRole();

		BeanUtils.copyProperties(role, tbRole);
		tbRole.setId(UUID.randomUUID().toString());
		if (role.getMenus() != null && role.getMenus().length() > 0) {
			Set<TBMenu> menus = new HashSet();
			String[] arrMenus = role.getMenus().split(",");
			for (String menuid : arrMenus) {
				TBMenu tbMenu = menuDao.get(TBMenu.class, menuid);
				if (tbMenu != null) {
					menus.add(tbMenu);
				}
			}
			tbRole.setMenus(menus);
		}
		roleDao.save(tbRole);
		role.setId(tbRole.getId());
		logger.info("add role end [" + role.getId() + "]");
		return role;
	}

	@Override
	public Role ListById(String id) {
		logger.info("get role by id begin");
		TBRole tbRole = roleDao.get(TBRole.class,id);
		Role role = new Role();
		role.setId(tbRole.getId());
		role.setCode(tbRole.getCode());
		role.setName(tbRole.getName());
		role.setEnable(tbRole.isEnable());
		String menus = "";
		if (tbRole.getMenus() != null) {
			logger.info("none menu");
		} else {
			logger.info("with menu");
		}
		if (tbRole.getMenus() != null) {
			for (TBMenu menu : tbRole.getMenus()) {
				menus = menus + menu.getId() + ",";
			}
		}
		if (menus.length() > 0) {
			menus.substring(0, menus.length() - 1);
		}
		role.setMenus(menus);
		return role;
	}

	@Override
	public Role update(Role role) {
		logger.info("upate begin");
		TBRole tbRole = roleDao.get(TBRole.class,role.getId());
		tbRole.setCode(role.getCode());
		tbRole.setName(role.getName());
		tbRole.setEnable(role.isEnable());
		String [] stringArr= role.getMenus().split(",");
		List<String> list = java.util.Arrays.asList(stringArr);
		Set<TBMenu> tbMenus = new HashSet<TBMenu>();
		for (String menuId : list) {
			TBMenu tbMenu = new TBMenu();
			tbMenu = menuDao.get(TBMenu.class, menuId);
			if (tbMenu != null) {
				tbMenus.add(tbMenu);
			}
		}
		tbRole.setMenus(tbMenus);
		roleDao.update(tbRole);
		return role;
	}
	@Override
	public List<Role> ListByUserId(String userId) {
		// TODO Auto-generated method stub
		List<Role> roles = new ArrayList<Role>();
		List<TBRole> tbRoles = new ArrayList<TBRole>();
		TBUser tbUser = new TBUser();
		tbUser=userDao.get(TBUser.class, userId);
		String hql = "from TBRole";
		tbRoles = roleDao.find(hql);
		if (tbUser.getRoles() != null && tbUser.getRoles().size()>0) {
			for (TBRole tbRole : tbRoles) {
				Role role = new Role();
				if (tbUser.getRoles().contains(tbRole)) {
					role.setId(tbRole.getId());
					role.setCode(tbRole.getCode());
					role.setName(tbRole.getName());
					role.setChecked(true);
				} else {
					role.setId(tbRole.getId());
					role.setCode(tbRole.getCode());
					role.setName(tbRole.getName());
					role.setChecked(false);
				}
				roles.add(role);
			}
		} else {
			for (TBRole tbRole : tbRoles) {
				Role role = new Role();
				role.setId(tbRole.getId());
				role.setCode(tbRole.getCode());
				role.setName(tbRole.getName());
				role.setChecked(false);
				roles.add(role);
			}
		}
		return roles;
	}
}
