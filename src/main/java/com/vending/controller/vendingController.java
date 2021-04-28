package com.vending.controller;

import com.vending.dao.vendingDao;
import com.vending.vo.vendingVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vending.dao.vendingInventory;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class vendingController {
	/**
	 * 自動販売機初期画面
	 * @param　Model model（モデル）
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String init(Model model) {

		vendingDao resultList = new vendingDao();

		try{
			List<vendingVO> vendingList = resultList.getvendingList();

			model.addAttribute("list", vendingList);

			return "CSI0101A";
		}catch(Exception e){
			e.printStackTrace();
			return "CSI0201A";
		}
	}

	/**
	 * 自動販売機ボダンイベント
	 * @param　String productNumber（製品情報）
	 * @return　レスポンスマップ
	 */
	@RequestMapping(value = "/purchase", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, String> getSoldOutFlag(String productNumber) throws Exception {

		HashMap<String, String> dataMap = new HashMap<>();

		if(productNumber.isEmpty()) {
			dataMap.put("state", "fail");
			dataMap.put("error", "ERRS0001");
		} else {
			vendingInventory inventory = new vendingInventory();
			dataMap = inventory.getInventory(productNumber);
		}
		return dataMap;
	}

}