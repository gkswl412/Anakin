package com.anakin.manager;

public class CottageVO {
	String manager_id= "";
	int cottage_id= 0;
	String cottage_name= "";
	String cottage_location= "";
	String cottage_phone_number= "";
	String cottage_description= "";
	String cottage_cat="";
	String cottage_longitude_x="";
	String cottage_latitude_y="";
	
	public CottageVO() {}
	
	
	public CottageVO( String cottage_name, String cottage_location,
			String cottage_phone_number, String cottage_description, String cottage_cat, String cottage_longitude_x, String cottage_latitude_y) {
		super();
		this.cottage_name = cottage_name;
		this.cottage_location = cottage_location;
		this.cottage_phone_number = cottage_phone_number;
		this.cottage_description = cottage_description;
		this.cottage_cat = cottage_cat;
		this.cottage_longitude_x = cottage_longitude_x;
		this.cottage_latitude_y = cottage_latitude_y;
	}
	
	public CottageVO( int cottage_id, String cottage_name, String cottage_location,
			String cottage_phone_number, String cottage_description, String cottage_cat) {
		super();
		this.cottage_id = cottage_id;
		this.cottage_name = cottage_name;
		this.cottage_location = cottage_location;
		this.cottage_phone_number = cottage_phone_number;
		this.cottage_description = cottage_description;
		this.cottage_cat = cottage_cat;
	}
	
	public CottageVO(String manager_id, int cottage_id, String cottage_name, String cottage_location,
			String cottage_phone_number, String cottage_description, String cottage_cat) {
		super();
		this.manager_id = manager_id;
		this.cottage_id = cottage_id;
		this.cottage_name = cottage_name;
		this.cottage_location = cottage_location;
		this.cottage_phone_number = cottage_phone_number;
		this.cottage_description = cottage_description;
		this.cottage_cat = cottage_cat;
	}

	public CottageVO(String manager_id, int cottage_id, String cottage_name, String cottage_location,
			String cottage_phone_number, String cottage_description, String cottage_cat, String cottage_longitude_x,
			String cottage_latitude_y) {
		super();
		this.manager_id = manager_id;
		this.cottage_id = cottage_id;
		this.cottage_name = cottage_name;
		this.cottage_location = cottage_location;
		this.cottage_phone_number = cottage_phone_number;
		this.cottage_description = cottage_description;
		this.cottage_cat = cottage_cat;
		this.cottage_longitude_x = cottage_longitude_x;
		this.cottage_latitude_y = cottage_latitude_y;
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

	public String getCottage_longitude_x() {
		return cottage_longitude_x;
	}

	public void setCottage_longitude_x(String cottage_longitude_x) {
		this.cottage_longitude_x = cottage_longitude_x;
	}

	public String getCottage_latitude_y() {
		return cottage_latitude_y;
	}

	public void setCottage_latitude_y(String cottage_latitude_y) {
		this.cottage_latitude_y = cottage_latitude_y;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CottageVO [manager_id=").append(manager_id).append(", cottage_id=").append(cottage_id)
				.append(", cottage_name=").append(cottage_name).append(", cottage_location=").append(cottage_location)
				.append(", cottage_phone_number=").append(cottage_phone_number).append(", cottage_description=")
				.append(cottage_description).append(", cottage_cat=").append(cottage_cat)
				.append(", cottage_longitude_x=").append(cottage_longitude_x).append(", cottage_latitude_y=")
				.append(cottage_latitude_y).append("]");
		return builder.toString();
	}
	
	
}
