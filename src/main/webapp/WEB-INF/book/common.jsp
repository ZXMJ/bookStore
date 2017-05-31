<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公共页面</title>
<script type="text/javascript"
	src="/bookStore/webjars/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("a").each(function() {
			this.onclick = function() {
				window.location.href = this.href + "&" + $(":hidden").serialize();
				return false;
			};
		});

		$(".addSearch").click(function() {
			window.location.href = this.href + "&" + $(":hidden").serialize();
			return false;
		});
	});
</script>
</head>
<body>
	<input type="hidden" name="minPrice" value="${param.minPrice }" />
	<input type="hidden" name="maxPrice" value="${param.maxPrice }" />
</body>
</html>