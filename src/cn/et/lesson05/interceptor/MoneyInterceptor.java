package cn.et.lesson05.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MoneyInterceptor implements HandlerInterceptor {

	
	/**
	 * 在此处实现拦截逻辑
	 */
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		 
		// 先从参数中取到uuid
		String uuid = request.getParameter("token");
		
		// 再从session
		Object sessionUUID = request.getSession().getAttribute("token");
		
		if (uuid != null) {	// 参数中带有重复提交的uuid则进行判断
			if (sessionUUID != null) {
				if (uuid.equals(sessionUUID.toString())) {	// 相同则返回true，其余情况全部返回false
					
					// 一定要清除掉session的uuid值
					request.getSession().removeAttribute("token");
					return true;
				}
			}
			return false;	// 重复提交、或者提交的uuid和session中的不一致都会返回false
		}
		
		return true; // 不需要判断重复提交的请求
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
