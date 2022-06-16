<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
      <title>화장법글쓰기</title>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/blue/assets/css/main.css" />
      <style>p.mup01  { float:left; width:95%; font-size:1.25em; color:#575757; margin:30px 0px;  font-weight: bolder;}</style>
</head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	$(document).ready(function(){ $("#header").load(contextPath+"/blue/include/header.jsp") });
</script>  
<body class="is-preload">

<header id="header"></header> 

<!-- Wrapper -->
<div class="wrapper">	
	<section class="main">
		<section>
			<h3 style="width:100%; text-align:center;" >등록이 완료되었습니다.</h3>
			<ul class="actions fit" >
				<li class="login" style="width:10%; marin:0 auto; text-align:center;"><a href="${pageContext.request.contextPath}/bttip/BeautytipListJSP.bt" class="button primary fit">목록으로</a></li>
			</ul>
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
<script>				