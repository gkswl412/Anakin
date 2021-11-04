package com.anakin.reservation.VO;

public class CottageRoomVO {
	int cottage_id;
	int room_id;
	String room_name;
	int room_occupancy;
	int room_standard_price;
	int room_holyday_price;
	int room_peak_season_price;
	int room_tv_count;
	int room_bathroom_count;
	String room_balcony_option;
	String room_status;
	String room_description;
	int room_count;
	
	public CottageRoomVO(int cottage_id, int room_id, String room_name, int room_occupancy, int room_standard_price,
			int room_holyday_price, int room_peak_season_price, int room_tv_count, int room_bathroom_count,
			String room_balcony_option, String room_status, String room_description, int room_count) {
		super();
		this.cottage_id = cottage_id;
		this.room_id = room_id;
		this.room_name = room_name;
		this.room_occupancy = room_occupancy;
		this.room_standard_price = room_standard_price;
		this.room_holyday_price = room_holyday_price;
		this.room_peak_season_price = room_peak_season_price;
		this.room_tv_count = room_tv_count;
		this.room_bathroom_count = room_bathroom_count;
		this.room_balcony_option = room_balcony_option;
		this.room_status = room_status;
		this.room_description = room_description;
		this.room_count = room_count;
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
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public int getRoom_occupancy() {
		return room_occupancy;
	}
	public void setRoom_occupancy(int room_occupancy) {
		this.room_occupancy = room_occupancy;
	}
	public int getRoom_standard_price() {
		return room_standard_price;
	}
	public void setRoom_standard_price(int room_standard_price) {
		this.room_standard_price = room_standard_price;
	}
	public int getRoom_holyday_price() {
		return room_holyday_price;
	}
	public void setRoom_holyday_price(int room_holyday_price) {
		this.room_holyday_price = room_holyday_price;
	}
	public int getRoom_peak_season_price() {
		return room_peak_season_price;
	}
	public void setRoom_peak_season_price(int room_peak_season_price) {
		this.room_peak_season_price = room_peak_season_price;
	}
	public int getRoom_tv_count() {
		return room_tv_count;
	}
	public void setRoom_tv_count(int room_tv_count) {
		this.room_tv_count = room_tv_count;
	}
	public int getRoom_bathroom_count() {
		return room_bathroom_count;
	}
	public void setRoom_bathroom_count(int room_bathroom_count) {
		this.room_bathroom_count = room_bathroom_count;
	}
	public String getRoom_balcony_option() {
		return room_balcony_option;
	}
	public void setRoom_balcony_option(String room_balcony_option) {
		this.room_balcony_option = room_balcony_option;
	}
	public String getRoom_status() {
		return room_status;
	}
	public void setRoom_status(String room_status) {
		this.room_status = room_status;
	}
	public String getRoom_description() {
		return room_description;
	}
	public void setRoom_description(String room_description) {
		this.room_description = room_description;
	}
	public int getRoom_count() {
		return room_count;
	}
	public void setRoom_count(int room_count) {
		this.room_count = room_count;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cottage_RoomVO [cottage_id=").append(cottage_id).append(", room_id=").append(room_id)
				.append(", room_name=").append(room_name).append(", room_occupancy=").append(room_occupancy)
				.append(", room_standard_price=").append(room_standard_price).append(", room_holyday_price=")
				.append(room_holyday_price).append(", room_peak_season_price=").append(room_peak_season_price)
				.append(", room_tv_count=").append(room_tv_count).append(", room_bathroom_count=")
				.append(room_bathroom_count).append(", room_balcony_option=").append(room_balcony_option)
				.append(", room_status=").append(room_status).append(", room_description=").append(room_description)
				.append(", room_count=").append(room_count).append("]");
		return builder.toString();
	}
	
	
	
}
