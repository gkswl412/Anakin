package com.anakin.user.VO;

public class SearchResultVO {
	String manager_id ="";
	int cottage_id= 0;
	String cottage_name= "";
	String cottage_location= "";
	String cottage_phone_number= "";
	String cottage_description= "";
	String cottage_cat="";
	double cottage_longitude_X=0;
	double cottage_latitude_Y=0;
	int photo_id=0;
	int room_id=0;
	String photo_name="";
	String photo_url="";
	
	public SearchResultVO() {}
	
	public SearchResultVO(String manager_id, int cottage_id, String cottage_name, String cottage_location,
			String cottage_phone_number, String cottage_description, String cottage_cat, double cottage_longitude_X,
			double cottage_latitude_Y, int photo_id, int room_id, String photo_name, String photo_url) {
		super();
		this.manager_id = manager_id;
		this.cottage_id = cottage_id;
		this.cottage_name = cottage_name;
		this.cottage_location = cottage_location;
		this.cottage_phone_number = cottage_phone_number;
		this.cottage_description = cottage_description;
		this.cottage_cat = cottage_cat;
		this.cottage_longitude_X = cottage_longitude_X;
		this.cottage_latitude_Y = cottage_latitude_Y;
		this.photo_id = photo_id;
		this.room_id = room_id;
		this.photo_name = photo_name;
		this.photo_url = photo_url;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchResultVO [manager_id=").append(manager_id).append(", cottage_id=").append(cottage_id)
				.append(", cottage_name=").append(cottage_name).append(", cottage_location=").append(cottage_location)
				.append(", cottage_phone_number=").append(cottage_phone_number).append(", cottage_description=")
				.append(cottage_description).append(", cottage_cat=").append(cottage_cat)
				.append(", cottage_longitude_X=").append(cottage_longitude_X).append(", cottage_latitude_Y=")
				.append(cottage_latitude_Y).append(", photo_id=").append(photo_id).append(", room_id=").append(room_id)
				.append(", photo_name=").append(photo_name).append(", photo_url=").append(photo_url).append("]");
		return builder.toString();
	}

	public String getManager_id() {
		return manager_id;
	}

	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}

	public int getCottage_id() {
		return cottage_id;
	}

	public void setCottage_id(int cottage_id) {
		this.cottage_id = cottage_id;
	}

	public String getCottage_name() {
		return cottage_name;
	}

	public void setCottage_name(String cottage_name) {
		this.cottage_name = cottage_name;
	}

	public String getCottage_location() {
		return cottage_location;
	}

	public void setCottage_location(String cottage_location) {
		this.cottage_location = cottage_location;
	}

	public String getCottage_phone_number() {
		return cottage_phone_number;
	}

	public void setCottage_phone_number(String cottage_phone_number) {
		this.cottage_phone_number = cottage_phone_number;
	}

	public String getCottage_description() {
		return cottage_description;
	}

	public void setCottage_description(String cottage_description) {
		this.cottage_description = cottage_description;
	}

	public String getCottage_cat() {
		return cottage_cat;
	}

	public void setCottage_cat(String cottage_cat) {
		this.cottage_cat = cottage_cat;
	}

	public double getCottage_longitude_X() {
		return cottage_longitude_X;
	}

	public void setCottage_longitude_X(double cottage_longitude_X) {
		this.cottage_longitude_X = cottage_longitude_X;
	}

	public double getCottage_latitude_Y() {
		return cottage_latitude_Y;
	}

	public void setCottage_latitude_Y(double cottage_latitude_Y) {
		this.cottage_latitude_Y = cottage_latitude_Y;
	}

	public int getPhoto_id() {
		return photo_id;
	}

	public void setPhoto_id(int photo_id) {
		this.photo_id = photo_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getPhoto_name() {
		return photo_name;
	}

	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}

	public String getPhoto_url() {
		return photo_url;
	}

	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}

	
}
