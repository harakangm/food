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
	<form  action="#" name="frm">
		<table class="type10">
			<thead>
				<tr>
					<th colspan="2">주문하기</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">주문자명</th>
					<td></td>
				</tr>
				<tr>
					<th scope="row" class="even">주문음식</th>
					<td class="even"></td>
				</tr>
				<tr>
					<th scope="row">결재금액</th>
					<td></td>
				</tr>
				<tr>
					<th>주문주소</th>
					<td><input type="text" name="order_addr"></td>
				</tr>
				<tr>
					<th colspan="2">
						<button type="submit">수정하기</button>
					</th>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>