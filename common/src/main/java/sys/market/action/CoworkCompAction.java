package sys.market.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import sys.common.action.BaseAction;
import sys.market.page.model.CoworkCompany;
import sys.market.page.model.DataGrid;
import sys.market.page.model.Json;
import sys.market.service.CoworkCompService;

import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("default")
@Namespace("/market/hzdw")
@Action(value="coworkCompAction")
@Results(value={
		@Result(name="list",location="/market/hzdw/show.jsp"),
		@Result(name="detail",location="/market/hzdw/detail.jsp"),
		@Result(name="selectComp",location="/market/hzdw/selectComp.jsp")
	})
public class CoworkCompAction extends BaseAction implements ModelDriven<CoworkCompany> {
	CoworkCompany coworkComp = new CoworkCompany();
	private CoworkCompService coworkCompService;
	
	@Override
	public CoworkCompany getModel() {
		// TODO Auto-generated method stub
		return coworkComp;
	}

	public CoworkCompService getCoworkCompService() {
		return coworkCompService;
	}
	@Autowired
	public void setCoworkCompService(CoworkCompService coworkCompService) {
		this.coworkCompService = coworkCompService;
	}
	public String list() {
		int pageSize=coworkComp.getPageSize();
		int currPage=coworkComp.getPageCurrent();
		if (pageSize == 0) {
			pageSize = 10;
		}
		if (currPage == 0) {
			currPage = 1;
		}
		DataGrid grid= coworkCompService.list(pageSize, currPage);
		super.setAttribute("coworkcomplist", grid);
		return "list";
	}
	public void add() {
		Json json = new Json();
		CoworkCompany cowork = null;
		try {
			cowork=coworkCompService.add(coworkComp);
		} catch (Exception ex) {
			json.setSuccess(false);
			json.setMsg(ex.getMessage());
			super.writeJson(json);
		}
		json.setSuccess(true);
		json.setMsg("添加合作单位成功!");
		super.writeJson(json);
	}
	public String detail() {
		CoworkCompany cc = null;
		try {
			cc = coworkCompService.detail(coworkComp.getId());
		} catch (Exception e) {
			
		}
		super.setAttribute("coworkComp", cc);
		return "detail";
	}
	public void edit() {
		Json json = new Json();
		try {
			coworkCompService.update(coworkComp);
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("编辑合作单位出错-"+e.getMessage());
			super.writeJson(json);
		}
		json.setSuccess(true);
		json.setMsg("编辑合作单位成功!");
		super.writeJson(json);
		
	}
	public String selectComp() {
		DataGrid grid = null;
		if (coworkComp.getPageSize()==0) {
			coworkComp.setPageSize(10);
		}
		if (coworkComp.getPageCurrent()==0){
			coworkComp.setPageCurrent(1);
		}
		try {
			grid = coworkCompService.selectComp(coworkComp);
		} catch (Exception ex) {
			
		}
		super.setAttribute("compList", grid);
		return "selectComp";
	}
}
