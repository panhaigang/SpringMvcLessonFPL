package cn.et.lesson05.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MoneyDaoImpl {

	@Autowired
	private JdbcTemplate template;
	
	public void transfer(Integer money){
		String sql = "update bank set money = money - " + money + " where id = 1";
		template.update(sql);
	}
	
	public Integer queryMoney(){
		String sql = "select money from bank where id = 1";
		Integer money = template.queryForObject(sql, Integer.class);
		return money;
	}
}
