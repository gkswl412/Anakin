package com.anakin.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.anakin.user.VO.CottageVO;
import com.anakin.user.VO.Cottage_photoVO;

import util.DBUtil;

public class CottageDATAinsertToDB {
	public static void test() {
		
		BufferedReader br = null;
		String result = "";
		String sql = "insert into cottage values(?,?,?,?,?,?,?,?,?)";
		String sql2 = "insert into cottage_photo values(?,?,?,?,?)";
		
		Connection conn= DBUtil.dbConnect();
		PreparedStatement st= null;
		PreparedStatement st2 = null;
		PreparedStatement st3 = null;
		
		try {
			String urlstr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchStay?"+
					"serviceKey=7N1ck9BJoJ79alkE4apYfS4bLQ9%2BfmVbi01uunVJc9YbXbzk4sffi7I3GCI%2FIJKhrRJDpum0tie6cz0st3wIvw%3D%3D" + 
					"&numOfRows=10000&pageSize=10&pageNo=1&MobileOS=ETC&" +
					"MobileApp=AppTest&arrange=P&listYN=Y&_type=json";
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
			String line;
			while((line = br.readLine()) != null) {
				result = result + line + "\n";
			}
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
			JSONObject parse_response = (JSONObject) jsonObject.get("response");
			JSONObject parse_body = (JSONObject) parse_response.get("body");
			JSONObject parse_items = (JSONObject) parse_body.get("items");
			JSONArray parse_item = (JSONArray) parse_items.get("item");
			JSONObject cottage;
			int cnt=0;
			int cnt2=0;
			String cat="";
			for(int i=0 ; i<parse_item.size(); i++) {
				cottage = (JSONObject) parse_item.get(i);
				System.out.println((String) cottage.get("title"));
				
				st = conn.prepareStatement(sql);
				st2 = conn.prepareStatement(sql2);
				
				//cottage_id = (�����ڵ�) + (�ñ����ڵ�) + i
				String str = String.valueOf(cottage.get("areacode")) + String.valueOf(cottage.get("sigungucode")); 
				int cottage_id = str.equals("nullnull")? 115:Integer.parseInt(str);
				cottage_id *= 10000;
				cottage_id += (i+1);
				
				
				st.setString(1, "�̵��");
				st.setInt(2, cottage_id);
				st.setString(3, (String) cottage.get("title"));
				st.setString(4, (String) cottage.get("addr1"));
				st.setString(5, (String) cottage.get("tel"));
				st.setString(6, "�̵��");
				cat = (String) cottage.get("cat3");
				if(cat.equals("B02010100")) {
					cat = "����ȣ��";
				}else if(cat.equals("B02010200")) {
					cat = "�������ȣ��";
				}else if(cat.equals("B02010300")) {
					cat = "����ȣ��";
				}else if(cat.equals("B02010400")) {
					cat = "����ȣ��";
				}else if(cat.equals("B02010500")) {
					cat = "�ܵ��̴Ͼ�";
				}else if(cat.equals("B02010600")) {
					cat = "����ȣ����";
				}else if(cat.equals("B02010700")) {
					cat = "���";
				}else if(cat.equals("B02010800")) {
					cat = "����";
				}else if(cat.equals("B02010900")) {
					cat = "����";
				}else if(cat.equals("B02011000")) {
					cat = "�ι�";
				}else if(cat.equals("B02011100")) {
					cat = "�Խ�Ʈ�Ͽ콺";
				}else if(cat.equals("B02011200")) {
					cat = "Ȩ������";
				}else if(cat.equals("B02011300")) {
					cat = "���񽺵巹������";
				}else if(cat.equals("B02011400")) {
					cat = "�Ƿ����ȣ��";
				}else if(cat.equals("B02011500")) {
					cat = "����ȣ��";
				}else if(cat.equals("B02011600")){
					cat = "�ѿ�������";
				}else {
					cat = "�̺з�";
				}
					
				
				st.setString(7, cat);
				//st.addBatch();
				double longitudeX = cottage.get("mapx")==null?0:Double.valueOf(String.valueOf(cottage.get("mapx")));
				double latitudeY = cottage.get("mapy")==null?0:Double.valueOf(String.valueOf(cottage.get("mapy")));
				st.setDouble(8, longitudeX);
				st.setDouble(9, latitudeY);
				cnt += st.executeUpdate();
				if(st!=null) {
					
					st.close();
				}
				
				
				
				//st.close();
				if(cottage.get("firstimage")!=null) {
					st2 = conn.prepareStatement(sql2);
					//photo_id : 1xxxx : main image
					//           2xxxx : room image
					//           3xxxx : �δ�ü� image
					//           4xxxx : ������ image
					
					String str2 = "1"+i; //main image
					
					int photo_id = Integer.parseInt(str2);
					st2.setInt(1, photo_id);
					st2.setInt(2, cottage_id);
					st2.setInt(3, 0);
					st2.setString(4, "mainImage");
					st2.setString(5,(String) cottage.get("firstimage"));
					//st2.addBatch();
					cnt2 += st2.executeUpdate();
					
					if(st2!=null) {
						
						st2.close();
					}
				}

				/*if(cottage.get("firstimage2")!=null) {
					st2 = conn.prepareStatement(sql2);
					st2.setInt(1, i+26);
					st2.setInt(2, i);
					st2.setInt(3, 0);
					st2.setString(4, "mainImage2");
					st2.setString(5,(String) cottage.get("firstimage2"));
					cnt2 += st2.executeUpdate();
				}*/
				
			}
			System.out.println(cnt + "�� ����!");
			System.out.println(cnt2 + "�� ����!");
			//int[] cnt = st.executeBatch();
			//System.out.println("cottage ���̺� " + cnt.length + "��" + "insert ����");
			//int[] cnt2 = st2.executeBatch();
			//System.out.println("cottage_photo ���̺� " + cnt2.length + "��" + "insert ����");
			//st.clearBatch();
			//st2.clearBatch();
			conn.commit();
		} catch (IOException | ParseException | SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(null, st, null);
			DBUtil.dbClose(conn, st2, null);
		}
		
		
		
	}


	/* String manager_id ="";
	int cottage_id= 0;
	String cottage_name= "";
	String cottage_phone_number= "";
	String cottage_location= "";
	String cottage_description= "";
	
	int photo_id;
	int cottage_id;
	int room_id;
	String photo_name;
	String photo_url; */
	
	
	
	
	
}