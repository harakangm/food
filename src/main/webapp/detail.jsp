<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%@include file="./header.jsp" %>
 	<main>
		<div class="detailWrapper">
		<img alt="" src="${m.food_img}" class="detailViewImage">
		<div>
				<p>${m.mtr_inf}</p>
				<br>
				<p>칼로리 정보 : ${m.clr_inf}</p>
			</div>
		</div>
	</main>
</body>
</html>