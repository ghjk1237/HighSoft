package sys.Eval.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sys.Eval.page.Model.BiCorporation;
import sys.Eval.service.BiCorporationService;
import sys.common.page.model.DataGrid;
@Service("biCorporationService")
public class BiCorporationServiceImpl implements BiCorporationService {
	private static final Logger LOGGER =Logger.getLogger(BiCorporationServiceImpl.class);
	private SessionFactory sessionFactory;
	
	
	@Override
	public DataGrid list(BiCorporation biCorporation) {
		// TODO Auto-generated method stub
		DataGrid grid = new DataGrid();
		String sql ="select count(1)from BI_Corporation";
		int total =0;
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);		
		total = (Integer)query.uniqueResult();
		sql = "SELECT dbo.BI_Corporation.corpId, "
				+"dbo.BI_Corporation.corpName, "
				+"dbo.BI_Corporation.hospId, "
				+"dbo.BI_Corporation.hospName," 
				+"dbo.BI_Corporation.isValid, "
				+"dbo.BI_Corporation.memo"
				+" FROM dbo.BI_Corporation";
		query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		List<Object[]> liscop = null;
		try {
			liscop= query.list();
		} catch (Exception ex) {
			System.out.println("lis");
			ex.printStackTrace();
		}
		List<BiCorporation> aaa = new ArrayList<BiCorporation>();
		for (Object[] objects : liscop) {
			BiCorporation biCorporation2 = new BiCorporation();
			biCorporation2.setCorpId(objects[0].toString().trim());
			aaa.add(biCorporation2);
		}
		
		grid.setRows(aaa);
		grid.setPageCurrent(1);
		grid.setPageSize(10);
		grid.setTotal(1);
		return grid;
	}

	@Override
	public BiCorporation add(BiCorporation biCorporation) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public BiCorporation update(BiCorporation biCorporation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BiCorporation getBiCorporationById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
