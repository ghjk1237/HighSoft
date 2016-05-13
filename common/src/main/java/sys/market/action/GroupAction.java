package sys.market.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import sys.common.action.BaseAction;
import sys.market.page.model.DataGrid;
import sys.market.page.model.Group;
import sys.market.page.model.Json;
import sys.market.service.GroupService;

import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("default")
@Namespace("/market/group")
@Action(value="groupAction")
@Results(value={
		@Result(name="list",location="/market/group/show.jsp"),
		@Result(name="detail",location="/market/group/detail.jsp"),
		@Result(name="listUser",location="/market/group/listUser.jsp"),
		@Result(name="selectMem",location="/market/group/selectMem.jsp")
	})
public class GroupAction extends BaseAction implements ModelDriven<Group> {
	private GroupService groupService;
	Group group = new Group();

	public GroupService getGroupService() {
		return groupService;
	}
	@Autowired
	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}
	@Override
	public Group getModel() {
		return group;
	}
	
	public String list() {
		int pageSize=group.getPageSize();
		int currPage=group.getPageCurrent();
		if (pageSize == 0) {
			pageSize = 10;
		}
		if (currPage == 0) {
			currPage = 1;
		}
		DataGrid grid= groupService.list(pageSize, currPage);
		super.setAttribute("groplist", grid);
		return "list";
	}
	public void add() {
		Json json = new Json();
		Group innerGroup = groupService.add(group);
		if (innerGroup == null) {
			json.setSuccess(false);
			json.setMsg("添加组失败");
		} else {
			json.setSuccess(true);
			json.setMsg("添加组成功");
		}
		super.writeJson(json);
	}
	public String detail() {
		Group innerGroup = null;
		try {
			innerGroup = groupService.detail(group.getId());
		} catch (Exception ex) {
			
		}
		super.setAttribute("groupInfo", innerGroup);
		return "detail";
	}
	public void edit() {
		Json json = new Json();
		Group innerGroup = null;
		try {
			innerGroup = groupService.update(group);
		} catch (Exception ex) {
			json.setSuccess(false);
			json.setMsg("编辑组失败");
			super.writeJson(json);
		}
		json.setSuccess(true);
		json.setMsg("编辑组成功");
		super.writeJson(json);
	}
	public String listUser() {
		DataGrid grid = new DataGrid();
		try {
			grid = groupService.listUser(group.getId());
		} catch (Exception ex) {
			
		}
		super.setAttribute("groupuser", grid);
		super.setAttribute("groupId", group.getId());
		return "listUser";
	}
	public void updateUser() {
		Json json = new Json();
		String [] users= group.getUsers().split(",");
		try {
			groupService.updateUser(group.getId(), users);
		} catch (Exception ex) {
			json.setMsg("更新组成员出错-"+ex.getMessage());
			json.setSuccess(false);
		}
		json.setMsg("更新组成员成功!");
		json.setSuccess(true);
		super.writeJson(json);
	}
	public String selectMem() {
		String code = group.getCode();
		DataGrid grid = new DataGrid();
		try {
			grid = groupService.selectMem(code);
		} catch (Exception ex) {
			
		}
		super.setAttribute("memList", grid);
		return "selectMem";
	}
	
}
