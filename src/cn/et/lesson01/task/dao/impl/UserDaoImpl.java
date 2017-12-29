package cn.et.lesson01.task.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.et.lesson01.task.dao.UserDao;
import cn.et.lesson01.task.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addUser(User user) {
		String sql = "insert into users (username , password) values ('"
				+ user.getUserName() + "' , '" + user.getPassword() + "')";
		jdbcTemplate.execute(sql);
	}

	public int deleteUser(String userId) {
		String sql = "delete from users where userid = " + userId;
		return jdbcTemplate.update(sql);
	}

	public int updateUser(User user) {
		String sql = "update users set username = " + "'" + user.getUserName()
				+ "' , password = '" + user.getPassword() + "' where userid = "
				+ user.getUserId();
		return jdbcTemplate.update(sql);
	}

	public List<User> queryUsers() {
		String sql = "select * from users";
		List<User> list = jdbcTemplate.query(sql, new User());
		return list;
	}

	public User queryUserById(String userId) {
		String sql = "SELECT * FROM users WHERE userid = ?";
		User user = jdbcTemplate.queryForObject(sql, new User(),new Object[]{userId});
		return user;
	}

}
