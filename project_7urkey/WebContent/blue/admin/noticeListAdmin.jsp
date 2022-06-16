<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Untitled</title>
      <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/blue/assets/css/main.css" />
</head>

<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>


<script>
	$(document).ready(function(){ $("#header").load("${pageContext.request.contextPath}/blue/include/header.jsp") });
</script> 
<body class="is-preload">



	<header id="header"></header>

<%-- 
		<c:if test="${session_id eq null}">
			<script>
				alert("로그인 후 이용해주세요");
				location.replace("${pageContext.request.contextPath}/member/MemberLogin.me");
			</script>
		</c:if> 
 --%>
		<c:set var="list" value="${requestScope.noticeList}"/>
		<c:set var="nowPage" value="${requestScope.nowPage}"/>
		<c:set var="startPage" value="${requestScope.startPage}"/>
		<c:set var="endPage" value="${requestScope.endPage}"/>
		<c:set var="totalCnt" value="${requestScope.totalCnt}"/>
		<c:set var="totalPage" value="${requestScope.totalPage}"/>
		<center>
		
 		
<%-- 			<table border="0" cellpadding="0" cellspacing="0" width="900px" >
				<tr align="right" valign="middle">
					<td>
						일반회원  ${session_id} 님 환영합니다.
						<a href="${pageContext.request.contextPath}/member/MemberLogOut.me">로그아웃</a>
					</td>
				</tr>
			</table> --%>


 

	<!-- Wrapper -->
	<div class="wrapper">	
	<section class="main">
		<section>
		
					<!-- 게시판 리스트 -->
			<table width="900px" border="0" cellpadding="0" cellspacing="0">
				<tr align="center" valign="middle">
					<td><h3>공지사항</h3></td>
				</tr>
				<tr align="right" valign="middle">
					<td>글 개수 : ${totalCnt}</td>
				</tr>
			</table>

		<div class="review_table">
			<table id="review" class="review" width="80%" cellpadding="0" cellspacing="0">
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
            			<th>제목</th>
            			<th>작성자</th>
            			<th>날짜</th>
            			<th>조회수</th>
          			</tr>
        		</thead>
		        <tbody>
			<c:choose>
				<c:when test="${list != null and fn:length(list) > 0}">
					<c:forEach var="n_bean" items="${list}">
						<tr align="center" valign="middle" onmouseover="this.style.backgroundColor='F8F8F8'" onmouseout="this.style.backgroundColor=''">
						
						
							<td height="23" style="font-family:Tahoma;font-size:10pt;">
								${n_bean.getNotice_num()}
							</td>
							
							<td style="font-family:Tahoma;font-size:10pt;">
								<div align="left">
							<a href="${pageContext.request.contextPath}/notice/NoticeView.no?seq=${n_bean.getNotice_num()}">${n_bean.getNotice_title()}</a>
								<%-- <a href="${pageContext.request.contextPath}/noticeReview/NoticeReviewView.nor?notice_num=${n_bean.getNotice_num()}">${n_bean.getNotice_title()}</a> --%>
								</div>
							</td>
							
							<td>
								<div align="center">${n_bean.getUserid()}</div>
							</td>
							<td>
								<div align="center">${n_bean.getNotice_date()}</div>
							</td>	
							<td>
								<div align="center">${n_bean.getNotice_readcount()}</div>
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
				<tr height="50px">
					<td colspan="5" align="center">등록된 게시물이 없습니다.</td>
				</tr>
				</c:otherwise>
			</c:choose>
		        </tbody>
			</table>
			
		</div>
			<br/>
			<table border="0" cellpadding="0" cellspacing="0" width="900px">
				<tr align="center" valign="middle">
					<td>
					<c:choose>
						<c:when test="${nowPage > 1}">
							<a href="${pageContext.request.contextPath}/notice/NoticeList.no?page=${nowPage - 1}">[이전]</a>&nbsp;
						</c:when>
					</c:choose>
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<c:choose>
							<c:when test="${i eq nowPage}">
								[${i}]
							</c:when>
							<c:otherwise>
								<a href="${pageContext.request.contextPath}/notice/NoticeList.no?page=${i}">[${i}]</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:choose>
						<c:when test="${nowPage < totalPage}">
							<a href="${pageContext.request.contextPath}/notice/NoticeList.no?page=${nowPage + 1}">[다음]</a>&nbsp;
						</c:when>
					</c:choose>
					</td>
				</tr>
			</table>
	</section>
		<a href = "${pageContext.request.contextPath}/notice/NoticeWrite.no"><input type="submit" value="공지사항 등록하기" class="primary"></a>
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
         
         <script>
    	 $("#review tr").click(function(){
    	        var str = ""
    	        var tdArr = new Array();  
    	            
    	        // 현재 클릭된 Row(<tr>)
    	        var tr = $(this);
    	        var td = tr.children();
    	   		var no = td.eq(0).text();
    	        console.log("notice_num: "+no);

    			var params = {notice_num : no};
    			
    			
    			window.location.href="${pageContext.request.contextPath}/notice/NoticeView.no?seq="+no;
    		 });
         </script>

	</body>
</html>