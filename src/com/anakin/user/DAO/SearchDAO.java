package com.anakin.user.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.anakin.user.VO.CottageVO;
import com.anakin.user.VO.SearchConditionVO;
import com.anakin.user.VO.SearchResultVO;

import util.DBUtil;

public class SearchDAO {
	
	public List<SearchResultVO> selectByArea(SearchConditionVO scVO){
		List<SearchResultVO> searchList = new ArrayList<>();
		String sql =
				"select cottage_id,cottage_name,cottage_cat,cottage_location,photo_url,availableRoomCount,prices,cottage_longitude_x,cottage_latitude_y,reviewCount\r\n"
				+ "from cottage left outer join (select cottage_id,count(cottage_id) availableRoomCount from cottage_room where room_id not in \r\n"
				+ "(select room_id from reservation where reservation_checkin_date between ? and ? \r\n"
				+ "or reservation_checkout_date between ? and ?)\r\n"
				+ "group by cottage_id) using(cottage_id) \r\n"
				+ "inner join (select cottage_id, photo_url from cottage_photo where photo_name='mainImage') using(cottage_id)\r\n"
				+ "left outer join (select cottage_id,avg(room_standard_price) prices from cottage_room group by cottage_id) using(cottage_id)\r\n"
				+ "left outer join (select cottage_id,count(cottage_id) reviewCount from review group by cottage_id) using(cottage_id)\r\n"
				+ "where cottage_location like ?\r\n"
				+ "order by case when availableRoomCount is null then 1 else 0 end";
		String sidoGugun = scVO.getSido() + " " + scVO.getGugun() + "%";
		String checkIn = scVO.getCheckinDate() + " 15:00:00.0";
		String checkOut = scVO.getCheckoutDate() + " 12:00:00.0";
		//Timestamp checkInDate = java.sql.Timestamp.valueOf(checkIn);
		//Timestamp checkOutDate = java.sql.Timestamp.valueOf(checkOut);
		//System.out.println(sidoGugun);
		//System.out.println(checkIn);
		//System.out.println(checkOut);
		//System.out.println(checkInDate);
		//System.out.println(checkOutDate);
		
		Connection conn = DBUtil.dbConnect();
		PreparedStatement st  = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, checkIn);
			st.setString(2, checkOut);
			st.setString(3, checkIn);
			st.setString(4, checkOut);
			st.setString(5, sidoGugun);
			rs = st.executeQuery();
			while(rs.next()) {
				searchList.add(new SearchResultVO(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getInt(6),
							rs.getInt(7),
							rs.getDouble(8),
							rs.getDouble(9),
							rs.getInt(10)
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
				"select cottage_id,cottage_name,cottage_cat,cottage_location,photo_url,availableRoomCount,max(room_standard_price) prices,cottage_longitude_x,cottage_latitude_y,reviewCount\r\n"
				+ "from cottage left outer join (select cottage_id,count(cottage_id) availableRoomCount from cottage_room where room_id not in \r\n"
				+ "(select room_id from reservation where reservation_checkin_date between ? and ?\r\n"
				+ "or reservation_checkout_date between ? and ?)\r\n"
				+ "group by cottage_id) using(cottage_id) \r\n"
				+ "inner join (select cottage_id, photo_url from cottage_photo where photo_name='mainImage') using(cottage_id)\r\n"
				+ "left outer join cottage_room using(cottage_id)\r\n"
				+ "left outer join (select cottage_id,count(cottage_id) reviewCount from review group by cottage_id) using(cottage_id)\r\n"
				+ "where (availableRoomCount > 0 or availableRoomCount is null) and cottage_location like ?\r\n"
				+ "group by cottage_id,cottage_name,cottage_cat,cottage_location,photo_url,availableRoomCount,cottage_longitude_x,cottage_latitude_y,reviewCount\r\n"
				+ "order by case when availableRoomCount is null then 1 else 0 end,prices asc nulls last";
		String sql_sortByHighPrice = 
				"select cottage_id,cottage_name,cottage_cat,cottage_location,photo_url,availableRoomCount,max(room_standard_price) prices,cottage_longitude_x,cottage_latitude_y,reviewCount\r\n"
				+ "from cottage left outer join (select cottage_id,count(cottage_id) availableRoomCount from cottage_room where room_id not in \r\n"
				+ "(select room_id from reservation where reservation_checkin_date between ? and ? \r\n"
				+ "or reservation_checkout_date between ? and ?)\r\n"
				+ "group by cottage_id) using(cottage_id) \r\n"
				+ "inner join (select cottage_id, photo_url from cottage_photo where photo_name='mainImage') using(cottage_id)\r\n"
				+ "left outer join cottage_room using(cottage_id)\r\n"
				+ "left outer join (select cottage_id,count(cottage_id) reviewCount from review group by cottage_id) using(cottage_id)\r\n"
				+ "where (availableRoomCount > 0 or availableRoomCount is null) and cottage_location like ?\r\n"
				+ "group by cottage_id,cottage_name,cottage_cat,cottage_location,photo_url,availableRoomCount,cottage_longitude_x,cottage_latitude_y,reviewCount\r\n"
				+ "order by case when availableRoomCount is null then 1 else 0 end,prices desc nulls last";
		String sql_sortByLittleReview = 
				"select cottage_id,cottage_name,cottage_cat,cottage_location,photo_url,availableRoomCount,prices,cottage_longitude_x,cottage_latitude_y,reviewCount\r\n"
				+ "from cottage left outer join (select cottage_id,count(cottage_id) availableRoomCount from cottage_room where room_id not in \r\n"
				+ "(select room_id from reservation where reservation_checkin_date between ? and ?\r\n"
				+ "or reservation_checkout_date between ? and ?)\r\n"
				+ "group by cottage_id) using(cottage_id) \r\n"
				+ "inner join (select cottage_id, photo_url from cottage_photo where photo_name='mainImage') using(cottage_id)\r\n"
				+ "left outer join (select cottage_id,avg(room_standard_price) prices from cottage_room group by cottage_id) using(cottage_id)\r\n"
				+ "left outer join (select cottage_id,count(cottage_id) reviewCount from review group by cottage_id) using(cottage_id)\r\n"
				+ "where cottage_location like ?\r\n"
				+ "order by case when availableRoomCount is null then 1 else 0 end,reviewCount asc nulls last";
		String sql_sortByManyReview = 
				"select cottage_id,cottage_name,cottage_cat,cottage_location,photo_url,availableRoomCount,prices,cottage_longitude_x,cottage_latitude_y,reviewCount\r\n"
				+ "from cottage left outer join (select cottage_id,count(cottage_id) availableRoomCount from cottage_room where room_id not in \r\n"
				+ "(select room_id from reservation where reservation_checkin_date between ? and ? \r\n"
				+ "or reservation_checkout_date between ? and ?)\r\n"
				+ "group by cottage_id) using(cottage_id) \r\n"
				+ "inner join (select cottage_id, photo_url from cottage_photo where photo_name='mainImage') using(cottage_id)\r\n"
				+ "left outer join (select cottage_id,avg(room_standard_price) prices from cottage_room group by cottage_id) using(cottage_id)\r\n"
				+ "left outer join (select cottage_id,count(cottage_id) reviewCount from review group by cottage_id) using(cottage_id)\r\n"
				+ "where cottage_location like ?\r\n"
				+ "order by case when availableRoomCount is null then 1 else 0 end,reviewCount desc nulls last";
		
		String sidoGugun = scVO.getSido() + " " + scVO.getGugun() + "%";
		String checkIn = scVO.getCheckinDate() + " 15:00:00.0";
		String checkOut = scVO.getCheckoutDate() + " 12:00:00.0";
		//Timestamp checkInDate = java.sql.Timestamp.valueOf(checkIn);
		//Timestamp checkOutDate = java.sql.Timestamp.valueOf(checkOut);
		//System.out.println(sidoGugun);
		//System.out.println(checkIn);
		//System.out.println(checkOut);
		//System.out.println(checkInDate);
		//System.out.println(checkOutDate);

		
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
			st.setString(1, checkIn);
			st.setString(2, checkOut);
			st.setString(3, checkIn);
			st.setString(4, checkOut);
			st.setString(5, sidoGugun);
			rs = st.executeQuery();
			while(rs.next()) {
				searchList.add(new SearchResultVO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getDouble(8),
						rs.getDouble(9),
						rs.getInt(10)
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
	
	public String selectCottageDescriptionByCottageId(int cottage_id) {
		String description = "";
		String sql = "select cottage_description from cottage where cottage_id = ?";
		
		Connection conn = DBUtil.dbConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, cottage_id);
			rs = st.executeQuery();
			while(rs.next()) {
				description = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return description;
	}
	
}
