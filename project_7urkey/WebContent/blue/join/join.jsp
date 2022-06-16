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
	$(document).ready(function() {
		$("#header").load("${pageContext.request.contextPath}/blue/include/header.jsp")
	});
</script>
<body class="is-preload">

	<header id="header"></header> 

      <!-- Main -->
			<section class="main">
				<section>
				<h1 style="text-align:center; color: #777474; font-weight: bolder;">회원가입</h1>
					<form name="joinForm" action="${pageContext.request.contextPath}/join/MemberJoinOk.me" method="post" enctype="multipart/form-data">
						<table class="alt" style="width:60%; margin:40px auto; ">
							<tr>
								<td><h17>아이디</h17></td>
								<td>
									<label><input type="text" name="userid" placeholder="ID"/></label>
									<!-- <label class="auto"><input type="button" value="중복확인" onclick=""/></label> -->
									<p id="idCheck_text"></p>
								</td>
							</tr>
							<tr>
								<td><h17>비밀번호</h17></td>
								<td><input type="password" name="userpw" placeholder="PW"/></td>
							</tr>
							<tr>
								<td><h17>이름</h17></td>
								<td><input type="text" name="username" placeholder="NAME"/></td>
							</tr>
							<tr>
								<td><h17>핸드폰</h17></td>
								<td><input type="text" name="userphone"placeholder="Phone Number"/></td>
							</tr>
							<!-- <tr>
								<td><h17>비밀번호 재확인</h17></td>
								<td><input type="text" name="pw_re" placeholder="PW" style="margin-top:15px;"/></td>
							</tr> -->
							<tr>
								<td><h17>이메일</h17></td>
								<td><input type="text" name="useremail" placeholder="E-mail"/></td>
							</tr>
							<tr>
								<td><h17>프로필 사진</h17></td>
								<td><input type="file" name="profileimg" ></td>
							</tr>
						</table>
						<ul class="actions fit" >
							<li class="login" style="width:10%; marin:0 auto; text-align:center;"><a href="javascript:formSubmit()" class="button primary fit">가입하기</a></li>
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
<script>
	function formSubmit(){
		joinForm.submit();
	}
</script>	
</html>