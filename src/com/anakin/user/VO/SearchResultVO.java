package com.anakin.user.VO;

public class SearchResultVO {
	int cottage_id= 0;
	String cottage_name= "";
	String cottage_cat="";
	String cottage_location= "";
	String photo_url="";
	int price=0;
	double cottage_longitude_X=0;
	double cottage_latitude_Y=0;
	int reviewCount=0;
	
	public SearchResultVO() {}
	
	public SearchResultVO(int cottage_id, String cottage_name, String cottage_cat, String cottage_location,
			String photo_url, int price, double cottage_longitude_X, double cottage_latitude_Y,
			int reviewCount) {
		super();
		this.cottage_id = cottage_id;
		this.cottage_name = cottage_name;
		this.cottage_cat = cottage_cat;
		this.cottage_location = cottage_location;
		this.photo_url = photo_url;
		this.price = price;
		this.cottage_longitude_X = cottage_longitude_X;
		this.cottage_latitude_Y = cottage_latitude_Y;
		this.reviewCount = reviewCount;
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

	public String getCottage_cat() {
		return cottage_cat;
	}

	public void setCottage_cat(String cottage_cat) {
		this.cottage_cat = cottage_cat;
	}

	public String getCottage_location() {
		return cottage_location;
	}

	public void setCottage_location(String cottage_location) {
		this.cottage_location = cottage_location;
	}

	public String getPhoto_url() {
		return photo_url;
	}

	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}

	public int price() {
		return price;
	}

	public void price(int price) {
		this.price = price;
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

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchResultVO [cottage_id=").append(cottage_id).append(", cottage_name=").append(cottage_name)
				.append(", cottage_cat=").append(cottage_cat).append(", cottage_location=").append(cottage_location)
				.append(", photo_url=").append(photo_url).append(", room_standard_price=").append(price)
				.append(", cottage_longitude_X=").append(cottage_longitude_X).append(", cottage_latitude_Y=")
				.append(cottage_latitude_Y).append(", reviewCount=").append(reviewCount).append("]");
		return builder.toString();
	}
	
}
