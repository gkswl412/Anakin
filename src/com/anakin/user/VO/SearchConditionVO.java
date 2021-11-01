package com.anakin.user.VO;

public class SearchConditionVO {
	String sido="";
	String gugun="";
	String focus="";
	String checkinDate="";
	String checkoutDate="";
	
	public SearchConditionVO() {}
	
	public SearchConditionVO(String sido, String gugun, String focus, String checkinDate, String checkoutDate) {
		super();
		this.sido = sido;
		this.gugun = gugun;
		this.focus = focus;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getGugun() {
		return gugun;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	public String getFocus() {
		return focus;
	}

	public void setFocus(String focus) {
		this.focus = focus;
	}

	public String getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(String checkinDate) {
		this.checkinDate = checkinDate;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchConditionVO [sido=").append(sido).append(", gugun=").append(gugun).append(", focus=")
				.append(focus).append(", checkinDate=").append(checkinDate).append(", checkoutDate=")
				.append(checkoutDate).append("]");
		return builder.toString();
	}
	
	
}
