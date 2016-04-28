<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>

<body>
	<form action="<c:url value='/register.action'/>" method="post"  >
		<table align="center">
			<tr align="center">
				<th colspan="2" style="width: 325px; ">register</th>
			</tr>
			<tr>
				<td>username</td>
				<td><input type="text" name="username" value="${session.username}"/></td><td></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="password" value="${session.password}"/></td><td></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="text" name="email" value="${session.email}"/></td><td></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="okey"/></td>
			</tr>
		</table>
	</form>
</body>
</html>
