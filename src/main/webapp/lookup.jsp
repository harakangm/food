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
	<%@include file="./header.jsp"%>
	<form action="">
		<table border="1">
			<tr>
				<td>주문번호</td>
				<td>주문자명</td>
				<td>주문음식</td>
				<td>결제금액</td>
				<td>주소</td>
				<td>주문시간</td>
			</tr>
			<tr>
				<th>${rt.order_number}</th>
				<th>${rt.cust_name}</th>
				<th>${rt.food_name}</th>
				<th>${rt.pay}</th>
				<th>${rt.order_addr}</th>
				<th>${rt.pay_t}</th>
			</tr>
		</table>
	</form>
	<a href="./Modify?order_number=${rt.order_number}">주소수정하기</a>
	<a href="./delete?order_number=${rt.order_number}">취소하기</a>
</body>
</html>