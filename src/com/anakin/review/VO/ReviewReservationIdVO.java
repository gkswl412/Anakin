package com.anakin.review.VO;

import java.util.Date;

public class ReviewReservationIdVO {

	 int reservation_id;
	int cottage_id;
	Date reservation_checkout_date;
	
	public ReviewReservationIdVO() {}

	public ReviewReservationIdVO(int reservation_id, int cottage_id, Date reservation_checkout_date) {
		super();
		this.reservation_id = reservation_id;
		this.cottage_id = cottage_id;
		this.reservation_checkout_date = reservation_checkout_date;
	}

	public int getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}

	public int getCottage_id() {
		return cottage_id;
	}

	public void setCottage_id(int cottage_id) {
		this.cottage_id = cottage_id;
	}

	public Date getReservation_checkout_date() {
		return reservation_checkout_date;
	}

	public void setReservation_checkout_date(Date reservation_checkout_date) {
		this.reservation_checkout_date = reservation_checkout_date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReviewReservationIdVO [reservation_id=").append(reservation_id).append(", cottage_id=")
				.append(cottage_id).append(", reservation_checkout_date=").append(reservation_checkout_date)
				.append("]");
		return builder.toString();
	};
	
	
	
	
}
	