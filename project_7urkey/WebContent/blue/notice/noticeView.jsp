<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>MVC 게시판</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/app/assets/css/main.css" />
	</head>
	
	<body>
	<c:set var="noticeBean" value="${requestScope.noticeBean}"/>
	<c:set var="filesBeanList" value="${requestScope.filesBeanList}"/>
		<center>
		<c:choose>
			<c:when test="${session_id eq null}">
			<script>
				alert("로그인 후 이용해주세요");
				location.replace("${pageContext.request.contextPath}/member/MemberLogin.me");
			</script>
			</c:when>
			<c:otherwise>
			<table border="0" cellpadding="0" cellspacing="0" width="900px" >
				<tr align="right" valign="middle">
					<td>
						${session_id} 님 환영합니다.
						<a href="${pageContext.request.contextPath}/member/MemberLogOut.me">로그아웃</a>
					</td>
				</tr>
			</table>
			</c:otherwise>
			</c:choose>
			<br />
			<br />
		
			<table width="900px" border="0" cellpadding="0" cellspacing="0">
				<tr align="center" valign="middle">
					<td><h3>공지사항</h3></td>
				</tr>
			</table>
				
			<!-- 게시판 수정 -->
			<table width="900px" border="1" cellpadding="0" cellspacing="0">
				<tr height="30px">
					<td align="center" width="150px">제 목</td>
					<td style="padding-left:10px;">${noticeBean.getNotice_title()}</td>
				</tr>
				
				<tr height="30px">
					<td  align="center" width="150px">아이디</td>
					<td style="padding-left:10px;">${noticeBean.getMember_id()}</td>
				</tr>
				
				<tr height="200px">
					<td align="center" width="150px">내 용</td>
					<td valign="top" style="padding-top:10px; padding-left:10px;">${noticeBean.getNotice_contents()}</td>
				</tr>
				
				<tr height="30px">
					<td align="center">첨부파일</td>
					<c:if test="${filesBeanList != null}">
						<td>
							<c:forEach var="file" items="${filesBeanList}">
								<a href="${pageContext.request.contextPath}/notice/FileDownload.no?notice_file_name=${file.getNotice_file_name()}">${file.getNotice_file_name()}</a>
							</c:forEach>
						</td>
					</c:if>
				</tr>
			</table>
			
			<table width="900px" border="0" cellpadding="0" cellspacing="0">
				<tr align="right" valign="middle">
					<td>
						<c:if test="${NoticeBean.getMember_id() eq session_id}">
							<a href="${pageContext.request.contextPath}/notice/NoticeModify.no?seq=${noticeBean.getNotice_num()}">[수정]</a>&nbsp;&nbsp;
							<a href="javascript:deleteNotice()">[삭제]</a>&nbsp;&nbsp;
						</c:if>
						<a href="${pageContext.request.contextPath}/notice/NoticeList.no">[목록]</a>&nbsp;&nbsp;
					</td>
				</tr>
			</table>
			<!-- 게시판 수정 -->
			
			<form action="${pageContext.request.contextPath}/notice/NoticeDeleteOk.no" method="post" name="noticeform">
				<input type="hidden" name="seq" value="${noticeBean.getMember_id()}" />
 			</form>
		</center>
	</body>
		<script>
			function deleteNotice(){
				noticeform.submit();
			}
		</script>
</html>