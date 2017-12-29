<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8" />
<title>登录界面</title>
<link rel="stylesheet" href="<%=path%>/css/reset.css">
<link rel="stylesheet" href="<%=path%>/css/login.css">
<style type="text/css">
a {
	text-decoration:none;
	vertical-align: middle;
	display: inline-block;
	margin-bottom: 30px;
	line-height: 44px;
}
</style>
<script type="text/javascript">
	function checkSubmit() {1.

		document.forms[0].submit();
	}
</script>
</head>
<body>
	<div id="content">
		<div id="container">
			<h1><tags:message code="login"></tags:message></h1>
			<form action="<%=path%>/reg" method="post" name="myform">

				<input type="text" placeholder='<tags:message code="userName"></tags:message>' class="txt" name="userName" />
				<p style="color: red;">
					<form:errors path="user.userName"></form:errors>
				</p>

				<input type="password" placeholder="<tags:message code="password"></tags:message>" class="txt" name="password" />
				<p style="color: red;">
					<form:errors path="user.password"></form:errors>
				</p>

				<input type="password" placeholder="<tags:message code="repassword"></tags:message>" class="txt"
					name="rePassword" />
				<p style="color: red;">
					<form:errors path="user.rePassword"></form:errors>
				</p>

				<input type="text" placeholder="<tags:message code="age"></tags:message>" class="txt" name="age" />
				<p style="color: red;">
					<form:errors path="user.age"></form:errors>
				</p>

				<input type="text" placeholder="<tags:message code="phone"></tags:message>" class="txt" name="phone" />
				<p style="color: red;">
					<form:errors path="user.phone"></form:errors>
				</p>

				<input type="text" placeholder="<tags:message code="email"></tags:message>" class="txt" name="email" />
				<p style="color: red;">
					<form:errors path="user.email"></form:errors>
				</p>

				<input type="text" placeholder="<tags:message code="birthday"></tags:message>" class="txt"
					name="birthday" />
				<p style="color: red;">
					<form:errors path="user.birthday"></form:errors>
				</p>

				<input type="text" placeholder="<tags:message code="website"></tags:message>" class="txt" name="website" />
				<p style="color: red;">
					<form:errors path="user.website"></form:errors>
				</p>
				<div>
					<input id="btn" type="button" value='<tags:message code="reg"></tags:message>' onclick="checkSubmit()" />
					<input id="res" type="reset" value="<tags:message code="reset"></tags:message>" /> 
					<a id="btn" href="<%=path%>/forward?locale=zh_CN"><tags:message code="zh"></tags:message></a>
					<a id="btn" href="<%=path%>/forward?locale=en_GB"><tags:message code="en"></tags:message></a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>