package com.anakin.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class Cottage_RoomDAO {
	
	public int Cottage_RoomInsert(Cottage_RoomVO cr) {
		System.out.println("Cottage_RoomInsert sql문 실행 함수");
		String sql= "insert into cottage_Room values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				
		int result = 0;
		Connection conn= DBUtil.dbConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, cr.getCottage_id()); 
			st.setLong(2, cr.getRoom_id());
			st.setString(3, cr.getRoom_name());
			st.setInt(4, cr.getRoom_occupancy()); 
			st.setInt(5, cr.getRoom_standard_price()); 
			st.setInt(6, cr.getRoom_holiday_price()); 
			st.setInt(7, cr.getRoom_peak_season_price()); 
			st.setInt(8, cr.getRoom_tv_count()); 
			st.setInt(9, cr.getRoom_bathroom_count()); 
			st.setString(10, cr.getRoom_balcony_option());
			st.setString(11, cr.getRoom_status());
			st.setString(12, cr.getRoom_description());
			st.setInt(13, cr.getRoom_count());
			result = st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, null);
		}
		
		return result;
	}

	public List<Cottage_RoomVO> selectAllByCottage_id(int cottage_id) {
		System.out.println("selectAllByCottage_id sql문 실행 함수");
		String sql= "select room_id, room_name, room_count, room_occupancy, room_standard_price, room_holiday_price,"
				+ " room_peak_season_price, room_tv_count, room_bathroom_count, room_balcony_option,"
				+ " room_status, room_description from Cottage_Room where cottage_id = ? order by 1";
		
		List<Cottage_RoomVO> Cottage_Roomlist = new ArrayList<>();
		Connection conn= DBUtil.dbConnect();
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			pr = conn.prepareStatement(sql);
			pr.setInt(1, cottage_id);
			rs = pr.executeQuery();
			while(rs.next()) {
				Cottage_Roomlist.add(new Cottage_RoomVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, pr, rs);
		}
		return Cottage_Roomlist;
	}
	
	public Cottage_RoomVO selectAllByRoom_id(long room_id) {
		System.out.println("selectAllByroom_id sql문 실행 함수");
		String sql= "select cottage_id, room_name, room_count, room_occupancy, room_standard_price, room_holiday_price,"
				+ " room_peak_season_price, room_tv_count, room_bathroom_count, room_balcony_option,"
				+ " room_status, room_description, room_id from Cottage_Room where room_id = ?";
		Cottage_RoomVO room = null;
		Connection conn= DBUtil.dbConnect();
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			pr = conn.prepareStatement(sql);
			pr.setLong(1, room_id);
			rs = pr.executeQuery();
			while(rs.next()) {
				room = new Cottage_RoomVO();
				room.setCottage_id(rs.getInt(1));
				room.setRoom_name(rs.getString(2));
				room.setRoom_count(rs.getInt(3));
				room.setRoom_occupancy(rs.getInt(4));
				room.setRoom_standard_price(rs.getInt(5));
				room.setRoom_holiday_price(rs.getInt(6));
				room.setRoom_peak_season_price(rs.getInt(7));
				room.setRoom_tv_count( rs.getInt(8));
				room.setRoom_bathroom_count(rs.getInt(9));
				room.setRoom_balcony_option(rs.getString(10));
				room.setRoom_status(rs.getString(11));
				room.setRoom_description(rs.getString(12));	
				room.setRoom_id(rs.getLong(13));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, pr, rs);
		}
		return room;
	}
	
	
	public int Cottage_RoomUpdate(Cottage_RoomVO cr) {
		System.out.println("Cottage_RoomUpdate sql문 실행 함수");
		String sql= "update Cottage_Room "
		+ "set cottage_id=?, "
		+ "room_name=?, "
		+ "room_occupancy=?, "
		+ "room_standard_price=?, "
		+ "room_holiday_price=?, "
		+ "room_peak_season_price=?, "
		+ "room_tv_count=?, "
		+ "room_bathroom_count=?, "
		+ "room_balcony_option=?, "
		+ "room_status=?, "
		+ "room_description=?, "
		+ "room_count=? "
		+ "where room_id =?";
		int result = 0;
		Connection conn= DBUtil.dbConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, cr.getCottage_id()); 
			st.setString(2, cr.getRoom_name());
			st.setInt(3, cr.getRoom_occupancy()); 
			st.setInt(4, cr.getRoom_standard_price()); 
			st.setInt(5, cr.getRoom_holiday_price()); 
			st.setInt(6, cr.getRoom_peak_season_price()); 
			st.setInt(7, cr.getRoom_tv_count()); 
			st.setInt(8, cr.getRoom_bathroom_count()); 
			st.setString(9, cr.getRoom_balcony_option());
			st.setString(10, cr.getRoom_status());
			st.setString(11, cr.getRoom_description());
			st.setInt(12, cr.getRoom_count());
			st.setLong(13, cr.getRoom_id());
			result = st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, null);
		}
		return result;
	}
	
	public int Cottage_RoomDelete(int room_id) {
		System.out.println("Cottage_RoomDelete sql문 실행 함수");
		String sql= "delete from Cottage_Room where room_id = ?";
		int result = 0;
		Connection conn= DBUtil.dbConnect();
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			pr = conn.prepareStatement(sql);
			pr.setInt(1, room_id);
			rs = pr.executeQuery();
			conn.commit();
			result = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, pr, rs);
		}
		return result;
	}
}
