package or.itschool.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnection {
	final String DRIVER = "com.mysql.cj.jdbc.Driver";
	final String URI = "jdbc:/mysql://localhost:3306/spring?allowPublicKeyRetrieval=true&useSSL=false";
	final String UID = "spring";
	final String UPW = "spring";
	
	public void connectTest() throws Exception{
		Class.forName(DRIVER);
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URI, UID, UPW);
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) conn.close();
		}
	}
}
