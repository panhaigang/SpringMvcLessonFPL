package cn.et.lesson04.controller;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.lesson04.entity.User;


@Controller
public class UserController {

	@RequestMapping(value="reg" , method = RequestMethod.POST)
	public String userReg(@Valid User userInfo , BindingResult errors){
		// 个人网址
		return "index";
	}
	
	@RequestMapping(value="/forward" , method = RequestMethod.GET)
	public String forward(@Valid User userInfo , BindingResult errors){
		return userReg(userInfo, errors);
	}
}
