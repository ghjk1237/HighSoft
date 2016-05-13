package sys.market.service;

import sys.market.page.model.AdmissionRecord;
import sys.market.page.model.DataGrid;

public interface AdmissionRecordService {
	public DataGrid importFromHis(AdmissionRecord admissRec);
	public AdmissionRecord loadFromHis(AdmissionRecord admissRec);
	
	public DataGrid list(AdmissionRecord admissRec);
	public AdmissionRecord add(AdmissionRecord addmissRec) throws Exception;
	public AdmissionRecord detail(AdmissionRecord addmissRec);
	public AdmissionRecord update(AdmissionRecord addmissRec);
}
