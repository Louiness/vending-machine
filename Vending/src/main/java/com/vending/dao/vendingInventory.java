package com.vending.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import com.vending.common.vendingConstant;

/**
 * 在庫処理後存在有無
 * @author 林基文
 *
 */
public class vendingInventory {
	// コネクション
	Connection conn;
	// ステートメント
	PreparedStatement pstm;
	// リザルト
	ResultSet rs;
	//　売り切れプラグ
	String soldOutFlag;
	
	/**
	 * 在庫数の処理を行う
	 * @param　String productNumber（製品情報）
	 * @return　soldOutFlag(売り切れプラグ)
	 */
	public HashMap<String, String> getInventory(String productNumber) throws Exception{

		HashMap<String, String> dataMap = new HashMap<>();
		

			String quary = quaryUpdateProcess();
			vendingConnection connection = new vendingConnection();
			
			conn = connection.getConnection();
			pstm = conn.prepareStatement(quary);
			pstm.setString(1, productNumber);
			if(pstm.executeUpdate() != vendingConstant.UPDATESUCCESS) {
				dataMap.put(vendingConstant.STATE, vendingConstant.FAIL);
				dataMap.put(vendingConstant.ERROR, vendingConstant.ERRS0002);
				return dataMap;
			}

			dataMap.put(vendingConstant.STATE, vendingConstant.SUCCESS);
			quary = quaryConditionProcess();
			pstm = conn.prepareStatement(quary);
			pstm.setString(1, productNumber);
			rs = pstm.executeQuery();

			while (rs.next()) {
				dataMap.put(vendingConstant.SOLDOUTFLAG, rs.getString("SOLDOUTFLAG"));
			}

				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}

		return dataMap;

	}

	/**
	 * 在庫数を処理するSQL構文を返還する
	 * @param　なし
	 * @return　sb.toString(SQL構文)
	 */
	public String quaryUpdateProcess() {

		StringBuilder sb = new StringBuilder();

		String startQuary = "UPDATE STOCK SET ITEM_QUANTITY = ITEM_QUANTITY - ";

		String endQuary = " WHERE ITEM_NUMBER = ?";

		sb.append(startQuary);
		sb.append(vendingConstant.ONE);
		sb.append(endQuary);

		return sb.toString();

	}

	/**
	 * 在庫数有無結果を処理するSQL構文を返還する
	 * @param　なし
	 * @return　sb.toString(SQL構文)
	 */
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
