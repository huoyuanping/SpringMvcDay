<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'food.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript">
		function sendAjax(url,methodType,param,retnFunction){
			//调用http://localhost:8080/SpringMvcDay/queryAll 获取数据通过dom方法添加到table中
				//ajax(异步)+json
			
				var xmlhttp = null;
				//兼容所有的浏览器创建这个对象（简称XHR对象）
				if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
					xmlhttp = new XMLHttpRequest();
				} else {// code for IE6, IE5
					xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
				}
				
					//匿名函数  不需要调的函数叫回调函数  当请求发送后回自动调用该方法
				xmlhttp.onreadystatechange = function() {
					if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
						retnFunction(xmlhttp.responseText);
					}
				}
				if(methodType=="get" || methodType=="GET"){
					//open方法表示产生一个请求的关联（get 提交）
					xmlhttp.open("GET",url+"?"+param, true);
					xmlhttp.send();
				}else{
				//open方法表示产生一个请求的关联（POST 提交）
				xmlhttp.open("POST",url, true);
	  			xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
	  			xmlhttp.send(param);
	  			}
		}
			function query() {
				var foodname=document.getElementsByName("foodName")[0].value;
				sendAjax("${pageContext.request.contextPath}/queryAll","GET","foodname="+foodname,function(responseText){
					//返回字符串的json
				var resultJson = responseText;
				//转换为js对象
				var resultObj = JSON.parse(resultJson);
				//获取table对象
				var table = document.getElementById("myTable");
				//将所有名字为dataTr的tr全部删除
				var allDataTr = document.getElementsByName("dataTr");
				var length = allDataTr.length;
				for ( var i = 0; i < length; i++) {
					table.removeChild(allDataTr[0]);
				}
	
				//根据json的行数追加多个tr
				for ( var i = 0; i < resultObj.length; i++) {
					var obj = resultObj[i];
					//创建<td>
					var tid = document.createElement("td");
					//将内容添加到td中
					tid.innerText = obj.foodid;
					var tname = document.createElement("td");
					tname.innerText = obj.foodname;
					var tprice = document.createElement("td");
					tprice.innerText = obj.price;
					var td2=document.createElement("td");
					//删除按钮
					var ib=document.createElement("button");
					ib.innerText="删除";
					td2.appendChild(ib);
					//修改按钮
					var ib1=document.createElement("button");
					ib1.innerText="修改";
					td2.appendChild(ib1);
					//创建<tr>
					var tr = document.createElement("tr");
					//将当前对象绑定到当前按钮
					ib.foodObj=obj;
					//将当前行的tr绑定当按钮上
					ib.myLineTr=tr;
					//删除按钮事件
					ib.addEventListener("click",function(){
						//获取按钮
						var eventStr=event.srcElement;
						//删除当前行+发送ajax请求到后台删除数据库
						table.removeChild(eventStr.myLineTr);
						sendAjax("${pageContext.request.contextPath}/food/"+ib.foodObj.foodid,"POST","_method=delete",function(responseText){
				         if(responseText==1)
				            alert("删除成功");
				         else{
				            alert("删除失败");
				         }
				      });
			   });
			   //将当前对象绑定到当前按钮
				ib1.foodObj=obj;
			   //修改按钮事件
				ib1.addEventListener("click",function(){
					//获取按钮
					var eventStr=event.srcElement;
					document.getElementById('updateDiv').style.display='block';
					document.getElementsByName("updateFoodName")[0].value=eventStr.foodObj.foodname;
					document.getElementsByName("updateFoodPrice")[0].value=eventStr.foodObj.price;
					document.getElementsByName("updateFoodId")[0].value=eventStr.foodObj.foodid;
				});
				
					tr.setAttribute("name", "dataTr");
					tr.appendChild(tid);
					tr.appendChild(tname);
					tr.appendChild(tprice);
					tr.appendChild(td2);
					table.appendChild(tr);
				}
			});
		}
/**
  新增的方法
*/
function saveFood(){
   var myFoodName=document.getElementsByName("myFoodName")[0].value;
   var myFoodPrice=document.getElementsByName("myFoodPrice")[0].value;
   sendAjax("${pageContext.request.contextPath}/food","POST","foodName="+myFoodName+"&price="+myFoodPrice,function(responseText){
         if(responseText==1){
            document.getElementById('addDiv').style.display='none';
            query();
            alert("新增成功");
            
         }else{
            alert("新增失败");
         }
	});
}

/**
  修改的方法
*/
function updateFood(){
   var myFoodName=document.getElementsByName("updateFoodName")[0].value;
   var myFoodPrice=document.getElementsByName("updateFoodPrice")[0].value;
   var myFoodId=document.getElementsByName("updateFoodId")[0].value;
   sendAjax("${pageContext.request.contextPath}/food/"+myFoodId,"POST","_method=put&foodName="+myFoodName+"&price="+myFoodPrice,function(responseText){
			         if(responseText==1){
			            document.getElementById('updateDiv').style.display='none';
			            query();
			            alert("修改成功");
			            
			         }else{
			            alert("修改失败");
			         }
	});
}
	</script>
	</head>
	<body>
		<input type="text" name="foodName" id="foodName">
		<input type="button" value="查询" onclick="query()">
		<input type="button" value="添加" onclick="document.getElementById('addDiv').style.display='block';">
		<table id="myTable" border="1">
			<tr>
				<th>菜品编号</th>
				<th>菜品名</th>
				<th>菜品价格</th>
				<th>操作</th>
			</tr>
		</table>
	</body>
	<div id="addDiv" style="display:none;position: absolute;left:45%;z-index: 100;border:1px solid black;width: 240px;height: 65px">
		菜品名&nbsp;:<input type="text" name="myFoodName"><br/>
		菜品价格:<input type="text" name="myFoodPrice"><br/>
			<input type="button" value="保存" onclick="saveFood()">&nbsp;<input type="button" value="关闭" onclick="document.getElementById('addDiv').style.display='none';">
	</div>
	
	<div id="updateDiv" style="display:none;position: absolute;left:45%;z-index: 100;border:1px solid black;width: 240px;height: 90px">
		<input type="hidden" name="updateFoodId"><br/>
		菜品名&nbsp;:<input type="text" name="updateFoodName"><br/>
		菜品价格:<input type="text" name="updateFoodPrice"><br/>
			<input type="button" value="修改" onclick="updateFood()">&nbsp;<input type="button" value="关闭" onclick="document.getElementById('updateDiv').style.display='none';">
	</div>
</html>
