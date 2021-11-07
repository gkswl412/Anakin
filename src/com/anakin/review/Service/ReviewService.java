package com.anakin.review.Service;

import java.util.List;

import com.anakin.review.ReviewDAO;
import com.anakin.review.VO.ReviewReservationIdVO;
import com.anakin.review.VO.ReviewVO;



public class ReviewService {
 
	ReviewDAO dao= new ReviewDAO();
	
	
	
	public List<ReviewVO> SelectList(int cottage_id) {
		return dao.selectList(cottage_id);
	}
	
	public ReviewVO  SelectById(int reviewid) {
		return dao.selectById(reviewid);
	}
	
	
	public int InsertReview(ReviewVO rev) {
		return dao.InsertReview(rev);
	}
	
	
	public int DeleteReview(String review_pw) {
		
		return dao.DeleteReview(review_pw);
		
	}
	
	public  int UpdateReview(ReviewVO rev) {
		
		return dao.UpdateReview(rev);
		
		
	}
	
	
	public  int CommentReview(ReviewVO rev) {
		
		return dao.CommentReview(rev);
		
		
	}
	
	public  List<ReviewReservationIdVO> SelectReservationId(int cottage_id){
		
		return dao.SelectReservationId(cottage_id);
		
	}
	
	
}
