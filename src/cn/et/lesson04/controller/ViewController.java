package cn.et.lesson04.controller;

import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.et.lesson04.entity.User;

@Controller
public class ViewController {

	
	@RequestMapping(value = "c1")
	public String case1(@ModelAttribute("harry") User user , PrintWriter writer){
		writer.println("content-type:text/html;charset=UTF-8");
		writer.println("user: " + user);
		
		
		return null;
	}
}
