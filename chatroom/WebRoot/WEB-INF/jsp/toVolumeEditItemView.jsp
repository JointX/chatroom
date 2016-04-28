<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  <form action='<c:url value="/updateItemsVolume.action" />' method="post">
  	<table align="center" border="3px">
  	<c:forEach items="${itemList}" var="key" varStatus="status" >
  		<tr>
  			<td><input type="hidden" name="extendsItemList[${status.index}].item_id" value="${key.item_id}"/></td>
  			<td><input type="text" name="extendsItemList[${status.index}].price" value="${key.price}"/></td>
  			<td><input type="text" name="extendsItemList[${status.index}].location" value="${key.location}"/></td>
  			<td><input type="text" name="extendsItemList[${status.index}].description" value="${key.description}"/></td>
  			<td><input type="text" name="extendsItemList[${status.index}].createtime" value="${key.createtime}"/></td>
  			<%-- <td><a href="<c:url value='/updateItems.action'/>">编辑</a></td> --%>
  			
  		</tr>
  	</c:forEach>
  		<tr><th colspan="2"><input type="submit" value="提交"></th></tr>
  	</table>
 </form>
  </body>
</html>
