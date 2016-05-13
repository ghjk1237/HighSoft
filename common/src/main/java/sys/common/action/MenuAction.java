package sys.common.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import sys.common.page.model.DataGrid;
import sys.common.page.model.Menu;
import sys.common.page.model.User;
import sys.common.service.MenuService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("default")
// @Namespace("/")
@Action(value = "menuAction")
@Results(value={
		@Result(name="listByRoleId",location="/system/role/menuByRole.jsp")
	})
//listByRoleId
public class MenuAction extends BaseAction implements ModelDriven<Menu> {
	private static final Logger logger = Logger.getLogger(MenuAction.class);
	private Menu menu = new Menu();

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	private MenuService menuService;

	public MenuService getMenuService() {
		return menuService;
	}

	@Autowired
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public void list() {
		logger.info(menu.getId());
		List<Menu> menus = menuService.listById(menu.getId());		
		super.writeJson(menus);
	}

	public void listAll() {
		logger.info("listAll");
		List<Menu> menus = menuService.list();
		logger.info(menus.size());
		super.writeJson(menus);
	}

	@Override
	public Menu getModel() {
		// TODO Auto-generated method stub
		return menu;
	}
	public String listByRoleId() {
		String roleId = menu.getRoleId();
		logger.info("传入RoleId="+roleId);
		List<Menu> menus = new ArrayList<Menu>();
		menus=menuService.listByRoleId(roleId);
		DataGrid grid = new DataGrid();
		grid.setRows(menus);
		super.setAttribute("id", roleId);
		super.setAttribute("menus", grid);
		return "listByRoleId";
	}
	public void listByUserId() {
		Map session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		logger.info("userId="+user.getId());
		logger.info("menuId="+menu.getId());
		List<Menu> menus = new ArrayList<Menu>();
		menus=menuService.listByUserId(user.getId(), menu.getId());
		super.writeJson(menus);
	}
}
