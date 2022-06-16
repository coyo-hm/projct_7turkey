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
      <title>제품상세 페이지</title>

	  <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/blue/assets/css/main.css" />
 	  <!--// plugin-specific resources //-->
 	  <script src="${pageContext.request.contextPath}/blue/assets/js/jquery.MetaData.js" type="text/javascript" language="javascript"></script>
  	  <script src="${pageContext.request.contextPath}/blue/assets/js/jquery.rating.js" type="text/javascript" language="javascript"></script>
  	  <link href="${pageContext.request.contextPath}/blue/assets/css/jquery.rating.css" type="text/css" rel="stylesheet"/>
</head>

<script>
	$(document).ready(function(){ $("#header").load("${pageContext.request.contextPath}/blue/include/header.jsp") });
</script> 
<script>

	var stars = 0;
	$(document).ready(function(){ 
		

		$('#star-container').rating({stars:5,callback:function(value){
		    	 stars = value;
		    	 if(stars != null){
		    		 document.getElementById('stars-point').innerHTML = "&nbsp;&nbsp;"+stars+" 점"; 
		    		 document.getElementById('comment_point').value = stars;
		    	 }else{
		    		 document.getElementById('stars-point').innerHTML = "&nbsp;&nbsp;";
		    		 document.getElementById('comment_point').value = 0;
		    	 }
	     } });
	
	});
	
	
	
	
	
	
	/* 신고하기 */
	function addreport() {
		reportform.submit();

	}
	
	
	
</script>   
<body class="is-preload">

	<header id="header"></header> 
	
	<c:set var="productBean" value="${requestScope.productBean}"/>
	<c:set var="productFilesBeanList" value="${requestScope.productFilesBeanList}"/>
	<c:set var="productReplyList" value="${requestScope.productReplyList}"/>
	<c:set var="mypageReplyList" value="${requestScope.mypageReplyList}"/>
	<c:set var="like_count" value="${requestScope.like_count}"/>
	
	
	
	<!-- jsp:useBean : ProductReplyDAO    -->
	<jsp:useBean id="pr_dao" class="com.dohwaji.app.product.dao.ProductReplyDAO"></jsp:useBean>

	


	
	<div align="center" valign="right">
		<button id="btnModfy" onclick="location.href = '${pageContext.request.contextPath}/product/ProductModify.pr?seq=${productBean.getProductNum()}'">수정</button>
		<button id="btnRemove" onclick="location.href = '${pageContext.request.contextPath}/product/ProductDeleteOk.pr?seq=${productBean.getProductNum()}'">삭제</button>
		<button id="btnList" onclick="location.href = '${pageContext.request.contextPath}/product/ProductList.pr'">목록</button>
	</div>
	
	<!-- Wrapper -->
	<div class="wrapper">	
	<section class="main">
		<section>
			<div class="p_top">			
 				<div class="p_img"><img src="${pageContext.request.contextPath}/ProductFile/${productBean.getProductImage()}" alt=""></div>
				<div class="p_text">
					<p class="p_t1">
						<a href="${pageContext.request.contextPath}/product/ProductView.pr?seq=${productBean.getProductNum()}">${productBean.getProductTitle()}</a></p>
					<p class="p_t2">${productBean.getProductBrand()}</p>
					<em class="p_t3">${productBean.getProductPrice()}</em>
					<table class="p_table">
					<colgroup>
						<col width="15%" />
						<col width="40%" />
						<col width="40%" />
					</colgroup>
					<tbody>
						<tr>
							<td class="p_t_1">카테고리</td>
							<td class="p_t_2">${productBean.getCatechoryDivName()}</td>
							<td class="p_t_3">${productBean.getCatechoryDivName2()}</td>
						</tr>
						<tr><td colspan="3"></td></tr> <!-- 띄어쓰기를 위한 구간입니다. 건드리지 말아주세요!! -->
						<tr>
							<td class="p_t_4">소개</td>
							<td class="p_t_5" colspan="2">
								${productBean.getProductExplanation()}
							</td>
						</tr>
					</tbody>
					</table>
				</div>
			</div>
			
			<div class="p_middle">
				<div class="m_left">
					<p class="m1">평점</p>
					<p class="m2">${productBean.getAvgValue()}</p>
					<p class="m3">${productBean.getAvgPoint()}</p>
					<p class="m4">(총 ${productBean.getCommentCount()}개)</p>
				</div>
				<div class="m_right">
					<table class="m_right_table">
					<colgroup>
						<col width="60%" />
						<col width="40%" />
					</colgroup>
						<c:if test="${productBean.getPointCount1() > 0}">
							<tr><td class="redzone">★☆☆☆☆</td><td>${productBean.getPointCount1()}개</td></tr>
						</c:if>						
						<c:if test="${productBean.getPointCount2() > 0}">
							<tr><td class="redzone">★★☆☆☆</td><td>${productBean.getPointCount2()}개</td></tr>
						</c:if>						
						<c:if test="${productBean.getPointCount3() > 0}">
							<tr><td class="redzone">★★★☆☆</td><td>${productBean.getPointCount3()}개</td></tr>
						</c:if>						
						<c:if test="${productBean.getPointCount4() > 0}">
							<tr><td class="redzone">★★★★☆</td><td>${productBean.getPointCount4()}개</td></tr>
						</c:if>						
						<c:if test="${productBean.getPointCount5() > 0}">
							<tr><td class="redzone">★★★★★</td><td>${productBean.getPointCount5()}개</td></tr>
						</c:if>
					</table>
				</div>
			</div>
			<div class="p_comment">
				<table class="comment_table">
					<tr>
						<td><p>평점
						     <div id="star-container">						     
    <input class="star" type="radio" name="test-2-rating-5" value="1"/>
    <input class="star" type="radio" name="test-2-rating-5" value="2"/>
    <input class="star" type="radio" name="test-2-rating-5" value="3"/>
    <input class="star" type="radio" name="test-2-rating-5" value="4"/>
    <input class="star" type="radio" name="test-2-rating-5" value="5" checked="checked"/>
						     </div>
						     <div id="stars-point"></div>
						</p></td>
					</tr>
					<tr>
						<td>
							<div class="comment">
								
								<input type="hidden" id="comment_point" name="star_point" value="0">
								<textarea  id="comment_write" name="comment_write" row="10" cols="70" ></textarea>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<button id="btnComment" onclick="onClickComment()">등록</button>
							<script>
						      function onClickComment() {
						    	  var comment_write = $('#comment_write').val();
						    	  var comment_point = $('#comment_point').val();
						    	  var url = "${pageContext.request.contextPath}/product/ProductReplyOk.pr?mode=add&seq=${productBean.getProductNum()}";
						    	  url = url +"&comment_point="+comment_point;
						    	  url = url +"&comment_write="+comment_write;
						    	  location.href = url;
						      }
						    </script>
						</td>
					</tr>
				</table>
			</div>
			<div class="p_bottom">
			
			<!-- &userid=${session_id} -->
				<ul class="comment_list">
					<li><a href="${pageContext.request.contextPath}/product/ProductView.pr?seq=${productBean.getProductNum()}">최신순</a></li>
					
<%-- 					<li><a href="${pageContext.request.contextPath}/product/ProductReplyViewLike.pr
					?seq=${productBean.getProductNum()}
					">추천순</a></li> --%>
					
					<li><a href="${pageContext.request.contextPath}/product/ProductStarReply.pr
					?seq=${productBean.getProductNum()}
					&userid=${session_id}
					">평점순</a></li>
					
					<li><a href="${pageContext.request.contextPath}/product/ProductMypage.pr
					?seq=${productBean.getProductNum()}
					&userid=${session_id}
					">내가 쓴 댓글</a></li>
				</ul>
			</div>
			
			
		

			<div class="p_bottom_list">	
				<table class="comment_list_table">
					<colgroup>
                  <col width="20%" />
                  <col width="5%" />
                  <col width="20%" />
                  <col width="5%" />
                  <col width="30%" />
                  <col width="5%" />
                  <col width="5%" />
                  <col width="5%" />
					</colgroup>
					<tbody>
						<c:choose>
							<c:when test="${productReplyList != null and fn:length(productReplyList) > 0}">
								<c:forEach var="p" items="${productReplyList}" varStatus="status">
									<tr>
									<!-- 사용자 이미지 -->					
										<td class="cm2">${p.getUserid()}</td>
										<td class="cm3">${p.getCommentStars()}</td>
										<td class="cm4">${p.getCommentDate()}</td>
										<%-- <td class="commentNum">${p.getCommentNum()}</td> --%>
										<td class="pr_dao">${pr_dao.like_count(p.getCommentNum())}</td>
										<td></td> <!-- 여백을 위한 공간입니다. 삭제하지 말아주세요!! -->
										
										<!-- 추천 기능 -->
										<td>
										
										<a href="${pageContext.request.contextPath}/product/ProductReviewLike.pr
										?seq=${productBean.getProductNum()}
										&userid=${session_id}
										&commentNum=${p.getCommentNum()}
										">
										[추천]</a>
										
										</td>
										
										<!-- 리뷰 신고  -->
										<td>
										<a href="${pageContext.request.contextPath}/report/ReportWrite.rep
										?productNum=${productBean.getProductNum()}
										&userid=${session_id}
										&commentNum=${p.getCommentNum()}
										&type=2
										">
										[신고]
										</a>
										</td>
							 
									<%-- 	<c:if test="${p.getUserid() eq session_id}"> --%>
										<td>
										<a href="${pageContext.request.contextPath}/product/ProductReplyDeleteOk.pr
										?seq=${productBean.getProductNum()}
										&commentNum=${p.getCommentNum()}">[삭제]</a>
										</td>
										</c:if>
									</tr>  
		
									<tr>
										<td class="cm5" colspan="7">${p.getCommentWrite()}</td>
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
		</section>
	</section>
	</div>
</body>
</html>