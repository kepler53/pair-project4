<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty bookList}">
			<span class="msg">매물이 없습니다.</span>
		</c:if>
	<c:if test="${not empty houseList}">
		<c:forEach items="${houseList}" var="h">
			<tr>
				<td>${h.isbn}</td>
				<td>${h.title }</td>
				<td>${h.author }</td>
				<td>${h.publisher }</td>
				<td>${h.price }</td>
			</tr>
		</c:forEach>
	</c:if>
</body>
</html>