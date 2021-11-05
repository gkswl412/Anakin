package com.anakin.reservation.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.anakin.reservation.VO.ReservationVO;

import util.DBUtil;

public class ReservationDAO {
	
	// ansi standard sql----------------------------------------------------------------------------
	static final String INSERT_RESERVATION = "insert into RESERVATION " + "values(?,?,?,?,?,?,?);";
	static final String SELECT_ALL_RESERVATION = "select * from RESERVATION;";
	static final String SELECT_RESERVATION_BY_ID = "select * from RESERVATION where RESERVATION_ID=?;";
	//static final String SQL_SELECT_BY_NAME = "select * from RESERVATION where DEPARTMENT_NAME=?";
	//static final String SQL_SELECT_BY_LOC = "select * from RESERVATION where LOCATION_ID=?";
	static final String UPDATE_RESERVATION = "update RESERVATION set " +
			"COTTAGE_ID=?, " +
			"ROOM_Id=?, " +
			"USER_NAME=?, " +
			"USER_PHONE_NUMBER=?, " +
			"RESERVATION_CHECKIN_DATE=?, " +
			"RESERVATION_CHECKOUT_DATE=?, " +
			"RESERVATION_people_count=? " +
			"where RESERVATION_id=? commit;";
	static final String DELETE_RESERVATION = "delete from RESERVATION where RESERVATION_ID=?;";
	
	// Create methods---------------------------------------------------------------------------------------
	public int insertReservation(ReservationVO reservation) {
		int result = 0;  //insert건수
		Connection conn = DBUtil.dbConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(INSERT_RESERVATION);
			
			st.setInt(1, reservation.getCottage_id());
			st.setLong(2, reservation.getRoom_id());
			st.setString(3, reservation.getUser_name());
			st.setString(4, reservation.getUser_phone_number());
			st.setDate(5, reservation.getReservation_checkin_date());
			st.setDate(6, reservation.getReservation_checkout_date());
			st.setInt(7, reservation.getReservation_people_count());

			result = st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			DBUtil.dbClose(conn, st, null);
		}
		return result;
	}
	
	// makeReservation from sql ---------------------------------------------------------------------
	private ReservationVO makeReservation(ResultSet rs) throws SQLException {
		ReservationVO reservation = new ReservationVO(); // 7 member variables.
		reservation.setReservation_id(rs.getLong("Reservation_id"));
		reservation.setCottage_id(rs.getInt("Cottage_id"));
		reservation.setRoom_id(rs.getInt("Room_id"));
		reservation.setUser_name(rs.getString("User_name"));
		reservation.setUser_phone_number(rs.getString("User_phone_number"));
		reservation.setReservation_checkin_date(rs.getDate("Reservation_checkin_date"));
		reservation.setReservation_checkout_date(rs.getDate("Reservation_checkout_date"));
		reservation.setReservation_people_count(rs.getInt("Reservation_people_count"));
		return reservation;
	}
	
	// Read methods ---------------------------------------------------------------------------------
	public List<ReservationVO> selectAllReservation() {
		
		List<ReservationVO> reservationList = new ArrayList<>();
		Connection conn= DBUtil.dbConnect();
		Statement st= null;
		ResultSet rs= null;
		
		try {
			st = conn.createStatement();
			rs= st.executeQuery(SELECT_ALL_RESERVATION);
			
			while(rs.next()) {
				reservationList.add(makeReservation(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return reservationList;
	}
	
	public ReservationVO selectReservationById(int reservation_id) {
		
		ReservationVO reservation = new ReservationVO();
		Connection conn = DBUtil.dbConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(SELECT_RESERVATION_BY_ID);
			st.setInt(1,  reservation_id);
			rs = st.executeQuery();
			
			while(rs.next()){
				reservation = makeReservation(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return reservation; // what if reservation = null?
	}
	
	// Update methods ---------------------------------------------------------------------------------
	public int updateReservationById(ReservationVO reservation, int reservation_id) {
		int result = 0;  //update 건수			 
		 
		Connection conn = DBUtil.dbConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(UPDATE_RESERVATION);
			//reservation id is the primary key.
			st.setInt(1, reservation.getCottage_id());
			st.setLong(2, reservation.getRoom_id());
			st.setString(3, reservation.getUser_name());
			st.setString(4, reservation.getUser_phone_number());
			st.setDate(5, reservation.getReservation_checkin_date());
			st.setDate(6, reservation.getReservation_checkout_date());
			st.setInt(7, reservation.getReservation_people_count());
			st.setInt(8, reservation_id);
			
			result = st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, null);
		}
		return result;
	}
	// Delete methods ---------------------------------------------------------------------------------
	public int deleteReservationById(int reservation_id) {
		int result = 0;  //delete건수
		Connection conn = DBUtil.dbConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(DELETE_RESERVATION);
			st.setInt(1, reservation_id);
			result = st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, null);
		}
		return result;
	}
	

}
