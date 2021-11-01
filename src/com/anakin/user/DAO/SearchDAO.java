package com.anakin.user.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anakin.user.VO.SearchConditionVO;
import com.anakin.user.VO.SearchResultVO;

import util.DBUtil;

public class SearchDAO {
	
	public List<SearchResultVO> selectByArea(SearchConditionVO scVO){
		List<SearchResultVO> searchList = new ArrayList();
		String sql = "select * from cottage inner join cottage_photo on cottage.cottage_id = cottage_photo.cottage_id "
				+ "where cottage_location like ?";
		String sidoGugun = scVO.getSido() + " " + scVO.getGugun() + "%";
		System.out.println(sidoGugun);
		
		Connection conn = DBUtil.dbConnect();
		PreparedStatement st  = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, sidoGugun);
			rs = st.executeQuery();
			while(rs.next()) {
				searchList.add(new SearchResultVO(
							rs.getString(1),
							rs.getInt(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getString(6),
							rs.getString(7),
							rs.getDouble(8),
							rs.getDouble(9),
							rs.getInt(10),
							rs.getInt(12),
							rs.getString(13),
							rs.getString(14)
						)
					);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return searchList;
	}
	
}
