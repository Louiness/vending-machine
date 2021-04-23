package com.vending.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vending.common.vendingConstant;

public class vendingInventory {

	Connection conn;

	PreparedStatement pstm;

	ResultSet rs;

	public String getInventory(String productNumber) {

		String soldOutFlag = "";

		try {

			String quary = quaryUpdateProcess();
			conn = connection.getConnection();
			pstm = conn.prepareStatement(quary);
			pstm.setString(1, productNumber);
			pstm.executeUpdate();

			quary = quaryConditionProcess();
			pstm = conn.prepareStatement(quary);
			pstm.setString(1, productNumber);
			rs = pstm.executeQuery();

			while (rs.next()) {
				soldOutFlag = rs.getString("SOLDOUTFLAG");
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			// DB 연결을 종료한다.
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
				throw new RuntimeException(e.getMessage());
			}
		}

		return soldOutFlag;

	}

	public String quaryUpdateProcess() {

		StringBuilder sb = new StringBuilder();

		String startQuary = "UPDATE STOCK SET ITEM_QUANTITY = ITEM_QUANTITY - ";

		String endQuary = " WHERE ITEM_NUMBER = ?";

		sb.append(startQuary);
		sb.append(vendingConstant.ONE);
		sb.append(endQuary);

		return sb.toString();

	}

	public String quaryConditionProcess() {

		StringBuilder sb = new StringBuilder();

		String startQuary = "SELECT CASE WHEN ITEM_QUANTITY <= ";
		String middleQuary1 = " THEN '";
		String middleQuary2 = "' ELSE '";
		String endQuary = "' END AS SOLDOUTFLAG FROM STOCK WHERE ITEM_NUMBER = ?";

		sb.append(startQuary);
		sb.append(vendingConstant.ZERO);
		sb.append(middleQuary1);
		sb.append(vendingConstant.SOLDOUT);
		sb.append(middleQuary2);
		sb.append(vendingConstant.BLANK);
		sb.append(endQuary);

		return sb.toString();

	}

}
