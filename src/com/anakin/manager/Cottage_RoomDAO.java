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
		String sql= "insert into cottage_Room values(?,?,?,?,?,?,?,?,?,?,?,?,?)"
				+ "commit;";
		int result = 0;
		Connection conn= DBUtil.dbConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, cr.getCottage_id()); 
			st.setInt(2, cr.getRoom_id());
			st.setString(3, cr.getRoom_name());
			st.setInt(4, cr.getRoom_occupancy()); 
			st.setInt(5, cr.getRoom_standard_price()); 
			st.setInt(6, cr.getRoom_holyday_price()); 
			st.setInt(7, cr.getRoom_peak_season_price()); 
			st.setInt(8, cr.getRoom_tv_count()); 
			st.setInt(9, cr.getRoom_bathroom_count()); 
			st.setString(10, cr.getRoom_balcony_option());
			st.setString(11, cr.getRoom_status());
			st.setString(12, cr.getRoom_description());
			st.setInt(13, cr.getRoom_count());
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, null);
		}
		
		return result;
	}

	public List<Cottage_RoomVO> selectAllByCottage_id(int cottage_id) {
		System.out.println("selectAllByCottage_id sql문 실행 함수");
		String sql= "select * from Cottage_Room where cottage_id = ? ";
		List<Cottage_RoomVO> Cottage_Roomlist = new ArrayList<>();
		Connection conn= DBUtil.dbConnect();
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			pr = conn.prepareStatement(sql);
			pr.setInt(1, cottage_id);
			rs = pr.executeQuery();
			while(rs.next()) {
				Cottage_Roomlist.add(new Cottage_RoomVO(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),
						rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getString(10),
						rs.getString(11),rs.getString(12),rs.getInt(13)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, pr, rs);
		}
		return Cottage_Roomlist;
	}
	
	public int Cottage_RoomUpdate(Cottage_RoomVO cr) {
		System.out.println("Cottage_RoomUpdate sql문 실행 함수");
		String sql= "update Cottage_Room "
		+ "set cottage_id=?"
		+ "room_name=?, "
		+ "room_occupancy=?, "
		+ "room_standard_price=?, "
		+ "room_holyday_price=?, "
		+ "room_peak_season_price=?, "
		+ "room_tv_count=?, "
		+ "room_bathroom_count=?, "
		+ "room_balcony_option=?, "
		+ "room_status=?, "
		+ "room_description=?, "
		+ "room_count=? "
		+ "where room_id =?"+ "commit;";
		int result = 0;
		Connection conn= DBUtil.dbConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, cr.getCottage_id()); 
			st.setString(2, cr.getRoom_name());
			st.setInt(3, cr.getRoom_occupancy()); 
			st.setInt(4, cr.getRoom_standard_price()); 
			st.setInt(5, cr.getRoom_holyday_price()); 
			st.setInt(6, cr.getRoom_peak_season_price()); 
			st.setInt(7, cr.getRoom_tv_count()); 
			st.setInt(8, cr.getRoom_bathroom_count()); 
			st.setString(9, cr.getRoom_balcony_option());
			st.setString(10, cr.getRoom_status());
			st.setString(11, cr.getRoom_description());
			st.setInt(12, cr.getRoom_count());
			st.setInt(13, cr.getRoom_id());
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, null);
		}
		return result;
	}
	
	public int Cottage_RoomDelete(int room_id) {
		System.out.println("Cottage_RoomDelete sql문 실행 함수");
		String sql= "delete from Cottage_Room where room_id = ? "+ "commit;";
		int result = 0;
		Connection conn= DBUtil.dbConnect();
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			pr = conn.prepareStatement(sql);
			pr.setInt(1, room_id);
			rs = pr.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, pr, rs);
		}
		return result;
	}
}
