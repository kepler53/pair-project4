<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.modal {
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}
/* Modal Content/Box */
.modal__content {
	position: relative;
	background-color: #fefefe;
	margin: 15% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	padding: 24px 36px;
	border-radius: 1em;
	width: 35%; /* Could be more or less, depending on screen size */
}

.modal__content__title {
	text-align: center;
	font-weight: bold;
	font-size: 18px;
	margin-bottom: 18px;
}

.close {
	position: absolute;
	top: 24px;
	left: 20px;
	font-size: 24px;
}

.close:hover {
	color: red;
	cursor: pointer;
}

/* Set a style for all buttons */
.signin-form__btn {
	background-color: #4caf50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

.form__row {
	display: block;
	width: 94%;
	padding: 12px;
	margin: 12px 0;
	font-size: 14px;
	outline: none;
	border: 0.5px solid darkgray;
}

.join {
	text-decoration: none;
}
</style>
</head>
<body>
	<div class="modal signin">
		<div class="modal__content animate">
			<div class="modal__content__title">로그인</div>
			<form action="${root}/main" class="signin-form">
				<input type="hidden" name="act" value="login">
				<input class="form__row id" type="text" placeholder="아이디"
					name="userid" required /> <input
					class="form__row pwd" type="password" placeholder="비밀번호"
					name="userpwd" required />
				<button class="signin-form__btn" type="submit">로그인</button>
			</form>
			<span class="psw">계정이 없으신가요? <a href="join.jsp" class="join">회원가입</a></span>
		</div>
	</div>
	<script>
    </script>
</body>
</html>