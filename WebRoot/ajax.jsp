<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>局部刷新</title>
<script type="text/javascript">
	function ajax() {
		// 创建xmlhttp对象
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}

		/*
		 回调函数，方法体中接收JSON字符并解析成JSON对象，创建节点插入数据一系列操作
		 都在此方法中实现。
		 */
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				
				// 接收JSON字符串
				var jsonStr = xmlhttp.responseText;
				
				// 转换成Json对象
				var jsonObj = JSON.parse(jsonStr);
				
				// 获取table
				var table = document.getElementById("tb");
				
				// 清除所有数据行，重新渲染table
				var dataTr = document.getElementsByName("dataTr");
				
				// 需要先获取长度，再去遍历删除，直接写dataTr.length删不完，很奇怪
				var dataTrLength = dataTr.length;
				
				for (var i = 0; i < dataTrLength; i++) {
					table.removeChild(dataTr[0]);
				}
				
				// 生成dom节点(tr td)插入到table中
				for ( var i = 0; i < jsonObj.length; i++) {
					
					var foodName = document.createElement("td");
					foodName.innerHTML=jsonObj[i].foodName;
					
					var price = document.createElement("td");
					price.innerHTML = jsonObj[i].price;
					
					var foodId = document.createElement("td");
					foodId.innerHTML = jsonObj[i].foodId;
					
					var tr = document.createElement("tr");
					tr.setAttribute("name" , "dataTr");
					tr.appendChild(foodName);
					tr.appendChild(price);
					tr.appendChild(foodId);
					
					// 插入table
					table.appendChild(tr);
				}
			}
		}

		// 发送请求
		var foodName = document.getElementsByName("foodName")[0].value;
		xmlhttp.open("GET","${pageContext.request.contextPath}/query?foodName="+ foodName, true);
		xmlhttp.send();
	}
</script>
<style type="text/css">
body {
	margin: 10 10;
}

table {
	margin-top: 10px; width : 500px;
	border: 1px solid black;
	width: 500px;
}

td {
	border: 1px solid black;
	padding-left: 5px;
}

th {
	border: 1px solid black;
}
</style>
</head>
<body>
	<input type="text" name="foodName" placeholder="请输入菜品名...">
	<input type="button" value="搜索" onclick="ajax()">

	<table id="tb">
		<tr>
			<th>菜名</th>
			<th>价格</th>
			<th>编号</th>
		</tr>
	</table>
</body>
</html>