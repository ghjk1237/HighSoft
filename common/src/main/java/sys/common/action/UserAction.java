package sys.common.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import sys.common.page.model.DataGrid;
import sys.common.page.model.Json;
import sys.common.page.model.User;
import sys.common.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("default")
// @Namespace("/")
@Action(value = "userAction")
@Results(value={
		@Result(name="list",location="/system/user/show.jsp"),
		@Result(name="detail",location="/system/user/detail.jsp"),
		@Result(name="detail2",location="/system/user/edit.jsp"),
		@Result(name="listRole",location="/system/user/roleByUser.jsp"),
		@Result(name="login_seccess",location="/index.jsp",type="redirect"),
		@Result(name="login_fail",location="/system/common/login.jsp",type="redirect"),
		@Result(name="logout_success",location="/system/common/login.jsp",type="redirect"),
		@Result(name="selectUser",location="/system/user/selectUser.jsp")
	})
public class UserAction extends BaseAction implements ModelDriven<User> {
	private String functionInfo;
	private static final Logger logger = Logger.getLogger(UserAction.class);
	private UserService userService;
	User user = new User();
	private Json json = new Json();

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	/**
	 * 新增用户
	 **/
	public void add() {
		functionInfo = "添加角色信息";
		User retUser = new User();
		logger.info(functionInfo+"-开始");
		try {
			retUser = userService.add(user);
		} catch (Exception ex) {
			logger.error(functionInfo + "-异常" + ex.getMessage());
			json.setSuccess(false);
			json.setMsg(functionInfo + "-异常");
			json.setResult(ex);
			super.writeJson(json);
		}
		if (retUser != null) {
			json.setSuccess(true);
			json.setMsg("添加用户-成功");
			json.setResult(retUser);
		} else {
			json.setSuccess(false);
			json.setMsg("添加用户-出错");
			json.setResult(null);
		}
		logger.info(functionInfo + "-结束");
		super.writeJson(json);
	}

	/**
	 * 用户登陆
	 **/
	public String login() {
		String code = user.getCode();
		String password = user.getPassword();
		User retUser;
		retUser = userService.find(code, password);
		if (retUser != null) {
			Map session = ActionContext.getContext().getSession();
			session.put("user", retUser);			
			return "login_seccess";
		} else {
			return "login_fail";
		}			
	}

	/**
	 * 用户登出
	 **/
	public String logout() {
		Map session = ActionContext.getContext().getSession();
		session.put("user", null);			
		return "logout_success";
	}

	public String list() {
		functionInfo = "查询用户信息";
		logger.info(functionInfo + "-开始");
		DataGrid grid = new DataGrid(); 
		List<User> users = new ArrayList<User>();
		if (user.getPageSize()==0) {
			user.setPageSize(10);
		}
		if (user.getPageCurrent()==0){
			user.setPageCurrent(1);
		}
		try {
			grid = userService.list(user);
		} catch (Exception ex) {
			logger.error(functionInfo + "-异常" + ex.getMessage());
		}
		super.setAttribute("userList", grid);
		return "list";
	}
	public String detail2() {
		functionInfo = "查询用户信息";
		logger.info(functionInfo + "-开始");
		User retUser = new User();
		try {
			retUser = userService.ListById(user.getId());
		} catch (Exception ex) {
			json.setSuccess(false);
			json.setMsg(functionInfo + "-异常");
			json.setResult(ex);
			super.writeJson(json);
		}
		if (retUser != null) {
			json.setSuccess(true);
			json.setMsg(functionInfo + "-成功");
		} else {
			json.setSuccess(false);
			json.setMsg(functionInfo + "-出错");
		}
		logger.info(functionInfo + "-结束");
		super.setAttribute("userInfo", retUser);
		return "detail2";
	}
	public void update() {
		functionInfo = "更新用信息";
		User retUser = new User();
		User u = userService.ListById(user.getId()); 
		user.setRoles(u.getRoles());
		logger.info(functionInfo + "-开始");
		try {
			retUser = userService.update(user);
		} catch (Exception ex) {
			logger.error(functionInfo + "-异常" + ex.getMessage());
			json.setSuccess(false);
			json.setMsg(functionInfo + "-异常");
			json.setResult(ex);
			super.writeJson(json);
		}
		if (retUser != null) {
			json.setSuccess(true);
			json.setMsg(functionInfo + "-成功");
			json.setResult(retUser);
		} else {
			json.setSuccess(false);
			json.setMsg(functionInfo + "-出错");
			json.setResult(null);
		}
		logger.info(functionInfo + "-结束");
		super.writeJson(json);
	}
	public void updateRole() {
		functionInfo = "更新用户信息对应的角色";
		User retUser = new User();
		User u = userService.ListById(user.getId()); 
		user.setCode(u.getCode());
		user.setName(u.getName());
		user.setEnable(u.isEnable());
		user.setSex(u.getSex());
		user.setBirth(u.getBirth());
		//user.setBirth(u.getBirth());
		user.setPassword(u.getPassword());
		logger.info(user.getRoles());
		json.setMsg(functionInfo + "-开始");
		try {
			retUser = userService.update(user);
		} catch (Exception ex) {
			logger.error(functionInfo + "-异常" + ex.getMessage());
			json.setSuccess(false);
			json.setMsg(functionInfo + "-异常");
			json.setResult(ex);
			super.writeJson(json);
		}
		if (retUser != null) {
			json.setSuccess(true);
			json.setMsg(functionInfo + "-成功");
			json.setResult(retUser);
		} else {
			json.setSuccess(false);
			json.setMsg(functionInfo + "-出错");
			json.setResult(null);
		}
		logger.info(functionInfo + "-结束");
		super.writeJson(json);
	}
	public String selectUser() {
		DataGrid grid = null;
		if (user.getPageSize()==0) {
			user.setPageSize(10);
		}
		if (user.getPageCurrent()==0){
			user.setPageCurrent(1);
		}
		try {
			grid = userService.selectUser(user);
		} catch (Exception ex) {
			logger.error(functionInfo + "-异常" + ex.getMessage());
		}
		super.setAttribute("userList", grid);
		return "selectUser";
	}
}
