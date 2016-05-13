package sys.market.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sys.market.page.model.CoworkDoctor;
import sys.market.page.model.DataGrid;
import sys.market.service.CoworkDocService;
@Repository("coworkDocService")
public class CoworkDocServiceImpl implements CoworkDocService {
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
	public DataGrid list(int pageSize, int currPage) {
		DataGrid grid = new DataGrid();
		String sql = "";
		int total;
		Query query;
		sql = "select count(1) from TB_MK_HZYS";
		query= sessionFactory.getCurrentSession().createSQLQuery(sql);
		total = (Integer) query.uniqueResult();
		sql = "select ys.id,ys.code,ys.name,ys.enable,ys.ksrq,ys.zzrq,"
			+ "isnull(dw.user_id,'') as userid,isnull(u.name,'')  as username,"
			+ "isnull(ys.comp_id,'') as compid,isnull(dw.name,'') as compname"
			+ " from TB_MK_HZYS ys"
			+ " left join TB_USER u on ys.user_id=u.id"
			+ " left join TB_MK_HZDW dw on ys.comp_id=dw.id"
			+ " order by ys.code";
		query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setFirstResult((currPage-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Object[]> data = query.list();
		List<CoworkDoctor> coworkDoc = new ArrayList<CoworkDoctor>();
		for(Object[] obj : data) {
			CoworkDoctor doc = new CoworkDoctor();
			doc.setId(obj[0].toString().trim());
			doc.setCode(obj[1].toString().trim());
			doc.setName(obj[2].toString().trim());
			if (Integer.parseInt(obj[3].toString().trim())==0) {
				doc.setEnable(false);
			} else {
				doc.setEnable(true);
			}
			try {
				doc.setBeginDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(obj[4].toString().trim()));
			} catch (ParseException e) {
				logger.error("转换日期出错,"+obj[4].toString().trim());
			}
			try {
				doc.setEndDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(obj[5].toString().trim()));
			} catch (ParseException e) {
				logger.error("转换日期出错,"+obj[5].toString().trim());
			}			
			doc.setUserId(obj[6].toString().trim());
			doc.setUserName(obj[7].toString().trim());
			doc.setCompId(obj[8].toString().trim());
			doc.setCompName(obj[9].toString().trim());
			coworkDoc.add(doc);
		}
		grid.setPageCurrent(currPage);
		grid.setPageSize(pageSize);
		grid.setTotal(total);
		grid.setRows(coworkDoc);
		return grid;
	}

	@Override
	public CoworkDoctor add(CoworkDoctor coworkDoc) {
		String sql = "";
		Query query = null;
		sql = "insert into TB_MK_HZYS(id,code,name,enable,user_id,comp_id,ksrq,zzrq)"
			+ " values(:id,:code,:name,:enable,:user_id,:comp_id,:ksrq,:zzrq)";
		try {
			query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setString("id", UUID.randomUUID().toString());
			query.setString("code", coworkDoc.getCode());
			query.setString("name", coworkDoc.getName());
			if (coworkDoc.isEnable()) {
				query.setInteger("enable", 1);
			} else {
				query.setInteger("enable", 0);
			}
			query.setString("user_id", coworkDoc.getUserId());
			query.setString("comp_id", coworkDoc.getCompId());
			query.setDate("ksrq", coworkDoc.getBeginDate());
			query.setDate("zzrq", coworkDoc.getEndDate());
			query.executeUpdate();
		} catch (Exception ex) {
			logger.error("保存合作单位出错,"+ex.getMessage());
			return null;
		}
		return coworkDoc;
	}

	@Override
	public CoworkDoctor detail(String id) throws Exception {
		CoworkDoctor innserCoworkDoc;
		String sql = "";
		Query query = null;
		List<Object[]> data = null;
		sql = "select ys.id,ys.code,ys.name as ysname,ys.enable,ys.ksrq,ys.zzrq,"
			+ "isnull(ys.user_id,'') as userid,isnull(u.name,'') as username,"
			+ "isnull(ys.comp_id,'') as compid,isnull(dw.name,'') as dwname"
			+ " from TB_MK_HZYS ys"
			+ " left join TB_USER u on ys.user_id=u.id"
			+ " left join TB_MK_HZDW dw on ys.comp_id=dw.id"
			+ " where ys.id=:id";
		try {
			query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setString("id", id);
			data = query.list();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		if (data != null) {
			logger.info("有数据");
			innserCoworkDoc = new CoworkDoctor();
			for (Object[] obj :data) {
				innserCoworkDoc.setId(obj[0].toString());
				innserCoworkDoc.setCode(obj[1].toString());
				innserCoworkDoc.setName(obj[2].toString());
				if (Integer.parseInt(obj[3].toString())==1) {
					innserCoworkDoc.setEnable(true);
				} else {
					innserCoworkDoc.setEnable(false);
				}
				try {
					innserCoworkDoc.setBeginDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(obj[4].toString().trim()));
				} catch (ParseException e) {
					logger.error("转换日期出错,"+obj[4].toString().trim());
				}
				try {
					innserCoworkDoc.setEndDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(obj[5].toString().trim()));
				} catch (ParseException e) {
					logger.error("转换日期出错,"+obj[5].toString().trim());
				}
				innserCoworkDoc.setUserId(obj[6].toString());
				innserCoworkDoc.setUserName(obj[7].toString());
				innserCoworkDoc.setCompId(obj[8].toString());
				innserCoworkDoc.setCompName(obj[9].toString());
			}
			return innserCoworkDoc; 
		} else {
			logger.info("无数据");
			return null;
		}
	}

	@Override
	public CoworkDoctor update(CoworkDoctor coworkDoc) throws Exception {
		String sql = "";
		Query query = null;
		sql = "update TB_MK_HZYS set id=:id,code=:code,name=:name,"
			+ "enable=:enable,user_id=:user_id,comp_id=:comp_id,"
			+ "ksrq=:ksrq,zzrq=:zzrq"
			+ " where id=:id";
		try {
			query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setString("id", coworkDoc.getId().trim());
			query.setString("code", coworkDoc.getCode().trim());
			query.setString("name", coworkDoc.getName().trim());
			if (coworkDoc.isEnable()) {
				query.setInteger("enable", 1);
			} else {
				query.setInteger("enable", 0);
			}
			query.setString("user_id", coworkDoc.getUserId().trim());
			query.setString("comp_id", coworkDoc.getCompId().trim());
			query.setDate("ksrq", coworkDoc.getBeginDate());
			query.setDate("zzrq", coworkDoc.getEndDate());
			query.executeUpdate();
		} catch (Exception ex) {
			logger.error("更新合作医生出错,"+ex.getMessage());
			return null;
		}
		return coworkDoc;
	}
	@Override
	public DataGrid selectComp(CoworkDoctor coworkDoc) {
		DataGrid grid = new DataGrid();
		String sql = "";
		int total;
		Query query;
		if (coworkDoc.getCode() == null || coworkDoc.getCode().trim().equals("")) {
			sql = "select count(1) from TB_MK_HZYS";
		} else {
			sql = "select count(1) from TB_MK_HZYS where code like :code";
		}
		query= sessionFactory.getCurrentSession().createSQLQuery(sql);
		if (coworkDoc.getCode() == null || coworkDoc.getCode().trim().equals("")) {
		} else {
			try {
				query.setString("code", "%"+coworkDoc.getCode().trim()+"%");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		logger.info(sql);
		total = (Integer) query.uniqueResult();
		if (coworkDoc.getCode() == null || coworkDoc.getCode().trim().equals("")) {
			sql = "select ys.id,ys.code,ys.name,ys.enable,ys.ksrq,ys.zzrq,"
				+ "isnull(ys.user_id,'') as userid,isnull(u.name,'') as username"
				+ " from TB_MK_HZYS ys"
				+ " left join TB_USER u on ys.user_id=u.id"
				+ " order by ys.code";
		} else {
			sql = "select ys.id,ys.code,ys.name,ys.enable,ys.ksrq,ys.zzrq,"
				+ "isnull(ys.user_id,'') as userid,isnull(u.name,'') as username"
				+ " from TB_MK_HZYS ys"
				+ " left join TB_USER u on ys.user_id=u.id"
				+ " where ys.code like :code"
				+ " order by ys.code";
		}	
		logger.info(sql);
		query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		if (coworkDoc.getCode() == null || coworkDoc.getCode().trim().equals("")) {
		} else {
			query.setString("code", "%"+coworkDoc.getCode().trim()+"%");
		}
		query.setFirstResult((coworkDoc.getPageCurrent()-1)*coworkDoc.getPageSize());
		query.setMaxResults(coworkDoc.getPageSize());
		List<Object[]> data = query.list();
		List<CoworkDoctor> cc = new ArrayList<CoworkDoctor>();
		for(Object[] obj : data) {
			CoworkDoctor g = new CoworkDoctor();
			g.setId(obj[0].toString());
			g.setCode(obj[1].toString());
			g.setName(obj[2].toString());
			if (Integer.parseInt(obj[3].toString().trim())<=0) {
				g.setEnable(false);
			} else {
				g.setEnable(true);
			}
			try {
				g.setBeginDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(obj[4].toString().trim()));
			} catch (ParseException e) {
				logger.error("转换日期出错,"+obj[4].toString().trim());
			}
			try {
				g.setEndDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(obj[5].toString().trim()));
			} catch (ParseException e) {
				logger.error("转换日期出错,"+obj[5].toString().trim());
			}
			g.setUserId(obj[6].toString().trim());
			g.setUserName(obj[7].toString().trim());				
			cc.add(g);
		}
		grid.setPageCurrent(coworkDoc.getPageCurrent());
		grid.setPageSize(coworkDoc.getPageSize());
		grid.setTotal(total);
		grid.setRows(cc);
		return grid;
	}
}
