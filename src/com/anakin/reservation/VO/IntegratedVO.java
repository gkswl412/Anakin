package com.anakin.reservation.VO;

import java.sql.Date;

public class IntegratedVO {

	private String user_name;
	private long reservation_id;
	private String cottage_name;
	private String room_name;
	private String reservation_chekin_date;
	private String reservation_checkout_date;
	
	public IntegratedVO(String user_name, long reservation_id, String cottage_name, String room_name,
			String reservation_chekin_date, String reservation_checkout_date) {
		super();
		this.user_name = user_name;
		this.reservation_id = reservation_id;
		this.cottage_name = cottage_name;
		this.room_name = room_name;
		this.reservation_chekin_date = reservation_chekin_date;
		this.reservation_checkout_date = reservation_checkout_date;
	}

	public IntegratedVO() {
		// TODO Auto-generated constructor stub
	}

	public String getUser_name() {
		return user_name;
	}

	public long getReservation_id() {
		return reservation_id;
	}

	public String getCottage_name() {
		return cottage_name;
	}

	public String getRoom_name() {
		return room_name;
	}

	public String getReservation_chekin_date() {
		return reservation_chekin_date;
	}

	public String getReservation_checkout_date() {
		return reservation_checkout_date;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public void setReservation_id(long reservation_id) {
		this.reservation_id = reservation_id;
	}

	public void setCottage_name(String cottage_name) {
		this.cottage_name = cottage_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public void setReservation_chekin_date(String reservation_chekin_date) {
		this.reservation_chekin_date = reservation_chekin_date;
	}

	public void setReservation_checkout_date(String reservation_checkout_date) {
		this.reservation_checkout_date = reservation_checkout_date;
	}
	
}
