<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신고</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/blue/assets/css/main.css" />
</head>
<script>
	$(document).ready(function(){ $("#header").load("${pageContext.request.contextPath}/blue/include/header.jsp") });
</script> 

<body>

	<c:set var="noticeBean" value="${requestScope.noticeBean}" />
	<c:set var="filesBeanList" value="${requestScope.filesBeanList}" />


	<c:set var="reportBean" value="${requestScope.reportBean}" />
	<c:set var="filesBeanList" value="${requestScope.filesBeanList}" />
	<c:set var="replyBeanList" value="${requestScope.replyBeanList}" />


	<%-- <center>
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
						<td>${session_id} 님 환영합니다. <a
							href="${pageContext.request.contextPath}/member/MemberLogOut.me">로그아웃</a>
						</td>
					</tr>
				</table>
			</c:otherwise>
		</c:choose>
		<br /> <br /> --%>
		<!-- Wrapper -->
		<div class="wrapper">
			<section class="main"> <section>

			<table width="900px" border="0" cellpadding="0" cellspacing="0">
				<tr align="center" valign="middle">
					<td><h3>신고 상세보기</h3></td>
				</tr>
			</table>

			<!-- 게시판 수정 -->
			<table width="900px" border="1" cellpadding="0" cellspacing="0">

			<!-- 신고당한 게시글 번호  -->
				<tr>
					<td align="center" width="150px">접수 번호</td>
					<td style="padding-left: 10pt;">
						${reportBean.getReport_num()}
					</td>
				</tr>
				
				<tr height="30px">
					<td align="center" width="150px">게시글 타입</td>
					<td style="padding-left: 10px;"><c:if
							test="${reportBean.getReport_type() == 2}">
							<div>제품 리뷰</div>
						</c:if> <c:if test="${reportBean.getReport_type() == 1}">
					나만의 화장
					</c:if></td>
				</tr>

					<!-- 신고당한 게시글 번호  -->
				<tr>
					<td align="center" width="150px">신고 게시글</td>
					<td style="padding-left: 10pt;">
						${reportBean.getReport_board()}
					</td>
				</tr>


				<tr height="30px">
					<td align="center" width="150px">제 목</td>
					<td style="padding-left: 10px;">
						${reportBean.getReport_title()}</td>
				</tr>

				<tr height="30px">
					<td align="center" width="150px">아이디</td>
					<td style="padding-left: 10px;">${reportBean.getUserid()}</td>
				</tr>

				<tr height="200px">
					<td align="center" width="150px">내 용</td>
					<td valign="top" style="padding-top: 10px; padding-left: 10px;">${reportBean.getReport_contents()}</td>
				</tr>


				<%-- 				
				<tr height="30px">
					<td align="center">첨부파일</td>
					<c:if test="${filesBeanList != null}">
						<td>
							<c:forEach var="file" items="${filesBeanList}">
								<a href="${pageContext.request.contextPath}/report/FileDownload.bo?file_name=${file.getFile_name()}">${file.getFile_name()}</a>
							</c:forEach>
						</td>
					</c:if>
				</tr>
 --%>

			</table>



			<table width="900px" border="0" cellpadding="0" cellspacing="0">
				<tr align="right" valign="middle">
					<td>
					<c:if test="${reportBean.getUserid() eq session_id}">
							<%-- 
			<a href="${pageContext.request.contextPath}/report/ReportModify.rep?seq=${reportBean.getReport_num()}">[수정]</a>&nbsp;&nbsp; 
			--%>
						</c:if> 
					
						<a href="javascript:deleteReport()">[삭제]</a>&nbsp;&nbsp;
						 
						 
						<a href="${pageContext.request.contextPath}/report/ReportUpdatePass.rep?report_num=${reportBean.getReport_num()}">
						[통과]</a>&nbsp;&nbsp;
						
						
						<a href="${pageContext.request.contextPath}/report/ReportList.rep">
						[목록]</a>&nbsp;&nbsp;
				
						
					</td>
				</tr>
			</table>

			</section> </section>
		</div>





		<!-- 삭제 -->
		<form action="${pageContext.request.contextPath}/report/ReportDeleteOk.rep
		?report_num=${reportBean.getReport_num()}
		&report_board=${reportBean.getReport_board()}
		&report_type=${reportBean.getReport_type()}" 
		method="post" name="reportform">
		</form>
		
		
	
<%-- 	
			<!-- 삭제 -->
		<!-- 공지글 삭제 or 신고게시글 삭제 -->
		<form action="${pageContext.request.contextPath}/report/ReportDeleteOk.re
		?qwe=${reportBean.getReport_num()}" 
		method="post" name="reportpassform">
			<input type="hidden" name="qwe" value="${reportBean.getReport_num()}" />
		</form>
	
	 --%>
	
		
<%-- 		 
		<!-- 삭제 -->
		
		<form action="${pageContext.request.contextPath}/notice/NoticeDeleteOk.no?seq=${reportBean.getReport_board()}&qwe=${reportBean.getReport_num()}" method="post" name="noticeform">
			<input type="hidden" name="seq" value="${noticeBean.getNotice_num()}" />
		</form>
		
 --%>		
	</center>
</body>


<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://rawgit.com/jackmoore/autosize/master/dist/autosize.min.js"></script>
<script>
	var check = false;
	autosize($("textarea.replys"));

	function passReport() {
		reportpassform.submit();

	}

	function deleteReport() {
		reportform.submit();
	

	}
	
/* 	function deleteNotice() {

		noticeform.submit();

	} */
	
	
	
/* 
	function comment() {
		var textarea = $("textarea[name='reply_contents']");
		if (textarea.val() == "") {
			alert("댓글을 작성해주세요.");
			return false;
		}
		boardReply.submit();
	} */
	
	

/* 	function updateReply(num) {
		var textarea = $("textarea#" + num);
		var modify_ready_a = $("a#ready" + num);
		var modify_ok_a = $("a#ok" + num);

		if (!check) {
			textarea.removeAttr("readonly");
			modify_ready_a.css("display", "none");
			modify_ok_a.css("display", "inline");
			check = true;
		} else {
			alert("수정중인 댓글이 있습니다.");
		}
	} */
	
	
/* 
	function submitReplyUpdateForm(reply_num, seq, num) {
		$("form[name='boardReply']").attr(
				"action",
				"${pageContext.request.contextPath}/board/BoardReplyModifyOk.bo?reply_num="
						+ reply_num + "&seq=" + seq + "&num=" + num);
		boardReply.submit();
	} */
</script>
</html>






