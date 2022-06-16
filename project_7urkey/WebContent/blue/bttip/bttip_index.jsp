<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--
   Faction by Pixelarity
   pixelarity.com | hello@pixelarity.com
   License: pixelarity.com/license
-->
<html>
<head>
<title>"${pageContext.request.contextPath}"</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/blue/assets/css/main.css" />
</head>
<script>
	var contextPath = "${pageContext.request.contextPath}"
</script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/blue/bttip/bttip.js"></script>
<script>
	$(document).ready(function() {
		$("#header").load("${pageContext.request.contextPath}/blue/include/header.jsp")
	});
</script>
<body class="is-preload">

<c:if test="${session_id eq null}">
			<script>
				alert("로그인 후 이용해주세요");
				location.replace("${pageContext.request.contextPath}/join/MemberLogin.me");
			</script>
			</c:if>
			
	<c:if test="${not empty param.bttipcnt}">
		<c:if test="${param.bttipcnt == 3}">
			<script>
	alert("최대 3개까지 저장가능합니다");	
	</script>
		</c:if>
	</c:if>

	<c:set var="list" value="${requestScope.bttipList}" />
	<c:set var="nowPage" value="${requestScope.nowPage}" />
	<c:set var="startPage" value="${requestScope.startPage}" />
	<c:set var="endPage" value="${requestScope.endPage}" />
	<c:set var="totalCnt" value="${requestScope.totalCnt}" />
	<c:set var="totalPage" value="${requestScope.totalPage}" />
	<form name="bttipForm"
		action="${pageContext.request.contextPath}/bttip/BeautySave.bt"
		method="post">
		<header id="header"></header>

		<!-- Wrapper -->

		<div class="wrapper">

			<!-- Main -->
			<section class="main"> <section>
			<h1 style="margin-bottom: 50px;">나만의 화장법</h1>

			<h16>맞춤형 메이크업 찾기</h16>
			<div style="width: 25%; margin: 20px 50px;">
				<select name="category" id="myMakeup"
					onchange="if(this.value) location.href=(this.value);">
					<option value="">- 나의 맞춤형 메이크업 -</option>
					<option id="category1"
						value="${pageContext.request.contextPath}/mypage/MypageBttipCheck.my">${btlist}</option>
					<option id="category2"
						value="${pageContext.request.contextPath}/mypage/MypageBttipCheck2.my">${btlist2}</option>
					<option id="category3"
						value="${pageContext.request.contextPath}/mypage/MypageBttipCheck3.my">${btlist3}</option>
				</select>
			</div>
			<div id="test">
				<table id="select_table">
					<tr>
						<td class="first">성별</td>
						<td class="label"><input style="vertical-align: -2px;"
							type="checkbox" id="m" name="gender" value="남"><label
							for="m">남</label></td>
						<td class="label"><input type="checkbox" id="w" name="gender"
							value="여"><label for="w">여</label></td>
						<td class="label"></td>
						<td class="label"></td>
						<td class="last"></td>
					</tr>
					<tr>
						<td class="first">나이</td>
						<td class="label"><input type="checkbox" id="age1" name="age"
							value="10"><label for="age1">10대</label></td>
						<td class="label"><input type="checkbox" id="age2" name="age"
							value="20"><label for="age2">20대</label></td>
						<td class="label"><input type="checkbox" id="age3" name="age"
							value="30"><label for="age3">30대</label></td>
						<td class="label"><input type="checkbox" id="age4" name="age"
							value="40"><label for="age4">40대</label></td>
						<td class="last"><input type="checkbox" id="age5" name="age"
							value="50"><label for="age5">50대 이상</label></td>
					</tr>
					<tr>
						<td class="first">눈</td>
						<td class="label"><input type="checkbox" id="eye1" name="eye"
							value="무쌍"><label for="eye1">무쌍</label></td>
						<td class="label"><input type="checkbox" id="eye2" name="eye"
							value="겉쌍"><label for="eye2">겉쌍</label></td>
						<td class="label"><input type="checkbox" id="eye3" name="eye"
							value="속쌍"><label for="eye3">속쌍</label></td>
						<td class="label"><input type="checkbox" id="eye4" name="eye"
							value="올라간눈"><label for="eye4">올라간눈</label></td>
						<td class="last"><input type="checkbox" id="eye5" name="eye"
							value="내려간눈"><label for="eye5">내려간눈</label></td>
					</tr>
					<tr>
						<td class="first">코</td>
						<td class="label"><input type="checkbox" id="nose1"
							name="nose" value="높은코"><label for="nose1">높은코</label></td>
						<td class="label"><input type="checkbox" id="nose2"
							name="nose" value="낮은코"><label for="nose2">낮은코</label></td>
						<td class="label"><input type="checkbox" id="nose3"
							name="nose" value="복코"><label for="nose3">복코</label></td>
						<td class="label"><input type="checkbox" id="nose4"
							name="nose" value="메부리코"><label for="nose4">메부리코</label></td>
						<td class="last"></td>
					</tr>
					<tr>
						<td class="first">입</td>
						<td class="label"><input type="checkbox" id="lip1" name="lip"
							value="작은입술"><label for="lip1">작은입술</label></td>
						<td class="label"><input type="checkbox" id="lip2" name="lip"
							value="큰입술"><label for="lip2">큰입술</label></td>
						<td class="label"><input type="checkbox" id="lip3" name="lip"
							value="얇은입술"><label for="lip3">얇은입술</label></td>
						<td class="label"><input type="checkbox" id="lip4" name="lip"
							value="두꺼운입술"><label for="lip4">두꺼운입술</label></td>
						<td class="last"></td>
					</tr>
					<tr>
						<td class="first">얼굴형</td>
						<td class="label"><input type="checkbox" id="face1"
							name="face" value="계란형"><label for="face1">계란형</label></td>
						<td class="label"><input type="checkbox" id="face2"
							name="face" value="둥근형"><label for="face2">둥근형</label></td>
						<td class="label"><input type="checkbox" id="face3"
							name="face" value="각진형"><label for="face3">각진형</label></td>
						<td class="label"><input type="checkbox" id="face4"
							name="face" value="긴형"><label for="face4">긴형</label></td>
						<td class="last"><input type="checkbox" id="face5"
							name="face" value="넓적형"><label for="face5">넓적형</label></td>
					</tr>
					<tr>
						<td class="first">피부타입</td>
						<td class="label"><input type="checkbox" id="type1"
							name="type" value="건성"><label for="type1">건성</label></td>
						<td class="label"><input type="checkbox" id="type2"
							name="type" value="지성"><label for="type2">지성</label></td>
						<td class="label"><input type="checkbox" id="type3"
							name="type" value="복합성"><label for="type3">복합성</label></td>
						<td class="label"><input type="checkbox" id="type4"
							name="type" value="트러블"><label for="type4">트러블</label></td>
						<td class="last"></td>
					</tr>
					<tr>
						<td class="first">피부톤</td>
						<td class="label"><input type="checkbox" id="tone1"
							name="tone" value="어두운톤"><label for="tone1">어두운톤</label></td>
						<td class="label"><input type="checkbox" id="tone2"
							name="tone" value="밝은톤"><label for="tone2">밝은톤</label></td>
						<td class="label"><input type="checkbox" id="tone3"
							name="tone" value="핑크톤"><label for="tone3">핑크톤</label></td>
						<td class="label"><input type="checkbox" id="tone4"
							name="tone" value="노란톤"><label for="tone4">노란톤</label></td>
						<td class="last"></td>
					</tr>
					<tr>
						<td class="first">계절</td>
						<td class="label"><input type="checkbox" id="season1"
							name="season" value="봄"><label for="season1">봄</label></td>
						<td class="label"><input type="checkbox" id="season2"
							name="season" value="여름"><label for="season2">여름</label></td>
						<td class="label"><input type="checkbox" id="season3"
							name="season" value="가을"><label for="season3">가을</label></td>
						<td class="label"><input type="checkbox" id="season4"
							name="season" value="겨울"><label for="season4">겨울</label></td>
						<td class="last"></td>
					</tr>
					<tr>
						<td class="first">테마</td>
						<td class="label"><input type="checkbox" id="theme1"
							name="theme" value="데일리"><label for="theme1">데일리</label></td>
						<td class="label"><input type="checkbox" id="theme2"
							name="theme" value="하객"><label for="theme2">하객</label></td>
						<td class="label"><input type="checkbox" id="theme3"
							name="theme" value="페스티벌"><label for="theme3">페스티벌</label></td>
						<td class="label"><input type="checkbox" id="theme4"
							name="theme" value="인물커버"><label for="theme4">인물커버</label></td>
						<td class="last"><input type="checkbox" id="theme5"
							name="theme" value="새내기"><label for="theme5">새내기</label></td>
					</tr>
				</table>
			</div>
			<span class="basic">| 선택 된 항목 |</span> <span class="select_text"
				id="selectFilter"></span>
			<ul class="select_btn">
				<li><button type="button" class="s_button"
						onclick="selectAll()">전체 리스트</button></li>
				<li><button type="button" class="s_button" onclick="refresh()">초기화</button></li>

				<li><button type="button" class="s_button"
						onclick="checkbttip()">맞춤저장</button></li>
				<li><button type="button" class="s_button"
						onclick="searchBttip()">검색</button></li>
			</ul>

			<div class="makeup_div">
				<div class="makeup_category">
					<select name="category" id="category">
						<option value="">- Category -</option>
						<option value="1">최신순</option>
						<option value="2">인기순</option>
					</select>
				</div>
				<div class="write_btn">
					<a class="underline-hover-btn"
						href="${pageContext.request.contextPath}/blue/bttip/makeup_write.jsp">글쓰기</a>
				</div>
				<!-- <ul class="write_btn">
							<li><button type="button" class="w_button">글쓰기</button></li>
						</ul> -->
			</div>
			<div class="makeup_list">
				<table class="makeup" width="100%" cellpadding="0" cellspacing="0">
					<colgroup>
						<col width="5%" />
						<col width="15%" />
						<col width="*" />
						<col width="10%" />
					</colgroup>
					<tbody>
						<c:choose>
							<c:when test="${param.search ne true}">
								<c:forEach var="bean" items="${list}">
									<tr onclick="">
										<td class="po01">${bean.getBttipNum() }</td>
										<td class="po02"><a
											href="${pageContext.request.contextPath}/bttip/BeautytipView.bt?seq=${bean.getBttipNum()}">
												<img
												src="${pageContext.request.contextPath}/blue/images/ex03.jpg"
												alt="">
										</a></td>
										<td class="po03">
											<p>${bean.getBttipTitle()}</p> <em class="st">
											#${bean.getBttipGender()} #${bean.getBttipAge()}이상
												#${bean.getBttipEye()} #${bean.getBttipNose()}
												#${bean.getBttipLip()} #${bean.getBttipFace()}
												#${bean.getBttipType()} #${bean.getBttipTone()}
												#${bean.getBttipSeason()} #${bean.getBttipTheme()}</em>
											<p class="good">좋아요 ${bean.getBttipLike()}</p>
										</td>
										<td class="po04">${bean.getUserID()}님</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:forEach var="bean" items="${result}">
									<tr onclick="">
										<td class="po01">${bean.getBttipNum() }</td>
										<td class="po02"><img
											src="${pageContext.request.contextPath}/blue/images/ex03.jpg"
											alt=""></td>
										<td class="po03">
											<p>${bean.getBttipTitle()}</p> <em class="st">
											#${bean.getBttipGender()}
											#${bean.getBttipAge()}이상
												#${bean.getBttipEye()} #${bean.getBttipNose()}
												#${bean.getBttipLip()} #${bean.getBttipFace()}
												#${bean.getBttipType()} #${bean.getBttipTone()}
												#${bean.getBttipSeason()} #${bean.getBttipTheme()}</em>
											<p class="good">좋아요 ${bean.getBttipLike()}</p>
										</td>
										<td class="po04">${bean.getUserID()}님</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
			<table border="0" cellpadding="0" cellspacing="0" width="900px">
				<tr align="center" valign="middle">
					<td>
					<c:choose>
						<c:when test="${nowPage > 1}">
							<a href="${pageContext.request.contextPath}/blue/bttip/BeautyList.bt?page=${nowPage - 1}">[이전]</a>&nbsp;
						</c:when>
					</c:choose>
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<c:choose>
							<c:when test="${i eq nowPage}">
								[${i}]
							</c:when>
							<c:otherwise>
								<a href="${pageContext.request.contextPath}/blue/bttip/BeautyList.bt?page=${i}">[${i}]</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:choose>
						<c:when test="${nowPage < totalPage}">
							<a href="${pageContext.request.contextPath}/blue/bttip/BeautyList.bt?page=${nowPage + 1}">[다음]</a>&nbsp;
						</c:when>
					</c:choose>
					</td>
				</tr>
			</table>
			</section> </section>


			<script>
$(${btresult}).attr("checked", true); 
$(${btresult2}).attr("checked", true); 
$(${btresult3}).attr("checked", true); 
</script>

			<!-- Scripts -->
			<script
				src="${pageContext.request.contextPath}/blue/assets/js/jquery.min.js"></script>
			<script
				src="${pageContext.request.contextPath}/blue/assets/js/jquery.dropotron.min.js"></script>
			<script
				src="${pageContext.request.contextPath}/blue/assets/js/browser.min.js"></script>
			<script
				src="${pageContext.request.contextPath}/blue/assets/js/breakpoints.min.js"></script>
			<script
				src="${pageContext.request.contextPath}/blue/assets/js/util.js"></script>
			<script
				src="${pageContext.request.contextPath}/blue/assets/js/main.js"></script>
	</form>
</body>
</html>