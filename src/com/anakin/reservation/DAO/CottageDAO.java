package com.anakin.reservation.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anakin.reservation.VO.CottageRoomVO;
import com.anakin.reservation.VO.CottageVO;

import util.DBUtil;

public class CottageDAO {
	
	public static final String SELECT_COTTAGE_BY_NAME = "select * from COTTAGE where COTTAGE_NAME=?;";
	
	public CottageVO selectCottageByName(String cottageName) {
		
		CottageVO cottage = null;
		Connection conn= DBUtil.dbConnect();
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			pr = conn.prepareStatement(SELECT_COTTAGE_BY_NAME);
			pr.setString(1, cottageName);
			rs = pr.executeQuery();
			while(rs.next()) {
				cottage = new CottageVO(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, pr, null);
		}
		return cottage;
	}
	
}