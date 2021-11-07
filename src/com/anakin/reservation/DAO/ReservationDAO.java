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
	static final String INSERT_RESERVATION = "insert into RESERVATION values(?,?,?,?,?,?,?,?,?)";
	static final String SELECT_ALL_RESERVATION = "select * from RESERVATION;";
	static final String SELECT_RESERVATION_BY_ID = "select * from RESERVATION where RESERVATION_ID=?;";
	static final String UPDATE_RESERVATION = "update RESERVATION set " +
			"USER_NAME=?, " +
			"USER_PHONE_NUMBER=?, " +
			"where RESERVATION_id=?;";
	static final String DELETE_RESERVATION = "delete from RESERVATION where RESERVATION_ID=?;";
	
	// Create methods (insert into DB) ----------------------------------------------------------------
	public int insertReservation(ReservationVO reservationVO) {
		
		int result = 0;  //insert건수
		Connection conn = DBUtil.dbConnect();
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(INSERT_RESERVATION);
			
			st.setLong(1, reservationVO.getReservation_id());
			st.setInt(2, reservationVO.getCottage_id());
			st.setLong(3, reservationVO.getRoom_id());
			st.setString(4, reservationVO.getUser_name());
			st.setString(5, reservationVO.getUser_phone_number());
			st.setString(6, reservationVO.getReservation_checkin_date());
			st.setString(7, reservationVO.getReservation_checkout_date());
			st.setInt(8, reservationVO.getReservation_people_count());
			st.setString(9, reservationVO.getReservation_description());

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
		reservation.setReservation_checkin_date(rs.getString("Reservation_checkin_date"));
		reservation.setReservation_checkout_date(rs.getString("Reservation_checkout_date"));
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
	
	public ReservationVO selectReservationById(long reservation_id) {
		
		ReservationVO reservation = new ReservationVO();
		Connection conn = DBUtil.dbConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(SELECT_RESERVATION_BY_ID);
			st.setLong(1,  reservation_id);
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
	public int updateReservationById(ReservationVO reservationVO) {
		int result = 0;  //update 건수			 
		Connection conn = DBUtil.dbConnect();
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(UPDATE_RESERVATION);
			st.setString(1, reservationVO.getUser_name());
			st.setString(2, reservationVO.getUser_phone_number());
			st.setInt(3, reservationVO.getCottage_id());
			
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
	public int deleteReservationById(long reservation_id) {
		int result = 0;  //delete건수
		Connection conn = DBUtil.dbConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(DELETE_RESERVATION);
			st.setLong(1, reservation_id);
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
