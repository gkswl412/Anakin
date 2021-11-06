package com.anakin.user.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.anakin.user.VO.Cottage_photoVO;
import com.anakin.user.VO.Cottage_roomVO;
import com.anakin.user.VO.SearchConditionVO;

import util.DBUtil;

public class GetRoomInfoDAO {
	public List<Cottage_roomVO> selectRoomByCottageId(SearchConditionVO scVO, int cottage_id){
		List<Cottage_roomVO> roomList = new ArrayList<>();
		String sql = "select * from cottage_photo inner join "
				+ "(select * from cottage_room where room_id not in \r\n"
				+ "(select room_id from reservation "
				+ "where reservation_checkin_date between ? and ? \r\n"
				+ "or reservation_checkout_date between ? and ?) "
				+ "and cottage_id = ?) using(room_id)";
		String checkIn = scVO.getCheckinDate() + " 15:00:00.0";
		String checkOut = scVO.getCheckoutDate() + " 12:00:00.0";
		
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
				Cottage_roomVO room = new Cottage_roomVO();
				room.setCottage_id(rs.getInt(3));
				room.setRoom_id(rs.getInt(1));
				room.setRoom_name(rs.getString(7));
				room.setRoom_occupancy(rs.getInt(8));
				room.setRoom_standard_price(rs.getInt(9));
				room.setRoom_holiday_price(rs.getInt(10));
				room.setRoom_peak_season_price(rs.getInt(11));
				room.setRoom_tv_count(rs.getInt(12));
				room.setRoom_bathroom_count(rs.getInt(13));
				room.setBalcony_option(rs.getString(14));
				room.setRoom_status(rs.getString(15));
				room.setRoom_description(rs.getString(16));
				room.setRoom_count(rs.getInt(17));
				room.setRoom_photo_url(rs.getString(5));
				roomList.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return roomList;
	}
	
}
