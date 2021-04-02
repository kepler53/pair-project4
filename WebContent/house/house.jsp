<%@ page import="com.happyhouse.model.DTO.*, java.util.*;"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
.house {
	display: flex;
	justify-content: center;
	align-items: center;
}

.container {
	display: flex;
	justify-content: center; align-items : center;
	margin-top: 30px; padding-left : 0; flex-wrap : wrap;
	min-width: 1000px;
	max-width: 1000px;
	width: 1000px;
	align-items: center; margin-top : 30px; padding-left : 0;
	flex-wrap: wrap;
	padding-left: 0
}

.item {
	width: 200px;
	height: 200px;
	background-color: blue;
	margin: 10px;
}
</style>
<c:if test="${empty houseList}">
	<span class="msg">매물이 없습니다.</span>
</c:if>

<c:if test="${not empty houseList}">
	<ul class="container">
		<c:forEach items="${houseList}" var="b">
			<li class="item">
				<div>${b.dong}</div>
				<div>${b.AptName}</div>
				<div>${b.code}</div>
				<div>${b.dealAmount}</div>
				<div>${b.buildYear}</div>
			</li>
		</c:forEach>
	</ul>
</c:if>