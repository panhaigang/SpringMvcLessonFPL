package cn.et.lesson03.task.controller;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.lesson03.task.entity.User;


@Controller
public class UserController {

	@RequestMapping(value="reg" , method = RequestMethod.POST)
	public String userReg(@Valid User userInfo , BindingResult errors){
		
		if (!"".equals(userInfo.getBirthday())) {
			
			try {
				
				// 先取出输入的月份
				String mon = userInfo.getBirthday().split("-")[1];
				
				/*
				 *  再把日期转换成date类型，如果转换错误，则认为是格式不正确，
				 *  Java的日期转换有个特性，如果日期超出了月份的最后一天，它会
				 *  自动偏移，利用这个特性可以判断本月有没有这一天
				 */
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date date = format.parse(userInfo.getBirthday());
				
				// 转换之后的月份
				String parseMon = format.format(date).split("-")[1];
				
				// 再把转换后的月份和原来的月份相比较，如果发生了偏移，这个月就没有这一天。
				if (!parseMon.equals(mon)) {
					errors.addError(new FieldError("user" , "birthday" , mon + "月没有" + userInfo.getBirthday().split("-")[2] + "日哦"));
				}
			} catch (Exception e) {
				errors.addError(new FieldError("user" , "birthday" , "日期格式错误"));
			}
		}
		
		
		// 个人网址
		
		return "/index.jsp";
	}
}
