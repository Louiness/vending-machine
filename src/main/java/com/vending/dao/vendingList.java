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

    public List<vendingVO> getvendingList() {

        try {

            String quary = "SELECT A.ITEM_NUMBER, B.PRICE, B.ITEM_IMAGE,CASE WHEN ITEM_QUANTITY <= 0 THEN '1' ELSE '0' END AS SOLDOUTPLAG FROM STOCK A INNER JOIN PRODUCT_INFOMATION B ON (A.ITEM_NUMBER = B.ITEM_NUMBER)";

            conn = connection.getConnection();

            pstm = conn.prepareStatement(quary);

            rs = pstm.executeQuery();

            while (rs.next()) {

                String itemNumber = rs.getString("ITEM_NUMBER");
                int price = rs.getInt("PRICE");
                String itemImage = rs.getString("ITEM_IMAGE");
                Boolean soldOutPlag = rs.getBoolean("SOLDOUTPLAG");
                vendingList.add(new vendingVO(itemNumber, price, itemImage, soldOutPlag));

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