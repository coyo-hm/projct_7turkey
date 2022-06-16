<%@page import="com.dohwaji.app.mypage.dao.MypageBean"%>
<%@page import="com.dohwaji.app.mypage.dao.HomeDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<!--
   Faction by Pixelarity
   pixelarity.com | hello@pixelarity.com
   License: pixelarity.com/license
-->
<html>
<script> alert(request.contextPath)</script>
<head>
      <title>${pageContext.request.contextPath}</title>
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/blue/assets/css/main.css" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script language="JavaScript">
   $(document).ready(function() {
      var $banner = $(".banners").find("ul");

      var $bannerWidth = $banner.children().outerWidth();
      var $bannerHeight = $banner.children().outerHeight(); 
      var $bannerLength = $banner.children().length;
      var rollingId;

      rollingId = setInterval(function() { rollingStart(); }, 3000);
      
      function rollingStart() {
         $banner.css("width", $bannerWidth * $bannerLength + "px");
         $banner.css("height", $bannerHeight + "px");
         $banner.animate({left: - $bannerWidth + "px"}, 1500, function() { 
            $(this).append("<li>" + $(this).find("li:first").html() + "</li>");
            $(this).find("li:first").remove();
            $(this).css("left", 0);
         });
      }
   }); 
</script>

</head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<script>
   $(document).ready(function(){ $("#header").load("${pageContext.request.contextPath}/blue/include/header.jsp") });
</script>   
<body class="is-preload">
   <c:set var="userInfo" value="${requestScope.userInfo}"/>
   <c:set var="topList" value="${requestScope.topList}"/>
   <%
      HomeDAO h_dao = new HomeDAO();
      List<MypageBean> toplist = h_dao.topList();
   %>
   <header id="header"></header>
      <!-- Wrapper -->
      <div class="wrapper">

         <!-- Main -->
            <section class="main">

               <!-- 공지사항_img부분 -->
                  <section id="banner">
                     <article data-position="center">
                        <div class="contents">
                        <div class="banners">
                           <ul>
            <li><img src="${pageContext.request.contextPath}/blue/banner/banner1.jpg" width="100%" height="100%"></li>
            <li><img src="${pageContext.request.contextPath}/blue/banner/banner2.jpg" width="100%" height="100%"></li>
            <li><img src="${pageContext.request.contextPath}/blue/banner/banner3.jpg" width="100%" height="100%"></li>
            </ul>
                        </div>
                        </div>
                     </article>
                  </section>
                  
           					<!-- 공지사항_text부분 -->
						<section>
							<h1></h1>
							
							<a class="button large" href="${pageContext.request.contextPath}/notice/NoticeList.no"><button class="btn-1">공지 사항</button></a>
						</section>

               <!-- Features -->
                  <section class="features alt">
                     <article class="icon fa-gem">
                        <h3>나만의 화장법</h3>
                        <p>나를 바꿔 줄 화장법을 찾아보세요!</p>
                     </article>
                     <article class="icon fa-save">
                        <h3>제품 리뷰</h3>
                        <p>화장품의 모든 정보를 알아보세요!</p>
                     </article>
                  </section>

               <!-- Spotlights -->
                  <section class="spotlights alt">
                     <article>
                        <a href="#" class="image fit"><img src="${pageContext.request.contextPath}/blue/images/coverIU.jpg" alt=""></a>
                     <h10><a href="">호텔델루나 아이유 커버 메이크업</a></h10>
                     </article>
                     <article>
                        <a href="#" class="image fit"><img src="${pageContext.request.contextPath}/blue/images/cliopink.jpg" alt=""></a>
                            <h10><a href="">클리오 프로 아이 팔레트 심플리 핑크</a></h10>
                     </article>
                     <article>
                        <a href="#" class="image fit"><img src="${pageContext.request.contextPath}/blue/images/glosyface.jpg" alt=""></a>
                         <h10><a href="">촉촉한 피부표현 메이크업</a></h10>
                     </article>
                     <article>
                        <a href="#" class="image fit"><img src="${pageContext.request.contextPath}/blue/images/nars.jpg" alt=""></a>
                        <h10><a href="">에프터글로우 립 밤</a></h10>
                     </article>
                     <article>
                        <a href="#" class="image fit"><img src="${pageContext.request.contextPath}/blue/images/springmakeup.jpg" alt=""></a>
                         <h10><a href="">핑크빛 봄 메이크업</a></h10>
                     </article>
                     <article>
                        <a href="#" class="image fit"><img src="${pageContext.request.contextPath}/blue/images/herablack.jpg" alt=""></a>
                        <h10><a href="">헤라 블랙 쿠션 SPF34/PA++</a></h10>
                     </article>
                  </section>

            </section>

         <!-- Sidebar -->
         <aside class="sidebar">
         <section style="text-align:center;">
         <c:choose>
            <c:when test="${session_id != null}">
               <h2 style="font-weight: bold;">내 정보</h2>
               <img src="blue/join/userimg/<%=session.getAttribute("session_img")%>" alt="" style="margin-bottom:30px; width:200px; height:200px; border-radius: 100px; -moz-border-radius: 100px; -khtml-border-radius: 100px; -webkit-border-radius: 1000px;">
               <p style="font-weight: bold;"><%=session.getAttribute("session_id")%></p>
               <ul class="actions" style="width:100%; display: inline-block;">
                  <li><a href="${pageContext.request.contextPath}/mypage/MypageOpen.my?homepage_user=${session_id}" class="button">프로필 보기</a></li>
               </ul>
            </c:when>
            <c:otherwise>
               <h2>로그인 후 이용해주세요</h2>
               <ul class="actions" style="width:100%; display: inline-block;">
                  <li><a href="${pageContext.request.contextPath}/join/MemberLogin.me" class="button">LOGIN</a></li>
               </ul>
            </c:otherwise>
         </c:choose>
         </section>
               
               <!-- Featured posts -->
               <section class="featured-posts" style="padding:20px;">
                  <video controls loop autoplay width="100%" height="auto" > 
                        <source src="${pageContext.request.contextPath}/blue/video/video01.mp4" type="video/mp4"> 
                  </video>
               </section>

         <!-- Posts -->
         <section>
            <h2 style="font-weight: bold;">Top5 화가</h2>
               <ul class="posts">
                  <li style="float:left;">
                  <%
                     for(int i = 0; i < toplist.size(); i++){
                  %>
                        <div class="top5_img"> 
                           <a href="${pageContext.request.contextPath}/mypage/MypageOpen.my?homepage_user=<%=toplist.get(i).getUserid() %>">
                              <img src="${pageContext.request.contextPath}/blue/join/userimg/<%=toplist.get(i).getUserfileimg() %>" alt="" class="round" style="margin-bottom:30px; width:100px; height:100px;">
                           </a>   
                        </div>
                        <div class="top5_text">
                           <a href="${pageContext.request.contextPath}/mypage/MypageOpen.my?homepage_user=<%=toplist.get(i).getUserid() %>">
                           <h11><%=toplist.get(i).getUsername() %></h11><br></a>
                           <h12>구독자 : <%=toplist.get(i).getFollowernum() %></h12>
                        </div>
                  
                  <%
                     }
                  %>
                  </li>
               </ul>
            </section>
         </aside>

      </div>

   <!-- Footer -->
      <footer id="footer">
         <div class="inner">
            <section class="info">
               <h3>About Us</h3>
               <div class="about">
                  <p>Morbi mattis mi consectetur tortor elementum, varius pellentesque velit convallis. Aenean tincidunt lectus auctor mauris maximus, ac scelerisque ipsum tempor. Duis vulputate ex et ex tincidunt, quis lacinia velit aliquet. Duis non efficitur malesuada.</p><p>Sagittis felis ac sagittis semper. Curabitur purus leo donec vel dolor at arcu tincidunt bibendum. Interdum et malesuada fames ac ante ipsum primis.</p>
                  <ul class="actions">
                     <li><a href="#" class="button">Learn More</a></li>
                  </ul>
               </div>
               <div class="team">
                  <article>
                     <span class="image"><img src="${pageContext.request.contextPath}/blue/images/pic06.jpg" alt=""></span>
                     <p>
                        <strong class="name">John Doe</strong>
                        <span class="title">Lorem semper magna etiam</span>
                     </p>
                  </article>
                  <article>
                     <span class="image"><img src="${pageContext.request.contextPath}/blue/images/pic07.jpg" alt=""></span>
                     <p>
                        <strong class="name">Jane Anderson</strong>
                        <span class="title">Etiam feugiat adipiscing veroeros</span>
                     </p>
                  </article>
                  <article>
                     <span class="image"><img src="${pageContext.request.contextPath}/blue/images/pic08.jpg" alt=""></span>
                     <p>
                        <strong class="name">Mike Smith</strong>
                        <span class="title">Consequat nulla dolor blandit</span>
                     </p>
                  </article>
               </div>
            </section>
            <section class="contact">
               <h3>Contact Us</h3>
               <ul class="contact-icons">
                  <li class="icon solid fa-home"><a href="#">1234 Somewhere Road #80486<br>Nashville, TN 00000</a></li>
                  <li class="icon solid fa-phone"><a href="#">(800) 555-0000 x12345</a></li>
                  <li class="icon solid fa-envelope"><a href="#">hello@untitled.tld</a></li>
                  <li class="icon brands fa-facebook"><a href="#">facebook.com/untitled-tld</a></li>
                  <li class="icon brands fa-twitter"><a href="#">twitter.com/untitled-tld</a></li>
               </ul>
            </section>
         </div>
         <div class="copyright">
            &copy; Untitled. All rights reserved.
         </div>
      </footer>

   <!-- Scripts -->
      <script src="${pageContext.request.contextPath}/blue/assets/js/jquery.min.js"></script>
      <script src="${pageContext.request.contextPath}/blue/assets/js/jquery.dropotron.min.js"></script>
      <script src="${pageContext.request.contextPath}/blue/assets/js/browser.min.js"></script>
      <script src="${pageContext.request.contextPath}/blue/assets/js/breakpoints.min.js"></script>
      <script src="${pageContext.request.contextPath}/blue/assets/js/util.js"></script>
      <script src="${pageContext.request.contextPath}/blue/assets/js/main.js"></script>

   </body>
</html>