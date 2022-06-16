<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/blue/assets/css/main.css" />
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){ $("#header").load("${pageContext.request.contextPath}/blue/include/header.jsp") });
</script>   
<body class="is-preload">


	<header id="header"></header> 
	
	
	
	<c:set var = "searchlist" value = "${requestScope.searchList}"/>
	<!-- 제품 -->
	
	<c:set var = "searchListOne" value = "${requestScope.searchListOne}"/>
	
	
	
	<!-- Wrapper -->
	<div class="wrapper">	<!-- wrapper -->
	<section class="main"><!-- section -->
		<section>
			<h1 style="width:100%; margin:20px 0 50px 0;">검색 결과</h1>
			
			
			<!-- 일단 이리로 들어와야해 지금 있는 테이블이 이거니까  -->
			
			<c:choose>
			<c:when test="${searchlist != null and fn:length(searchlist) > 0}">	
			<div class="area_02">
				<ul>
				<p class="top_title">My Make-Up</p>
					<c:forEach var="s_bean" items="${searchlist}">
					<li class="search_list">
						<div class="st">
							<div class="s_title"><a href="${pageContext.request.contextPath}/search/SearchView.ser?seq=${s_bean.getBttipnum()}" onclick="">${s_bean.getBttiptitle()}</a></div>
							<div class="s_day">${s_bean.getBttipdate()}</div>
						</div>	
						<!-- s_content 에서 일정 글자가 넘을 경우 (두줄 이상으로 넘어 갈 경우) 마지막 글자 뒤 '...' 으로 되도록 설정 부탁드립니다. -->
						<div class="s_content">${s_bean.getBttipcontent()}</div>
						<div class="s_person">${s_bean.getUserid()}</div>
					</li>
					</c:forEach>
				</ul>
			</div>			
			</c:when>
			<c:otherwise>
				
			<div class="area_03">
				<ul>
				<p class="top_title">My Make-Up</p>	
					<p class="list_none">검색 된 결과가 없습니다.</p>
				</ul>
			</div>
			</c:otherwise>
			
			</c:choose>
	
	
	<!-- 여기 안된다  -->
			
			<c:choose>
			<c:when test="${searchListOne != null and fn:length(searchListOne) > 0}">
			
			<div class="area_02">
				<ul>
				<p class="top_title">Product</p>
					<c:forEach var="p_bean" items="${searchListOne}">
					<li class="search_list">
						<div class="st">
							<div class="s_title"><a href="${pageContext.request.contextPath}/product/ProductView.pr?seq=${p_bean.getProduct_Num()}" onclick="">${p_bean.getProduct_Title()}</a></div>
							<div class="s_day">${p_bean.getProduct_Date()}</div>
						</div>	
						<div class="s_content">${p_bean.getProduct_Brand()}</div>
						<div class="s_person">admin</div>
					</li>
					</c:forEach>
				</ul>

			</div>
			
			</c:when>
			<c:otherwise>
				
			<div class="area_03">
				<ul>
				<p class="top_title">Product</p>	
					<p class="list_none">검색 된 결과가 없습니다.</p>
				</ul>
			</div>
			</c:otherwise>
			</c:choose>
			
			
			<!--  여기 안된다  -->	
	
	

		</section>
		</section><!-- main -->
		</div><!-- wrapper -->
		

</body>
</html>