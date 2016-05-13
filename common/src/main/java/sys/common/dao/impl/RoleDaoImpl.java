package sys.common.dao.impl;

import org.springframework.stereotype.Repository;

import sys.common.dao.RoleDao;
import sys.common.model.TBRole;
@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<TBRole> implements RoleDao {

}
