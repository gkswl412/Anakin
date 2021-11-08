package com.anakin.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anakin.review.VO.ReviewReservationIdVO;
import com.anakin.review.VO.ReviewVO;

import util.DBUtil;



public class ReviewDAO {
   
	
	
	
	//리뷰 페이지 예약번호 입력
			public String  SelectReservationId(int reservedId, int cattage_id) {
				String result="0";
				String sql = " select reservation_id "
						+ "from reservation "
						+ "where reservation_id = ? and cattage_id = ? and reservation_checkout_date <= sysdate";
						
				Connection conn = DBUtil.dbConnect();
				PreparedStatement st = null;
				ResultSet rs = null;
				try {
					st = conn.prepareStatement(sql);
					st.setInt(1, reservedId);
					st.setInt(2, cattage_id);
					rs = st.executeQuery();
					while (rs.next()) {
						result="1";
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					DBUtil.dbClose(conn, st, rs);
				}
				return result;
			}
			
		
	
	
	
	
	
	
	
	
	
	
	
	//리뷰리스트
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
	
	//리뷰리스트
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
		
	
	//삭제
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
   	//리뷰 수정
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


	//리뷰작성
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
	
	
	
	

	//리뷰 답변
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
