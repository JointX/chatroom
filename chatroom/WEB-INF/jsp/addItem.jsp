<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>

<body>
	<form action="<c:url value='/addItem.action'/>" method="post" enctype="multipart/form-data" >
		<table align="center">
			<tr align="center">
				<th colspan="2" style="width: 325px; ">添加商品</th>
			</tr>
			<tr>
				<td>price</td>
				<td><input type="text" name="extendsItem.price" value="${errorsItem.extendsItem.price}"/></td>
				<td><c:forEach items="${listPriceErrors}" var="key">
					${key},
				</c:forEach></td>
			</tr>
			<tr>
				<td>location</td>
				<td><input type="text" name="extendsItem.location" value="${errorsItem.extendsItem.location}"/></td><td></td>
			</tr>
			<tr>
				<td>description</td>
				<td><input type="text" name="extendsItem.description" value="${errorsItem.extendsItem.description}"/></td><td></td>
			</tr>
			<tr>
				<td>createtime</td>
				<td><input type="text" name="extendsItem.createtime" value="${errorsItem.extendsItem.createtime}"/></td>
				<td><c:forEach items="${listCreatetimeErrors}" var="key">
					${key},
				</c:forEach></td>
			</tr>
			<tr>
				<td>file_upload</td>
				<td><input type="file" name="picMultipartFile"/></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="添加"/></td>
			</tr>
		</table>
	</form>
</body>
</html>
