package cn.et.lesson08.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.et.lesson08.entity.Food;
import cn.et.lesson08.services.FoodService;

@Controller
public class FoodController {

	@Autowired
	private FoodService service;

	/**
	 * 根据菜品名模糊查询
	 * 
	 * @param foodName
	 * @param os
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public void queryFoodsByName(String foodName, OutputStream os)
			throws UnsupportedEncodingException, IOException {
		String JSONString = service.queryFoodsByName(foodName);
		os.write(JSONString.getBytes("UTF-8"));
	}
	
	/**
	 * 直接返回Json字节
	 * @param foodName
	 * @param os
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/queryFood", method = RequestMethod.GET)
	public byte[] queryFoodsByName_jsonStr(String foodName)
			throws UnsupportedEncodingException, IOException {
		String JSONString = service.queryFoodsByName(foodName);
		return JSONString.getBytes("UTF-8");
	}
	
	@ResponseBody
	@RequestMapping(value = "/queryFoodList", method = RequestMethod.GET)
	public List<Food> queryFoodsList(String foodName) throws UnsupportedEncodingException{
		List<Food> list = service.queryFoodsList(foodName);
		return list;
	}
	
	/**
	 * 新增菜品
	 * 
	 * @param foodName
	 * @param price
	 * @param os
	 * @throws IOException
	 */
	@RequestMapping(value = "/saveFood", method = RequestMethod.POST)
	public void saveFood(String foodName, String price, OutputStream os)
			throws IOException {
		try {
			service.saveFood(foodName, price);
			os.write("0".getBytes());
		} catch (Exception e) {
			os.write("1".getBytes());
		}
	}

	/**
	 * 根据菜品ID删除菜品
	 * 
	 * @param foodId
	 * @param os
	 * @throws IOException
	 */
	@RequestMapping(value = "delFood/{foodId}", method = RequestMethod.DELETE)
	public void deleteFood(@PathVariable String foodId, OutputStream os)
			throws IOException {
		try {
			service.deleteFood(foodId);
			os.write("0".getBytes());
		} catch (Exception e) {
			os.write("1".getBytes());
		}
	}

	/**
	 * 修改菜品信息
	 * @param foodName
	 * @param foodId
	 * @param price
	 * @param os
	 * @throws IOException
	 */
	@RequestMapping(value = "updateFood", method = RequestMethod.PUT)
	public void updateFood(String foodName, String foodId, String price,
			OutputStream os) throws IOException {
		try {
			service.updateFood(foodId, foodName, price);
			os.write("0".getBytes());
		} catch (Exception e) {
			os.write("1".getBytes());
		}
	}
}
