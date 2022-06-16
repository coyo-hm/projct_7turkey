<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML>
<!--
   Faction by Pixelarity
   pixelarity.com | hello@pixelarity.com
   License: pixelarity.com/license
-->
<html>
	<head>
		<title>Mypage</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/blue/assets/css/main.css"/>
	</head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){ $("#header").load("${pageContext.request.contextPath}/blue/include/header.jsp") });
</script>
<body class="is-preload">
	<c:set var="userInfo" value="${requestScope.userInfo}"/>
	<c:set var="state" value="${requestScope.state}"/>
	<c:set var="bttipList" value="${requestScope.bttipList}"/>
	<c:set var="reviewList" value="${requestScope.reviewList}"/>

	<header id="header"></header>

	<!-- Wrapper -->
	<div class="wrapper">

		<!-- Main -->
		<section class="main">
			<section>
				<h1 style="width: 100%; margin: 20px 0 50px 0;">마이페이지</h1>
				<div class="my_intro">
					<img src="${pageContext.request.contextPath}/blue/join/userimg/${userInfo.getUserfileimg()}" alt="" class="round" style="width: 300px; height: 300px; margin: 20px;">
					<h13>${userInfo.getUsername()} 님</h13>
				</div>
				<div class="my_intro_text">
					<div class="in01">
						<a href="${pageContext.request.contextPath}/mypage/MyPageFollower.my"><h14>팔로워</h14>
						<br>
						<h14>${userInfo.getFollowernum()} 명</h14>
						</a>
					</div>
					<div class="in02">
						<a href="${pageContext.request.contextPath}/mypage/MyPageFollowing.my"><h14>팔로잉</h14>
						<br>
						<h14>${userInfo.getFollowingnum()} 명</h14>
						</a>
					</div>
					<div class="in03">
						<h14>게시글</h14>
						<br>
						<h14>${userInfo.getPostnum()} 건</h14>
					</div>
				</div>
				<div class="my_option">
						<span class="top">저장 된 맞춤 메이크업</span><br> 
						<input type="hidden" name="bttipsavenum1" value="${bttipsavenum1}">
						<div class="mg"><a href="${pageContext.request.contextPath}/mypage/MypageBttipCheck.my">${btlist}</a><a href="${pageContext.request.contextPath}/mypage/MypageBttipDelete.my?bttipsavenum1=${bttipsavenum1}" class="button small" id="delete1">삭제</a></div><br> 
						<input type="hidden" name="bttipsavenum2" value="${bttipsavenum2}">
						<div class="mg"><a href="${pageContext.request.contextPath}/mypage/MypageBttipCheck2.my">${btlist2}</a><a href="${pageContext.request.contextPath}/mypage/MypageBttipDelete.my?bttipsavenum2=${bttipsavenum2}" class="button small" id="delete2">삭제</a></div><br> 
						<input type="hidden" name="bttipsavenum3" value="${bttipsavenum3}">
						<div class="mg"><a href="${pageContext.request.contextPath}/mypage/MypageBttipCheck3.my">${btlist3}</a><a href="${pageContext.request.contextPath}/mypage/MypageBttipDelete.my?bttipsavenum3=${bttipsavenum3}" class="button small" id="delete3">삭제</a></div><br> 
					
					<%-- 	</c:forEach> --%>
				</div>
				<div class="my_intro_btn">
					<div class="col-3 col-12-small">
						<ul class="actions stacked">
							<li><a href="${pageContext.request.contextPath}/mypage/MyPageEnterPW.my" class="button primary fit">회원 정보 수정</a></li>
						</ul>
					</div>
				</div>
			</section>

			<div class="my_post_list_btn">
				<ul>
					<li class="on"><a href="${pageContext.request.contextPath}/mypage/MypageOpen.my?state=${0}&homepage_user=${userInfo.getUserid()}">My Make-up</a></li>
					<li class="off"><a href="${pageContext.request.contextPath}/mypage/MypageOpen.my?state=${1}&homepage_user=${userInfo.getUserid()}">Product Review</a></li>
				</ul>
			</div>
			
			<div class="my_post_list">
				<c:choose>
					<c:when test="${param.state == 1}">
						<!-- 제품 리뷰 테이블 -->
						<table class="my_post" width="80%" cellpadding="0" cellspacing="0">
							<colgroup>
								<col width="5%" />
								<col width="15%" />
								<col width="*" />
								<col width="10%" />
							</colgroup>
							<tbody>
							<c:set var="i" value="${1}"/>
							<c:choose>
								<c:when test="${reviewList != null and fn:length(reviewList) > 0}">
								<c:forEach var="review" items="${reviewList}">
									<tr>
										<td class="po01">${i}</td>
										<td class="po02">
										<img src="${pageContext.request.contextPath}/blue/product_upload/${review.getProductImg()}" alt=""></td>
										<td class="po03"><a href="${pageContext.request.contextPath}/product/ProductView.pr?seq=${review.getProductNum()}">
											${review.getProductName()}</a></td>
										<td class="po04"><a href="${pageContext.request.contextPath}/product/ProductView.pr?seq=${review.getProductNum()}">
										${review.getReplyContents()}</a></td>

									</tr>
								</c:forEach>										
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="5" align="center">아직 작성된 리뷰가 없습니다.</td>
									</tr>
								</c:otherwise>
							</c:choose>
							</tbody>
						</table>					
					</c:when>
					<c:otherwise>
						<!-- 나만의 화장법 테이블 -->
						<table class="my_post" width="80%" cellpadding="0" cellspacing="0">
						<colgroup>
							<col width="5%" />
							<col width="15%" />
							<col width="*" />
							<col width="10%" />
						</colgroup>
						<tbody>
						<c:set var="i" value="${1}"/>
						<c:choose>
							<c:when test="${bttipList != null and fn:length(bttipList) > 0}">
								<c:forEach var="bttip" items="${bttipList}">
									<c:set var="i" value="${i + 1}"/>
										<tr>
											<td class="po01">${i}</td>
											<td class="po02"><a href="${pageContext.request.contextPath}/bttip/BeautytipView.bt?seq=${bttip.getBttipNum()}">
												<img src="${pageContext.request.contextPath}/blue/bttip/btimg/${bttip.getFileName()}" alt=""></a></td>
											<td class="po03"><a href="${pageContext.request.contextPath}/bttip/BeautytipView.bt?seq=${bttip.getBttipNum()}">
											${bttip.getBttipTitle()}</a></td>
											<td class="po04">${bttip.getBttipDate()}</td>
										</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="5" align="center">등록된 게시물이 없습니다.</td>
								</tr>
							</c:otherwise>
						</c:choose>
						</tbody>
						</table>
					</c:otherwise>
				</c:choose>



			</div>
		</section>
	</div>
<c:if test='${btlist eq ""}'>
<script>
document.getElementById("delete1").style.visibility="hidden";
</script>
</c:if>
<c:if test='${btlist2 eq ""}'>
<script>
document.getElementById("delete2").style.visibility="hidden";
</script>
</c:if>
<c:if test='${btlist3 eq ""}'>
<script>
document.getElementById("delete3").style.visibility="hidden";
</script>
</c:if>


	<!-- Scripts -->
	<script src="../assets/js/jquery.min.js"></script>
	<script src="../assets/js/jquery.dropotron.min.js"></script>
	<script src="../assets/js/browser.min.js"></script>
	<script src="../assets/js/breakpoints.min.js"></script>
	<script src="../assets/js/util.js"></script>
	<script src="../assets/js/main.js"></script>

</body>
</html>