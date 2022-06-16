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
      <title>제품수정</title>
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
<script>

	var category1Id =<%=String.valueOf(session.getAttribute("category1Id"))%>;
	var category2Id =<%=String.valueOf(session.getAttribute("category2Id"))%>;
	
	
	$(document).ready(function(){ 
	

		//페이지로드시 대분류 가져오기(카톡 링크 보낸거 보기)
		$.get("${pageContext.request.contextPath}/product/ProductGetCat.pr", function(responseJson) {
	        var $select = $("#category1");
	        $select.find("option").remove();  
	        $.each(responseJson, function(index, category) {
	        $("<option>").val(category.id).text(category.name).appendTo($select);
	        }); 

			if(category1Id != null){
				$('#category1').val(category1Id).prop("selected", true);
			}
			getCategory2();
	    });
		

		//대분류 선택시 소분류 가져오기
		$('#category1').change(function(){
			getCategory2();	
		});
		
		function getCategory2() {
			var params = {category : $("#category1 option:selected").text()};
			
			$.post("${pageContext.request.contextPath}/product/ProductGetCat2.pr", $.param(params), function(responseJson) {
		        var $select = $("#category2");
		        $select.find("option").remove();  
		        $.each(responseJson, function(index, category) {
		        $("<option>").val(category.id).text(category.name).appendTo($select);
		        }); 
				if(category2Id != null){
					$('#category2').val(category2Id).prop("selected", true);
				}
		    });
		}
	});
	
	
	//	파일선택했을때 파일 정보 보여줌  
	function fileSelected() {
		var file = document.getElementById('productImage').files[0];
		if (file) {
			var fileSize = 0;
			if (file.size > 1024 * 1024)
				fileSize = (Math.round(file.size * 100 / (1024 * 1024)) / 100).toString() + 'MB';
			else
				fileSize = (Math.round(file.size * 100 / 1024) / 100).toString() + 'KB';

			document.getElementById('fileName').innerHTML = '파일명: ' + file.name;
			document.getElementById('fileSize').innerHTML = '크기: ' + fileSize;
			document.getElementById('fileType').innerHTML = '유형: ' + file.type;
		}
	}
</script>   
<body class="is-preload">

	<c:set var="productBean" value="${requestScope.productBean}"/>
	<c:set var="productFilesBeanList" value="${requestScope.productFilesBeanList}"/>
	
	<form action="${pageContext.request.contextPath}/product/ProductModifyOk.pr" method="post" enctype="multipart/form-data" name="productform">

	<header id="header"></header> 
	
	
		<div class="wrapper">	
		<section class="main">
		<section>
		<h9>제품 수정</h9>
		<div class="category_area">
			<span>카테고리</span>
			<div class="category_box">
				<select name="category1" id="category1" >
				    <c:forEach items="${listCategory}" var="category">
				        <option value="${category.id}">${category.name}</option>
				    </c:forEach>
				</select>
			</div>
			<div class="category_box">
				<select name="category2" id="category2" >
				    <c:forEach items="${listCategory}" var="category">
				        <option value="${category.id}">${category.name}</option>
				    </c:forEach>
				</select>
			</div>

			<input type="hidden" id="productNum" name="productNum" value="${productBean.getProductNum()}">
			<div class="prj_title">
			<span>제품명</span>
				<input type="text" name="productTitle" id="productTitle" value="${productBean.getProductTitle()}" placeholder="Title" style="width:50%;">
			</div>
			<div class="prj_title">
			<span>브랜드</span>
				<input type="text" name="productBrand" id="productBrand" value="${productBean.getProductBrand()}" placeholder="Brand" style="width:50%;">
			</div>
			<div class="prj_title">
			<span>가격</span>
				<input type="text" name="productPrice" id="productPrice" value="${productBean.getProductPrice()}" placeholder="Price" style="width:50%;">
			</div>
			
			<div class="prj_img">
			<span>이미지</span>
				<input type="file" name="productImage" id="productImage" value="" placeholder="첨부파일" style="width:30%;"   onchange="fileSelected();">
				
				<div class="field">
					<div class="info-file">
						<div id="fileName" class="info-small">${productBean.getProductImage()}</div>
						<div id="fileSize" class="info-small"></div>
						<div id="fileType" style="display:none"></div>
						<div id="progressNumber" style="display:none"></div>
					</div>
				</div>
			</div>
			
			<div class="prj_content">
				<span>내용</span>
				<div class="col-12"  width="80%" cellpadding="0" cellspacing="0">
					<textarea name="productExplanation" id="productExplanation" placeholder="Enter your message" rows="15">${productBean.getProductExplanation()}</textarea>
				</div>
			</div>
		</div>
			<div class="prj_btn">
				<input type="submit" value="수정" class="primary" style="width:15%;">
			</div>
	</section>
	</section>
	</form>

      <!-- Scripts -->
         <script src="${pageContext.request.contextPath}/blue/assets/js/jquery.min.js"></script>
         <script src="${pageContext.request.contextPath}/blue/assets/js/jquery.dropotron.min.js"></script>
         <script src="${pageContext.request.contextPath}/blue/assets/js/browser.min.js"></script>
         <script src="${pageContext.request.contextPath}/blue/assets/js/breakpoints.min.js"></script>
         <script src="${pageContext.request.contextPath}/blue/assets/js/util.js"></script>
         <script src="${pageContext.request.contextPath}/blue/assets/js/main.js"></script>

	</body>
	<script type="text/javascript">
	//AJAX select box 
//	function citySelect(province){ $.ajax({type: "POST",url: "/tc/ProductListSelect.pr",dataType:"json",data: {param:province},success: 
//		function(result){ //SELECT BOX 초기화  $("#city").find("option").remove().end().append("<option value=''>전체</option>");
		//배열 개수 만큼 option 추가
//		$.each(result, function(i){$("#city").append("<option value='"+result[i]+"'>"+result[i]+"</option>")});},error: function (jqXHR, textStatus, errorThrown) {alert("오류가 발생하였습니다.");}}); }
	</script>
	
	
	
	
<script>
	function addproduct(){
		productform.submit();
	}
	
</script>
</html>