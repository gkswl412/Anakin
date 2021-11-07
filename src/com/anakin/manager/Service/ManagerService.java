package com.anakin.manager.Service;

import java.util.List;

import com.anakin.manager.DAO.ManagerDAO;
import com.anakin.manager.VO.ManagerVO;

public class ManagerService {

	ManagerDAO dao = new ManagerDAO();
	
	public int ManagerInsertService(ManagerVO m) {
		return dao.ManagerInsert(m);
	}
	
	public ManagerVO selectAllByManager_ID(String manager_id) {
		return dao.selectAllByManager_ID(manager_id);
	}
		
	public int ManagerUpdate(ManagerVO m) {
		return dao.ManagerUpdate(m);
	}
	
	public int ManagerDelete(String manager_id) {
		return dao.ManagerDelete(manager_id);
	}
	
	
	public List<ManagerVO> IDCheck(String manager_id) {
		return dao.IDCheck(manager_id);
	}
	
	public int ManagerLoginCheck(String manager_id, String manager_pw) {
		return dao.ManagerLoginCheck(manager_id, manager_pw);
	}
	
}
