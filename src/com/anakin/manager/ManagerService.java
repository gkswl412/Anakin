package com.anakin.manager;

import java.util.List;

public class ManagerService {

	ManagerDAO dao = new ManagerDAO();
	
	public int ManagerInsertService(ManagerVO m) {
		System.out.println("service");
		return dao.ManagerInsert(m);
	}
	
	public List<ManagerVO> selectAllByManager_IDService(String manager_id) {
		return dao.selectAllByManager_ID(manager_id);
	}
	
	public int ManagerUpdate(ManagerVO m) {
		return dao.ManagerUpdate(m);
	}
	
	public int ManagerDelete(String manager_id) {
		return dao.ManagerDelete(manager_id);
	}
	
	public List<ManagerVO> CheckID(String manager_id) {
		return dao.CheckID(manager_id);
	}
	
	public int ManagerLoginCheck(String manager_id, String manager_pw) {
		return dao.ManagerLoginCheck(manager_id, manager_pw);
	}
	
}
