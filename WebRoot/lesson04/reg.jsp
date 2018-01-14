<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="t"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>国际化</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function checkSubmit(){
			document.forms[0].submit();
		}
	</script>
	
  </head>
  
  <body>
 		<a href="${pageContext.request.contextPath}/mid?a=zh_CN">中文</a>&nbsp;<a href="${pageContext.request.contextPath}/mid?a=en_US">English</a>
	    <form action="${pageContext.request.contextPath}/myregs" method="post" > 
	    	<t:message code="userName"></t:message>:<input type="text"  name="userName"/>
	    	<font color="red"><form:errors path="user.userName"></form:errors></font>
	    	<br/><br/>
	    	<t:message code="password"></t:message>  ：<input type="password"  name="password"/>
	    	<font color="red"><form:errors path="user.password"></form:errors></font>
	    	<br/><br/>
	    	<t:message code="repassWord"></t:message>:<input type="password" name="repassword"/>
	    	<font color="red"><form:errors path="user.repassword"></form:errors></font>
	    	<br/><br/>
	    	<t:message code="email"></t:message>：<input type="text" name="email"/>
	    	<font color="red"><form:errors path="user.email"></form:errors></font>
	    	<br/><br/>
	    	<t:message code="age"></t:message>：<input type="text" name="age"/>
	    	<font color="red"><form:errors path="user.age"></form:errors></font>
	    	<br/><br/>
	    	<t:message code="phone"></t:message>:<input type="text" name="phone"/>
	    	<font color="red"><form:errors path="user.phone"></form:errors></font>
	    	<br/><br/>
	    	<t:message code="net"></t:message>:<input type="text" name="net"/>
	    	<font color="red"><form:errors path="user.net"></form:errors></font>
	    	<br/><br/>
	    	<t:message code="dates"></t:message> ：<input type="text" name="dates"/>
	    	<font color="red"><form:errors path="user.dates"></form:errors></font>
	    	<br/><br/>
	    		<input type="button" value="<t:message code="zhu"></t:message>" onclick="checkSubmit()"/><br/>
	    </form>
  
  </body>
</html>
