package com.anakin.reservation.Service;

import com.anakin.reservation.DAO.IntegratedDAO;
import com.anakin.reservation.VO.IntegratedVO;

public class IntegratedService {

	IntegratedDAO integratedDAO = new IntegratedDAO();
	
	public IntegratedVO selectIntegratedByReservationIdService(long reservationID) {
		return integratedDAO.selectIntegratedByReservationId(reservationID);	
	}
}

