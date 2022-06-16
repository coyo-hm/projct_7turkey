<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
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
   <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
   <script>
   	$(document).ready(function(){ $("#header").load("${pageContext.request.contextPath}/blue/include/header.jsp") });
   </script>
   <body class="is-preload">
      <c:set var="userInfo" value="${requestScope.userInfo}" />
      <c:set var="profile" value="${requestScope.profile}" />
      <header id="header"></header>
   
      <!-- Wrapper -->
      <div class="wrapper">
   
         <!-- Main -->
         <section class="main">
            <section>
               <h1 style="text-align: center;">회원 정보 수정</h1>
               <form method="post" action="${pageContext.request.contextPath}/mypage/MypageUpdateOk.my" name="modifyForm" enctype="multipart/form-data">
                  <table class="alt" style="width: 60%; margin: 40px auto;">
                     <tr>
                        <td><h7>아이디</h7></td>
                        <td><h7>${session_id}</h7></td>
                     </tr>
                     <tr>
                        <td><h7>비밀번호</h7></td>
                        <td><input type="password" name="pw" placeholder="${userInfo.getUserpw()}" /></td>
                     </tr>
                     <!-- <tr>
                        <td><h7>비밀번호 재확인</h7></td>
                        <td><input type="password" name="pw_re" placeholder="" style="margin-top: 15px;" /></td>
                     </tr> -->
                     <tr>
                        <td><h7>전화번호</h7></td>
                        <td><input type="tel" name="phone" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" value="${userInfo.getUserphone()}"} readonly/></td>
                     </tr>
                     <tr>
                        <td><h7>이메일</h7></td>
                        <td><input type="text" name="e_mail" value="${userInfo.getUseremail()}"/></td>
                     </tr>
                     <tr>
                        <td><h7>프로필 사진</h7></td>
                        <td><input type="file" name="profileimg"></td>
                     </tr>
                     <tr>
                        <td><h7>닉네임</h7></td>
                        <td><input type="text" name="username" placeholder="${userInfo.getUsername()}"/></td>
                     </tr>
                  </table>
                  <ul class="actions fit">
                     <li class="login" style="width: 10%; margin: 0 auto; text-align: center;"><a href="${pageContext.request.contextPath}/mypage/MypageSignOut.my" class="button primary fit">회원 탈퇴</a></li>
                  </ul>
                  <ul class="actions fit">
                     <li class="login" style="width: 10%; margin: 0 auto; text-align: center;">
                        <a href="${pageContext.request.contextPath}/mypage/MypageOpen.my?homepage_user=${session_id}" class="button primary fit">취소</a></li>
                     <li class="login" style="width: 10%; margin: 0 auto; text-align: center;">
                        <a href="javascript:modifyForm.submit()" class="button primary fit">수정하기</a></li>
                  </ul>
               </form>
            </section>
         </section>
      </div>
   </body>
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
</html>