package sys.market.service;

import sys.market.page.model.DataGrid;
import sys.market.page.model.Group;

public interface GroupService {
	public DataGrid list(int pageSize,int currPage);
	public DataGrid selectMem(String code) throws Exception;
	
	public Group add(Group group);
	public Group detail(String id) throws Exception;
	public Group update(Group group) throws Exception;
	public DataGrid listUser(String groupId) throws Exception;
	public void updateUser(String groupId,String[] users) throws Exception;
}
