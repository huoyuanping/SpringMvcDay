<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="my" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>防止重复提交</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body>
    <form action="${pageContext.request.contextPath }/tm">&nbsp; 
    	扣款：<input name="money">
    		<my:token></my:token>
    	<input name="提交" type="submit">
    
    </form>
  </body>
</html>
