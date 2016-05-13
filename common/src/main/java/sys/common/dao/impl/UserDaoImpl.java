package sys.common.dao.impl;

import org.springframework.stereotype.Repository;

import sys.common.dao.UserDao;
import sys.common.model.TBUser;
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<TBUser> implements UserDao{
	
}
