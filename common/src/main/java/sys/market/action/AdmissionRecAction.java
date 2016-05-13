package sys.market.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import sys.market.page.model.AdmissionRecord;
import sys.market.page.model.DataGrid;
import sys.market.page.model.Json;
import sys.market.service.AdmissionRecordService;

import com.opensymphony.xwork2.ModelDriven;
@ParentPackage("default")
@Namespace("/market/rygz")
@Action(value="admissionRecAction")
@Results(value={
		@Result(name="importFromHis",location="/market/rygz/hisinfo.jsp"),
		@Result(name="list",location="/market/rygz/show.jsp"),
		@Result(name="detail",location="/market/rygz/detail.jsp"),
		@Result(name="loadFromHis",location="/market/rygz/add.jsp")
	})
public class AdmissionRecAction extends BaseAction  implements ModelDriven<AdmissionRecord>{
	AdmissionRecord admissionRec = new AdmissionRecord();
	private AdmissionRecordService admissionRecService;
	@Override
	public AdmissionRecord getModel() {
		// TODO Auto-generated method stub
		return admissionRec;
	}
	
	public AdmissionRecordService getAdmissionRecService() {
		return admissionRecService;
	}
	@Autowired
	public void setAdmissionRecService(AdmissionRecordService admissionRecService) {
		this.admissionRecService = admissionRecService;
	}

	public String importFromHis() {
		DataGrid grid = null;
		if (admissionRec.getPageSize() == 0) {
			admissionRec.setPageSize(10);
		}
		if (admissionRec.getPageCurrent()==0) {
			admissionRec.setPageCurrent(1);
		}
		try {
			grid = admissionRecService.importFromHis(admissionRec);
		} catch (Exception ex) {
			//ex.printStackTrace();
		}
		try {
		System.out.println(grid.getPageCurrent());
		System.out.println(grid.getPageSize());
		System.out.println(grid.getTotal());
		} catch (Exception e) {
			
		}
		super.setAttribute("recList", grid);
		super.setAttribute("admissionRec", admissionRec);
		return "importFromHis";
	}
	public String loadFromHis() {
		AdmissionRecord admissRec = null;
		admissRec = admissionRecService.loadFromHis(admissionRec); 
		super.setAttribute("admissRec", admissRec);
		return "loadFromHis";
	}
	public void add() {
		Json json = new Json();
		try {
			admissionRecService.add(admissionRec);
		} catch(Exception ex) {
			json.setSuccess(false);
			json.setMsg(ex.getMessage());
		}
		json.setSuccess(true);
		json.setMsg("保存入院单成功");
		super.writeJson(json);
	}
}
