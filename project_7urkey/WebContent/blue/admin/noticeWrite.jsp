<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

		<h9 id = "title">공지 사항 등록</h9>
	
	 
<!-- 	<div class="col-12" style="float:right; width:17%; margin-top:70px;">
	<select name="category" id="category">
	<option value="">- Category -</option>
	<option value="1">Manufacturing</option>
	<option value="1">Shipping</option>
	<option value="1">Administration</option>
	<option value="1">Human Resources</option>
	</select>
	</div> -->
	
	
<!-- 게시판 등록 -->
			

				<form action="${pageContext.request.contextPath}/notice/NoticeWriteOk.no" method="post" enctype="multipart/form-data" name="noticeform">
				<table  border="1" cellpadding="0" cellspacing="0" width="900px" >
					<tr height="30px">
						<td align="center" width="150px">
							<div align="center">제 목</div>
						</td>
						<td style="padding-left:10px;">
							<input name="notice_title" type="text" size="50" maxlength="100" value=""/>
						</td>
					</tr>
					<tr height="30px">
						<td align="center" width="150px">
							<div align="center">글쓴이</div>
						</td>
						<td style="padding-left:10px;">
							<%--  <input name="userid" type="text" size="10" maxlength="10" value="${session_id}" readonly /> --%>
							
							 	<input name="userid" type="text" size="10" maxlength="10" value="admin" readonly />
							
						</td>
					</tr>
					<tr height="200px">
						<td align="center" width="150px">
							<div align="center">내 용</div>
						</td>
						<td style="padding-left:10px;">
							<textarea name="notice_contents" style="width:700px; height:185px"></textarea>
						</td>
					</tr>
	<!-- 				<tr height="30px">
						<td align="center" width="150px">
							<div align="center">파일 첨부</div>
						</td>
						<td style="padding-left:10px;">
							<input name="notice_file1" type="file"/>
							<input type="button" onclick="cancleFile('board_file1')" value="첨부 삭제">
						</td>
					</tr> -->
	
				</table>
				
		
				
				<table border="0" cellpadding="0" cellspacing="0" width="900px">
					<tr align="right" valign="middle">
						<td>
							<a href="javascript:addnotice()">
							등록
							</a>&nbsp;&nbsp;
							
							
							<a href="${pageContext.request.contextPath}/notice/NoticeList.no">
							목록
							</a>&nbsp;&nbsp;
						
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
		
		function addnotice(){
			

			noticeform.submit();
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