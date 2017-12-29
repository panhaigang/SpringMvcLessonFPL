package cn.et.lesson07.services;

public interface FoodService {

	/**
	 * 调用dao层存储新菜品
	 * @param foodName
	 * @param price
	 */
	public abstract void saveFood(String foodName, String price);

	/**
	 * 根据菜品ID删除菜品
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
	 * 根据菜品名模糊查询菜品信息
	 * @param foodName
	 * @return
	 */
	public abstract String queryFoodsByName(String foodName);

}