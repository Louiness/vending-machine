package com.vending.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vending.dao.vendingInventory;
import com.vending.dao.vendingDao;

@Controller
public class vendingController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {

		vendingDao resultList = new vendingDao();
		model.addAttribute("list", resultList.getvendingList());

		return "index";
	}
	
	@RequestMapping(value = "/purchase", method = RequestMethod.GET)
	public boolean plag(Model model, String productNumber) {
		
//		vendingInventory inventory = new vendingInventory();

//		Boolean test = inventory.getInventory(productNumber);
		
		return false;
	}
	
}
