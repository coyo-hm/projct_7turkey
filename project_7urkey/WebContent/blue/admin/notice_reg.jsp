<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
       <link rel="stylesheet" href="${pageContext.request.contextPath}/app/assets/css/main.css" />
      <style>
      		
      </style>
</head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){ $("#header").load("../include/header.html") });
</script>   
<body class="is-preload">

	<header id="header"></header> 
	
		<div class="wrapper">	
	<section class="main">
		<section>

		<h9 id = "title">공지 등록</h9>
	
	 
	<div class="col-12" style="float:right; width:17%; margin-top:70px;">
	<select name="category" id="category">
	<option value="">- Category -</option>
	<option value="1">Manufacturing</option>
	<option value="1">Shipping</option>
	<option value="1">Administration</option>
	<option value="1">Human Resources</option>
	</select>
	</div>
	
	
	
	<div class="col-12"  width="80%" cellpadding="0" cellspacing="0">
	<textarea name="message" id="message" placeholder="Enter your message" rows="15"></textarea>
	</div>
	
	
	
	
	
	</section>
	<input type="submit" value="등록" class="primary">
	</section>
					
	
	
	
	
		

      <!-- Scripts -->
         <script src="../assets/js/jquery.min.js"></script>
         <script src="../assets/js/jquery.dropotron.min.js"></script>
         <script src="../assets/js/browser.min.js"></script>
         <script src="../assets/js/breakpoints.min.js"></script>
         <script src="../assets/js/util.js"></script>
         <script src="../assets/js/main.js"></script>

	</body>
</html>