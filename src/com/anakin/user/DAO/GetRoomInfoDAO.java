package com.anakin.user.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.anakin.user.VO.Cottage_roomVO;
import com.anakin.user.VO.SearchConditionVO;

import util.DBUtil;

public class GetRoomInfoDAO {
	public List<Cottage_roomVO> selectRoomByCottageId(int cottage_id, SearchConditionVO scVO){
		List<Cottage_roomVO> roomList = new ArrayList<>();
		String sql = "select * from cottage_room where room_id not in \r\n"
				+ "(select room_id from reservation where reservation_checkin_date between ? and ? \r\n"
				+ "or reservation_checkout_date between ? and ?) and cottage_id = ?";
		String checkIn = scVO.getCheckinDate() + " 15:00:00";
		String checkOut = scVO.getCheckoutDate() + " 12:00:00";
		Timestamp checkInDate = java.sql.Timestamp.valueOf(checkIn);
		Timestamp checkOutDate = java.sql.Timestamp.valueOf(checkOut);
		Connection conn = DBUtil.dbConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(sql);
			st.setTimestamp(1,checkInDate);
			st.setTimestamp(2, checkOutDate);
			st.setTimestamp(3,checkInDate);
			st.setTimestamp(4, checkOutDate);
			st.setInt(5, cottage_id);
			rs = st.executeQuery();
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return null;
	}
}
