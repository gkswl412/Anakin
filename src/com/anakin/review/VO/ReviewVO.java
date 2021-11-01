package com.anakin.review.VO;

import java.util.Date;

public class ReviewVO {
  int review_id;
  String review_title; 
  String review_pw;
  String review_writer;
  Date review_date; 
  String review_description;
  String review_comment;
  int reservation_id;
  
 public ReviewVO() {};
  
  
public ReviewVO(int review_id, String review_title, String review_pw, String review_writer, Date review_date,
		String review_description, String review_comment, int reservation_id) {
	super();
	this.review_id = review_id;
	this.review_title = review_title;
	this.review_pw = review_pw;
	this.review_writer = review_writer;
	this.review_date = review_date;
	this.review_description = review_description;
	this.review_comment = review_comment;
	this.reservation_id = reservation_id;
}


public int getReview_id() {
	return review_id;
}


public void setReview_id(int review_id) {
	this.review_id = review_id;
}


public String getReview_title() {
	return review_title;
}


public void setReview_title(String review_title) {
	this.review_title = review_title;
}


public String getReview_pw() {
	return review_pw;
}


public void setReview_pw(String review_pw) {
	this.review_pw = review_pw;
}


public String getReview_writer() {
	return review_writer;
}


public void setReview_writer(String review_writer) {
	this.review_writer = review_writer;
}


public Date getReview_date() {
	return review_date;
}


public void setReview_date(Date review_date) {
	this.review_date = review_date;
}


public String getReview_description() {
	return review_description;
}


public void setReview_description(String review_description) {
	this.review_description = review_description;
}


public String getReview_comment() {
	return review_comment;
}


public void setReview_comment(String review_comment) {
	this.review_comment = review_comment;
}


public int getReservation_id() {
	return reservation_id;
}


public void setReservation_id(int reservation_id) {
	this.reservation_id = reservation_id;
}


@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("ReviewVO [review_id=").append(review_id).append(", review_title=").append(review_title)
			.append(", review_pw=").append(review_pw).append(", review_writer=").append(review_writer)
			.append(", review_date=").append(review_date).append(", review_description=").append(review_description)
			.append(", review_comment=").append(review_comment).append(", reservation_id=").append(reservation_id)
			.append("]");
	return builder.toString();
}
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
