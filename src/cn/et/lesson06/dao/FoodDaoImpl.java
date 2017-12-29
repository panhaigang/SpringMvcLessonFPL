package cn.et.lesson06.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FoodDaoImpl {

	@Autowired
	private JdbcTemplate template;
	
	public List<Map<String, Object>> queryFoodsByName(String foodName){
		String sql = "select * from food where foodname like '%" + foodName + "%'";
		return template.queryForList(sql);
	}
}
