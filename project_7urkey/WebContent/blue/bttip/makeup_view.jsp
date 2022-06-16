<%@ page import="java.util.ArrayList"%>
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
	<section class="main">
		<section>
			 <h8><a href = "${pageContext.request.contextPath}/mypage/MypageOpen.my?homepage_user=${BeautytipBean.getUserID()}"># ${BeautytipBean.getUserID()}님의 화장법</a></h8>
			<%-- <h8># ${BeautytipBean.getUserID()}님의 화장법</h8> --%>
			<div class="bt_view_top">
				<p class="bt_title">${BeautytipBean.getBttipTitle()}</p>
				<p class="bt_select"># ${BeautytipBean.getBttipGender()} # ${BeautytipBean.getBttipAge()}대 # ${BeautytipBean.getBttipEye()} # ${BeautytipBean.getBttipNose()} # ${BeautytipBean.getBttipLip()} # ${BeautytipBean.getBttipFace()} # ${BeautytipBean.getBttipType()} # ${BeautytipBean.getBttipTone()} # ${BeautytipBean.getBttipSeason()} # ${BeautytipBean.getBttipTheme()} </p>
			</div>
			<div class="bt_view_files">
			<% 
					int num = (Integer)session.getAttribute("session_n");
					num = num - 2 ;
					int num2 = (Integer)session.getAttribute("session_n2");
					num2 = num2 - 1;

					ArrayList<String> list = (ArrayList)session.getAttribute("file_path"); 
					ArrayList<String> textlist = (ArrayList)session.getAttribute("text_path"); 
					
			 		for(int i=num; i>-1; i--){ 
			%>
						<img src="${pageContext.request.contextPath}/blue/bttip/btimg/<%=list.get(i)%>">	
			<% 		
					}
			%>
			</div>
			<div class="bt_view_contents">
			<% 	
			 		for(int a=0; a<num2; a++){ 
			%>
						<span><%=textlist.get(a)%></span><br>
			<% 		
			 		}
			%>	
			</div>
			<a href="${pageContext.request.contextPath}/bttip/Bttiplike.bt?seq=${BeautytipBean.getBttipNum()}">[좋아요]</a>&nbsp;&nbsp;
				<h5 style="float : left; margin-bottom:30px;">좋아요 : ${BeautytipBean.getBttipLike()}</h5>
				<c:if test="${BeautytipBean.getUserID() eq session_id }">
					<a href="${pageContext.request.contextPath}/bttip/BttipDelete.bt?seq=${BeautytipBean.getBttipNum()}"><h5 style="float:right; margin-bottom:30px;">[삭제]</h5></a>
				</c:if>
		</section>
	</section>
</div>
</body>
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
<script src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" ></script>

</html>