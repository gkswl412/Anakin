package com.anakin.reservation.Service;

import com.anakin.reservation.DAO.CottageRoomDAO;
import com.anakin.reservation.VO.CottageRoomVO;

public class CottageRoomService {

	CottageRoomDAO room_DAO = new CottageRoomDAO();
	
	public CottageRoomVO selectRoomByNamesService(String cottage_name, String room_name) {
		System.out.println("insertReservation execute.");
		return room_DAO.selectRoomByNames(cottage_name, room_name);
	}
	
}
