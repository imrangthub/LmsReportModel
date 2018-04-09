package com.imran.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.imran.model.Loan;
import com.imran.service.LoanService;

@Controller
public class HomeController {
	
	 
	@Autowired
	LoanService loanService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap map) {	
		
       List<Loan> loanList =  loanService.loanList();
       map.addAttribute("loanList", loanList);

		return "home";
	}

}