package sys.common.service;

import sys.common.model.TBUser;
import sys.common.page.model.DataGrid;
import sys.common.page.model.User;

public interface UserService {
	public TBUser save(User user);
	public User update(User user);
	public DataGrid list(User user);
	public User add(User user);
	public User ListById(String id);
	public User find(String code,String password);
	public DataGrid selectUser(User user);
}
