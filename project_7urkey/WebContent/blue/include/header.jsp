<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link href="https://fonts.googleapis.com/css2?family=Gaegu:wght@700&display=swap" rel="stylesheet">
<!DOCTYPE html>
<!-- Header -->

      <!-- Logo -->
         <span class="logo">
				<a href="/team_prj/index.html"><img src="images/logo.png" alt="" style="height:76px; margin-top:30px; "></a>
				<span style="font-family: 'Gaegu', cursive; font-size: 25px;">도와줘! 화장품의 지혜로</span>
			</span>
         
      <!-- search -->   
      
      <form method="post" action="${pageContext.request.contextPath}/search/Search.ser" style="margin-right:50px;">
      <div class="row gtr-uniform" style="position:relative; width:850px; height:50px; float:left; ">
         <div class="col-9 col-12-small" style="">
            <input type="text" name="query" id="query" value="" placeholder="Query" style="background-color:rgba(255,255,255,0.9); color:rgb(50,50,50);"/>
         </div>
         <div class="col-3 col-12-small" style="padding-top:15px;">
            <input type="submit" value="Search" class="fit" />
         </div>
      </div>
      </form>
      
      <!-- Nav -->
         <nav id="nav">
            <ul>
               <li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
               <li><a href="${pageContext.request.contextPath}/blue/bttip/BeautyList.bt">My Make-Up</a></li>
               <li><a href="${pageContext.request.contextPath}/product/ProductList.pr">Product Review</a></li>
               <li><a href="${pageContext.request.contextPath}/blue/calendar/sale_index.jsp">Sale Calendar</a></li>
               <c:choose>
            <c:when test="${session_id != null}">
               <li><a href="${pageContext.request.contextPath}/join/MemberLogout.me" class="button">LOGOUT</a></li>
            </c:when>
            <c:otherwise>
               <li><a href="${pageContext.request.contextPath}/join/MemberLogin.me" class="button">LOGIN</a></li>
            </c:otherwise>
         </c:choose>
            </ul>
         </nav>