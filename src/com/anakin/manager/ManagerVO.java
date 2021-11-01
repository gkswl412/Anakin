package com.anakin.manager;

public class ManagerVO {
	String manager_id;
	String manager_pw;
	String manager_name;
	String manager_phone;
	String manager_email;
	
	public ManagerVO() {
		
	}
	
	public ManagerVO(String manager_id, String manager_pw, String manager_name, String manager_phone,
			String manager_email) {
		super();
		this.manager_id = manager_id;
		this.manager_pw = manager_pw;
		this.manager_name = manager_name;
		this.manager_phone = manager_phone;
		this.manager_email = manager_email;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public String getManager_pw() {
		return manager_pw;
	}
	public void setManager_pw(String manager_pw) {
		this.manager_pw = manager_pw;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public String getManager_phone() {
		return manager_phone;
	}
	public void setManager_phone(String manager_phone) {
		this.manager_phone = manager_phone;
	}
	public String getManager_email() {
		return manager_email;
	}
	public void setManager_email(String manager_email) {
		this.manager_email = manager_email;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ManagerVO [manager_id=").append(manager_id).append(", manager_pw=").append(manager_pw)
				.append(", manager_name=").append(manager_name).append(", manager_phone=").append(manager_phone)
				.append(", manager_email=").append(manager_email).append("]");
		return builder.toString();
	}
	
	
}
