package sys.market.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sys.market.page.model.DataGrid;
import sys.market.page.model.Group;
import sys.market.page.model.GroupUser;
import sys.market.service.GroupService;
@Service("groupService")
public class GroupServiceImpl implements GroupService {
	private static final Logger logger = Logger.getLogger(GroupServiceImpl.class);
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public DataGrid list(int pageSize,int currPage) {
		DataGrid grid = new DataGrid();
		String sql = "";
		int total;
		Query query;
		sql = "select count(1) from TB_MK_GROUP";
		query= sessionFactory.getCurrentSession().createSQLQuery(sql);
		total = (Integer) query.uniqueResult();
		sql = "select id,code,name,enable from TB_MK_GROUP order by code";
		query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setFirstResult((currPage-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Object[]> groupData = query.list();
		List<Group> groups = new ArrayList<Group>();
		for(Object[] obj : groupData) {
			Group g = new Group();
			g.setId(obj[0].toString());
			g.setCode(obj[1].toString());
			g.setName(obj[2].toString());
			if (Integer.parseInt(obj[3].toString())==0) {
				g.setEnable(false);
			} else {
				g.setEnable(true);
			}
			groups.add(g);
		}
		grid.setPageCurrent(currPage);
		grid.setPageSize(pageSize);
		grid.setTotal(total);
		grid.setRows(groups);
		return grid;
	}
	@Override
	public Group add(Group group) {
		String sql = "";
		Query query;
		sql = "insert into TB_MK_GROUP(id,code,name,enable) values(:id,:code,:name,:enable)";
		query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setString("id", UUID.randomUUID().toString());
		query.setString("code", group.getCode());
		query.setString("name", group.getName());
		if (group.getEnable()) {
			query.setInteger("enable", 1);
		} else {
			query.setInteger("enable", 0);
		}		
		try {
			query.executeUpdate();
		} catch(Exception ex) {
			logger.error(ex.getMessage());
			return null;
		}
		return group;
	}
	@Override
	public Group detail(String id) throws Exception {
		Group innerGroup;
		String sql = "";
		Query query;
		List<Object[]> groupData;
		sql = "select id,code,name,enable from TB_MK_GROUP where id=:id";
		try {
			query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setString("id", id);
			groupData = query.list();
		} catch (Exception ex) {
			throw new Exception("获取对应小组出错-"+ex.getMessage());
		}
		if (groupData != null) {
			innerGroup = new Group();
			for (Object[] obj : groupData) {
				innerGroup.setId(obj[0].toString());
				innerGroup.setCode(obj[1].toString());
				innerGroup.setName(obj[2].toString());
				if (Integer.parseInt(obj[3].toString())==0) {
					innerGroup.setEnable(false);
				} else {
					innerGroup.setEnable(true);
				}
			}
			return innerGroup;
		} else {
			return null;
		}
	}
	@Override
	public Group update(Group group) throws Exception {
		String sql = "";
		Query query;
		sql = "update TB_MK_GROUP set code=:code,name=:name,enable=:enable"
			+ " where id=:id";
		try {
			query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setString("code", group.getCode());
			query.setString("name", group.getName());
			if (group.getEnable()) {
				query.setInteger("enable", 1);
			} else {
				query.setInteger("enable", 0);
			}
			query.setString("id", group.getId());
			query.executeUpdate();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new Exception("编辑小组出错-"+ex.getMessage());
		}
		return group;
	}
	@Override
	public DataGrid listUser(String groupId) throws Exception {
		logger.info("传入groupId="+groupId);
		DataGrid grid = new DataGrid();
		List<GroupUser> groupUser = new ArrayList<GroupUser>();
		List<Object[]> data;
		String sql = "";
		Query query = null;
		sql = "select u.id,u.name,isnull(g.group_id,'') as groupid"
			+ " from TB_USER u"
			+ " left join TB_MK_GROUP_USER g on u.id=g.user_id and g.group_id=:id"
			+ " order by u.name";
		try {
			query=sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setString("id", groupId);
			data = query.list();
			if (data != null) {
				for (Object[] obj : data) {
					GroupUser gu = new GroupUser();
					gu.setUserId(obj[0].toString());
					gu.setUserName(obj[1].toString());
					gu.setGroupId(groupId);
					if (obj[2].toString().trim().equals("")) {
						gu.checked = false;
					} else {
						gu.checked = true;
					}
					groupUser.add(gu);
				}
			}
			grid.setRows(groupUser);			
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new Exception("获取组成员出错-"+ex.getMessage());
		}
		return grid;
	}
	@Override
	public void updateUser(String groupId, String[] users) throws Exception {
		String sql = "";
		Query query = null;
		try {
			sql = "delete from TB_MK_GROUP_USER where group_id=:groupId";
			query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setString("groupId", groupId);
			query.executeUpdate();
			if (users.length>0) {
				for (String userId : users) {
					sql = "insert into TB_MK_GROUP_USER(group_id,user_id)"
						+ " values(:groupId,:userId)";
					query = sessionFactory.getCurrentSession().createSQLQuery(sql);
					query.setString("groupId", groupId);
					query.setString("userId", userId);
					query.executeUpdate();
				}
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new Exception("更新组成员出错-"+ex.getMessage());
		}
	}
	@Override
	public DataGrid selectMem(String code) throws Exception {
		logger.info("传入code="+code);
		DataGrid grid = new DataGrid();
		List<GroupUser> groupUser = new ArrayList<GroupUser>();
		List<Object[]> data;
		String sql = "";
		Query query = null;
		if (code != null && code != "") {
			sql = "select u.id,u.name,isnull(gu.group_id,'') as groupid,u.enable,g.name as groupname,u.code"
					+ " from TB_USER u"
					+ " inner join TB_MK_GROUP_USER gu on u.id=gu.user_id"
					+ " inner join TB_MK_GROUP g on gu.group_id=g.id"
					+ " where u.code like :code"
					+ " order by u.name";
		} else {
			sql = "select u.id,u.name,isnull(gu.group_id,'') as groupid,u.enable,g.name as groupname,u.code"
				+ " from TB_USER u"
				+ " inner join TB_MK_GROUP_USER gu on u.id=gu.user_id"
				+ " inner join TB_MK_GROUP g on gu.group_id=g.id"
				+ " order by u.name";
		}
		try {
			query=sessionFactory.getCurrentSession().createSQLQuery(sql);
			if (code != null && code != "") {
				query.setString("code", "%"+code+"%");
			}
			data = query.list();
			if (data != null) {
				for (Object[] obj : data) {
					GroupUser gu = new GroupUser();
					gu.setUserId(obj[0].toString());
					gu.setUserName(obj[1].toString());
					gu.setGroupId(obj[2].toString());
					if (Integer.parseInt(obj[3].toString())==1) {
						gu.setChecked(true);
					} else {
						gu.setChecked(false);
					}
					gu.setGroupName(obj[4].toString());	
					gu.setUserCode(obj[5].toString());
					groupUser.add(gu);
				}
			}
			grid.setRows(groupUser);			
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new Exception("获取组成员出错-"+ex.getMessage());
		}
		return grid;
	}
}
