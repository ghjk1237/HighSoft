package sys.common.service;

import java.util.List;

import sys.common.page.model.Menu;

public interface MenuService {
	public List<Menu> list();

	public List<Menu> listById(String id);
	
	public List<Menu> listMenu();
	
	public List<Menu> listByRoleId(String roleId);
	public List<Menu> listByUserId(String userId,String id);
}
