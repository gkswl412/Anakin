package com.anakin.reservation.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anakin.reservation.VO.CottageVO;

import util.DBUtil;

public class CottageDAO {
	
	public static final String SELECT_COTTAGE_BY_NAME = "select * from COTTAGE where COTTAGE_NAME=?;";
	
	public int SELECT_COTTAGE_BY_NAME(String cottageName) {
		int result = 0;
		Connection conn= DBUtil.dbConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(SELECT_COTTAGE_BY_NAME);
			st.setString(1, cottageName);
			result = st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, null);
		}
		return result;
	} 
}