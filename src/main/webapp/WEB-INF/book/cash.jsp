<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>结账页面</title>
</head>
<body>
	<br><br>
	<br><br>
	<center>
		<c:if test="${!empty shoppingCart.totalNumber}">
			<a>购物车中共有&nbsp;${shoppingCart.totalNumber}&nbsp;本书</a>
			<a>总金额：¥ ${shoppingCart.totalPrice}</a>
		</c:if>
		<br><br><br>
		<c:if test="${!empty requestScope.message}">
			<a style="color: red;">${requestScope.message}</a>
		</c:if>
		<br><br><br>
		<form action="bookServlet?method=cash" method="post">
			用户名：<input type="text" name="username"  value="${param.username }"/>
			<br><br><br>
			卡&nbsp;&nbsp;&nbsp;号：<input type="text" name="accountId" value="${param.accountId }"/>
			<br><br><br>
			<input type="submit" value="结账" />
		</form>

	</center>
</body>
</html>