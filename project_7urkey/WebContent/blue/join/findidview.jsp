<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!--
   Faction by Pixelarity
   pixelarity.com | hello@pixelarity.com
   License: pixelarity.com/license
-->
<html>
<head>
      <title>${pageContext.request.contextPath}</title>
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/blue/assets/css/main.css" />
</head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function() {
		$("#header").load("${pageContext.request.contextPath}/blue/include/header.jsp")
	});
</script>
<body class="is-preload">

	<header id="header"></header> 

      <!-- Wrapper -->

         <div class="wrapper">

             <!-- Main -->
               <section class="main">
                  <section>
                     <h1 style="text-align:center;">아이디 찾기</h1>
                           <div class="row gtr-uniform" style="marin:0 auto; width:100%; text-align:center;">
                           		<h8>회원님의 아이디</h8>
                           		<p class="findid"><%=session.getAttribute("session_id")%></p>
                           </div>
                         <div style="width:100%; text-align:center;">
                           <a href="findpw.jsp">비밀번호 찾기</a>&ensp;<a href="login.jsp">로그인</a>
                        </div>                
                  </section>
               </section>

<!-- Scripts -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.dropotron.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.js"></script>
<script>var contextPath = "${pageContext.request.contextPath}";</script>
<script> $(function() { $("#postcodify_search_button").postcodifyPopUp(); }); </script>	
 
</body>
</html>