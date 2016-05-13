package sys.evalsetting.action;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.mapping.Value;
import org.springframework.beans.factory.annotation.Autowired;

import sys.Eval.page.Model.*;
import sys.Eval.service.BiCorporationService;
import sys.common.page.model.DataGrid;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

@ParentPackage("default")
@Namespace("/evalsetting")
@Action(value="biCorporationAction")
			   		       
@Results(value={@Result(name="list",location="/evalsetting/corporation.jsp")})


public class BiCorporationAction extends sys.evalsetting.action.BaseAction implements ModelDriven<BiCorporation> {
	private BiCorporationService biCorporationService ;
	/**
	 * @return the biCorporationService
	 */
	public BiCorporationService getBiCorporationService() {
		return biCorporationService;
	}
	/**
	 * @param biCorporationService the biCorporationService to set
	 */
	@Autowired
	public void setBiCorporationService(BiCorporationService biCorporationService) {
		this.biCorporationService = biCorporationService;
	}
	public String list() {
		System.out.println("中文到底是不是乱码");	
		DataGrid grid =biCorporationService.list(null);
		super.setAttribute("corlist", grid);
		return "list";
	}
	@Override
	public BiCorporation getModel() {
		// TODO Auto-generated method stub
		return null;
	}

}
