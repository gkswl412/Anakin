package com.anakin.reservation.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.anakin.reservation.VO.CottageRoomVO;

import util.DBUtil;

public class CottageRoomDAO {
	
	public static final String SELECT_COTTAGE_ROOM_BY_NAMES = "select * from COTTAGE_ROOM where COTTAGE_NAME=? and ROOM_NAME=?";

	public CottageRoomVO selectRoomByNames(String room_name, String cottage_name) {
		
		CottageRoomVO cottage_room = null;
		Connection conn= DBUtil.dbConnect();
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			pr = conn.prepareStatement(SELECT_COTTAGE_ROOM_BY_NAMES);
			pr.setString(1, room_name);
			pr.setString(2, cottage_name);
			rs = pr.executeQuery(); // execute sql
			while(rs.next()) {
				cottage_room = new CottageRoomVO(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),
						rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getString(10),
						rs.getString(11),rs.getString(12),rs.getInt(13));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, pr, rs);
		}
		return cottage_room;
	}
}