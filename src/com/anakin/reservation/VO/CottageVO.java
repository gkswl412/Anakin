package com.anakin.reservation.VO;

public class CottageVO {
	String manager_id;
	int cottage_id;
	String cottage_name;
	String cottage_location;
	String cottage_phone_number;
	String cottage_description;
	
	public CottageVO() {
		super();
	}
	
	public CottageVO(String manager_id, int cottage_id, String cottage_name, String cottage_phone_number, String cottage_location,
			String cottage_description) {
		super();
		this.manager_id = manager_id;
		this.cottage_id = cottage_id;
		this.cottage_name = cottage_name;
		this.cottage_phone_number = cottage_phone_number;
		this.cottage_location = cottage_location;
		this.cottage_description = cottage_description;
	}

	public int getCottage_id() {
		return cottage_id;
	}

	public void setCottage_id(int cottage_id) {
		this.cottage_id = cottage_id;
	}

	public String getManager_id() {
		return manager_id;
	}

	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}

	public String getCottage_name() {
		return cottage_name;
	}

	public void setCottage_name(String cottage_name) {
		this.cottage_name = cottage_name;
	}

	public String getCottage_phone_number() {
		return cottage_phone_number;
	}

	public void setCottage_phone_number(String cottage_phone_number) {
		this.cottage_phone_number = cottage_phone_number;
	}

	public String getCottage_location() {
		return cottage_location;
	}

	public void setCottage_location(String cottage_location) {
		this.cottage_location = cottage_location;
	}

	public String getCottage_description() {
		return cottage_description;
	}

	public void setCottage_description(String cottage_description) {
		this.cottage_description = cottage_description;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("cottageVO [manager_id=").append(manager_id).append(", cottage_id=").append(cottage_id)
				.append(", cottage_name=").append(cottage_name).append(", cottage_phone_number=")
				.append(cottage_phone_number).append(", cottage_location=").append(cottage_location)
				.append(", cottage_description=").append(cottage_description).append("]");
		return builder.toString();
	}

	
}

