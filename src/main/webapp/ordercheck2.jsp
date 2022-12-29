<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="./header.jsp"%>
	<div><p>주문번호를 입력해주세요</p></div>
	<form action="lookup">
		<table>
			<tr>
				<td>주문번호</td>
				<td><input type="text" name="order_num"></td>
				<td><button type="submit">확인</button></td>
			</tr>
		</table>
	</form>
</body>
</html>