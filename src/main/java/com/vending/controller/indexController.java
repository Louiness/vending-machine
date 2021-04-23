package com.vending.controller;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vending.dao.vendingList;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class indexController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {

		vendingList resultList = new vendingList();
		model.addAttribute("list", resultList.getvendingList());

		return "index";
	}

	@RequestMapping(value = "/purchase", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, String> getSoldOutFlag(String productNumber) {
			HashMap<String, String> dataMap = new HashMap<>();
			dataMap.put("soldOutFlag", "soldout");

			return dataMap;
	}
}