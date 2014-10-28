package com.clsa.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clsa.web.domain.TransactionInfo;
import com.clsa.web.services.interfaces.IService;
/**
 * @author clsa
 * KFC restaurant will call this service to get money from user
 */
@Controller
@RequestMapping("/api/")
public class BankApi {

	@Autowired
	IService service;
	
	@RequestMapping("/withdraw")
	@ResponseBody
	public TransactionInfo withdraw(@RequestParam int withdraw){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
		return service.withdraw(name,withdraw);
	}
	
	@RequestMapping("/client")
	@ResponseBody
	public String clientService(){
		return "{\"message\":'This is service for client'}";
	}
	
}
