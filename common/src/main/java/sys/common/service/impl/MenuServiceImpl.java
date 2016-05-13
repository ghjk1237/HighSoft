package sys.common.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sys.common.dao.MenuDao;
import sys.common.dao.RoleDao;
import sys.common.dao.UserDao;
import sys.common.model.TBMenu;
import sys.common.model.TBRole;
import sys.common.model.TBUser;
import sys.common.page.model.Menu;
import sys.common.service.MenuService;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
	private static final Logger logger = Logger
			.getLogger(MenuServiceImpl.class);

	private MenuDao menuDao;
	private RoleDao roleDao;
	private UserDao userDao;
	

	public UserDao getUserDao() {
		return userDao;
	}
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public MenuDao getMenuDao() {
		return menuDao;
	}

	@Autowired
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}
	
	public RoleDao getRoleDao() {
		return roleDao;
	}
	@Autowired
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public List<Menu> list() {
		logger.info("list");
		List<TBMenu> tbMenus = new ArrayList<TBMenu>();
		List<Menu> menus = new ArrayList<Menu>();
		String hql;
		hql = "from TBMenu";
		tbMenus = menuDao.find(hql);
		if (tbMenus != null && tbMenus.size() > 0) {
			for (TBMenu tbMenu : tbMenus) {
				Menu menu = new Menu();
				menu.setId(tbMenu.getId());
				menu.setUrl(tbMenu.getUrl());
				menu.setTxt(tbMenu.getTxt());
				if (tbMenu.getTBMenu() != null) {
					menu.setParentId(tbMenu.getTBMenu().getId());
				} else {
					menu.setParentId("0");
				}
				menus.add(menu);
			}
		}
		logger.info(tbMenus.size());
		return menus;
	}

	@Override
	public List<Menu> listById(String id) {
		List<TBMenu> tbMenus = new ArrayList<TBMenu>();
		List<Menu> menus = new ArrayList<Menu>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql;
		if (id == null || id == "") {
			hql = "from TBMenu t where t.TBMenu.id is null";
		} else {
			hql = "from TBMenu t where t.TBMenu.id = :id";
			params.put("id", id);
		}
		tbMenus = menuDao.find(hql, params);
		if (tbMenus != null && tbMenus.size() > 0) {
			for (TBMenu tbMenu : tbMenus) {
				Menu menu = new Menu();
				menu.setId(tbMenu.getId());
				menu.setUrl(tbMenu.getUrl());
				menu.setTxt(tbMenu.getTxt());
				if (tbMenu.getTBMenu() != null) {
					menu.setParentId(tbMenu.getTBMenu().getId());
				} else {
					menu.setParentId("0");
				}
				menus.add(menu);
			}
		}
		logger.info(id);
		return menus;
	}
	@Override
	public List<Menu> listMenu() {
		List<TBMenu> tbMenus = new ArrayList<TBMenu>();
		List<Menu> menus = new ArrayList<Menu>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql;
		hql = "from TBMenu t where t.TBMenu.id is null and TBMenus is null";
		tbMenus = menuDao.find(hql, params);
		if (tbMenus != null && tbMenus.size() > 0) {
			for (TBMenu tbMenu : tbMenus) {
				Menu menu = new Menu();
				menu.setId(tbMenu.getId());
				menu.setUrl(tbMenu.getUrl());
				menu.setTxt(tbMenu.getTxt());
				if (tbMenu.getTBMenu() != null) {
					menu.setParentId(tbMenu.getTBMenu().getId());
				} else {
					menu.setParentId("0");
				}
				menus.add(menu);
			}
		}
		return menus;
	}
	@Override
	public List<Menu> listByRoleId(String roleId) {
		List<Menu> menus = new ArrayList<Menu>();
		List<TBMenu> tbMenus = new ArrayList<TBMenu>();
		TBRole tbRole = new TBRole();
		tbRole=roleDao.get(TBRole.class, roleId);
		String hql="from TBMenu";
		
		tbMenus = menuDao.find(hql);
		if (tbRole.getMenus() != null && tbRole.getMenus().size()>0) {
			for (TBMenu tbMenu : tbMenus) {
				Menu menu = new Menu();
				if (tbRole.getMenus().contains(tbMenu)) {					
					menu.setId(tbMenu.getId());
					menu.setTxt(tbMenu.getTxt());
					menu.setUrl(tbMenu.getUrl());
					if (tbMenu.getTBMenu() != null ) {
						menu.setParentId(tbMenu.getTBMenu().getId());
					} else {
						menu.setParentId("0");
					}
					menu.setChecked(true);
				} else {
					menu.setId(tbMenu.getId());
					menu.setTxt(tbMenu.getTxt());
					menu.setUrl(tbMenu.getUrl());
					if (tbMenu.getTBMenu() != null ) {
						menu.setParentId(tbMenu.getTBMenu().getId());
					} else {
						menu.setParentId("0");
					}
					menu.setChecked(false);
				}
				menus.add(menu);
			}
		} else {
			for (TBMenu tbMenu : tbMenus) {
				Menu menu = new Menu();
				menu.setId(tbMenu.getId());
				menu.setTxt(tbMenu.getTxt());
				menu.setUrl(tbMenu.getUrl());
				if (tbMenu.getTBMenu() != null ) {
					menu.setParentId(tbMenu.getTBMenu().getId());
				} else {
					menu.setParentId("0");
				}
				menu.setChecked(false);
				menus.add(menu);
			}
		}
		return menus;
	}
	@Override
	public List<Menu> listByUserId(String userId,String id) {
		Set<Menu> menus = new HashSet<Menu>();
		TBUser tbUser = userDao.get(TBUser.class, userId);
		if (tbUser != null) {
			if (tbUser.getRoles() != null && tbUser.getRoles().size()>0) {
				for (TBRole tbRole : tbUser.getRoles()) {
					if (tbRole.getMenus() != null && tbRole.getMenus().size()>0) {
						for (TBMenu tbMenu : tbRole.getMenus()) {
							Menu menu = new Menu();
							menu.setId(tbMenu.getId());
							menu.setTxt(tbMenu.getTxt());
							menu.setUrl(tbMenu.getUrl());
							if (tbMenu.getTBMenu() != null) {
								menu.setParentId(tbMenu.getTBMenu().getId());
							} else {
								menu.setParentId("0");
							}
							if (id != null && id != "") {
								if (menu.getParentId().equals(id)) {
									menus.add(menu);
								}
							} else {
								if (menu.getParentId()=="0") {
									menus.add(menu);
								}
							}
						}
					}
				}
			}
		}
		logger.info(menus.size());
		List<Menu> menuList = new ArrayList<Menu>();
		menuList.clear();
		menuList.addAll(menus);
		logger.info(menus.size());
		return menuList;
	}
}
