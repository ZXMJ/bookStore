<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>交易详情</title>
</head>
<body>
	<center>
		用户名:${userInfo.username } 
		<br><br>
		<c:forEach items="${userInfo.trades }" var="trade">
			<table cellpadding="10" cellspacing="0" border="0">
				<tr>
					<td>
						时间:${trade.tradeTime }
					</td>
					<td>
						<c:forEach items="${trade.items }" var="item">
							数量:${item.quantity }&nbsp;&nbsp;&nbsp;
								书名:${item.book.title }&nbsp;&nbsp;&nbsp;
								价格:${item.book.price }
							<br>
						</c:forEach>
					</td>
				</tr>
			</table>
		</c:forEach>
	</center>
</body>
</html>