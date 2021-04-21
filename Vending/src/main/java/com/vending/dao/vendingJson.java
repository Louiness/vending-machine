package com.vending.dao;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class vendingJson {

	public static void main(String[] args) {

		jsonAdd();

	}

	@SuppressWarnings("unchecked")
	public static void jsonAdd() {

		String json; // 파싱할 최종 데이터 담아주기 위한 문자열

		vendingList vendingList = new vendingList();

		JSONObject obj = new JSONObject();

		//obj.put("soldOutPlag", vending.getsoldOutPlag());

		// 테스트용 출력
		//System.out.println(json);

		// System.out.println(arr.toJSONString());
	}

}
