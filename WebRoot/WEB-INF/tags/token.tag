<%@ tag language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	// 记得要在tag 的imprt属性中导包啊
	
	// 设置个UUID作为随机值
	String uuid = UUID.randomUUID().toString();
	
	// 将uuid存到session中
	session.setAttribute("token" , uuid);
%>
<%-- 同时将这个uuid设到隐藏表单域中 --%>
<input type="hidden" name="token" value="<%=uuid%>">