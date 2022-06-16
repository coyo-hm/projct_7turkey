<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      <title>Untitled</title>
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<%--       <link rel="stylesheet" href="${pageContext.request.contextPath}/app/assets/css/main.css" /> --%>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/blue/assets/css/main.css" />
      
</head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){ $("#header").load("../include/header.jsp") });
</script>   
<body class="is-preload">

	
		<c:if test="${not empty param.login}">
			<c:if test="${not param.login}">
			<!-- 로그인 실패시에만 alert창 실행 -->
				<script>alert("아이디 또는 비밀번호를 다시 확인해주세요.");</script>
			</c:if>
		</c:if>



	<header id="header"></header> 

      <!-- Wrapper -->
         <div class="wrapper">

            <!-- Main -->
               <section class="main">
                  <section>
                     <h1>Manager LogIn</h1>
                        <form method="post" name = "loginForm" action = "${pageContext.request.contextPath}/admin/AdminLoginOk.adm">
                           <div class="row gtr-uniform">
                           <div class="col-6 col-12-xsmall">
                              <h3>아이디</h3>
                              <input type="text" name="id" id="id" value="" placeholder="id" />
                           </div>
                           <div class="col-6 col-12-xsmall">
                              <h3>비밀번호</h3>
                              <input type="password" name="password" id="email" value="" placeholder="Email" />
                           </div>
                           </div>
                        </form>
                        <ul class="actions fit" >
                           <li class="login" style="width:10%; marin:0 auto; text-align:center;"><a href="javascript:loginForm.submit()" class="button primary fit">로그인</a></li>
                        </ul>
                       </section>
               </section>
         </div>
      
      

      <!-- Scripts -->
         <script src="assets/js/jquery.min.js"></script>
         <script src="assets/js/jquery.dropotron.min.js"></script>
         <script src="assets/js/browser.min.js"></script>
         <script src="assets/js/breakpoints.min.js"></script>
         <script src="assets/js/util.js"></script>
         <script src="assets/js/main.js"></script>

   </body>
</html>