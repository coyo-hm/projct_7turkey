<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
      <style>
      		
      </style>
</head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){ $("#header").load("${pageContext.request.contextPath}/blue/include/header.jsp") });
</script>  
<body class="is-preload">

	<header id="header"></header> 
	
		<div class="wrapper">	
	<section class="main">
		<section>

		<h9 id = "title">신고 등록</h9>
	


	<c:set var="reportList" value="${requestScope.reportList}"/>
	



<!-- 신고 게시글 등록 -->
			<form action="${pageContext.request.contextPath}/report/ReportWriteOk.rep" 
			method="post" enctype="multipart/form-data" name="reportform">


					
								
				<table  border="1" cellpadding="0" cellspacing="0" width="900px" >
 
 
 				<tr height="30px">
					<td align="center" width="150px">게시글 타입</td>
					<td style="padding-left: 10px;">
					
					<c:if test="${param.type == 2}">
					<div>제품 리뷰</div>
					<input name="report_type" type="hidden" size="10" maxlength="10" value="${param.type}" readonly />
					</c:if>
					
					<c:if test="${param.type == 1}">
					<div>나만의 화장</div>
					<input name="report_type" type="hidden" size="10" maxlength="10" value="${param.type}" readonly />
					</c:if> 
					
					</td>
				</tr>
					
				
					<!-- 신고 당한 게시글 no(PK) -->
					<tr height="30px">
						<td align="center" width="150px">
							<div align="center">게시글 번호</div>
						</td>
							<td style="padding-left:10px;">
							<input name="report_board" type="text" size="10" maxlength="10" value="${param.commentNum}" readonly />
						</td>
						
					</tr>

	   
	
					<tr height="30px">
						<td align="center" width="150px">
							<div align="center">신고자</div>
						</td>
						<td style="padding-left:10px;">
							<%-- <input name="userid" type="text" size="10" maxlength="10" value="${session_id}" readonly /> --%>
							<input name="userid" type="text" size="10" maxlength="10" value="${param.userid}" readonly />
							
						</td>
					</tr>
	   					
					
					<tr height="30px">
						<td align="center" width="150px">
							<div align="center">제 목</div>
						</td>
						<td style="padding-left:10px;">
							<input name="report_title" type="text" size="50" maxlength="100" value=""/>
						</td>
					</tr>
	
	
					
					
					
					<tr height="200px">
						<td align="center" width="150px">
							<div align="center">내 용</div>
						</td>
						<td style="padding-left:10px;">
							<textarea name="report_contents" style="width:1200px; height:185px"></textarea>
						</td>
					</tr>
					
					
					
<!-- 					
					<tr height="30px">
						<td align="center" width="150px">
							<div align="center">파일 첨부</div>
						</td>
						<td style="padding-left:10px;">
							<input name="report_file1" type="file"/>
							<input type="button" onclick="cancleFile('report_file')" value="첨부 삭제">
						</td>
					</tr> 
	 -->
	
	
				</table>
				
				<table border="0" cellpadding="0" cellspacing="0" width="900px">
					<tr align="right" valign="middle">
						<td>
							<a href="javascript:addreport()">
							등록
							</a>&nbsp;&nbsp;
							
			<%-- 				
							<a href="${pageContext.request.contextPath}/report/ReportList.rep">
							목록
							</a>&nbsp;&nbsp;
						 --%>
						</td>
					</tr>
				</table>
				
				</form>

				
				
	
	
		

      <!-- Scripts -->
         <script src="../assets/js/jquery.min.js"></script>
         <script src="../assets/js/jquery.dropotron.min.js"></script>
         <script src="../assets/js/browser.min.js"></script>
         <script src="../assets/js/breakpoints.min.js"></script>
         <script src="../assets/js/util.js"></script>
         <script src="../assets/js/main.js"></script>

	</body>
	<script>
		var check = true;
		
		function addreport(){
			

			reportform.submit();
		}
		
		
		
		function cancleFile(fileTagName){
			//ie일 때
			if($.browser.msie){
				$("input[name='"+fileTagName+"']").replaceWith(("input[name='"+fileTagName+"']").clone(true));
			}else{
			//그 외 브라우저	
				$("input[name='"+fileTagName+"']").val("");
			}
		}
		
	</script>
</html>