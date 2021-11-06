package com.anakin.reservation.Service;

import java.util.List;

import com.anakin.reservation.DAO.ReservationDAO;
import com.anakin.reservation.VO.ReservationVO;

public class ReservationService {
	
	ReservationDAO dao = new ReservationDAO();
	
	// insert
	public int insertReservationService(ReservationVO reservationVO) {
		return dao.insertReservation(reservationVO);
	}
	
	// select all
	public List<ReservationVO> selectAllReservationService() {
		return dao.selectAllReservation();
	}
	
	// select by id
	public ReservationVO selectReservationById(int reservation_id) {
		return dao.selectReservationById(reservation_id);
	}
	
	// update
	public int updateReservationById(ReservationVO reservationVO) {
		return dao.updateReservationById(reservationVO);
	}
	
	//delete
	public int deleteReservationByIdService(int reservation_id) {
		return dao.deleteReservationById(reservation_id);
	}
	
}
