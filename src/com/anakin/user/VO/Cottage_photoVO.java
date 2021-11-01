package com.anakin.user.VO;

public class Cottage_photoVO {
	int photo_id;
	int cottage_id;
	int room_id;
	String photo_name;
	String photo_url;
	
	public Cottage_photoVO() {}
	
	public Cottage_photoVO(int photo_id, int cottage_id, int room_id, String photo_name, String photo_url) {
		super();
		this.photo_id = photo_id;
		this.cottage_id = cottage_id;
		this.room_id = room_id;
		this.photo_name = photo_name;
		this.photo_url = photo_url;
	}

	public int getPhoto_id() {
		return photo_id;
	}

	public void setPhoto_id(int photo_id) {
		this.photo_id = photo_id;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cottage_photoVO [photo_id=").append(photo_id).append(", cottage_id=").append(cottage_id)
				.append(", room_id=").append(room_id).append(", photo_name=").append(photo_name).append(", photo_url=")
				.append(photo_url).append("]");
		return builder.toString();
	}
	
}
