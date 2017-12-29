package cn.et.lesson06.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.lesson06.dao.FoodDaoImpl;

@Service
public class FoodServicesImpl {

	@Autowired
	private FoodDaoImpl dao;

	public String queryFoodsByName(String foodName) {

		List<Map<String, Object>> list = dao.queryFoodsByName(foodName);

		JSONArray array = JSONArray.fromObject(list);
		
		/*
		 * JSONObject object = JSONObject.fromObject(list);
		 * net.sf.json.JSONException: 'object' is an array. Use JSONArray
		 * instead
		 */
		return array.toString();
	}
}
