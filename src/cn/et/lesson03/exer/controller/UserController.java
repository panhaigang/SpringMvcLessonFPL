package cn.et.lesson03.exer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.lesson03.exer.entity.User;

@Controller
public class UserController {

	@RequestMapping(value="reg" , method = RequestMethod.POST)
	public String userReg(@ModelAttribute("u") @Valid User userInfo , BindingResult errors){
		
		if (errors.hasErrors()) {
			// 两次密码不相符
			if (!userInfo.getPassword().equals(userInfo.getRePassword())) {
				
				/*
				 *  发现第一个参数随意填写都可以，因为现在是单例模式，
				 *  Spring默认按类型来匹配，所以错误信息也能够被填充到
				 *  BindingResult中。
				 */
				errors.addError(new FieldError("someUsers", "rePassword", "两次密码输入不一致"));
			}
		}
		return "/index.jsp";
	}
}
