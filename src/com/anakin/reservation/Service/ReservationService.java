package com.anakin.reservation.Service;

import java.util.List;

import com.anakin.reservation.DAO.ReservationDAO;
import com.anakin.reservation.VO.ReservationVO;

public class ReservationService {
	
	ReservationDAO dao;
	
	// insert
	public int insertReservation(ReservationVO reservation) {
		System.out.println("insertReservation execute.");
		return insertReservation(reservation);
	}
	
	// select all
	public List<ReservationVO> selectAllReservation() {
		System.out.println("selectAllReservation service execute.");
		return dao.selectAllReservation();
	}
	
	// select by id
//	public List<ReservationVO> selectReservationById(int reservation_id) {
//		System.out.println("selectReservationById service execute.");
//		return dao.selectReservationById(reservation_id);
//	}
	
	// update
//	public int updateReservationById(ReservationVO reservation) {
//		System.out.println();
//		return dao.updateReservationById(reservation);
//	}
	
	//delete
	public int deleteReservationById(int reservation_id) {
		System.out.println();
		return dao.deleteReservationById(reservation_id);
	}
	
}
