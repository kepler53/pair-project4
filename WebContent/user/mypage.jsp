<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<style type="text/css">
/* The Modal (background) */
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
	width: 40%; /* Could be more or less, depending on screen size */
}

.modal__content__title {
	text-align: center;
	font-weight: bold;
	font-size: 18px;
	margin-bottom: 18px;
}

/* 회원가입 모달 */
.modal.signup .modal__content {
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	min-width: 400px;
}

input.form__row {
	width: 93.5%;
}

.form__row {
	display: block;
	width: 100%;
	padding: 12px;
	margin: 12px 0;
	font-size: 14px;
	outline: none;
	border: 0.5px solid darkgray;
}

.signup-form__email {
	display: flex;
	align-items: center;
}

.form__row.email {
	width: 100%;
	display: inline;
}

.email-center {
	margin: 0 3px;
}

.signup-form__btn {
	width: 49%;
	height: 50px;
	font-size: 20px;
	background-color: blueviolet;
	color: white;
}
</style>

</head>
<body>
	<div class="modal signup">
		<div class="modal__content animate">
			<div class="modal__content__title">필수 정보를 입력해주세요.</div>
			<form class="update-form" action="submit">
				<input type="hidden" name="act" value="update"> <input
					class="form__row id" type="text"
					placeholder="현재 아이디 : ${userinfo.userid}" name="userid" disabled />
				<input class="form__row pwd" type="password" name="userpwd"
					placeholder="비밀번호* (영문+숫자, 8~20자)" required /> <input
					class="form__row pwd" type="password" placeholder="비밀번호 재확인*"
					required />
				<div class="signup-form__email">
					<input class="form__row email front" type="text"
						placeholder="${userinfo.userid}" name="useremail-front" required />
					<span class="email-center">@</span> <input
						class="form__row email end" type="text" name="useremail-end"
						placeholder="이메일 뒷자리*" disabled />
				</div>
				<select class="form__row email-select" name="email">
					<option value="noSelected">이메일 선택</option>
					<option value="naver.com">naver.com</option>
					<option value="nate.com">nate.com</option>
					<option value="hotmail.com">hotmail.com</option>
					<option value="gmail.com">gmail.com</option>
					<option value="etc">직접 입력</option>
				</select>
				<button class="signup-form__btn" type="submit"
					onclick="javascript:update();">회원 수정</button>
				<button class="signup-form__btn" type="submit"
					onclick="javascript:deleteUser();">회원 탈퇴</button>
			</form>
		</div>
	</div>
	<script type="text/javascript">
    document
    .querySelector(".email-select")
    .addEventListener("change", (e) => {
      const selectedEmail = e.target.options[e.target.selectedIndex].value;
      if (selectedEmail === "etc") {
        document.querySelector(".email.end").value = "";
        document.querySelector(".email.end").disabled = false;
        return;
      } else {
    	document.querySelector(".email.end").disabled = true;
    	document.querySelector(".email.end").value = selectedEmail;
      }
      
      
    });
  	function update() {
  	document.querySelector(".update-form").action = "${root}/main";
  	document.querySelector(".update-form").submit(); 	
 	 }
  	function deleteUser() {
	  document.location.href="${root}/main?act=delete"
	  }
	</script>
</body>
</html>