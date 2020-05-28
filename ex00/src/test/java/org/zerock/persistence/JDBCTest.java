package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest {
	public static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static {
		try {
			Class.forName(ORACLE_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "book_ex";
		String password = "book_ex";
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			log.info(con);
		} catch (Exception e) {
			System.err.println("시스템 에러 발생");
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
}
