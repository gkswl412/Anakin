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
		List<SearchResultVO> searchList = new ArrayList<>();
		String sql =
				"select distinct cottage_id,cottage_name,cottage_cat,cottage_location,photo_url,price,cottage_longitude_x,cottage_latitude_y,reviewCount\r\n"
				+ "from cottage inner join cottage_photo using(cottage_id) \r\n"
				+ "left outer join (select cottage_id,avg(room_standard_price) price from cottage_room group by cottage_id) using(cottage_id)\r\n"
				+ "left outer join review using(cottage_id)\r\n"
				+ "left outer join (select cottage_id,count(cottage_id) reviewCount from review group by cottage_id) using(cottage_id)\r\n"
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
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getInt(6),
							rs.getDouble(7),
							rs.getDouble(8),
							rs.getInt(9)
						)
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return searchList;
	}

	public List<SearchResultVO> sortCottageList(SearchConditionVO scVO, String whatSort) {
		List<SearchResultVO> searchList = new ArrayList<>();
		String sql_sortByLowPrice = 
				"select cottage_id,cottage_name,cottage_cat,cottage_location,photo_url,min(room_standard_price) price,cottage_longitude_x,cottage_latitude_y,reviewCount\r\n"
				+ "from cottage inner join cottage_photo using(cottage_id) \r\n"
				+ "left outer join cottage_room using(cottage_id)\r\n"
				+ "left outer join review using(cottage_id)\r\n"
				+ "left outer join (select cottage_id,count(cottage_id) reviewCount from review group by cottage_id) using(cottage_id)\r\n"
				+ "where cottage_location like ?\r\n"
				+ "group by cottage_id,cottage_name,cottage_cat,cottage_location,photo_url,cottage_longitude_x,cottage_latitude_y,reviewCount\r\n"
				+ "order by price asc nulls last";
		String sql_sortByHighPrice = 
				"select cottage_id,cottage_name,cottage_cat,cottage_location,photo_url,max(room_standard_price) price,cottage_longitude_x,cottage_latitude_y,reviewCount \r\n"
				+ "from cottage inner join cottage_photo using(cottage_id) \r\n"
				+ "left outer join cottage_room using(cottage_id)\r\n"
				+ "left outer join review using(cottage_id)\r\n"
				+ "left outer join (select cottage_id,count(cottage_id) reviewCount from review group by cottage_id) using(cottage_id)\r\n"
				+ "where cottage_location like ?\r\n"
				+ "group by cottage_id,cottage_name,cottage_cat,cottage_location,photo_url,cottage_longitude_x,cottage_latitude_y , reviewCount \r\n"
				+ "order by price desc nulls last";
		String sql_sortByLittleReview = 
				"select distinct cottage_id,cottage_name,cottage_cat,cottage_location,photo_url,price,cottage_longitude_x,cottage_latitude_y,reviewCount\r\n"
				+ "from cottage inner join cottage_photo using(cottage_id) \r\n"
				+ "left outer join (select cottage_id,avg(room_standard_price) price from cottage_room group by cottage_id) using(cottage_id)\r\n"
				+ "left outer join review using(cottage_id)\r\n"
				+ "left outer join (select cottage_id,count(cottage_id) reviewCount from review group by cottage_id) using(cottage_id)\r\n"
				+ "where cottage_location like ?\r\n"
				+ "order by reviewCount asc nulls last";
		String sql_sortByManyReview = 
				"select distinct cottage_id,cottage_name,cottage_cat,cottage_location,photo_url,price,cottage_longitude_x,cottage_latitude_y,reviewCount\r\n"
				+ "from cottage inner join cottage_photo using(cottage_id) \r\n"
				+ "left outer join (select cottage_id,avg(room_standard_price) price from cottage_room group by cottage_id) using(cottage_id)\r\n"
				+ "left outer join review using(cottage_id)\r\n"
				+ "left outer join (select cottage_id,count(cottage_id) reviewCount from review group by cottage_id) using(cottage_id)\r\n"
				+ "where cottage_location like ?\r\n"
				+ "order by reviewCount desc nulls last";
		String sidoGugun = scVO.getSido() + " " + scVO.getGugun() + "%";
		System.out.println(sidoGugun);
		
		Connection conn = DBUtil.dbConnect();
		PreparedStatement st  = null;
		ResultSet rs = null;
		
		try {
			if(whatSort.equals("낮은 가격 순")) {
				st = conn.prepareStatement(sql_sortByLowPrice);
			}else if(whatSort.equals("높은 가격 순")) {
				st = conn.prepareStatement(sql_sortByHighPrice);
			}else if(whatSort.equals("리뷰 적은 순")) {
				st = conn.prepareStatement(sql_sortByLittleReview);
			}else if(whatSort.equals("리뷰 많은 순")) {
				st = conn.prepareStatement(sql_sortByManyReview);
			}
			st.setString(1, sidoGugun);
			rs = st.executeQuery();
			while(rs.next()) {
				searchList.add(new SearchResultVO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getDouble(7),
						rs.getDouble(8),
						rs.getInt(9)
					)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return searchList;
	}
	
}
