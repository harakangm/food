<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <%@include file="./header.jsp" %>
<body>
	<main>
		<div class="menu_wrapper">
			<c:forEach items="${menulist}" var="i" varStatus="s">
				<div>
				<a href="./orderview?food_name=${i.food_name}&price=${i.price}"><img alt="" src="${i.food_img}"></a>
				<p>${i.food_name}</p>
				<p>${i.price}원</p>
				</div>
			</c:forEach>
		</div>
	</main>
</body>
</html>