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
	//DB자원을 반납하고 연결을 종료하는 코드
	public static void dbClose(Connection conn, Statement st, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			System.out.println("자원반납실패");
			e.printStackTrace();
		}
	}
	//DB연결 코드
	public static Connection dbConnect() {
		//Connection Pooling 기능을 이용한 연결 : 서버(아파치 톰캣 컨테이너)가 
		//미리 몇개의 DBConnection을 만들어 놓음
		//Servers/context.xml 파일에 DB리소스 정보를 입력해야 함
		//프로젝트 WEB-INF/web.xml 파일에 resource 추가 해야함
		//요청할때마다 DB 열결 하는 것은 비효율
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
