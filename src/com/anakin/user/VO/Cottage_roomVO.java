package com.anakin.user.VO;

public class Cottage_roomVO {
	int cottage_id;
	int room_id;
	String room_name;
	int room_occupancy;
	int room_standard_price;
	int room_holiday_price;
	int room_peak_season_price;
	int room_tv_count;
	int room_bathroom_count;
	String balcony_option;
	String room_status;
	String room_description;
	int room_count;
	String room_photo_url;
	
	public Cottage_roomVO() {}
	
	public Cottage_roomVO(int cottage_id, int room_id, String room_name, int room_occupancy, int room_standard_price,
			int room_holiday_price, int room_peak_season_price, int room_tv_count, int room_bathroom_count,
			String balcony_option, String room_status, String room_description, int room_count, String room_photo_url) {
		super();
		this.cottage_id = cottage_id;
		this.room_id = room_id;
		this.room_name = room_name;
		this.room_occupancy = room_occupancy;
		this.room_standard_price = room_standard_price;
		this.room_holiday_price = room_holiday_price;
		this.room_peak_season_price = room_peak_season_price;
		this.room_tv_count = room_tv_count;
		this.room_bathroom_count = room_bathroom_count;
		this.balcony_option = balcony_option;
		this.room_status = room_status;
		this.room_description = room_description;
		this.room_count = room_count;
		this.room_photo_url = room_photo_url;
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

	public int getRoom_holiday_price() {
		return room_holiday_price;
	}

	public void setRoom_holiday_price(int room_holiday_price) {
		this.room_holiday_price = room_holiday_price;
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

	public String getBalcony_option() {
		return balcony_option;
	}

	public void setBalcony_option(String balcony_option) {
		this.balcony_option = balcony_option;
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

	public String getRoom_photo_url() {
		return room_photo_url;
	}

	public void setRoom_photo_url(String room_photo_url) {
		this.room_photo_url = room_photo_url;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cottage_roomVO [cottage_id=").append(cottage_id).append(", room_id=").append(room_id)
				.append(", room_name=").append(room_name).append(", room_occupancy=").append(room_occupancy)
				.append(", room_standard_price=").append(room_standard_price).append(", room_holiday_price=")
				.append(room_holiday_price).append(", room_peak_season_price=").append(room_peak_season_price)
				.append(", room_tv_count=").append(room_tv_count).append(", room_bathroom_count=")
				.append(room_bathroom_count).append(", balcony_option=").append(balcony_option).append(", room_status=")
				.append(room_status).append(", room_description=").append(room_description).append(", room_count=")
				.append(room_count).append(", room_photo_url=").append(room_photo_url).append("]");
		return builder.toString();
	}
	
	
}
