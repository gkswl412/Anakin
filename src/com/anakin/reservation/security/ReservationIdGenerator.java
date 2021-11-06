package com.anakin.reservation.security;

import java.security.MessageDigest;
import java.security.SecureRandom;
 
public class ReservationIdGenerator {
	
	private static final int SALT_SIZE = 16;
	private static DB db = new DB();
	
	
	// ���ο� ���� ����� 
	public void set_User(String ID, byte[] Password) throws Exception {	
		String SALT = getSALT();
		db.set_USER(ID, Hashing(Password, SALT), SALT);		
	}
	
    
	// ���� ������ ������ �� �α��� �ϱ� 
	public void get_User(String ID, byte[] password) throws Exception {
		String temp_salt = db.get_SALT(ID);					// �ش� ID�� SALT ���� ã�´� 
		
		String temp_pass = Hashing(password, temp_salt);	// ���� Salt �� password �� �����غ���.
		
		if(db.check(ID,temp_pass)) {						// db �� ����� ���̵�� ��й�ȣ�� �����Ѵ� 
			System.out.println("�α��� ����");
		}
		else {
			System.out.println("�α��� ����");
		}
		
	}
	
	
	// ��й�ȣ �ؽ�  
	private String Hashing(byte[] password, String Salt) throws Exception {
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");	// SHA-256 �ؽ��Լ��� ��� 
 
		// key-stretching
		for(int i = 0; i < 10000; i++) {
			String temp = Byte_to_String(password) + Salt;	// �н������ Salt �� ���� ���ο� ���ڿ� ���� 
			md.update(temp.getBytes());						// temp �� ���ڿ��� �ؽ��Ͽ� md �� �����صд� 
			password = md.digest();							// md ��ü�� ��������Ʈ�� ��� password �� �����Ѵ� 
		}
		
		return Byte_to_String(password);
	}
	
	
	// SALT �� ����  
	private String getSALT() throws Exception {
		SecureRandom rnd = new SecureRandom();
		byte[] temp = new byte[SALT_SIZE];
		rnd.nextBytes(temp);
		
		return Byte_to_String(temp);
		
	}
	
	
	// ����Ʈ ���� 16������ �������ش� 
	private String Byte_to_String(byte[] temp) {
		StringBuilder sb = new StringBuilder();
		for(byte a : temp) {
			sb.append(String.format("%02x", a));
		}
		return sb.toString();
	}
	
	public void get_DB() {
		System.out.println("\n================DB���================\n");
		System.out.println(db);
	}
}