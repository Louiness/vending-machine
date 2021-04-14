package com.vending.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vending.dao.vendingList;

/**
 * Handles requests for the application home page.
 */
@Controller
public class indexController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {

		vendingList resultList = new vendingList();
		model.addAttribute("list", resultList.getvendingList());

		return "index";
	}
	
}
