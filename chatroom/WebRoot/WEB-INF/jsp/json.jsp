<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.6.js"></script>
  <script type="text/javascript" >
  	function getJson1()
  	{
  		$.ajax({
  			type:'post',
  			url:'${pageContext.request.contextPath}/getJson.action',
  			contentType:'application/json;charset=utf-8',
  			data:'{"price":20,"location":"北京"}',
  			success:function(data)
  			{
  				alert(data.price);
  			}
  			
  		});
  	}
  	function getJson2()
  	{
  		$.ajax({
  			type:'post',
  			url:'${pageContext.request.contextPath}/getJson1.action',
  			/* contentType:'application/json;charset=utf-8', */
  			data:'price=20&location=北京',
  			success:function(data)
  			{
  				alert(data.price);
  			}
  		});
  	}
  </script>
  </head>
  
  <body>
  	<input type="button" onclick="getJson1()" value="json_to_json"/><br/>
  	<input type="button" onclick="getJson2()" value="keyValue_to_json"/>
  </body>
</html>
