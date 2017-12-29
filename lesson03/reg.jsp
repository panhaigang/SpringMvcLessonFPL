<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
  function checkSubmit(){
	  	/*var userName=document.getElementsByName("userName")[0].value;
	  	if(userName==null||userName==""){
	  		alert("用户名不能为空");
	  		return;
	  	}
	  	var password=document.getElementsByName("password")[0].value;
	  	var repassword=document.getElementsByName("repassword")[0].value;
	  	if(password!=repassword){
	  		alert("两次输入密码不一致");
	  		return;
	  	}*/
	  	document.forms[0].submit();
  	}
  </script>
  <body>
    <form action="<%=path %>/reg" method="post">
    	用户名:<input type="text" name="userName"><br/>
    	密码:<input type="password" name="password"><br/>
    	再次输入密码<input type="password" name="repassword"><br/>
    	邮件:<input type="text" name="email"><br/>
    	年龄:<input type="text" name="age"><br/>
    	手机号码:<input type="text" name="phone"><br/>
    	<input type="button" onclick="checkSubmit()" value="提交">
    </form>
  </body>
</html>
