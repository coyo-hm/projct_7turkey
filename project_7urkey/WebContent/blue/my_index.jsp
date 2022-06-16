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
      <title>${pageContext.request.contextPath}</title>
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/blue/assets/css/main.css" />
</head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){ $("#header").load("include/header.jsp") });
</script>
<body class="is-preload">

	<header id="header"></header> 

      <!-- Wrapper -->
		<div class="wrapper">

			<!-- Main -->
				<section class="main">

					<!-- 공지사항_img부분 -->
						<section id="banner">
							<article data-position="center">
								<div class="inner">
									<img src="images/slide04.jpg" alt="">
									<h2>Porta ultricies consectetur</h2>
									<p>Mattis ante fermentum, malesuada neque vitae, eleifend erat. Phasellus non pulvinar erat. Fusce tincidunt lorem ipsum dolor sit amet. Magna tellus fusce tincidunt lorem.</p>
									<ul class="actions">
										<li><a class="button large" href="#">Magna sed dolor</a></li>
									</ul>
								</div>
							</article>
						</section>
						
					<!-- 공지사항_text부분 -->
						<section>
							<h1>Sed mattis nunc lorem</h1>
							<p>Phasellus sed ultricies mi non congue ullam corper. Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla lorem.</p>
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
								<a href="#" class="image fit"><img src="images/pic01.jpg" alt=""></a>
								<h10>★한소희 커버 메이크업★</h10>
							</article>
							<article>
								<a href="#" class="image fit"><img src="images/pic02.jpg" alt=""></a>
								<h10>에스티로더 더블웨어 파운데이션 30ml 샌드</h10>
							</article>
							<article>
								<a href="#" class="image fit"><img src="images/pic01.jpg" alt=""></a>
								<h10>여름철 해수욕장 워터푸르프 메이크업</h10>
							</article>
							<article>
								<a href="#" class="image fit"><img src="images/pic02.jpg" alt=""></a>
								<h10>시에로코스메틱 젤러시 아카이브 플럼퍼 3.3g 1호(젤러시 레드)</h10>
							</article>
							<article>
								<a href="#" class="image fit"><img src="images/pic01.jpg" alt=""></a>
								<h10>코로나 마스크 메이크업</h10>
							</article>
							<article>
								<a href="#" class="image fit"><img src="images/pic02.jpg" alt=""></a>
								<h10>키엘 울트라 페이셜 수분 크림 125ml</h10>
							</article>
						</section>

				</section>

			<!-- Sidebar -->
				<aside class="sidebar">

					<section style="text-align:center;">
						<h2 style="font-weight: bold;">내 정보</h2>
						<img src="blue/join/userimg/<%=session.getAttribute("session_img")%>" alt="" style="margin-bottom:30px; width:200px; height:200px; border-radius: 100px; -moz-border-radius: 100px; -khtml-border-radius: 100px; -webkit-border-radius: 1000px;">
						<p style="font-weight: bold;"><%=session.getAttribute("session_id")%></p>
						<ul class="actions" style="width:100%; display: inline-block;">
							<li><a href="mypage/my_index.html" class="button">프로필 보기</a></li>
						</ul>
					</section>
					
					<!-- Featured posts -->
					<section class="featured-posts" style="padding:20px;">
						<video controls loop autoplay width="100%" height="auto" > 
   							<source src="video/video01.mp4" type="video/mp4"> 
						</video>
					</section>
<!-- 						<section class="featured-posts">
							<h2>Sed aliquam</h2>
							<article>
								<a href="#" class="image fit"><img src="images/pic05.jpg" alt=""></a>
								<header>
									<span class="date">September 19, 2016</span>
									<h3><a href="#">Non velit accumsan cursus gravida amet sapien</a></h3>
								</header>
								<p>Phasellus in odio at ipsum porttitor mollis id vel diam. Praesent sit amet posuere risus, eu faucibus lectus. Vivamus ex ligula, tempus pulvinar ipsum in, auctor porta quam. Proin nec commodo, vel scelerisque nisi scelerisque. Suspendisse id quam vel tortor tincidunt suscipit. Nullam auctor orci eu dolor consectetur, interdum ullamcorper ante tincidunt. Mauris felis nec felis varius.</p>
								<ul class="actions">
									<li><a href="#" class="button">Continue Reading</a></li>
								</ul>
							</article>
						</section> -->

					<!-- Blurb -->
<!-- 						<section>
							<h2>Magna etiam</h2>
							<p>Fermentum ut nisl vitae, convallis maximus nisl. Sed mattis nunc id lorem sed euismod placerat. Vivamus porttitor et magna enim, ac accumsan tortor cursus at. Phasellus sed ultricies mi non congue ullam corper lorem ipsum.</p>
							<ul class="actions">
								<li><a href="#" class="button">Learn More</a></li>
							</ul>
						</section> -->

					<!-- Posts -->
						<section>
							<h2 style="font-weight: bold;">Top5 화가</h2>
							<ul class="posts">
								<li style="float:left;">
									<div class="top5_img">
									<a href="mypage/subscribe.html">
										<img src="images/ex02.jpg" alt="" class="round" style="margin-bottom:30px; width:100px; height:100px;">
									</a>
									</div>
									<div class="top5_text">
									<a href="mypage/subscribe.html"><h11>한지민</h11><br></a>
									<h12>구독자 : 2315명</h12>
									</div>
								</li>
								<li style="float:left;">
									<div class="top5_img">
									<a href="#">
										<img src="images/ex02.jpg" alt="" style="margin-bottom:30px; width:100px; height:100px; border-radius: 100px; -moz-border-radius: 100px; -khtml-border-radius: 100px; -webkit-border-radius: 1000px;">
									</a>
									</div>
									<div class="top5_text">
									<h11>이사베</h11><br>
									<h12>구독자 : 2018명</h12>
									</div>
								</li>
								<li style="float:left;">
									<div class="top5_img">
									<a href="#">
										<img src="images/ex02.jpg" alt="" style="margin-bottom:30px; width:100px; height:100px; border-radius: 100px; -moz-border-radius: 100px; -khtml-border-radius: 100px; -webkit-border-radius: 1000px;">
									</a>
									</div>
									<div class="top5_text">
									<h11>한소희</h11><br>
									<h12>구독자 : 1810명</h12>
									</div>
								</li>
								<li style="float:left;">
									<div class="top5_img">
									<a href="#">
										<img src="images/ex02.jpg" alt="" style="margin-bottom:30px; width:100px; height:100px; border-radius: 100px; -moz-border-radius: 100px; -khtml-border-radius: 100px; -webkit-border-radius: 1000px;">
									</a>
									</div>
									<div class="top5_text">
									<h11>전지현</h11><br>
									<h12>구독자 : 1315명</h12>
									</div>
								</li>
								<li style="float:left;">
									<div class="top5_img">
									<a href="#">
										<img src="images/ex02.jpg" alt="" style="margin-bottom:30px; width:100px; height:100px; border-radius: 100px; -moz-border-radius: 100px; -khtml-border-radius: 100px; -webkit-border-radius: 1000px;">
									</a>
									</div>
									<div class="top5_text">
									<h11>손예진</h11><br>
									<h12>구독자 : 815명</h12>
									</div>
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
		<script src="${pageContext.request.contextPath}/blue/assets/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/blue/assets/js/jquery.dropotron.min.js"></script>
		<script src="${pageContext.request.contextPath}/blue/assets/js/browser.min.js"></script>
		<script src="${pageContext.request.contextPath}/blue/assets/js/breakpoints.min.js"></script>
		<script src="${pageContext.request.contextPath}/blue/assets/js/util.js"></script>
		<script src="${pageContext.request.contextPath}/blue/assets/js/main.js"></script>

	</body>
</html>