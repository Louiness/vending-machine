package com.vending.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vending.dao.vendingDao;
import com.vending.dao.vendingInventory;
/**
 * 自動販売機コントロール
 * @author 林基文
 *
 */
@Controller
public class vendingController {
	/**
	 * 自動販売機初期画面
	 * @param　Model model（モデル）
	 * @return　index(index.jsp)
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {

		vendingDao resultList = new vendingDao();
		model.addAttribute("list", resultList.getvendingList());

		return "index";
	}
	
	/**
	 * 自動販売機ボダンイベント
	 * @param　String productNumber（製品情報）
	 * @return　dataMap(売り切れプラグ)
	 */
	@RequestMapping(value = "/purchase", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, String> getSoldOutFlag(String productNumber) {
			HashMap<String, String> dataMap = new HashMap<>();
			vendingInventory inventory = new vendingInventory();
			
			dataMap.put("soldOutFlag", inventory.getInventory(productNumber));

			return dataMap;
	}
	
}
