package sys.Eval.service;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

import sys.Eval.page.Model.BiCorporation;
import sys.common.page.model.DataGrid;

public interface BiCorporationService {
	public DataGrid	 list(BiCorporation biCorporation);
	public BiCorporation add(BiCorporation biCorporation);
	public BiCorporation update(BiCorporation biCorporation);
	public BiCorporation getBiCorporationById(String id);
}
