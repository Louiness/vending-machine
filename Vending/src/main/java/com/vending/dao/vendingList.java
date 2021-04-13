package com.vending.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class vendingList {

	Connection conn;

	PreparedStatement pstm;

	ResultSet rs;

	List<vendingVO> vendingList = new ArrayList<>();

	/* Testのデイタテストリスト */
	public List<vendingVO> getvendingList() {

		try {

			String quary = "SELECT * FROM (SELECT * FROM JAPAN ORDER BY DBMS_RANDOM.RANDOM) WHERE ROWNUM <= 10";

			conn = connection.getConnection();

			pstm = conn.prepareStatement(quary);

			rs = pstm.executeQuery();

			while (rs.next()) {

				String item_Number = rs.getString("ITEM_NUMBER");
				int item_Quantity = rs.getInt("ITEM_QUANTITY");
				int max_Item_Quantity = rs.getInt("MAX_ITEM_QUANTITY");

				vendingList.add(new vendingVO(item_Number, item_Quantity, max_Item_Quantity));

			}

			return vendingList;
		} catch (Exception e) {
			System.out.println("vendingList 에러 발생");

		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

			}
		}
		return vendingList;
	}
}
