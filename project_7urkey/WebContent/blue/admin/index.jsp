<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--
   Faction by Pixelarity
   pixelarity.com | hello@pixelarity.com
   License: pixelarity.com/license
-->
<html>
<head>
<title>Untitled</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/blue/assets/css/main.css" />
</head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>

<script>
	$(document).ready(function(){ $("#header").load("${pageContext.request.contextPath}/blue/include/header.jsp") });
</script> 


<body class="is-preload">

	<header id="header"></header> 
	
	<div class="container" style = "text-align :center;">
		<a href="${pageContext.request.contextPath}/report/ReportList.rep">><button class="btn-1">신고 목록</button></a>
		<a href="${pageContext.request.contextPath}/product/ProductList.pr">><button class="btn-1">제품 목록</button></a>
		<a href="${pageContext.request.contextPath}/blue/admin/prod_reg.jsp">><button class="btn-1">제품 등록</button></a>
		<a href="${pageContext.request.contextPath}/notice/noticeListAdmin.no"><button class="btn-1">공지 사항</button></a>
		<a href="${pageContext.request.contextPath}/notice/NoticeWrite.no"><button class="btn-1">공지 사항 등록하기</button></a>
		<a href="ppl.html"><button class="btn-1">광고</button></a>
	</div>
	

     
      <!-- Scripts -->
      	<!-- Scripts -->
		<script src="${pageContext.request.contextPath}/blue/assets/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/blue/assets/js/jquery.dropotron.min.js"></script>
		<script src="${pageContext.request.contextPath}/blue/assets/js/browser.min.js"></script>
		<script src="${pageContext.request.contextPath}/blue/assets/js/breakpoints.min.js"></script>
		<script src="${pageContext.request.contextPath}/blue/assets/js/util.js"></script>
		<script src="${pageContext.request.contextPath}/blue/assets/js/main.js"></script>

   </body>
</html>