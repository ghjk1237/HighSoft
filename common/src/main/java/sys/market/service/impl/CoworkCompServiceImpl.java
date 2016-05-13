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
import org.springframework.stereotype.Service;

import sys.market.page.model.CoworkCompany;
import sys.market.page.model.DataGrid;
import sys.market.service.CoworkCompService;
@Service("coworkCompService")
public class CoworkCompServiceImpl implements CoworkCompService {
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
		sql = "select count(1) from TB_MK_HZDW";
		query= sessionFactory.getCurrentSession().createSQLQuery(sql);
		total = (Integer) query.uniqueResult();
		sql = "select dw.id,dw.code,dw.name,dw.enable,dw.ksrq,dw.zzrq,"
			+ "isnull(dw.user_id,'') as userid,isnull(u.name,'') as username"
			+ " from TB_MK_HZDW dw"
			+ " left join TB_USER u on dw.user_id=u.id"
			+ " order by dw.code";
		query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setFirstResult((currPage-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Object[]> data = query.list();
		List<CoworkCompany> coworkComp = new ArrayList<CoworkCompany>();
		for(Object[] obj : data) {
			CoworkCompany g = new CoworkCompany();
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
			coworkComp.add(g);
		}
		grid.setPageCurrent(currPage);
		grid.setPageSize(pageSize);
		grid.setTotal(total);
		grid.setRows(coworkComp);
		return grid;
	}

	@Override
	public CoworkCompany add(CoworkCompany coworkComp) {
		String sql = "";
		Query query = null;
		sql = "insert into TB_MK_HZDW(id,code,name,enable,user_id,ksrq,zzrq)"
			+ " values(:id,:code,:name,:enable,:user_id,:ksrq,:zzrq)";
		try {
			query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setString("id", UUID.randomUUID().toString());
			query.setString("code", coworkComp.getCode());
			query.setString("name", coworkComp.getName());
			if (coworkComp.isEnable()) {
				query.setInteger("enable", 1);
			} else {
				query.setInteger("enable", 0);
			}
			query.setString("user_id", coworkComp.getUserId());
			query.setDate("ksrq", coworkComp.getBeginDate());
			query.setDate("zzrq", coworkComp.getEndDate());
			query.executeUpdate();
		} catch (Exception ex) {
			logger.error("保存合作单位出错,"+ex.getMessage());
			return null;
		}
		return coworkComp;
	}

	@Override
	public CoworkCompany detail(String id) throws Exception {
		CoworkCompany innserCoworkComp;
		String sql = "";
		Query query = null;
		List<Object[]> data = null;
		sql = "select dw.id,dw.code,dw.name as dwname,dw.enable,dw.ksrq,dw.zzrq,"
			+ "dw.user_id,u.name"
			+ " from TB_MK_HZDW dw"
			+ " inner join TB_USER u on dw.user_id=u.id"
			+ " where dw.id=:id";
		try {
			query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setString("id", id);
			data = query.list();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		if (data != null) {
			logger.info("有数据");
			innserCoworkComp = new CoworkCompany();
			for (Object[] obj :data) {
				innserCoworkComp.setId(obj[0].toString());
				innserCoworkComp.setCode(obj[1].toString());
				innserCoworkComp.setName(obj[2].toString());
				if (Integer.parseInt(obj[3].toString())==1) {
					innserCoworkComp.setEnable(true);
				} else {
					innserCoworkComp.setEnable(false);
				}
				try {
					innserCoworkComp.setBeginDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(obj[4].toString().trim()));
				} catch (ParseException e) {
					logger.error("转换日期出错,"+obj[4].toString().trim());
				}
				try {
					innserCoworkComp.setEndDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(obj[5].toString().trim()));
				} catch (ParseException e) {
					logger.error("转换日期出错,"+obj[5].toString().trim());
				}
				innserCoworkComp.setUserId(obj[6].toString());
				innserCoworkComp.setUserName(obj[7].toString());
			}
			return innserCoworkComp; 
		} else {
			logger.info("无数据");
			return null;
		}
	}

	@Override
	public CoworkCompany update(CoworkCompany coworkComp) throws Exception {
		String sql = "";
		Query query = null;
		sql = "update TB_MK_HZDW set id=:id,code=:code,name=:name,"
			+ "enable=:enable,user_id=:user_id,"
			+ "ksrq=:ksrq,zzrq=:zzrq"
			+ " where id=:id";
		try {
			query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setString("id", coworkComp.getId().trim());
			query.setString("code", coworkComp.getCode().trim());
			query.setString("name", coworkComp.getName().trim());
			if (coworkComp.isEnable()) {
				query.setInteger("enable", 1);
			} else {
				query.setInteger("enable", 0);
			}
			query.setString("user_id", coworkComp.getUserId().trim());
			query.setDate("ksrq", coworkComp.getBeginDate());
			query.setDate("zzrq", coworkComp.getEndDate());
			query.executeUpdate();
		} catch (Exception ex) {
			logger.error("更新合作单位出错,"+ex.getMessage());
			return null;
		}
		return coworkComp;
		
	}
	@Override
	public DataGrid selectComp(CoworkCompany coworkComp) throws Exception {
		DataGrid grid = new DataGrid();
		String sql = "";
		int total;
		Query query;
		if (coworkComp.getCode() == null || coworkComp.getCode().trim().equals("")) {
			sql = "select count(1) from TB_MK_HZDW";
		} else {
			sql = "select count(1) from TB_MK_HZDW where code like :code";
		}
		query= sessionFactory.getCurrentSession().createSQLQuery(sql);
		if (coworkComp.getCode() == null || coworkComp.getCode().trim().equals("")) {
		} else {
			try {
				query.setString("code", "%"+coworkComp.getCode().trim()+"%");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		logger.info(sql);
		total = (Integer) query.uniqueResult();
		if (coworkComp.getCode() == null || coworkComp.getCode().trim().equals("")) {
			sql = "select dw.id,dw.code,dw.name,dw.enable,dw.ksrq,dw.zzrq,"
				+ "isnull(dw.user_id,'') as userid,isnull(u.name,'') as username"
				+ " from TB_MK_HZDW dw"
				+ " left join TB_USER u on dw.user_id=u.id"
				+ " order by dw.code";
		} else {
			sql = "select dw.id,dw.code,dw.name,dw.enable,dw.ksrq,dw.zzrq,"
				+ "isnull(dw.user_id,'') as userid,isnull(u.name,'') as username"
				+ " from TB_MK_HZDW dw"
				+ " left join TB_USER u on dw.user_id=u.id"
				+ " where dw.code like :code"
				+ " order by dw.code";
		}	
		logger.info(sql);
		query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		if (coworkComp.getCode() == null || coworkComp.getCode().trim().equals("")) {
		} else {
			query.setString("code", "%"+coworkComp.getCode().trim()+"%");
		}
		query.setFirstResult((coworkComp.getPageCurrent()-1)*coworkComp.getPageSize());
		query.setMaxResults(coworkComp.getPageSize());
		List<Object[]> data = query.list();
		List<CoworkCompany> cc = new ArrayList<CoworkCompany>();
		for(Object[] obj : data) {
			CoworkCompany g = new CoworkCompany();
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
		grid.setPageCurrent(coworkComp.getPageCurrent());
		grid.setPageSize(coworkComp.getPageSize());
		grid.setTotal(total);
		grid.setRows(cc);
		return grid;
	}
}
