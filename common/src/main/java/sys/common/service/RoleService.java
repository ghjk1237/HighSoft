package sys.common.service;

import java.util.List;

import sys.common.page.model.DataGrid;
import sys.common.page.model.Role;

public interface RoleService {
	public DataGrid list(Role role);

	public Role add(Role role);

	public Role update(Role role);
	
	public Role ListById(String id);
	public List<Role> ListByUserId(String userId);
}
