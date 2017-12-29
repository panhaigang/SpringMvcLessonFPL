package cn.et.lesson07.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.lesson07.services.FoodService;

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
