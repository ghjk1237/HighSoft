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

import sys.market.page.model.AdmissionRecord;
import sys.market.page.model.DataGrid;
import sys.market.service.AdmissionRecordService;
import sys.util.CommonUtil;
@Repository("admissionRecService")
public class AdmissionRecordServiceImpl implements AdmissionRecordService {
	private static final Logger logger = Logger.getLogger(GroupServiceImpl.class);
	private SessionFactory sessionFactory;
	private SessionFactory hisFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getHisFactory() {
		return hisFactory;
	}
	@Autowired
	public void setHisFactory(SessionFactory hisFactory) {
		this.hisFactory = hisFactory;
	}
	@Override
	public DataGrid importFromHis(AdmissionRecord admissRec) {
		DataGrid grid = new DataGrid();
		Query query = null;
		int total;
		String sql = "";
		sql = "select count(1)"
			+ " from zy_cryk a(nolock)"
			+ " inner join sz_ksk b(nolock) on a.bqbm=b.ksbm and b.lx='11'"
			+ " inner join sz_ksk c(nolock) on a.ryks=c.ksbm and c.lx='51'"
			+ " inner join yy_sflxk d(nolock) on a.sflx=d.bm"
			+ " where a.djrq between :ksrq and :jzrq"
			+ " and a.bz<>:brzt";
		try {
			query = hisFactory.getCurrentSession().createSQLQuery(sql);
			query.setTimestamp("ksrq", admissRec.getKsrq());
			query.setTimestamp("jzrq", CommonUtil.last(admissRec.getJzrq()));
			query.setString("brzt", "无效");
		} catch (Exception ex) {
			logger.error("查询入院记录总数出错-"+ex.getMessage());
			return null;
		}
		total = (Integer) query.uniqueResult();
		logger.info("记录总数="+total);
		sql = "select a.zdh,a.zyh,a.bqbm as bqdm,b.ksmc as bqmc,a.ryks as ksdm,"
			+ "c.ksmc as ksmc,a.kh,a.xm,a.xb,a.djrq,a.ryrq,a.rqrq,a.cqrq,a.cyrq,a.jsrq,a.bz,"
			+ "a.sflx,d.mc"
			+ " from zy_cryk a(nolock)"
			+ " inner join sz_ksk b(nolock) on a.bqbm=b.ksbm and b.lx='11'"
			+ " inner join sz_ksk c(nolock) on a.ryks=c.ksbm and c.lx='51'"
			+ " inner join yy_sflxk d(nolock) on a.sflx=d.bm"
			+ " where a.djrq between :ksrq and :jzrq"
			+ " and a.bz<>:brzt";
		List<Object[]> data = null;
		try {
			query = hisFactory.getCurrentSession().createSQLQuery(sql);
			query.setTimestamp("ksrq", admissRec.getKsrq());		
			query.setTimestamp("jzrq", CommonUtil.last(admissRec.getJzrq()));
			query.setString("brzt", "无效");
			query.setFirstResult((admissRec.getPageCurrent()-1)*admissRec.getPageSize());
			query.setMaxResults(admissRec.getPageSize());
			data = query.list();
		} catch (Exception ex) {
			logger.error("查询入院记录出错-"+ex.getMessage());
			return null;
		}
		List<AdmissionRecord> admissRecList = new ArrayList<AdmissionRecord>();
		if (data != null) {
			for (Object[] obj : data) {
				AdmissionRecord rec = new AdmissionRecord();
				rec.setZdh(obj[0].toString().trim());
				rec.setBlh(obj[1].toString().trim());
				rec.setBqdm(obj[2].toString().trim());
				rec.setBqmc(obj[3].toString().trim());
				rec.setKsdm(obj[4].toString().trim());
				rec.setKsmc(obj[5].toString().trim());
				rec.setCardno(obj[6].toString().trim());
				rec.setHzxm(obj[7].toString().trim());
				rec.setSex(obj[8].toString().trim());
				if (obj[9] != null) {
					try {
						rec.setDjrq(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(obj[9].toString().trim()));
					} catch (ParseException e) {
						logger.error("转换日期出错");
					}
				} 
				if (obj[10] != null) {
					try {
						rec.setRyrq(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(obj[10].toString().trim()));
					} catch (ParseException e) {
						logger.error("转换日期出错");
					}
				}
				if (obj[11] != null) {
					try {
						rec.setRqrq(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(obj[11].toString().trim()));
					} catch (ParseException e) {
						logger.error("转换日期出错");
					}
				}
				if (obj[12] != null) {
					try {
						rec.setCqrq(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(obj[12].toString().trim()));
					} catch (ParseException e) {
						logger.error("转换日期出错");
					}
				} 
				if (obj[13] != null) {
					try {
						rec.setCyrq(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(obj[13].toString().trim()));
					} catch (ParseException e) {
						logger.error("转换日期出错");
					}
				} 
				if (obj[14] != null) {
					try {
						rec.setJsrq(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(obj[14].toString().trim()));
					} catch (ParseException e) {
						logger.error("转换日期出错");
					}
				} 
				rec.setBrzt(obj[15].toString().trim());
				rec.setYbdm(obj[16].toString().trim());
				rec.setYbmc(obj[17].toString().trim());
				admissRecList.add(rec);				
			}
			logger.info("当前页="+admissRec.getPageCurrent());
			logger.info("每页数="+admissRec.getPageSize());
			logger.info("总数="+total);
			grid.setPageCurrent(admissRec.getPageCurrent());
			grid.setPageSize(admissRec.getPageSize());
			grid.setTotal(total);
			grid.setRows(admissRecList);
			logger.info("当前页="+grid.getPageCurrent());
			logger.info("每页数="+grid.getPageSize());
			logger.info("总数="+grid.getTotal());
			return grid;
		}
		return grid;
	}
	@Override
	public DataGrid list(AdmissionRecord admissRec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdmissionRecord add(AdmissionRecord addmissRec) throws Exception {
		Query query = null;
		String compId="";
		String groupId="";
		String sql = "";
		sql = "select group_id from TB_MK_GROUP_USER where user_id=:user_id";
		try {
			query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setString("user_id", addmissRec.getUserId());
			groupId=(String)query.uniqueResult();
		} catch (Exception ex) {			
			throw ex;
		}
		addmissRec.setGroupId(groupId);
		sql = "select comp_id from TB_MK_HZYS where id=:id";
		try {
			query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setString("id", addmissRec.getDocId());
			compId=(String)query.uniqueResult();
		} catch (Exception ex) {			
			throw ex;
		}
		addmissRec.setCompId(compId);
		addmissRec.setId(UUID.randomUUID().toString());
		sql = "insert into TB_MK_ZYJL(id,zdh,blh,bqdm,bqmc,ksdm,ksmc,cardno,hzxm,"
			+ "sex,ybdm,ybmc,djrq,ryrq,rqrq,cqrq,cyrq,jsrq,brzt,comp_id,doc_id,user_id,"
			+ "group_id,memo,flag)"
			+ " values(:id,:zdh,:blh,:bqdm,:bqmc,:ksdm,:ksmc,:cardno,:hzxm,"
			+ ":sex,:ybdm,:ybmc,:djrq,:ryrq,:rqrq,:cqrq,:cyrq,:jsrq,:brzt,:comp_id,:doc_id,:user_id,"
			+ ":group_id,:memo,:flag)";
		try {
			query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setString("id", addmissRec.getId());
			query.setString("zdh", addmissRec.getZdh());
			query.setString("blh", addmissRec.getBlh());
			query.setString("bqdm", addmissRec.getBqdm());
			query.setString("bqmc", addmissRec.getBqmc());
			query.setString("ksdm", addmissRec.getKsdm());
			query.setString("ksmc", addmissRec.getKsmc());
			query.setString("cardno", addmissRec.getCardno());
			query.setString("hzxm", addmissRec.getHzxm());
			query.setString("sex", addmissRec.getSex());
			query.setString("ybdm",addmissRec.getYbdm());
			query.setString("ybmc", addmissRec.getYbmc());
			query.setTimestamp("djrq", addmissRec.getDjrq());
			query.setTimestamp("ryrq", addmissRec.getRyrq());
			query.setTimestamp("rqrq", addmissRec.getRqrq());
			query.setTimestamp("cqrq", addmissRec.getCqrq());
			query.setTimestamp("cyrq", addmissRec.getCyrq());
			query.setTimestamp("jsrq", addmissRec.getJsrq());
			query.setString("brzt", addmissRec.getBrzt());
			query.setString("comp_id", addmissRec.getCompId());
			query.setString("doc_id", addmissRec.getDocId());
			query.setString("user_id",addmissRec.getUserId());
			query.setString("group_id", addmissRec.getGroupId());
			query.setString("memo", addmissRec.getMemo());
			query.setInteger("flag", 0);
			query.executeUpdate();
		} catch (Exception ex) {
			throw ex;
		}
		
		return addmissRec;
	}

	@Override
	public AdmissionRecord detail(AdmissionRecord addmissRec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdmissionRecord update(AdmissionRecord addmissRec) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public AdmissionRecord loadFromHis(AdmissionRecord admissRec) {
		DataGrid grid = new DataGrid();
		Query query = null;
		int total;
		String sql = "";		
		sql = "select a.zdh,a.zyh,a.bqbm as bqdm,b.ksmc as bqmc,a.ryks as ksdm,"
			+ "c.ksmc as ksmc,a.kh,a.xm,a.xb,a.djrq,a.ryrq,a.rqrq,a.cqrq,a.cyrq,a.jsrq,a.bz,"
			+ "a.sflx,d.mc"
			+ " from zy_cryk a(nolock)"
			+ " inner join sz_ksk b(nolock) on a.bqbm=b.ksbm and b.lx='11'"
			+ " inner join sz_ksk c(nolock) on a.ryks=c.ksbm and c.lx='51'"
			+ " inner join yy_sflxk d(nolock) on a.sflx=d.bm"
			+ " where a.zdh=:zdh"
			+ " and a.bz<>:brzt";
		List<Object[]> data = null;
		try {
			query = hisFactory.getCurrentSession().createSQLQuery(sql);
			query.setString("zdh", admissRec.getZdh());
			query.setString("brzt", "无效");
			data = query.list();
		} catch (Exception ex) {
			logger.error("按账单号查询入院记录出错-"+ex.getMessage());
			return null;
		}
		AdmissionRecord rec = null;
		List<AdmissionRecord> admissRecList = new ArrayList<AdmissionRecord>();
		if (data != null) {
			for (Object[] obj : data) {
				rec = new AdmissionRecord();
				rec.setZdh(obj[0].toString().trim());
				rec.setBlh(obj[1].toString().trim());
				rec.setBqdm(obj[2].toString().trim());
				rec.setBqmc(obj[3].toString().trim());
				rec.setKsdm(obj[4].toString().trim());
				rec.setKsmc(obj[5].toString().trim());
				rec.setCardno(obj[6].toString().trim());
				rec.setHzxm(obj[7].toString().trim());
				rec.setSex(obj[8].toString().trim());
				if (obj[9] != null) {
					try {
						rec.setDjrq(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(obj[9].toString().trim()));
					} catch (ParseException e) {
						logger.error("转换日期出错");
					}
				} 
				if (obj[10] != null) {
					try {
						rec.setRyrq(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(obj[10].toString().trim()));
					} catch (ParseException e) {
						logger.error("转换日期出错");
					}
				}
				if (obj[11] != null) {
					try {
						rec.setRqrq(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(obj[11].toString().trim()));
					} catch (ParseException e) {
						logger.error("转换日期出错");
					}
				}
				if (obj[12] != null) {
					try {
						rec.setCqrq(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(obj[12].toString().trim()));
					} catch (ParseException e) {
						logger.error("转换日期出错");
					}
				} 
				if (obj[13] != null) {
					try {
						rec.setCyrq(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(obj[13].toString().trim()));
					} catch (ParseException e) {
						logger.error("转换日期出错");
					}
				} 
				if (obj[14] != null) {
					try {
						rec.setJsrq(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(obj[14].toString().trim()));
					} catch (ParseException e) {
						logger.error("转换日期出错");
					}
				} 
				rec.setBrzt(obj[15].toString().trim());			
				rec.setYbdm(CommonUtil.ByteTstr(obj[16]));
				rec.setYbmc(obj[17].toString().trim());				
			}
		}
		return rec;
	}
}
