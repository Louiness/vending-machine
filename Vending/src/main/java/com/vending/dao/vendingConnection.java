package com.vending.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBの連結初期設定
 * 
 * @author 林基文
 *
 */
public class vendingConnection {

	// コネクション
	Connection conn;

	/**
	 * コネクションの連結設定を行う
	 * @param　なし
	 * @return　conn(コネクション情報)
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public Connection getConnection() throws Exception {

		String user = "scott";
		String pw = "4568";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, user, pw);

		return conn;
	}
}
