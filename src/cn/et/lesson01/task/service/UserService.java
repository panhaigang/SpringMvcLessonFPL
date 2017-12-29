package cn.et.lesson01.task.service;

import java.util.List;

import cn.et.lesson01.task.entity.User;

public interface UserService {

	public void addUser(User user);
	
	public int deleteUser(String userId);
	
	public int updateUser(User user);
	
	public List<User> queryUsers();
	
	public User queryUserById(String userId);
}
