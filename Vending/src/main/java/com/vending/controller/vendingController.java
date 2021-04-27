package com.vending.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vending.dao.vendingDao;
import com.vending.dao.vendingInventory;
import com.vending.vo.vendingVO;
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
	 * @return　CSI0101A(初期画面)
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String init(Model model) {

		vendingDao resultList = new vendingDao();
		
		List<vendingVO> vendingList = resultList.getvendingList();
		
		if(vendingList.isEmpty()) {
			return "CSI0201E";
		}
		
		model.addAttribute("list", vendingList);

		return "CSI0101A";
	}
	
	/**
	 * 自動販売機ボダンイベント
	 * @param　String productNumber（製品情報）
	 * @return　レスポンスマップ
	 */
	@RequestMapping(value = "/purchase", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, String> getSoldOutFlag(String productNumber) {
		
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
