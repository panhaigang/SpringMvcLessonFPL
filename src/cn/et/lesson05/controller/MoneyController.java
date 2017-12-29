package cn.et.lesson05.controller;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.lesson05.services.MoneyServicesImpl;

@Controller
public class MoneyController {

	@Autowired
	private MoneyServicesImpl services;
	
	@RequestMapping(value = "transfer" , method = RequestMethod.POST)
	public String transfer(Integer money , PrintWriter writer){
		services.transfer(money);
		writer.println("Your Balance: " + services.queryMoney());
		return null;
	}
}
