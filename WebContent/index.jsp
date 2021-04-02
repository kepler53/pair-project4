<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="style.css">
	<link
      href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap"
      rel="stylesheet"
    />
	<title>해피 부동산</title>
	</head>
<body>
	<header>
		<div class="header__main">
			<i class="fas fa-home"></i> <a href="index.jsp">Happy House</a>
		</div>
		<ul class="header__menu">
		<c:if test="${userinfo eq null}">
			<li><button class="signin-btn" onclick="javascript:login();">로그인</button></li>
			<li><button class="signup-btn" onclick="javascript:join();">회원가입</button></li>
		</c:if>		
		<c:if test="${userinfo ne null}">
			<li><button class="board-btn" onclick="">자유게시판</button></li>
			<li><button class="bulletin-btn" onclick="javascript:write();">글쓰기</button></li>
			<li><button class="mypage-btn" onclick="javascript:mypage();">마이페이지</button></li>
			<li><button class="logout-btn" onclick="javascript:logout();">로그아웃</button></li>
		</c:if>	
		</ul>
		<a href="#" class="header__toggleBtn"><i class="fas fa-bars"></i></a>
	</header>
	<section class="main-content">
		<section class="search">
			<select class="select city">
				<option value="all">도/광역시</option>
				<option value="서울특별시">서울특별시</option>
				<option value="경기도">경기도</option>
				<option value="인천광역시">인천광역시</option>
				<option value="부산광역시">부산광역시</option>
				<option value="대전광역시">대전광역시</option>
				<option value="대구광역시">대구광역시</option>
				<option value="울산광역시">울산광역시</option>
				<option value="세종특별자치시">세종시</option>
				<option value="광주광역시">광주광역시</option>
				<option value="강원도">강원도</option>
				<option value="충청북도">충청북도</option>
				<option value="경상북도">경상북도</option>
				<option value="경상남도">경상남도</option>
				<option value="전라북도">전라북도</option>
				<option value="전라남도">전라남도</option>
				<option value="제주특별자치도">제주도</option>
			</select> <select class="select si">
				<option value="all">시/구/군</option>
			</select>
		</section>

		<div class="map__and__info">
			<div id="map"></div>
			<ul class="map-info-list"></ul>
		</div>
	</section>
	<footer>
		<ul class="footer__nav">
			<li><a href="#">회사소개</a></li>
			<li><a href="#">이용약관</a></li>
			<li><a href="#">개인정보처리방침</a></li>
			<li><a href="#">이메일 무단수집거부</a></li>
			<li><a href="#">부동산 고객센터</a></li>
			<li><a href="#">사이트 맵</a></li>
		</ul>
	</footer>
	<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY"
		async></script>
	<script type="text/javascript">
	
	async function fetchJSON(url){
	    try {
	      const response = await fetch(url);
	      if (response.ok) {
	        const data = await response.json();
	        return data;
	      } else {
	        const errorData = await response.json();
	        throw errorData;
	      }
	    } catch (err) {
	      throw {
	        message: err.message,
	        status: err.status,
	      };
	    }
	  }
	
	const selectCity = document.querySelector(".select.city");
	const selectSi = document.querySelector(".select.si");
	selectCity.addEventListener("change", (e) => {
	  const selectedCity = e.target.options[e.target.selectedIndex].value;

	  const response = fetchJSON("res/address.json");
	  response.then((data) => {
	    for (let i = 0; i < data.length; i++) {
	      if (Object.keys(data[i])[0] === selectedCity) {
	        const target = data[i][selectedCity];
	        for (let j = 0; j < target.length; j++) {
	          const name = Object.keys(target[j])[0];
	          const newSi = document.createElement("option");
	          newSi.setAttribute("value", name);
	          newSi.setAttribute("data-code", target[j][name].code);
	          newSi.textContent = name;
	          selectSi.appendChild(newSi);
	        }
	        return;
	      }
	    }
	    selectSi.innerHTML = '<option value="all">시/구/군</option>';
	  });
	  console.log(selectedCity);
	});

	selectSi.addEventListener("change", (e) => {
	  const selectedSi = e.target.options[e.target.selectedIndex];

	  const item = [];
	  const response = api.fetchJSON("./src/data/houseData.json");
	  response.then((res) => {
	    const data = res[0];
	    let locs = [];
	    if (data[selectedSi.dataset.code] !== undefined) {
	      console.log(data[selectedSi.dataset.code]);
	      for (let i = 0; i < data[selectedSi.dataset.code].length; i++) {
	        console.log(data[selectedSi.dataset.code][i]);
	        locs.push(data[selectedSi.dataset.code][i]["location"]);
	        item.push(data[selectedSi.dataset.code][i]);
	      }
	    }
	    console.log(item);
	    document.querySelector(".map-info-list").innerHTML = "";
	    for (let k = 0; k < item.length; k++) {
	      const div = document.createElement("li");
	      div.innerHTML = `
	          <div>${item[k]["name"]}</div>
	          <div>${item[k]["price"]}</div>
	      `;
	      document.querySelector(".map-info-list").appendChild(div);
	    }

	    for (let i = 0; i < locs.length; i++) {
	      const response = api.fetchGetLoc(locs[i]);
	      response.then((res) => {
	        const loc = res["results"][0]["geometry"]["location"];
	      });
	    }
	  });
	});
	
	function login(){
		document.location.href="${root}/user/login.jsp";
	}
	function join(){
		document.location.href="${root}/user/join.jsp";
	}
	function logout(){
		document.location.href="${root}/main?act=logout"
	}
	function mypage(){
		document.location.href="${root}/user/mypage.jsp";
	}
	</script>
</body>
</html>