<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="common.jsp"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍列表</title>
<script type="text/javascript" src="/bookStore/webjars/jquery/1.7.2/jquery.min.js"></script>

<script type="text/javascript">
	$(function() {

		$("#tempPageNo").change(function() {
			var pageNo = $(this).val();
			var reg = /^\d+$/;
			var flag = true;
			if (reg.test(pageNo)) {
				pageNo = parseInt(pageNo);
				if (pageNo > 0 && pageNo < parseInt("${bookPage.pageNumberCount+1}")) {
					flag = false;
				}
			}
			if (flag) {
				$("#tip").show();
				$(this).val("");
				return;
			}
			window.location.href = "bookServlet?method=getBooks&pageNo=" + pageNo + "&" + $(":hidden").serialize();
		});
		
	});
</script>
</head>
<body>

	<center>
		<br><br>
		<c:if test="${!empty title }">
			已经把${title}放入到购物车中
			<br><br>
		</c:if>
		<c:if test="${sessionScope.shoppingCart.totalNumber > 0}">
			购物车中共有${sessionScope.shoppingCart.totalNumber}本书
			<a class="addSearch" href="bookServlet?method=toCommonPage&page=cart&pageNo=${bookPage.pageNo}">查看购物车</a>
			<br><br>
		</c:if>
		<form action="bookServlet?method=getBooks" method="post">
			price&nbsp;:&nbsp; 
			<input type="text" name="minPrice" size="3">
			&nbsp;~&nbsp; 
			<input type="text" name="maxPrice" size="3"> 
			<input type="submit" value="搜索">
			<br><br>
		</form>
		<table cellpadding="10">
			<tr>
				<td>id</td>
				<td>书名</td>
				<td>价格</td>
				<td>作者</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${bookPage.currentList }" var="book">
				<tr>
					<td>${book.id }</td>
					<td><a href="bookServlet?method=getBook&id=${book.id}&pageNo=${bookPage.pageNo}">${book.title }</a></td>
					<td>${book.price }</td>
					<td>${book.author }</td>
					<td><a class="addSearch" href="bookServlet?method=addToCart&id=${book.id}&pageNo=${bookPage.pageNo}">加入购物车</a></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		共${bookPage.pageNumberCount }页 &nbsp;第${bookPage.pageNo}页
		<c:if test="${!bookPage.first }">
			<a href="bookServlet?method=getBooks&pageNo=1">首页</a>
			&nbsp;
			<a href="bookServlet?method=getBooks&pageNo=${bookPage.pageNo-1}">上一页</a>
		</c:if>
		<c:if test="${bookPage.first }">
			&nbsp;
			<a>首页</a>
			&nbsp;
			<a>上一页</a>
		</c:if>

		<c:if test="${!bookPage.last }">
			&nbsp;
			<a href="bookServlet?method=getBooks&pageNo=${bookPage.pageNo+1}">下一页</a>
			&nbsp;
			<a
				href="bookServlet?method=getBooks&pageNo=${bookPage.pageNumberCount }">尾页</a>
		</c:if>
		<c:if test="${bookPage.last }">
			&nbsp;
			<a>下一页</a>
			&nbsp;
			<a>尾页</a>
			&nbsp;
		</c:if>
		&nbsp;跳转到&nbsp;<input type="text" id="tempPageNo" name="tempPageNo" size="1" />&nbsp;页
		<label id="tip" style="display: none;color: red;">输入的页码有误!</label>
		<br>
	</center>
</body>
</html>