package cn.et.lesson01.task.dao;

import java.util.List;

import cn.et.lesson01.task.entity.User;

public interface UserDao {

	/**
	 * 往数据库新增一个用户
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * 根据用户Id删除用户
	 * @param userId
	 */
	public int deleteUser(String userId);
	
	/**
	 * 修改用户信息
	 * 传递的User内包含了UserId，其余字段则是新值，
	 * id作为where条件，取出其余字段覆盖原纪录即可。
	 * @param user
	 * @return 修改记录数
	 */
	public int updateUser(User user);
	
	/**
	 * 查询所有用户信息
	 * @return
	 */
	public List<User> queryUsers();
	
	/**
	 * 根据用户Id查询用户信息
	 * @param userId
	 * @return
	 */
	public User queryUserById(String userId);
}
