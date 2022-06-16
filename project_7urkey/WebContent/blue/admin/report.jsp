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
      <link rel="stylesheet" href="${pageContext.request.contextPath}/blue/assets/css/main.css" />
</head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){ $("#header").load("../include/header.html") });
</script>   
<body class="is-preload">

	<header id="header"></header> 

	<!-- Wrapper -->
	<div class="wrapper">	
	<section class="main">
		<section>
		<h9>신고하기</h9>
		<div style="float:right; width:17%; margin-top:70px;">
			<select name="category" id="category">
				<option value="">- 게시판 선택 -</option>
				<option value="1">Name01</option>
				<option value="1">Name02</option>
				<option value="1">Name03</option>
				<option value="1">Name04</option>
			</select>
		</div>
		<p class="op1">게시글</p>
		<div class="review_table">
			<table class="review" width="80%" cellpadding="0" cellspacing="0">
				<colgroup>
          			<col width="5%" />
          			<col width="25%" />
          			<col width="45%" />
          			<col width="15%" />
          			<col width="10%" />
        		</colgroup>
        		<thead>
          			<tr>
            			<th>No</th>
            			<th>신고자</th>
            			<th>신고카테고리</th>
            			<th>내용</th>
            			<th>작성일</th>
          			</tr>
        		</thead>
		        <tbody>
					<tr>
						<td>1</td>
						<td>신고자</td>
						<td>신고 카테고리 적어주세요</td>
						<td>내용</td>
						<td>20.06.04</td>
					</tr>
					<tr>
						<td>2</td>
						<td>신고자</td>
						<td>신고 카테고리 적어주세요</td>
						<td>내용</td>
						<td>20.06.04</td>
					</tr>
		        </tbody>
			</table>
		</div>
	</section>
	</section>	
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
								<span class="image"><img src="images/pic06.jpg" alt=""></span>
								<p>
									<strong class="name">John Doe</strong>
									<span class="title">Lorem semper magna etiam</span>
								</p>
							</article>
							<article>
								<span class="image"><img src="images/pic07.jpg" alt=""></span>
								<p>
									<strong class="name">Jane Anderson</strong>
									<span class="title">Etiam feugiat adipiscing veroeros</span>
								</p>
							</article>
							<article>
								<span class="image"><img src="images/pic08.jpg" alt=""></span>
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
         <script src="../assets/js/jquery.min.js"></script>
         <script src="../assets/js/jquery.dropotron.min.js"></script>
         <script src="../assets/js/browser.min.js"></script>
         <script src="../assets/js/breakpoints.min.js"></script>
         <script src="../assets/js/util.js"></script>
         <script src="../assets/js/main.js"></script>

	</body>
</html>