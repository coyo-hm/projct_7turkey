<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/blue/assets/css/main.css" />
	</head>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"
		integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
		crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){ $("#header").load("${pageContext.request.contextPath}/blue/include/header.jsp") });
	</script>
	<body class="is-preload">
		<c:set var="followerlist" value="${requestScope.followerList}"/>	
		<header id="header"></header>
		<!-- Wrapper -->
		<div class="wrapper">
			<!-- Main -->
			<section class="main">
			<section>
				<h2 style="text-align: center; font-weight: bold;">팔로워</h2>
				<div class="follow_list">
					<table class="follow_table" cellpadding="0" cellspacing="0">
						<colgroup>
							<col width="23%" />
							<col width="50%" />
							<col width="*" />
						</colgroup>
						<c:choose>
							<c:when test="${followerlist != null and fn:length(followerlist) > 0}">
								<c:forEach var="user" items="${followerlist}">
									<tbody>
										<tr>
											<td class="f01"><a href="${pageContext.request.contextPath}/mypage/MypageOpen.my?homepage_user=${user.getUserid()}">
											<img src="${pageContext.request.contextPath}/blue/join/userimg/${user.getUserfileimg()}" class="round"></a></td>
											<td class="f02">
												<a href="${pageContext.request.contextPath}/mypage/MypageOpen.my?homepage_user=${user.getUserid()}">${user.getUsername()}</a></td>	
											<td class="f03">
												<c:choose>
													<c:when test="${user.isF_state() eq 'true'}">
														<a href = "${pageContext.request.contextPath}/mypage/Follow.my?target_id=${user.getUserid()}&state=er"><button type="button" class="f_button" style="background: #888;">팔로잉</button></a>		
													</c:when>
													<c:otherwise>
														<a href = "${pageContext.request.contextPath}/mypage/Follow.my?target_id=${user.getUserid()}&state=er"><button type="button" class="f_button" style="background: #358bca;">팔로우</button></a>
													</c:otherwise>
												</c:choose>
											</td>
										</tr>
									</tbody>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr height="50px">
									<td align="center">아직 팔로워가 없습니다.</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</table>
				</div>
			</section>
		</section>
		</div>
	
		<!-- Scripts -->
		<script src="../assets/js/jquery.min.js"></script>
		<script src="../assets/js/jquery.dropotron.min.js"></script>
		<script src="../assets/js/browser.min.js"></script>
		<script src="../assets/js/breakpoints.min.js"></script>
		<script src="../assets/js/util.js"></script>
		<script src="../assets/js/main.js"></script>
	</body>
</html>
