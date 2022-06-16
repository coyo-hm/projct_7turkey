<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>상품리스트</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/blue/assets/css/main.css" />



</head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){ $("#header").load("${pageContext.request.contextPath}/blue/include/header.jsp") });
</script>   

<script>

$(document).ready(function(){ 
	$("#header").load("${pageContext.request.contextPath}/blue/include/header.html");

	var category1Id =<%=String.valueOf(session.getAttribute("category1Id"))%>;
	var category2Id =<%=String.valueOf(session.getAttribute("category2Id"))%>;
	var list_order =<%=String.valueOf(session.getAttribute("list_order"))%>;

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
		if(category1Id == null || $("#category1").val() != category1Id){
			window.location.href="${pageContext.request.contextPath}/product/ProductList.pr?"
					+"category1Id="+$("#category1").val()
					+"&list_order="+$("#list_order").val();
		}		
	});
	
	//소분류 선택했을때////////////////다시보기
	$('#category2').change(function(){
		if(category2Id == null || $("#category2").val() != category2Id){
			window.location.href="${pageContext.request.contextPath}/product/ProductList.pr?"
					+"category1Id="+$("#category1").val()
					+"&category2Id="+$("#category2").val()
					+"&list_order="+$("#list_order").val();
		}		
	});
	
	//조회순서 선택했을때
	$('#list_order').change(function(){
		if(list_order == null || $("#list_order").val() != list_order){
			window.location.href="${pageContext.request.contextPath}/product/ProductList.pr?"
					+"category1Id="+$("#category1").val()
					+"&category2Id="+$("#category2").val()
					+"&list_order="+$("#list_order").val();
		}

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
	
	 $("#product_list_table tr").click(function(){
        var str = ""
        var tdArr = new Array();  
            
        // 현재 클릭된 Row(<tr>)
        var tr = $(this);
        var td = tr.children();
   		var no = td.eq(0).text();
        console.log("productNum: "+no);

		var params = {productNum : no};
		window.location.href="${pageContext.request.contextPath}/product/ProductView.pr?seq="+no;
	 });

	//조회순서 선택항목 복원
	if(list_order != null){
		$('#list_order').val(list_order).prop("selected", true);
	}else{
		$('#list_order').val("1").prop("selected", true); //기본값 선택 인 필요
	}
	

});
</script>
<body class="is-preload">

	<header id="header"></header>


	<c:set var="productList" value="${requestScope.productList}" />
	<c:set var="nowPage" value="${requestScope.nowPage}" />
	<c:set var="startPage" value="${requestScope.startPage}" />
	<c:set var="endPage" value="${requestScope.endPage}" />
	<c:set var="totalCnt" value="${requestScope.totalCnt}" />
	<c:set var="totalPage" value="${requestScope.totalPage}" />

	<!-- Wrapper -->
	<div class="wrapper">
		<section class="main"> <section> <h9>제품 등록
		리스트</h9>
		<div style="margin-top: 50px;">
			<div style="float: left; width: 20%;">
				<select name="category1" id="category1">
					<c:forEach items="${listCategory}" var="category">
						<option value="${category.id}">${category.name}</option>
					</c:forEach>
				</select>
			</div>



			<div style="float: left; width: 20%; margin: 0px 20px;">
				<select name="category2" id="category2">
					<c:forEach items="${listCategory}" var="category">
						<option value="${category.id}">${category.name}</option>
					</c:forEach>
				</select>
			</div>



			<div style="float: left; width: 15%;">
				<select name="list_order" id="list_order">
					<option value="1">최신순</option>
					<option value="2">별점순</option>
				</select>
			</div>

			<div class="product_list">
				<table id="product_list_table" class="product_list_table" width="100%" cellpadding="0"
					cellspacing="0">
					<colgroup>
						<col width="5%" />
						<col width="15%" />
						<col width="*" />
						<col width="10%" />
						<col width="10%" />
					</colgroup>
					<tbody>

						<c:choose>
							<c:when test="${productList != null and fn:length(productList) > 0}">
								<c:forEach var="p" items="${productList}" varStatus="status">
									<tr align="center" valign="middle"
										onmouseover="this.style.backgroundColor='F8F8F8'"
										onmouseout="this.style.backgroundColor=''">
										<td class="po01" style="font-family: Tahoma; font-size: 10pt;">
											${p.getProductNum()}</td>
										<td class="po02">
											<img src="${pageContext.request.contextPath}/ProductFile/${p.getProductImage()}" alt="">
										</td>
										<td class="po03">
											<p class="a1">${p.getProductBrand()}</p>
											<p class="a2">${p.getProductTitle()}</p>
											<em class="st">${p.getProductPrice()}</em>
										</td>
										<td class="po05">평점 ${p.getAvgPoint()}</td>
										<td class="po04">${p.getProductDate()}</td>
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
			<br />
<%-- 			
			<table border="0" cellpadding="0" cellspacing="0" width="900px">
				<tr align="center" valign="middle">
					<td><c:choose>
							<c:when test="${nowPage > 1}">
								<a
									href="${pageContext.request.contextPath}/product/ProductList.pr?page=${nowPage - 1}">[이전]</a>&nbsp;
						</c:when>
						</c:choose> <c:forEach var="i" begin="${startPage}" end="${endPage}">
							<c:choose>
								<c:when test="${i eq nowPage}">
								[${i}]
							</c:when>
								<c:otherwise>
									<a
										href="${pageContext.request.contextPath}/product/ProductList.pr?page=${i}">[${i}]</a>
								</c:otherwise>
							</c:choose>
						</c:forEach> <c:choose>
							<c:when test="${nowPage < totalPage}">
								<a
									href="${pageContext.request.contextPath}/product/ProductList.pr?page=${nowPage + 1}">[다음]</a>&nbsp;
						</c:when>
						</c:choose></td>
				</tr>
			</table>
			 --%>
			
		</section> <!--   --------- 괸리자 일 경우에만 글쓰기 보이게  -->
	</div>

	</section>
	</section>
	</div>

<div class="modal"></div>
</body>
</html>
