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
	 */
	public Connection getConnection() {

		try {
			String user = "scott";
			String pw = "4568";
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);

		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB 드라이버 로딩 실패 :" + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB 접속실패 : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		}
		return conn;
	}
}
