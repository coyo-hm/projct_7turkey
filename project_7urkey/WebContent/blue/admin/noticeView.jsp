<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

	<c:set var="count" value="${requestScope.count}" />
	<c:set var="reportBean" value="${requestScope.reportBean}" />
	<c:set var="reportList" value="${requestScope.reportList}" />

	<c:set var="noticeBean" value="${requestScope.noticeBean}" />
	<c:set var="filesBeanList" value="${requestScope.filesBeanList}" />


	<c:set var="noticeReviewBean" value="${requestScope.noticeReviewBean}" />
	<c:set var="noticeReviewList" value="${requestScope.noticeReviewList}" />



	<<%-- center>
		<c:choose>
			<c:when test="${session_id eq null}">
				<script>
					alert("로그인 후 이용해주세요");
					location
							.replace("${pageContext.request.contextPath}/member/MemberLogin.me");
				</script>
			</c:when>
			<c:otherwise>
				<table border="0" cellpadding="0" cellspacing="0" width="900px">
					<tr align="right" valign="middle">
						<td>${session_id}님환영합니다. <a
							href="${pageContext.request.contextPath}/member/MemberLogOut.me">로그아웃</a>
						</td>
					</tr>
				</table>
			</c:otherwise>
		</c:choose>
		</center>
		<br /> <br /> --%>
		<!-- Wrapper -->
		<div class="wrapper">
			<section class="main"> 
			<section>

			<table width="900px" border="0" cellpadding="0" cellspacing="0">
				<tr align="center" valign="middle">
					<td><h3>공지사항</h3></td>
				</tr>
			</table>

			<!-- 게시판 수정 -->

			<form
				action="${pageContext.request.contextPath}/notice/NoticeReport.no?num=${noticeBean.getNotice_num()}&add=1
			 "
				method="post" enctype="multipart/form-data" name="reportform">

				<table width="900px" border="1" cellpadding="0" cellspacing="0">


					<%-- 				<tr height="30px">
					<td align="center" width="150px">게시글 타입</td>
					<td style="padding-left: 10px;">
					
					<c:if test="${reportBean.getReport_type() == 2}">
					<div>제품 리뷰</div>
					</c:if>
					
					<c:if test="${reportBean.getReport_type() == 1}">
					<div>나만의 화장</div>
					</c:if> 
					
					</td>
				</tr> 
				
	--%>


					<tr height="30px">
						<td align="center" width="150px">게시글 타입</td>
						<td style="padding-left: 10px;">공지사항</td>
					</tr>


					<tr height="30px">
						<td align="center" width="150px">게시글 번호</td>
						<td style="padding-left: 10px;">${noticeBean.getNotice_num()}</td>
					</tr>

					<tr height="30px">
						<td align="center" width="150px">제 목</td>
						<td style="padding-left: 10px;">${noticeBean.getNotice_title()}</td>
					</tr>

					<tr height="30px">
						<td align="center" width="150px">아이디</td>
						<td style="padding-left: 10px;">${noticeBean.getUserid()}</td>
					</tr>

					<tr height="200px">
						<td align="center" width="150px">내 용</td>
						<td valign="top" style="padding-top: 10px; padding-left: 10px;">${noticeBean.getNotice_contents()}</td>
					</tr>


<%-- 
					<tr height="30px">
						<td align="center">첨부파일</td>
						<c:if test="${filesBeanList != null}">
							<td><c:forEach var="file" items="${filesBeanList}">
									<a
										href="${pageContext.request.contextPath}/notice/FileDownload.no?notice_file_name=${file.getNotice_file_name()}">${file.getNotice_file_name()}</a>
								</c:forEach></td>
						</c:if>
					</tr> --%>
				</table>
			</form>

			<table width="900px" border="0" cellpadding="0" cellspacing="0">
				<tr align="right" valign="middle">
					<td><c:if test="${noticeBean.getUserid() eq session_id}">



							<a href="javascript:deleteNotice()">[삭제]</a>&nbsp;&nbsp;
						</c:if> 
						<!-- <a href="javascript:addreport()">신고하기</a>&nbsp;&nbsp;  -->
						<a href="${pageContext.request.contextPath}/notice/NoticeList.no">[목록]</a>&nbsp;&nbsp;

						<%-- 						<a href="${pageContext.request.contextPath}/report/ReportWrite.re?num=${noticeBean.getNotice_num()}"><input
							type="submit" value="신고하기" class="primary"></a></td> --%>
				</tr>
			</table>
			
			
			
	

			<!-- 게시판 삭제 -->

			<form
				action="${pageContext.request.contextPath}/notice/NoticeDeleteOk.no"
				method="post" name="noticeform">

				<input type="hidden" name="seq"
					value="${noticeBean.getNotice_num()}" />
			</form>

	</section>


	</section>


</body>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://rawgit.com/jackmoore/autosize/master/dist/autosize.min.js"></script>
<script>
	var check = true;

	/* 신고하기 */
	function addreport() {
		reportform.submit();

	}

	function deleteNotice() {
		noticeform.submit();
	}
	
	
	
	

	/* 댓글 */
	function comment() {
		var textarea = $("textarea[name='review_contents']");
		if (textarea.val() == "") {
			alert("댓글을 작성해주세요.");
			return false;
		}
		noticeReview.submit();
	}
	


	
	
	
</script>
</html>