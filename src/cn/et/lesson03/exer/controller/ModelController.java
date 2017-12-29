package cn.et.lesson03.exer.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelController {

	
	@RequestMapping(value="/case" , method = RequestMethod.GET)
	public ModelAndView case1(){
		
		ModelAndView mav = new ModelAndView("res.jsp");
		mav.addObject("sex", "boy");
		
		return mav;
	}
	
	@RequestMapping(value="/case2" , method = RequestMethod.GET)
	public String case2(Model model){
		model.addAttribute("key", "value");
		return "res.jsp";
	}
	
	@RequestMapping(value="/case3" , method = RequestMethod.GET)
	public String case3(Map<String, Object> map){
		map.put("key", "value");
		return "res.jsp";
	}
}
