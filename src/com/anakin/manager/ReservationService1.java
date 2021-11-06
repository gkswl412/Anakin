package com.anakin.manager;

import java.util.List;

public class ReservationService1 {
	
	ReservationDAO1 dao = new ReservationDAO1();
	
	public List<ReservationVO1> selectReservationByCottageId(int cottage_id) {
		return dao.selectReservationByCottageId(cottage_id);
	}
	
}
