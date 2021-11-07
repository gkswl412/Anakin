package com.anakin.manager.VO;

import java.sql.Date;

public class ReservationVO1 {
	
	private String room_name;
	private int reservation_id; // = getCottage_id() + getRoom_id() + (int)System.currentTimeMillis();
	private int cottage_id;// : number(10) - foreign key
	private int room_id;// : number(10) - foreign key
	private String user_name;// : varchar2(20) - not null
	private String user_phone_number;// : varchar2(15) - not null, unique
	private Date reservation_checkin_date;// : date - not null
	private Date reservation_checkout_date;// : date - not null
	private int reservation_people_count;// : number(3) - not null
	private String reservation_description;
	
	
	public ReservationVO1() {super();}


	public ReservationVO1(String room_name, int reservation_id, int cottage_id, int room_id, String user_name,
			String user_phone_number, Date reservation_checkin_date, Date reservation_checkout_date,
			int reservation_people_count, String reservation_description) {
		super();
		this.room_name = room_name;
		this.reservation_id = reservation_id;
		this.cottage_id = cottage_id;
		this.room_id = room_id;
		this.user_name = user_name;
		this.user_phone_number = user_phone_number;
		this.reservation_checkin_date = reservation_checkin_date;
		this.reservation_checkout_date = reservation_checkout_date;
		this.reservation_people_count = reservation_people_count;
		this.reservation_description = reservation_description;
	}

	public String getRoom_name() {
		return room_name;
	}


	public void setRoom_name(String room_name) {
		this.room_name = room_name;
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


	public int getRoom_id() {
		return room_id;
	}


	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getUser_phone_number() {
		return user_phone_number;
	}


	public void setUser_phone_number(String user_phone_number) {
		this.user_phone_number = user_phone_number;
	}


	public Date getReservation_checkin_date() {
		return reservation_checkin_date;
	}


	public void setReservation_checkin_date(Date reservation_checkin_date) {
		this.reservation_checkin_date = reservation_checkin_date;
	}


	public Date getReservation_checkout_date() {
		return reservation_checkout_date;
	}


	public void setReservation_checkout_date(Date reservation_checkout_date) {
		this.reservation_checkout_date = reservation_checkout_date;
	}


	public int getReservation_people_count() {
		return reservation_people_count;
	}


	public void setReservation_people_count(int reservation_people_count) {
		this.reservation_people_count = reservation_people_count;
	}


	public String getReservation_description() {
		return reservation_description;
	}


	public void setReservation_description(String reservation_description) {
		this.reservation_description = reservation_description;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReservationVO1 [room_name=").append(room_name).append(", reservation_id=")
				.append(reservation_id).append(", cottage_id=").append(cottage_id).append(", room_id=").append(room_id)
				.append(", user_name=").append(user_name).append(", user_phone_number=").append(user_phone_number)
				.append(", reservation_checkin_date=").append(reservation_checkin_date)
				.append(", reservation_checkout_date=").append(reservation_checkout_date)
				.append(", reservation_people_count=").append(reservation_people_count)
				.append(", reservation_description=").append(reservation_description).append("]");
		return builder.toString();
	}

	
}
