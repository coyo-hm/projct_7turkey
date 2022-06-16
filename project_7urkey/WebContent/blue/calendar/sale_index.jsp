<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>도화지</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<script>
	$(document).ready(function() {
		$("#header").load(contextPath + "/blue/include/header.jsp")
	});
</script>
<body class="is-preload">
	<header id="header"></header>

	<!-- Wrapper -->

	<div class="wrapper">

		<!-- Main -->
		<section class="main">
			<section>
				<h1>세일 달력</h1>
				<!-- 이 부분에 div 생성하셔서 img 넣어주시면 될 것 같습니다!! -->
				<div>
					<img
						src="${pageContext.request.contextPath}/blue/calendar/sale_calerdar.jpg"
						style="margin-left: auto; margin-right: auto; display: block;">
				</div>

				<img
					src="${pageContext.request.contextPath}/blue/calendar/lohbs.jpg"
					width="700" height="auto"
					style="margin-left: auto; margin-right: auto; display: block;">
				<p align="center">
					<a href="http://www.lohbs.co.kr">롭스 홈페이지 바로가기</a>
				</p>
				
				<img
					src="${pageContext.request.contextPath}/blue/calendar/oliveyoung.jpg"
					width="700" height="auto"
					style="margin-left: auto; margin-right: auto; display: block;">
				<p align="center">
					<a href="http://www.oliveyoung.co.kr">올리브영 홈페이지 바로가기</a>
				</p>
				
						<img
					src="${pageContext.request.contextPath}/blue/calendar/etude.jpg"
					width="700" height="auto"
					style="margin-left: auto; margin-right: auto; display: block;">
				<p align="center">
					<a href="https://www.etude.com/kr/ko/main">에뛰드하우스 홈페이지 바로가기</a>
				</p>

			</section>
		</section>

	</div>
	<!-- Scripts -->
	<script
		src="${pageContext.request.contextPath}/blue/assets/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/blue/assets/js/jquery.dropotron.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/blue/assets/js/browser.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/blue/assets/js/breakpoints.min.js"></script>
	<script src="${pageContext.request.contextPath}/blue/assets/js/util.js"></script>
	<script src="${pageContext.request.contextPath}/blue/assets/js/main.js"></script>

</body>
</html>