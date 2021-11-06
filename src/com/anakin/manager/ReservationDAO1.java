package com.anakin.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import util.DBUtil;

public class ReservationDAO1 {
	
	static final String SELECT_RESERVATION_BY_COTTAGE_ID = "select B.room_name, A.* from reservation A full outer join cottage_room B on A.Room_id = B.room_id where A.cottage_id = ?";
	
	private ReservationVO1 makeReservation(ResultSet rs) throws SQLException {
		ReservationVO1 reservation = new ReservationVO1(); // 8 member variables.
		reservation.setRoom_name(rs.getString("Room_name"));
		reservation.setReservation_id(rs.getInt("Reservation_id"));
		reservation.setCottage_id(rs.getInt("Cottage_id"));
		reservation.setRoom_id(rs.getInt("Room_id"));
		reservation.setUser_name(rs.getString("User_name"));
		reservation.setUser_phone_number(rs.getString("User_phone_number"));
		reservation.setReservation_checkin_date(rs.getDate("Reservation_checkin_date"));
		reservation.setReservation_checkout_date(rs.getDate("Reservation_checkout_date"));
		reservation.setReservation_people_count(rs.getInt("Reservation_people_count"));
		reservation.setReservation_description(rs.getString("Reservation_description"));
		return reservation;
	}
	
public List<ReservationVO1> selectReservationByCottageId(int cottage_id) {
		
		List<ReservationVO1> rvlist = new ArrayList<>();
		Connection conn = DBUtil.dbConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(SELECT_RESERVATION_BY_COTTAGE_ID);
			st.setInt(1, cottage_id);
			rs = st.executeQuery();
			while(rs.next()){
				rvlist.add(makeReservation(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return rvlist; 
	}
	}
