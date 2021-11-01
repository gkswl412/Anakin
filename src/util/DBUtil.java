package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
	//DB�ڿ��� �ݳ��ϰ� ������ �����ϴ� �ڵ�
	public static void dbClose(Connection conn, Statement st, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			System.out.println("�ڿ��ݳ�����");
			e.printStackTrace();
		}
	}
	//DB���� �ڵ�
	public static Connection dbConnect() {
		//Connection Pooling ����� �̿��� ���� : ����(����ġ ��Ĺ �����̳�)�� 
		//�̸� ��� DBConnection�� ����� ����
		//Servers/context.xml ���Ͽ� DB���ҽ� ������ �Է��ؾ� ��
		//������Ʈ WEB-INF/web.xml ���Ͽ� resource �߰� �ؾ���
		//��û�Ҷ����� DB ���� �ϴ� ���� ��ȿ��
		Context initContext;
		Connection conn = null;
		try {
			initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/Anakin");
			conn = ds.getConnection();
			conn.setAutoCommit(false);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
