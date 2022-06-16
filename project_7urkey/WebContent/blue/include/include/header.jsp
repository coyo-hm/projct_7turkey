<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Header -->

		<!-- Logo -->
			<span class="logo">
				<a href="${pageContext.request.contextPath}/index.jsp">Faction</a>
				<span>By Pixelarity</span>
			</span>
			
		<!-- search -->	
		
		<form method="post" action="./index.jsp" style="margin-right:50px;">
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
					<li><a href="${pageContext.request.contextPath}/join/MemberLogin.me" class="button">Log In</a></li>
				</ul>
			</nav>