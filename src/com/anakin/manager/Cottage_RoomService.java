package com.anakin.manager;

import java.util.List;

public class Cottage_RoomService {

	Cottage_RoomDAO dao;
	
	public int Cottage_RoomInsertService(Cottage_RoomVO cr) {
		return dao.Cottage_RoomInsert(cr);
	}
	
	public List<Cottage_RoomVO> selectAllByCottage_idService(int cottage_id) {
		return dao.selectAllByCottage_id(cottage_id);
	}
	
	public int Cottage_RoomDeleteService(int room_id) {
		return dao.Cottage_RoomDelete(room_id);
	}
	
	public int Cottage_RoomUpdateService(Cottage_RoomVO cr) {
		return dao.Cottage_RoomUpdate(cr);
	}
}
