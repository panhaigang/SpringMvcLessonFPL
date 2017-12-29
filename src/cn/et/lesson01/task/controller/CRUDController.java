package cn.et.lesson01.task.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.lesson01.task.entity.User;
import cn.et.lesson01.task.service.UserService;

@Controller
public class CRUDController {

	@Autowired
	private UserService service;

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String insert(User user, HttpServletResponse response)
			throws IOException {
		service.addUser(user);
		response.getWriter().println("用户添加成功..");
		return null;
	}

	@RequestMapping(value = "/user", method = RequestMethod.DELETE)
	public String delete(String delId , HttpServletResponse response) throws IOException {
		service.deleteUser(delId);
		response.getWriter().println("删除成功...");
		return null;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String queryUsers(HttpServletRequest request) {
		List<User> list = service.queryUsers();
		request.setAttribute("userList", list);
		return "forward:/users.jsp";
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public String queryUserById(@PathVariable String userId,
			HttpServletRequest request) {
		User user = service.queryUserById(userId);
		List<User> list = new ArrayList<User>();
		list.add(user);
		request.setAttribute("userList", list);
		return "forward:/users.jsp";
	}
}
