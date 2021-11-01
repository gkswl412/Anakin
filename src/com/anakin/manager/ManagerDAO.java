package com.anakin.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import util.DBUtil;

public class ManagerDAO {
	
	public int ManagerInsert(ManagerVO m) {
		
		int result = 0;
		String sql= "insert into manager values (?,?,?,?,?)";
		Connection conn = DBUtil.dbConnect();
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement(sql);
			st.setString(1, m.getManager_id());
			st.setString(2, m.getManager_pw());
			st.setString(3, m.getManager_name());
			st.setString(4, m.getManager_phone());
			st.setString(5, m.getManager_email());
			System.out.println("ManagerInsert sql문 실행 함수");
			result = st.executeUpdate();
			System.out.println(result);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, null);
		}
		return result;
	}
	
	public int ManagerLoginCheck(String manager_id, String manager_pw) {
		System.out.println("로그인 체크");
		String sql= "select manager_pw from manager where manager_id = ?";
		Connection conn = DBUtil.dbConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		String mpw = null;
		int x=-1;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, manager_id);
			rs = st.executeQuery();
			System.out.println(rs);
			if(rs.next()) {
				mpw = rs.getString("manager_pw");
				if(mpw.equals(manager_pw)) {
					System.out.println("로그인 성공");
					x=1; 
				}else {
					System.out.println("비밀번호 틀림");
					x=0; 
				}
			}else {
				System.out.println("해당 아이디 존재 안함");
				x=-1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, null);
		}
		return x;
	}
	
	public List<ManagerVO> CheckID(String manager_id) {
		System.out.println("ID 중복 체크");
		List<ManagerVO> mlist = null;
		String sql= "select manager_id from manager where manager_id = '?'";
		Connection conn = DBUtil.dbConnect();
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			pr = conn.prepareStatement(sql);
			pr.setString(1,manager_id);
			rs = pr.executeQuery();
			System.out.println(rs);
			if(rs.next()) {
				mlist = new ArrayList<ManagerVO>();
				mlist.add(makeSt1(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, pr, rs);
		}
		return mlist;
	}

	public List<ManagerVO> selectAllByManager_ID(String manager_id) {
		System.out.println("selectAllByManager_ID sql문 실행 함수");
		String sql= "select * from manager where manager_id=?";
		List<ManagerVO> Managerlist = new ArrayList<>();
		Connection conn= DBUtil.dbConnect();
		PreparedStatement st = null;
		ResultSet rs= null;
		try {
			st = conn.prepareStatement(sql);
			rs= st.executeQuery();
			while(rs.next()) {
				Managerlist.add(new ManagerVO(rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return Managerlist;
	}
	
	public int ManagerUpdate(ManagerVO m) {
		System.out.println("ManagerUpdate sql문 실행 함수");
		int result = 0;
		String sql= "Update manager "
				+ "set manager_pw=?,"
				+ "manager_name=?, "
				+ "manager_phone=?, "
				+ "manager_email=? "
				+ "where manager_id=?";
		Connection conn= DBUtil.dbConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(5, m.getManager_id());
			st.setString(1, m.getManager_pw());
			st.setString(2, m.getManager_name());
			st.setString(3, m.getManager_phone());
			st.setString(4, m.getManager_email());
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, null);
		}
		return result;
	}
	
	public int ManagerDelete(String manager_id) {
		System.out.println("ManagerDelete sql문 실행 함수");
		int result = 0;
		String sql= "delete from manager where manager_id = ?";
		Connection conn= DBUtil.dbConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1,manager_id);
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, null);
		}
		return result;
	}
	
	private ManagerVO makeSt1(ResultSet rs) throws SQLException {
		ManagerVO st1 = new ManagerVO();
		st1.setManager_id(rs.getString("manager_id"));
		st1.setManager_pw(rs.getString("manager_pw"));
		st1.setManager_name(rs.getString("manager_name"));
		st1.setManager_phone(rs.getString("manager_phone"));
		st1.setManager_email(rs.getString("manager_email"));
		return st1;
	}
}
