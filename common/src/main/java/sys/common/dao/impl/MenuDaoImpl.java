package sys.common.dao.impl;

import org.springframework.stereotype.Repository;

import sys.common.dao.MenuDao;
import sys.common.model.TBMenu;

@Repository("menuDao")
public class MenuDaoImpl extends BaseDaoImpl<TBMenu> implements MenuDao {

}
