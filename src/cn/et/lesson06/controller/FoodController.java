package cn.et.lesson06.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.lesson06.entity.User;
import cn.et.lesson06.service.FoodServicesImpl;

@Controller
public class FoodController {

	@Autowired
	private FoodServicesImpl services;
	
	/**
	 * 接收Json字符串，返回给页面
	 * @param foodName
	 * @param writer
	 * @return
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/query" , method = RequestMethod.GET)
	public String query(String foodName , OutputStream os) throws UnsupportedEncodingException, IOException{
		os.write(services.queryFoodsByName(foodName).getBytes("UTF-8"));
		return null;
	}
	
	
	/**
	 * 如果后台返回的是个JSONObject，
	 * 前端直接obj.userName就OK了，数组的话就得遍历。
	 * @param foodName
	 * @param os
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/q" , method = RequestMethod.GET)
	public String q(String foodName , OutputStream os) throws UnsupportedEncodingException, IOException{
		User user = new User();
		user.setUserName("张三");
		user.setPassword("zs");
		
		JSONObject object = JSONObject.fromObject(user);
		
		os.write(object.toString().getBytes("UTF-8"));
		return null;
	}
}