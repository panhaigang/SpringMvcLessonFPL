package cn.et.lesson08.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.et.lesson08.dao.FoodDao;
import cn.et.lesson08.entity.Food;

@Repository
public class FoodDaoImpl implements FoodDao {

	@Autowired
	private JdbcTemplate template;
	
	/**
	 * 新增菜品
	 * @param foodName
	 * @param price
	 */
	public void saveFood(String foodName , String price){
		String sql = "insert into food (foodname , price) values (?,?)";
		template.update(sql, foodName , price);
	}
	
	/**
	 * 删除菜品
	 * @param foodId
	 */
	public void deleteFood(String foodId){
		String sql = "delete from food where foodid = ?";
		template.update(sql, foodId);
	}
	
	/**
	 * 修改菜品信息
	 * @param foodId
	 * @param foodName
	 * @param price
	 */
	public void updateFood(String foodId, String foodName , String price){
		String sql = "update food set foodname = ? , price = ? where foodid = ?";
		template.update(sql, foodName , price  ,foodId);
	}
	
	/**
	 * 根据菜品名模糊查询
	 * @param foodName
	 * @return
	 */
	public List<Food> queryFoodsByName(String foodName){
		String sql = "select foodid , foodname , price from food where foodname like '%" + foodName + "%'";
		List<Food> list = template.query(sql, new Food());
		return list;
	}
}
