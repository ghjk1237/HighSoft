package sys.market.service;

import sys.market.page.model.CoworkCompany;
import sys.market.page.model.DataGrid;

public interface CoworkCompService {
	public DataGrid list(int pageSize,int currPage);
	public CoworkCompany add(CoworkCompany coworkComp);
	public CoworkCompany detail(String id) throws Exception;
	public CoworkCompany update(CoworkCompany coworkComp) throws Exception;
	public DataGrid selectComp(CoworkCompany coworkComp) throws Exception;
}	
