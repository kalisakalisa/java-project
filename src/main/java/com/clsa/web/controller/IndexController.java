package com.clsa.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clsa.web.domain.Account;
import com.clsa.web.services.interfaces.IService;

/**
 * @author clsa
 * This is index page, user can view current balance
 */
@Controller
public class IndexController {
	@Autowired
	IService service;
	
	@RequestMapping("/index")
	public String index(Model model){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Account account =service.search(authentication.getName());
		if(account!=null){
			model.addAttribute("name", account.getFullname());
			model.addAttribute("balance",account.getBalance());
		}else{
			model.addAttribute("name", null);
			model.addAttribute("balance",null);
		}
		return "index";
	}
		
}
