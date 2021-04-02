<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<style type="text/css">
.house {
	display: flex;
	flex-direction:column;
	justify-content: center;
	align-items: center;
}

.dong{ margin-top: 30px;}

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
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
	width: 200px;
	height: 200px;
	border: 1px solid darkgrey;
	margin: 10px;
}
</style>

<c:if test="${empty houseList}">
	<span class="msg">there is no item</span>
</c:if>
<c:if test="${not empty houseList}">
	<ul class="container">

		<c:forEach items="${houseList}" var="b">
			<li class="item">
				<div>${b.dong}</div>
				<div><strong>${b.aptName}</strong></div>
				<div>${b.dealAmount},000원</div>
				<div>${b.buildYear}년 준공</div>
			</li>
		</c:forEach>
	</ul>
</c:if>