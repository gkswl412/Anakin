package com.anakin.reservation.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.anakin.reservation.VO.IntegratedVO;

import util.DBUtil;

public class IntegratedDAO {

	static final String SELECT_INTEGRATED_BY_RESERVATION_ID = "select USER_NAME, RESERVATION_ID, COTTAGE_NAME, ROOM_NAME, RESERVATION_CHECKIN_DATE, RESERVATION_CHECKOUT_DATE "
			+ "from reservation "
			+ "inner join cottage using(cottage_id) "
			+ "inner join cottage_room using(room_id) "
			+ "where RESERVATION_ID=?";
	
	public IntegratedVO selectIntegratedByReservationId(long reservation_id) {
		
		IntegratedVO integratedVO = null;
		Connection conn= DBUtil.dbConnect();
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			pr = conn.prepareStatement(SELECT_INTEGRATED_BY_RESERVATION_ID);
			pr.setLong(1, reservation_id);
			rs = pr.executeQuery(); // execute sql
			while(rs.next()) {
				integratedVO = new IntegratedVO(rs.getString(1), rs.getLong(2), 
						rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, pr, rs);
		}
		return integratedVO;
	}


}
