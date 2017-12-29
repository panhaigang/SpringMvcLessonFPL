package cn.et.lesson08.services.impl;

import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.lesson08.dao.FoodDao;
import cn.et.lesson08.entity.Food;
import cn.et.lesson08.services.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodDao dao;
	
	/**
	 * 调用dao层存储新菜品
	 * @param foodName
	 * @param price
	 */
	public void saveFood(String foodName , String price){
		dao.saveFood(foodName, price);
	}
	
	/**
	 * 根据菜品ID删除菜品
	 * @param foodId
	 */
	public void deleteFood(String foodId){
		dao.deleteFood(foodId);
	}
	
	/**
	 * 修改菜品信息
	 * @param foodId
	 * @param foodName
	 * @param price
	 */
	public void updateFood(String foodId , String foodName , String price){
		dao.updateFood(foodId, foodName, price);
	}
	
	/**
	 * 根据菜品名模糊查询菜品信息，dao层返回List<Food>结构的结果集，
	 * 此方法负责将结果集转换成JSONString，返回给Controller层
	 * @param foodName
	 * @return
	 */
	public String queryFoodsByName(String foodName){
		List<Food> list = dao.queryFoodsByName(foodName);
		JSONArray array = JSONArray.fromObject(list);
		return array.toString();
	}
	
	public List<Food> queryFoodsList(String foodName){
		List<Food> list = dao.queryFoodsByName(foodName);
		return list;
	}
}
