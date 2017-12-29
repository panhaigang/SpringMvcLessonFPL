<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>局部刷新</title>
		<script type="text/javascript">
			window.onload = function() {
				query();
			}
		</script>
		<script type="text/javascript">
			function sendAjax(requestMethod, url, param, returnFunction) {
				// 创建xmlhttp对象
				var xmlhttp;
				if (window.XMLHttpRequest) { // code for IE7+, Firefox, Chrome, Opera, Safari
					xmlhttp = new XMLHttpRequest();
				} else { // code for IE6, IE5
					xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
				}
				// 回调函数
				xmlhttp.onreadystatechange = function() {
					if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
						returnFunction(xmlhttp.responseText);
					}
				}
				if (requestMethod == "get" || requestMethod == "GET") {
					xmlhttp.open("GET", url + "?" + param, true);
					xmlhttp.send();
				} else {
					xmlhttp.open("POST", url, true);
					xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=UTF-8");
					xmlhttp.send(param);
				}
			};

			// 添加菜品 
			function saveFood() {
				var foodName = document.getElementById('foodName').value;
				var price = document.getElementById('price').value;

				// 发送ajax请求 responseText是服务器返回的值
				sendAjax("POST", "${pageContext.request.contextPath}/saveFood", "foodName=" + foodName + "&price=" + price, function(responseText) {

					if (responseText == 0) {
						alert("添加成功");
						document.getElementById('saveFoodDiv').style.display = 'none';
						query();
					} else {
						alert("添加失败");
					}
				});
			}

			// 修改菜品信息
			function updateFood() {
				var foodId = document.getElementById('updateFoodId').value;
				var foodName = document.getElementById('updateFoodName').value;
				var price = document.getElementById('updatePrice').value;
				sendAjax("POST", "${pageContext.request.contextPath}/updateFood", "_method=put&foodId=" + foodId + "&foodName=" + foodName + "&price=" + price, function(responseText) {
					if (responseText == 0) {
						alert('修改成功');
					} else{
						alert('修改失败');
					}
					document.getElementById('updateFoodDiv').style.display = 'none';
					query();
				})
			}

			function query() {
				var foodName = document.getElementsByName("foodName")[0].value;
				sendAjax("GET", "${pageContext.request.contextPath}/query", "foodName=" + foodName, function(JSONStr) {

					// 转换成Json对象
					var jsonObj = JSON.parse(JSONStr);

					// 获取table
					var table = document.getElementById("tb");

					// 清除所有数据行，重新渲染table
					var dataTr = document.getElementsByName("dataTr");

					// 需要先获取长度，再去遍历删除，直接写dataTr.length删不完，很奇怪
					var dataTrLength = dataTr.length;

					for (var i = 0; i < dataTrLength; i++) {
						table.removeChild(dataTr[0]);
					}

					for (var i = 0; i < jsonObj.length; i++) {

						var foodIdTd = document.createElement("td");
						foodIdTd.innerHTML = jsonObj[i].foodId;

						var foodNameTd = document.createElement("td");
						foodNameTd.innerHTML = jsonObj[i].foodName;

						var priceTd = document.createElement("td");
						priceTd.innerHTML = jsonObj[i].price;

						// 删除、修改按钮的格子
						var manipulationTd = document.createElement("td");

						// 创建修改按钮
						var updateButton = document.createElement("button");
						updateButton.innerText = "修改";

						// 绑定food对象
						updateButton.foodObj = jsonObj[i];

						// 事件监听器
						updateButton.addEventListener("click", function() {
						
							var eventElement = event.srcElement;
							document.getElementById('updateFoodDiv').style.display = 'block';

							// 数据填充到文本框中
							document.getElementById('updateFoodId').value = eventElement.foodObj.foodId;
							document.getElementById('updateFoodName').value = eventElement.foodObj.foodName;
							document.getElementById('updatePrice').value = eventElement.foodObj.price;

						})

						// 创建删除按钮
						var delButton = document.createElement("button");
						delButton.innerText = "删除";

						// 将当前Food对象绑定到按钮上
						delButton.foodObj = jsonObj[i];

						// 创建数据行
						var tr = document.createElement("tr");

						// 数据行绑定到按钮上
						delButton.dataLine = tr;

						// 为当前按钮添加事件监听器
						delButton.addEventListener("click", function() {

							if (confirm("是否删除当前菜品？")) {
								// 获取当前按钮
								var eventElement = event.srcElement;

								// 将数据行元素删除掉
								table.removeChild(eventElement.dataLine);

								// 发送AJAX请求删除当前数据行
								sendAjax("POST", "${pageContext.request.contextPath}/delFood/" + eventElement.foodObj.foodId, "_method=delete", function(responseText) {
									if (responseText == 0) {
										alert("菜品已删除");
										query();
									} else {
										alert("菜品删除失败");
									}
								});
							}
						})

						manipulationTd.appendChild(delButton);
						manipulationTd.appendChild(updateButton);
						tr.setAttribute("name", "dataTr");
						tr.appendChild(foodIdTd);
						tr.appendChild(foodNameTd);
						tr.appendChild(priceTd);
						tr.appendChild(manipulationTd);

						// 插入table
						table.appendChild(tr);
					}
				});
			}
		</script>
		<style type="text/css">
			body {
				margin: 10 10;
			}
			
			table {
				margin-top: 10px;
				width: 500px;
				border: 1px solid black;
				width: 500px;
			}
			
			td {
				border: 1px solid black;
				padding-left: 5px;
			}
			
			td button {
				margin-left: 5px;
			}
			
			th {
				border: 1px solid black;
			}
			
			.fakeForm {
				text-align: center;
				width: 300px;
				height: 200px;
				border: 2px solid #2D2D2D;
				margin: 50px auto;
			}
			
			.fakeForm input {
				padding-left: 5px;
				border-radius: 3px;
				height: 40px;
				width: 200px;
				font-size: 20px;
				margin-top: 20px;
				border: 2px solid #2D2D2D;
			}
			
			.fakeForm button {
				width: 200px;
				height: 30px;
			}
		</style>
	</head>

	<body>
		<input type="text" name="foodName" placeholder="请输入菜品名...">
		<input type="button" value="搜索" onclick="query()">&nbsp;
		<input type="button" value="新增" onclick="document.getElementById('saveFoodDiv').style.display='block'" />

		<table id="tb">
			<tr>
				<th>编号</th>
				<th>菜名</th>
				<th>价格</th>
				<th>操作</th>
			</tr>
		</table>
		<div id="saveFoodDiv" class="fakeForm" style="display: none;">
			<button style="width: 28px; height: 21px; float: right; text-align: center;" onclick="document.getElementById('saveFoodDiv').style.display='none'">X</button><br />
			<input type="text" id="foodName" placeholder="菜品名..." />
			<input type="text" id="price" placeholder="价格..." /><br /><br />
			<button id="saveBtn" onclick="saveFood()">添加</button>
		</div>

		<div id="updateFoodDiv" class="fakeForm" style="display: none;">
			<button style="width: 28px; height: 21px; float: right; text-align: center;" onclick="document.getElementById('updateFoodDiv').style.display='none'">X</button><br />
			<input type="hidden" id="updateFoodId" />
			<input type="text" id="updateFoodName" placeholder="菜品名..." />
			<input type="text" id="updatePrice" placeholder="价格..." /><br /><br />
			<button id="updateBtn" onclick="updateFood()">修改</button>
		</div>
	</body>
</html>