package com.anakin.reservation.security;

import java.util.ArrayList;

public class DB {
	
	private static ArrayList<String[]> UserData = new ArrayList<>();
	
	
	// ���� ���� 
	public void set_USER(String ID, String Hasing_Password, String SALT) {
		String[] temp = {ID, Hasing_Password, SALT};
		UserData.add(temp);		
	}
	
	// ���� ID �� ��й�ȣ�� ��ġ�ϴ��� üũ 
	public boolean check(String ID, String Hasing_password) {
		for(int i = 0; i < UserData.size(); i++) {
			if(ID.equals(UserData.get(i)[0])) {				// ID ��ġ�ϴ� ���� ã����� 
				if(Hasing_password.equals(UserData.get(i)[1])) {	// ��������Ʈ�� ��ġ�� ��� true
					return true;
				}
			}
		}
		return false;
	}
	
	// �ش� ID �� SALT �� ã�� 
	public String get_SALT(String ID) {
		String err = null;		// ���̵� �������� ���� ��� null ���� 
		for(int i = 0; i < UserData.size(); i++) {
			if(ID.equals(UserData.get(i)[0])) {
				return UserData.get(i)[2];
			}
		}
		return err;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(String[] temp : UserData) {
			sb.append("ID : " +temp[0] + "\tPassword : " + temp[1] + "\tSALT : "+ temp[2]).append("\n\n");
		}
		return sb.toString();
	}
 
}