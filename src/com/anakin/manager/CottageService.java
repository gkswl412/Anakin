package com.anakin.manager;

import java.util.List;


public class CottageService {

	CottageDAO dao = new CottageDAO();
	
	public int CottageInsertService(CottageVO ct) {
		return dao.CottageInsert(ct);
	}
	public List<CottageVO> selectAllByManager_idService(String manager_id){
		return dao.selectByManager_id(manager_id);
	}
	public int CottageUpdateService(CottageVO ct) {
		return dao.CottageUpdate(ct);
	}
	public int CottageDeleteService(int cottage_id) {
		return dao.CottageDelete(cottage_id);
	}
	
	public CottageVO selectByCottage_id(int Cottage_id) {
		return dao.selectByCottage_id(Cottage_id);
	}
}
