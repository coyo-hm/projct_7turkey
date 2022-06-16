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
                     <h1>LogIn</h1>
                        <form name="loginForm" action="${pageContext.request.contextPath}/join/MemberLoginOk.me" method="post">
                           <div class="row gtr-uniform">
                           <div class="col-6 col-12-xsmall">
                              <h3>아이디</h3>
                              <input type="text" name="userid" placeholder="ID" />
                           </div>
                           <div class="col-6 col-12-xsmall">
                              <h3>비밀번호</h3>
                              <input type="password" name="userpw" placeholder="PW" />
                           </div>
                           </div>
                        </form>
                        <ul class="actions fit" >
                           <li class="login" style="width:10%; marin:0 auto; text-align:center;"><a href="javascript:loginForm.submit()" class="button primary fit">로그인</a></li>
                        </ul>
                        <div style="width:100%; text-align:center;">
                           <a href="${pageContext.request.contextPath}/blue/join/findid.jsp">아이디 찾기</a>&ensp;<a href="${pageContext.request.contextPath}/blue/join/findpw.jsp">비밀번호 찾기</a>
                        </div>
                        <div style="width:100%; text-align:center; margin-top:10px;">
                           <a href="${pageContext.request.contextPath}/join/MemberJoin.me">회원가입</a>
                        </div>
                  </section>
               </section>
         </div>
<!-- Scripts -->
<script src="${pageContext.request.contextPath}/blue/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/blue/assets/js/jquery.dropotron.min.js"></script>
<script src="${pageContext.request.contextPath}/blue/assets/js/browser.min.js"></script>
<script src="${pageContext.request.contextPath}/blue/assets/js/breakpoints.min.js"></script>
<script src="${pageContext.request.contextPath}/blue/assets/js/util.js"></script>
<script src="${pageContext.request.contextPath}/blue/assets/js/main.js"></script>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.js"></script>
<script>var contextPath = "${pageContext.request.contextPath}";</script>
<script src="${pageContext.request.contextPath}/blue/join/join.js"></script>
<script> $(function() { $("#postcodify_search_button").postcodifyPopUp(); }); </script>	

   </body>
</html>