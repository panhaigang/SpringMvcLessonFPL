package cn.et.lesson01.task.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.lesson01.task.dao.UserDao;
import cn.et.lesson01.task.entity.User;
import cn.et.lesson01.task.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public void addUser(User user) {
		userDao.addUser(user);
	}

	public int deleteUser(String userId) {
		return userDao.deleteUser(userId);
	}

	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	public List<User> queryUsers() {
		return userDao.queryUsers();
	}

	public User queryUserById(String userId) {
		return userDao.queryUserById(userId);
	}

}
