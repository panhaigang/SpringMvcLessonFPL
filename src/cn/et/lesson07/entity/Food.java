package cn.et.lesson07.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class Food implements RowMapper<Food> {

	private String foodId;
	private String foodName;
	private String price;

	public String getFoodId() {
		return foodId;
	}

	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodName=" + foodName + ", price="
				+ price + "]";
	}

	public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
		Food food = new Food();
		food.setFoodId(rs.getString("foodid"));
		food.setFoodName(rs.getString("foodname"));
		food.setPrice(rs.getString("price"));
		return food;
	}

}
