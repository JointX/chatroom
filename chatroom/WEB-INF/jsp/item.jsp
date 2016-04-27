<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<table align="center" border="3px">
  	<c:forEach items="${list}" var="key">
  		<tr>
  			<td>${key.item_id}</td>
  			<td>${key.price}</td>
  			<td>${key.location}</td>
  			<td>${key.description}</td>
  			<td><a href="<c:url value='/updateItems.action'/>">编辑</a></td>
  		</tr>
  	</c:forEach>
  	</table>
  </body>
</html>
