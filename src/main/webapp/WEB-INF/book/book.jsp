<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<jsp:include page="common.jsp"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍详情</title>
</head>
<body>
	<table>
		<tr>
			<td>id:</td>
			<td>${book.id }</td>
		</tr>
		<tr>
			<td>作者:</td>
			<td>${book.author }</td>
		</tr>
		<tr>
			<td>标题:</td>
			<td>${book.title }</td>
		</tr>
		<tr>
			<td>价格:</td>
			<td>${book.price }</td>
		</tr>
		<tr>
			<td>出版日期:</td>
			<td>${book.publishingDate }</td>
		</tr>
		<tr>
			<td>标签:</td>
			<td>${book.remark }</td>
		</tr>
		<tr>
			<td>库存:</td>
			<td>${book.storeNumber }</td>
		</tr>
	</table>
	<a href="bookServlet?method=getBooks&pageNo=${param.pageNo}">返回</a>
</body>
</html>