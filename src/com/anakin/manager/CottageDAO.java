package com.anakin.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class CottageDAO {
	
	public int CottageInsert(CottageVO ct) {

		int result = 0;
		String sql= "insert into cottage values(?,?,?,?,?,?,?,?,?) ";
		Connection conn= DBUtil.dbConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, ct.getManager_id());
			st.setInt(2, ct.getCottage_id());
			st.setString(3, ct.getCottage_name());
			st.setString(4, ct.getCottage_location());
			st.setString(5, ct.getCottage_phone_number());
			st.setString(6, ct.getCottage_description());
			st.setString(7, ct.getCottage_cat());
			st.setString(8, ct.getCottage_longitude_x()); 
			st.setString(9,	ct.getCottage_latitude_y());
			result = st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, null);
		}
		return result;
	} 
	
	public CottageVO selectByCottage_id(int Cottage_id) {
		String sql= "select cottage_id, cottage_name, cottage_location, cottage_phone_number, cottage_description, cottage_cat "
				+ "from cottage where Cottage_id = ? order by 1";
		CottageVO clist = null;
		Connection conn= DBUtil.dbConnect();
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			pr = conn.prepareStatement(sql);
			pr.setInt(1, Cottage_id);
			rs = pr.executeQuery();
			while(rs.next()) {
				clist = new CottageVO();
				clist.setCottage_id(rs.getInt(1));
				clist.setCottage_name(rs.getString(2));
				clist.setCottage_location(rs.getString(3));
				clist.setCottage_phone_number(rs.getString(4));
				clist.setCottage_description(rs.getString(5));
				clist.setCottage_cat(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, pr, rs);
		}
		return clist;
	}
	
	
	public List<CottageVO> selectByManager_id(String manager_id) {
		
		String sql= "select cottage_id, cottage_name, cottage_location, cottage_phone_number, cottage_description, cottage_cat "
				+ "from cottage where Manager_id = ? order by 1";
		List<CottageVO> cottagelist = new ArrayList<>();
		Connection conn= DBUtil.dbConnect();
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			pr = conn.prepareStatement(sql);
			pr.setString(1, manager_id);
			rs = pr.executeQuery();
			while(rs.next()) {
				cottagelist.add(new CottageVO(rs.getInt(1),rs.getString(2),rs.getString(3),
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
		System.out.println(ct);
		String sql= "update cottage set cottage_name ='"+ ct.getCottage_name()+"'";
		String wheresql= " where cottage_id ="+ ct.getCottage_id();		
		String cl ="", mid="", ph="", des="", cat="", x="", y="";
		if(ct.getManager_id() != null) 
			mid = ", manager_id='"+ ct.getManager_id()+"'";
		if(ct.getCottage_location() != null)
			cl = ", cottage_location='"+ct.getCottage_location()+"'";
		if(ct.getCottage_phone_number() != null)
			ph =", cottage_phone_number='"+ct.getCottage_phone_number()+"'";
		if(ct.getCottage_description() != null)
			des =", cottage_description='"+ct.getCottage_description()+"'";
		if(ct.getCottage_cat() != null)
			cat =", cottage_cat='"+ct.getCottage_cat()+"'";
		if(ct.getCottage_longitude_x() != null)
			x =", cottage_longitude_x='"+ct.getCottage_longitude_x()+"'";
		if(ct.getCottage_latitude_y() != null)
			y =", cottage_latitude_y='"+ct.getCottage_latitude_y()+"'";
		sql += cl + mid + ph + des + cat + x + y + wheresql; 
		int result = 0;
		Connection conn= DBUtil.dbConnect();
		Statement st = null;
		try {
			st = conn.createStatement();
			result = st.executeUpdate(sql);
			conn.commit();
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
		String sql= "update cottage set manager_id='미등록' where cottage_id=?";
		Connection conn= DBUtil.dbConnect();
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			pr = conn.prepareStatement(sql);
			pr.setInt(1, cottage_id);
			rs = pr.executeQuery();
			result = 1;
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, pr, rs);
		}
		return result;
	}
}
