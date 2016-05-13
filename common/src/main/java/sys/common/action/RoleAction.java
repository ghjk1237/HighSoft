package sys.common.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import sys.common.page.model.DataGrid;
import sys.common.page.model.Json;
import sys.common.page.model.Role;
import sys.common.service.RoleService;

import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("default")
@Namespace("/system/role")
@Action(value="roleAction")
@Results(value={
		@Result(name="list",location="/system/role/show.jsp"),
		@Result(name="detail",location="/system/role/detail.jsp"),
		@Result(name="detail2",location="/system/role/edit.jsp"),
		@Result(name="listByUserId",location="/system/user/roleByUser.jsp")
	})
public class RoleAction extends BaseAction implements ModelDriven<Role> {
	private String functionInfo;
	private static final Logger logger = Logger.getLogger(RoleAction.class);
	Role role = new Role();
	private RoleService roleService;
	private Json json;
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public Role getModel() {
		// TODO Auto-generated method stub
		return role;
	}
	public RoleService getRoleService() {
		return roleService;
	}
	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	public Json getJson() {
		return json;
	}
	@Autowired
	public void setJson(Json json) {
		this.json = json;
	}
	//显示角色列表
	public String list() {
		functionInfo = "查询角色信息";
		logger.info(functionInfo + "-开始");
		DataGrid grid = new DataGrid(); 
		List<Role> roles = new ArrayList<Role>();
		if (role.getPageSize()==0) {
			role.setPageSize(10);
		}
		if (role.getPageCurrent()==0){
			role.setPageCurrent(1);
		}
		try {
			grid = roleService.list(role);
		} catch (Exception ex) {
			logger.error(functionInfo + "-异常" + ex.getMessage());
			json.setSuccess(false);
			json.setMsg(functionInfo + "-异常");
			json.setResult(ex);
			super.writeJson(json);
		}
		if (roles != null) {
			json.setSuccess(true);
			json.setMsg(functionInfo + "-成功");
		} else {
			json.setSuccess(false);
			json.setMsg(functionInfo + "-出错");
		}
		super.setAttribute("roleList", grid);
		logger.info(functionInfo + "-结束");
		return "list";
	}
	//显示角色详情
	public String detail() {
		functionInfo = "查询角色信息";
		logger.info(functionInfo + "-开始");
		Role retRole = new Role();
		try {
			retRole = roleService.ListById(role.getId());
		} catch (Exception ex) {
			json.setSuccess(false);
			json.setMsg(functionInfo + "-异常");
			json.setResult(ex);
			super.writeJson(json);
		}
		if (retRole != null) {
			json.setSuccess(true);
			json.setMsg(functionInfo + "-成功");
			//json.setResult(retRole);
		} else {
			json.setSuccess(false);
			json.setMsg(functionInfo + "-出错");
			//json.setResult(null);
		}
		logger.info(functionInfo + "-结束");
		super.setAttribute("roleInfo", retRole);
		return "detail";
	}
	//显示角色详情
	public String detail2() {
		functionInfo = "查询角色信息";
		logger.info(functionInfo + "-开始");
		logger.info(role.getId());
		Role retRole = new Role();
		try {
			retRole = roleService.ListById(role.getId());
		} catch (Exception ex) {
			json.setSuccess(false);
			json.setMsg(functionInfo + "-异常");
			json.setResult(ex);
			super.writeJson(json);
		}
		if (retRole != null) {
			json.setSuccess(true);
			json.setMsg(functionInfo + "-成功");
			//json.setResult(retRole);
		} else {
			json.setSuccess(false);
			json.setMsg(functionInfo + "-出错");
			//json.setResult(null);
		}
		logger.info(functionInfo + "-结束");
		super.setAttribute("roleInfo", retRole);
		return "detail2";
	}
	//添加角色
	public void add() {
		functionInfo = "添加角色信息";
		Role retRole = new Role();
		json.setMsg(functionInfo + "-开始");
		try {
			retRole = roleService.add(role);
		} catch (Exception ex) {
			logger.error(functionInfo + "-异常" + ex.getMessage());
			json.setSuccess(false);
			json.setMsg(functionInfo + "-异常");
			json.setResult(ex);
			super.writeJson(json);
		}
		if (retRole != null) {
			json.setSuccess(true);
			json.setMsg(functionInfo + "-成功");
			json.setResult(retRole);
		} else {
			json.setSuccess(false);
			json.setMsg(functionInfo + "-出错");
			json.setResult(null);
		}
		logger.info(functionInfo + "-结束");
		super.writeJson(json);
	}
	//更新角色信息
	public void update() {
		functionInfo = "更新角色信息";
		Role retRole = new Role();
		Role r = roleService.ListById(role.getId()); 
		role.setMenus(r.getMenus());
		json.setMsg(functionInfo + "-开始");
		try {
			retRole = roleService.update(role);
		} catch (Exception ex) {
			logger.error(functionInfo + "-异常" + ex.getMessage());
			json.setSuccess(false);
			json.setMsg(functionInfo + "-异常");
			json.setResult(ex);
			super.writeJson(json);
		}
		if (retRole != null) {
			json.setSuccess(true);
			json.setMsg(functionInfo + "-成功");
			json.setResult(retRole);
		} else {
			json.setSuccess(false);
			json.setMsg(functionInfo + "-出错");
			json.setResult(null);
		}
		logger.info(functionInfo + "-结束");
		super.writeJson(json);
	}
	//更新角色信息
	public void updateMenu() {
		functionInfo = "更新角色信息对应的权限";
		Role retRole = new Role();
		Role r = roleService.ListById(role.getId()); 
		role.setCode(r.getCode());
		role.setEnable(r.isEnable());
		role.setName(r.getName());
		logger.info(role.getMenus());
		json.setMsg(functionInfo + "-开始");
		try {
			retRole = roleService.update(role);
		} catch (Exception ex) {
			logger.error(functionInfo + "-异常" + ex.getMessage());
			json.setSuccess(false);
			json.setMsg(functionInfo + "-异常");
			json.setResult(ex);
			super.writeJson(json);
		}
		if (retRole != null) {
			json.setSuccess(true);
			json.setMsg(functionInfo + "-成功");
			json.setResult(retRole);
		} else {
			json.setSuccess(false);
			json.setMsg(functionInfo + "-出错");
			json.setResult(null);
		}
		logger.info(functionInfo + "-结束");
		super.writeJson(json);
	}
	public String listByUserId() {
		String userId = role.getUserId();
		logger.info("传入UserId="+userId);
		List<Role> roles = new ArrayList<Role>();
		//menus=menuService.listByRoleId(roleId);
		roles = roleService.ListByUserId(userId);				
		DataGrid grid = new DataGrid();
		grid.setRows(roles);
		super.setAttribute("id", userId);
		super.setAttribute("roles", grid);
		return "listByUserId";
	}
}
