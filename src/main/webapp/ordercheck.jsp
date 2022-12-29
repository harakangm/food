<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<main>
		<div class="ord_name">
			<p>${rt.cust_name}님주문해 주셔서 감사합니다</p>
		</div>
		<table>
			<tr>
				<th>주문번호</th>
				<td>${rt.order_number}</td>
			</tr>
			<tr>
				<th>주문자명</th>
				<td>${rt.cust_name}</td>
			</tr>
			<tr>
				<th>주문음식</th>
				<td>${rt.food_name}</td>
			</tr>
			<tr>
				<th>결제금액</th>
				<td>${rt.pay}</td>
			</tr>
			<tr>
				<th>배달주소</th>
				<td>${rt.order_addr}</td>
			</tr>
			<tr>
				<th>주문날짜</th>
				<td>${rt.pay_t}</td>
			</tr>
		</table>
	</main>
</body>
</html>