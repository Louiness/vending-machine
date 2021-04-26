package com.vending.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.vending.common.vendingConstant;
import com.vending.vo.vendingVO;

/**
 * 製品情報リスト
 * @author 林基文
 *
 */
public class vendingDao {
	// コネクション
	Connection conn;
	// ステートメント
	PreparedStatement pstm;
	// リザルト
	ResultSet rs;
	//　製品情報リスト
	List<vendingVO> vendingList = new ArrayList<>();

	/**
	 * 製品情報リストを返還する処理を行う
	 * @param　なし
	 * @return　vendingList(製品情報リスト)
	 */
	public List<vendingVO> getvendingList() {

		try {

			String quary = quaryJoinProcess();
			vendingConnection connection = new vendingConnection();
			
			conn = connection.getConnection();
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeQuery();

			while (rs.next()) {

				String itemNumber = rs.getString("ITEM_NUMBER");
				int price = rs.getInt("PRICE");
				String itemImage = rs.getString("ITEM_IMAGE");
				String soldOutFlag = rs.getString("SOLDOUTFLAG"); 
				vendingList.add(new vendingVO(itemNumber, price, itemImage, soldOutFlag));

			}
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
	
	/**
	 * SQL構文の結果を返還する処理を行う
	 * @param　なし
	 * @return　sb.toString(SQL構文)
	 */
	public String quaryJoinProcess() {
		
		StringBuilder sb = new StringBuilder();

		String startQuary = "SELECT A.ITEM_NUMBER, B.PRICE, B.ITEM_IMAGE,CASE WHEN ITEM_QUANTITY <= ";
		String middleQuary1 = " THEN ";
		String middleQuary2 = " ELSE ";
		String endQuary = " END AS SOLDOUTFLAG FROM STOCK A INNER JOIN PRODUCT_INFOMATION B ON (A.ITEM_NUMBER = B.ITEM_NUMBER)";

		sb.append(startQuary);
		sb.append(vendingConstant.ZERO);
		sb.append(middleQuary1);
		sb.append(vendingConstant.ONE);
		sb.append(middleQuary2);
		sb.append(vendingConstant.ZERO);
		sb.append(endQuary);
		
		return sb.toString();

	}
	
	
}
