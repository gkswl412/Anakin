package com.anakin.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.anakin.review.VO.ReviewVO;

import util.DBUtil;



public class ReviewDAO {
   
	
	
	//∏Æ∫‰∏ÆΩ∫∆Æ
	public List<ReviewVO> selectList(int cottage_id) {
		List<ReviewVO> reviewlist = new ArrayList<>();
		String sql = "select * from review where cottage_id=? order by 1 desc ";
		Connection conn = DBUtil.dbConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, cottage_id);
			rs = st.executeQuery();
			while (rs.next()) {
				ReviewVO review = new ReviewVO();
				review.setReview_id(rs.getInt(1));
				review.setReview_title(rs.getString(2));
				review.setReview_pw(rs.getString(3));
				review.setReview_writer(rs.getString(4));
				review.setReview_date(rs.getDate(5));
				review.setReview_description(rs.getString(6));
				review.setReservation_id(rs.getInt(7));
				review.setReview_comment(rs.getString(8));
				review.setCottage_id(rs.getInt(9));
				
				
				
				
				
				
				reviewlist.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return reviewlist;
	}
	
	//∏Æ∫‰∏ÆΩ∫∆Æ
		public ReviewVO selectById(int reviewid) {
			ReviewVO review = null;
			String sql = "select * from review where review_id = ?";
			Connection conn = DBUtil.dbConnect();
			PreparedStatement st = null;
			ResultSet rs = null;
			try {
				st = conn.prepareStatement(sql);
				st.setInt(1, reviewid);
				rs = st.executeQuery();
				if (rs.next()) {
					review = new ReviewVO();
					review.setReview_id(rs.getInt(1));
					review.setReview_title(rs.getString(2));
					review.setReview_pw(rs.getString(3));
					review.setReview_writer(rs.getString(4));
					review.setReview_date(rs.getDate(5));
					review.setReview_description(rs.getString(6));	
					review.setReservation_id(rs.getInt(7));
					review.setReview_comment(rs.getString(8));
					review.setCottage_id(rs.getInt(9));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.dbClose(conn, st, rs);
			}
			return review;
		}
		
	
	//ªË¡¶
	public int DeleteReview(String review_pw) {
		int result = 0;  
		String sql=" delete from review where review_pw = ?";
		Connection conn = DBUtil.dbConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, review_pw);
			result = st.executeUpdate();
			 conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, null);
		}
		return result;
	}
   	//∏Æ∫‰ ºˆ¡§
	public int UpdateReview(ReviewVO rev) {
		int result = 0;  
		String sql="update review set review_title=?,review_pw=?,review_writer=?,review_description=?"
				 + " where review_id=?"; 

		Connection conn = DBUtil.dbConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, rev.getReview_title());
			st.setString(2, rev.getReview_pw());
			st.setString(3, rev.getReview_writer());
			st.setString(4, rev.getReview_description());
		
			st.setInt(5, rev.getReview_id());
			
			result = st.executeUpdate();
			 conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, null);
		}
		return result;
	}


	//∏Æ∫‰¿€º∫
	public int InsertReview(ReviewVO rev) {
		int result = 0;  
		String sql=" insert into review(review_id,review_title,review_pw,review_writer,review_date,review_description,cottage_id)"
				+ " values(review_id_seq.nextval,?,?,?,sysdate,?,?)";
				
		
		
		Connection conn = DBUtil.dbConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			
		
			st.setString(1, rev.getReview_title());
			st.setString(2, rev.getReview_pw());
			st.setString(3, rev.getReview_writer());
			st.setString(4, rev.getReview_description());
			st.setInt(5, rev.getCottage_id());
		 
	
			result = st.executeUpdate();
	        conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, null);
		}
		return result;
	}
	
	
	
	

	//∏Æ∫‰ ¥‰∫Ø
	public int CommentReview(ReviewVO rev) {		
		int result = 0;  
		String sql="update review set review_title=?,review_pw=?,review_writer=?,review_description=?,review_comment=?"
				 + "where review_id=?"; 

		Connection conn = DBUtil.dbConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, rev.getReview_title());
			st.setString(2, rev.getReview_pw());			
			st.setString(3, rev.getReview_writer());
			st.setString(4, rev.getReview_description());
			st.setString(5, rev.getReview_comment());
			st.setInt(6, rev.getReview_id());
			
			
			result = st.executeUpdate();
		 conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	e.printStackTrace();
		} finally {
		DBUtil.dbClose(conn, st, null);
		}
	return result;
	}

	
}
