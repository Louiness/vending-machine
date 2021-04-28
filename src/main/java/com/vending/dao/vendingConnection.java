package com.vending.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class vendingConnection {

    public static Connection getConnection() throws Exception {
    Connection conn = null;
        String user = "c##scott";
        String pw = "4568";
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(url, user, pw);
        return conn;
    }
}