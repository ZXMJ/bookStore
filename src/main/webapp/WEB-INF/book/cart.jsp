<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车详情</title>
<script type="text/javascript" src="/bookStore/webjars/jquery/1.7.2/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$(":input").change(function(){
			
			var id = $(this).attr("id");
			
			var newNum = $.trim($(this).val());
			
			var reg = /^\d+$/g;
			
			var methodName;
			
			var oldNum = $(this).attr("name");
			
			if(reg.test(newNum)){
				newNum = parseInt(newNum);
				if(newNum>0){
					methodName = "changeItemNumber";
				}else{
					alert("输入有误!");
					this.value=oldNum;
					return ;
				}
			}else{
					alert("输入有误!");
					this.value=oldNum;
					return ;
			}
			
			
			var url = "bookServlet";
			
			var args = {"method":methodName, "id":id, "num":newNum};
			
			$.post(url, args, function(data){
				
				$("#bookNumber").text("购物车中共有 " + data.totalNumber + " 本书");
				
				$("#totalPrice").text("总金额：¥ "+ data.totalPrice);
				
			},"JSON");
			
		});
		
	});
</script>
<jsp:include page="common.jsp"/>
</head>
<body>
	<center>
		<br><br>
		<table cellpadding="8">
			<tr align="center">
				<td id="bookNumber" colspan="4">购物车中共有&nbsp;${shoppingCart.totalNumber}&nbsp;本书</td>
			</tr>
			<tr>
				<td>title</td>
				<td>quantity</td>
				<td>price</td>
				<td></td>
			</tr>
			<c:forEach items="${shoppingCart.items}" var="sci">
				<tr>
					<td>${sci.book.title}</td>
					<td><input type="text" id="${sci.book.id}" name="${sci.quantity}" value="${sci.quantity}" size="3"/></td>
					<td>${sci.book.price}</td>
					<td><a class="addSearch" href="bookServlet?method=delItem&id=${sci.book.id}&pageNo=${param.pageNo}">删除</a></td>
				</tr>
			</c:forEach>
			<tr><td id="totalPrice" colspan="4">总金额：¥ ${shoppingCart.totalPrice}<td></tr>
			<tr><td colspan="4"><a class="addSearch" href="bookServlet?method=getBooks&pageNo=${param.pageNo}">继续购物</a> <a class="addSearch" href="bookServlet?method=clearShoppingCart&pageNo=${param.pageNo}">清空购物车</a> <a href="bookServlet?method=toCommonPage&page=cash&pageNo=${param.pageNo}">结账</a><td></tr>
		</table>
	</center>
</body>
</html>