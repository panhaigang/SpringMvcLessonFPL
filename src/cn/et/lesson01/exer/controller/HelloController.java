package cn.et.lesson01.exer.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String sayHello(HttpServletResponse response) throws IOException{
		response.getWriter().println("hello Sucker!");
		return null;
	}	
	
	@RequestMapping("/index")
	public String index(String id , HttpServletResponse response) throws IOException{
		response.getWriter().write("您输入的ID：" + id);
		return null;
	}
	
	/**
	 * RESTFUL风格的URL中取到参数
	 * requestMapping中配置映射规则，用{变量名}表示占位符，
	 * 再把@PathVariable注解配到同名参数上，即可在方法中取到。
	 * @param userId
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/user/{userId}")
	public String param(@PathVariable String userId , HttpServletResponse response) throws IOException{
		response.getWriter().println("你的ID：" + userId);
		return null;
	}
}
