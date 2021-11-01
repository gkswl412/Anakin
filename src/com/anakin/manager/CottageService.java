package com.anakin.manager;

import java.util.List;


public class CottageService {

	CottageDAO dao;
	
	public int CottageInsertService(CottageVO ct) {
		return dao.CottageInsert(ct);
	}
	
	public List<CottageVO> selectAllByManager_idService(int manager_id){
		return dao.selectAllByManager_id(manager_id);
	}
	
	public int CottageUpdateService(CottageVO ct) {
		return dao.CottageUpdate(ct);
	}
	
	public int CottageDeleteService(int cottage_id) {
		return dao.CottageDelete(cottage_id);
		
	}
}
