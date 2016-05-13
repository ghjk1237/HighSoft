package sys.market.service;

import sys.market.page.model.CoworkDoctor;
import sys.market.page.model.DataGrid;

public interface CoworkDocService {
	public DataGrid list(int pageSize,int currPage);
	public DataGrid selectComp(CoworkDoctor coworkDoc);
	
	public CoworkDoctor add(CoworkDoctor coworkDoc);
	public CoworkDoctor detail(String id) throws Exception;
	public CoworkDoctor update(CoworkDoctor coworkDco) throws Exception;
}	
