package cn.et.lesson08.dao;

import java.util.List;

import cn.et.lesson08.entity.Food;

public interface FoodDao {

	/**
	 * 新增菜品
	 * @param foodName
	 * @param price
	 */
	public abstract void saveFood(String foodName, String price);

	/**
	 * 删除菜品
	 * @param foodId
	 */
	public abstract void deleteFood(String foodId);

	/**
	 * 修改菜品信息
	 * @param foodId
	 * @param foodName
	 * @param price
	 */
	public abstract void updateFood(String foodId, String foodName, String price);

	/**
	 * 根据菜品名模糊查询
	 * @param foodName
	 * @return
	 */
	public abstract List<Food> queryFoodsByName(String foodName);

}