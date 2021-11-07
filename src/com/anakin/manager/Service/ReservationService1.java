package com.anakin.manager.Service;

import java.util.List;

import com.anakin.manager.DAO.ReservationDAO1;
import com.anakin.manager.VO.ReservationVO1;

public class ReservationService1 {
	
	ReservationDAO1 dao = new ReservationDAO1();
	
	public List<ReservationVO1> selectReservationByCottageId(int cottage_id) {
		return dao.selectReservationByCottageId(cottage_id);
	}
	
}
