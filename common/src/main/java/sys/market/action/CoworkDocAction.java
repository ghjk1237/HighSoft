package sys.market.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import sys.common.action.BaseAction;
import sys.market.page.model.CoworkDoctor;
import sys.market.page.model.DataGrid;
import sys.market.page.model.Json;
import sys.market.service.CoworkDocService;

import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("default")
@Namespace("/market/hzys")
@Action(value="coworkDocAction")
@Results(value={
		@Result(name="list",location="/market/hzys/show.jsp"),
		@Result(name="detail",location="/market/hzys/detail.jsp"),
		@Result(name="selectDoc",location="/market/hzys/selectDoc.jsp")
	})
public class CoworkDocAction extends BaseAction implements ModelDriven<CoworkDoctor> {
	CoworkDoctor coworkDoc = new CoworkDoctor();
	private CoworkDocService coworkDocService;
	
	@Override
	public CoworkDoctor getModel() {
		// TODO Auto-generated method stub
		return coworkDoc;
	}
	
	public CoworkDocService getCoworkDocService() {
		return coworkDocService;
	}
	@Autowired
	public void setCoworkDocService(CoworkDocService coworkDocService) {
		this.coworkDocService = coworkDocService;
	}

	public String list() {
		int pageSize=coworkDoc.getPageSize();
		int currPage=coworkDoc.getPageCurrent();
		if (pageSize == 0) {
			pageSize = 10;
		}
		if (currPage == 0) {
			currPage = 1;
		}
		DataGrid grid= coworkDocService.list(pageSize, currPage);
		super.setAttribute("coworkdoclist", grid);
		return "list";
	}
	public void add() {
		Json json = new Json();
		CoworkDoctor cowork = null;
		try {
			cowork=coworkDocService.add(coworkDoc);
		} catch (Exception ex) {
			json.setSuccess(false);
			json.setMsg(ex.getMessage());
			super.writeJson(json);
		}
		json.setSuccess(true);
		json.setMsg("添加合作医生成功!");
		super.writeJson(json);
	}
	public String detail() {
		CoworkDoctor cc = null;
		try {
			cc = coworkDocService.detail(coworkDoc.getId());
		} catch (Exception e) {
			
		}
		super.setAttribute("coworkDoc", cc);
		return "detail";
	}
	public void edit() {
		Json json = new Json();
		try {
			coworkDocService.update(coworkDoc);
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("编辑合作医生出错-"+e.getMessage());
			super.writeJson(json);
		}
		json.setSuccess(true);
		json.setMsg("编辑合作医生成功!");
		super.writeJson(json);
	}
	public String selectDoc() {
		DataGrid grid = null;
		if (coworkDoc.getPageSize()==0) {
			coworkDoc.setPageSize(10);
		}
		if (coworkDoc.getPageCurrent()==0){
			coworkDoc.setPageCurrent(1);
		}
		try {
			grid = coworkDocService.selectComp(coworkDoc);
		} catch (Exception ex) {
			
		}
		super.setAttribute("docList", grid);
		return "selectDoc";
	}
}
