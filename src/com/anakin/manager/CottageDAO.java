package com.anakin.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class CottageDAO {
	
	public int CottageInsert(CottageVO ct) {
		int result = 0;
		String sql= "insert into cattage values(?,?,?,?,?,?) "+ "commit;";
		Connection conn= DBUtil.dbConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, ct.getManager_id());
			st.setInt(2, ct.getCottage_id());
			st.setString(3, ct.getCottage_name());
			st.setString(4, ct.getCottage_phone_number());
			st.setString(5, ct.getCottage_location());
			st.setString(6, ct.getCottage_description());
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, null);
		}
		return result;
	} 
	
	public List<CottageVO> selectAllByManager_id(int manager_id) {
		System.out.println("selectAllCottageByManager_id sql문 실행 함수");
		String sql= "select * from cottage where Manager_id = ? "+ "commit;";
		List<CottageVO> cottagelist = new ArrayList<>();
		Connection conn= DBUtil.dbConnect();
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			pr = conn.prepareStatement(sql);
			pr.setInt(1, manager_id);
			rs = pr.executeQuery();
			while(rs.next()) {
				cottagelist.add(new CottageVO(rs.getString(1),rs.getInt(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, pr, rs);
		}
		return cottagelist;
	}
	
	public int CottageUpdate(CottageVO ct) {
		System.out.println("CottageUpdate sql문 실행 함수");
		String sql= "update from cottage "
				+ "set manager_id=?, "
				+ "cottage_name=?, "
				+ "cottage_phone_number=?, "
				+ "cottage_location=?, "
				+ "cottage_description=? "
				+ "where cottage_id = ?"+ "commit;";
		int result = 0;
		Connection conn= DBUtil.dbConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, ct.getManager_id());
			st.setString(2, ct.getCottage_name());
			st.setString(3, ct.getCottage_phone_number());
			st.setString(4, ct.getCottage_location());
			st.setString(5, ct.getCottage_description());
			st.setInt(6, ct.getCottage_id());
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, null);
		}
		return result;
	}
	
	public int CottageDelete(int cottage_id) {
		System.out.println("CottageDelete sql문 실행 함수");
		int result = 0;
		String sql= "delete from cottage where cottage_id = ?"+ "commit;";
		Connection conn= DBUtil.dbConnect();
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			pr = conn.prepareStatement(sql);
			pr.setInt(1, cottage_id);
			rs = pr.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, pr, rs);
		}
		return result;
	}
}
