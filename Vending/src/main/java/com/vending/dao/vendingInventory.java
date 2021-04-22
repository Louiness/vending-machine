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

	public Boolean getInventory(String productNumber) {

		Boolean soldOutPlag = false;

		try {

			String quary = quaryUpdateProcess();
			conn = connection.getConnection();
			pstm.setString(1, productNumber);
			pstm = conn.prepareStatement(quary);
			pstm.executeUpdate();

			quary = quaryConditionProcess();
			pstm.setString(1, productNumber);
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeQuery();
			soldOutPlag = rs.getBoolean("SOLDOUTPLAG");

		} catch (SQLException sqle) {
			System.out.println("JapanUpDate에서 예러 발생");

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

		return soldOutPlag;

	}

	public String quaryUpdateProcess() {

		StringBuilder sb = new StringBuilder();

		String startQuary = "UPDATE STOCK SET ITEM_QUANTITY = ITEM_QUANTITY - ";

		String endQuary = " WHERE ITEM_NUMBER='?'";

		sb.append(startQuary);
		sb.append(vendingConstant.ONE);
		sb.append(endQuary);

		return sb.toString();

	}

	public String quaryConditionProcess() {
		
		StringBuilder sb = new StringBuilder();

		String startQuary = "SELECT CASE WHEN ITEM_QUANTITY <= ";
		String middle1 = " THEN ";
		String middle2 = " ELSE ";
		String endQuary = " END AS SOLDOUTPLAG FROM STOCK WHERE ITEM_NUMBER='?'";

		sb.append(startQuary);
		sb.append(vendingConstant.ZERO);
		sb.append(middle1);
		sb.append(vendingConstant.ONE);
		sb.append(middle2);
		sb.append(vendingConstant.ZERO);
		sb.append(endQuary);
		
		return sb.toString();

	}
	
	
	
}
