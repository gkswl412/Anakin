package com.anakin.manager.Service;

import java.util.List;

import com.anakin.manager.DAO.Cottage_RoomDAO;
import com.anakin.manager.VO.Cottage_RoomVO;

public class Cottage_RoomService {

	Cottage_RoomDAO dao = new Cottage_RoomDAO();
	
	public int Cottage_RoomInsertService(Cottage_RoomVO cr) {
		return dao.Cottage_RoomInsert(cr);
	}
	
	public List<Cottage_RoomVO> selectAllByCottage_id(int cottage_id) {
		return dao.selectAllByCottage_id(cottage_id);
	}
	
	public Cottage_RoomVO selectAllByRoom_id(long room_id) {
		return dao.selectAllByRoom_id(room_id);
	}
	
	public int Cottage_RoomDeleteService(int room_id) {
		return dao.Cottage_RoomDelete(room_id);
	}
	
	public int Cottage_RoomUpdateService(Cottage_RoomVO cr) {
		return dao.Cottage_RoomUpdate(cr);
	}
}
