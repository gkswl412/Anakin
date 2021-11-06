package com.anakin.manager;

import java.util.List;

import com.anakin.review.VO.ReviewVO;



public class ReviewService1 {
 
	ReviewDAO1 dao= new ReviewDAO1();
	
	
	
	public List<ReviewVO1> SelectList(int cottage_id) {
		return dao.selectList(cottage_id);
	}
	
	public ReviewVO  SelectById(int reviewid) {
		return dao.selectById(reviewid);
	}
	
	public int UpdateReview1(ReviewVO1 r) {
		return dao.UpdateReview1(r);
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
	
	
	
	
}
