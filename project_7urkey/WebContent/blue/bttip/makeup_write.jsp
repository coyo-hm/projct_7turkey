<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<!-- Wrapper -->
<div class="wrapper">	
	<section class="main">
		<section>
		<h9>나만의 화장법</h9>
		
		<form name="BTWriteForm" action="${pageContext.request.contextPath}/bttip/BeautytipWrite.bt" method="post" enctype="multipart/form-data">
		
		<div class="category_area" style="margin-top:30px;">
			<div class="prj_title">
				<span style="width:160px; margin:0px;">제 목</span>
				<input type="text" name="title" id="title" value="" placeholder="Title" style="width:70%;">
			</div>
			<div class="prj_img">
			<span>썸네일 이미지</span>
				<input type="file" name="fileName" placeholder="첨부파일" style="width:30%;">
			</div>
			<p class="mup01">화장법 카테고리</p>
				<table class="select_table">
              		<tr>
              			<td class="first">성별</td>
						<td class="label"><input style="vertical-align:-2px; " type="radio" id="m" name="gender" value = "남"><label for="m">남</label></td>
						<td class="label"><input type="radio" id="w" name="gender" value ="여"><label for="w">여</label></td>
						<td class="label"></td>
						<td class="label"></td>
						<td class="last"></td>
					</tr>
					<tr>
              			<td class="first">나이</td>
						<td class="label"><input type="radio" id="age1" name="age" value = "10"><label for="age1">10대</label></td>
						<td class="label"><input type="radio" id="age2" name="age" value = "20"><label for="age2">20대</label></td>
						<td class="label"><input type="radio" id="age3" name="age" value = "30"><label for="age3">30대</label></td>
						<td class="label"><input type="radio" id="age4" name="age" value = "40"><label for="age4">40대</label></td>
						<td class="last"><input type="radio"  id="age5" name="age" value = "50"><label for="age5">50대 이상</label></td>
					</tr>
					<tr>
              			<td class="first">눈</td>
						<td class="label"><input type="radio" id="eye1" name="eye" value = "무쌍"><label for="eye1">무쌍</label></td>
						<td class="label"><input type="radio" id="eye2" name="eye" value = "겉쌍"><label for="eye2">겉쌍</label></td>
						<td class="label"><input type="radio" id="eye3" name="eye" value = "속쌍"><label for="eye3">속쌍</label></td>
						<td class="label"><input type="radio" id="eye4" name="eye" value = "올라간눈"><label for="eye4">올라간눈</label></td>
						<td class="last"><input type="radio" id="eye5" name="eye" value = "내려간눈"><label for="eye5">내려간눈</label></td>
					</tr>
					<tr>
              			<td class="first">코</td>
						<td class="label"><input type="radio" id="nose1" name="nose" value="높은코"><label for="nose1">높은코</label></td>
						<td class="label"><input type="radio" id="nose2" name="nose" value="낮은코"><label for="nose2">낮은코</label></td>
						<td class="label"><input type="radio" id="nose3" name="nose" value="복코"><label for="nose3">복코</label></td>
						<td class="label"><input type="radio" id="nose4" name="nose" value="메부리코"><label for="nose4">메부리코</label></td>
						<td class="last"></td>
					</tr>
					<tr>
              			<td class="first">입</td>
						<td class="label"><input type="radio" id="lip1" name="lip" value="작은입술"><label for="lip1">작은입술</label></td>
						<td class="label"><input type="radio" id="lip2" name="lip" value="큰입술"><label for="lip2">큰입술</label></td>
						<td class="label"><input type="radio" id="lip3" name="lip" value="얇은입술"><label for="lip3">얇은입술</label></td>
						<td class="label"><input type="radio" id="lip4" name="lip" value="두꺼운입술"><label for="lip4">두꺼운입술</label></td>
						<td class="last"></td>
					</tr>
					<tr>
              			<td class="first">얼굴형</td>
						<td class="label"><input type="radio" id="face1" name="face" value="계란형"><label for="face1">계란형</label></td>
						<td class="label"><input type="radio" id="face2" name="face" value="둥근형"><label for="face2">둥근형</label></td>
						<td class="label"><input type="radio" id="face3" name="face" value="각진형"><label for="face3">각진형</label></td>
						<td class="label"><input type="radio" id="face4" name="face" value="긴형"><label for="face4">긴형</label></td>
						<td class="last"><input type="radio"  id="face5" name="face" value="넓적형"><label for="face5">넓적형</label></td>
					</tr>
					<tr>
              			<td class="first">피부타입</td>
						<td class="label"><input type="radio" id="type1" name="type" value="건성"><label for="type1">건성</label></td>
						<td class="label"><input type="radio" id="type2" name="type" value="지성"><label for="type2">지성</label></td>
						<td class="label"><input type="radio" id="type3" name="type" value="복합성"><label for="type3">복합성</label></td>
						<td class="label"><input type="radio" id="type4" name="type" value="트러블"><label for="type4">트러블</label></td>
						<td class="last"></td>
					</tr>
					<tr>
              			<td class="first">피부톤</td>
						<td class="label"><input type="radio" id="tone1" name="tone" value="어두운톤"><label for="tone1">어두운톤</label></td>
						<td class="label"><input type="radio" id="tone2" name="tone" value="밝은톤"><label for="tone2">밝은톤</label></td>
						<td class="label"><input type="radio" id="tone3" name="tone" value="핑크톤"><label for="tone3">핑크톤</label></td>
						<td class="label"><input type="radio" id="tone4" name="tone" value="노란톤"><label for="tone4">노란톤</label></td>
						<td class="last"></td>
					</tr>
					<tr>
              			<td class="first">계절</td>
						<td class="label"><input type="radio" id="season1" name="season" value="봄"><label for="season1">봄</label></td>
						<td class="label"><input type="radio" id="season2" name="season" value="여름"><label for="season2">여름</label></td>
						<td class="label"><input type="radio" id="season3" name="season" value="가을"><label for="season3">가을</label></td>
						<td class="label"><input type="radio" id="season4" name="season" value="겨울"><label for="season4">겨울</label></td>
						<td class="last"></td>
					</tr>
					<tr>
              			<td class="first">테마</td>      			
						<td class="label"><input type="radio" id="thema1" name="thema" value="데일리"><label for="thema1">데일리</label></td>
						<td class="label"><input type="radio" id="thema2" name="thema" value="하객"><label for="thema2">하객</label></td>
						<td class="label"><input type="radio" id="thema3" name="thema" value="페스티벌"><label for="thema3">페스티벌</label></td>
						<td class="label"><input type="radio" id="thema4" name="thema" value="인물커버"><label for="thema4">인물커버</label></td>
						<td class="last"><input type="radio"  id="thema5" name="thema" value="새내기"><label for="thema5">새내기</label></td>
					</tr>
				</table>
			<div class="prj_content" style="margin-bottom:30px;">
				<span style="margin-right:50px;">썸네일 내용</span>
				<input type="text" name="contents" id="message" value="" placeholder="Enter your message" style="width:70%;">
			</div>
			<!-- 아아아아아아아아ㅏ아아아아아아아아ㅏ아앙아아아아아아아아아이부분 -->
			<div style="width:100%; margin:20px;">
    			<div style="float:left; width:10%;">텍스트 추가 : </div>
    			<div style="clar:both;">
        			<input type="button" id="addItem" value="추가" onclick="createItem();" />
    			</div>
    		</div>
    		<div style="width:100%; margin:20px;">
    			<div style="float:left;width:10%;">이미지 추가 : </div>
    			<div style="clar:both;">
        			<input type="button" id="addItem" value="추가" onclick="createItemImg();" />
    			</div>
    		</div>
			<br />
			<div id="itemBoxWrap" style="width:100%;"></div>
			<!-- 까지이이이이이이이이이이이이이ㅣ이이이이이이ㅣ이이이ㅣ이이이이이ㅣ이이이이이 -->

		</div>
	</form>
	<ul class="actions fit" >
    	<li class="login" style="width:10%; marin:0 auto; text-align:center;"><a href="javascript:BTWriteForm.submit()" class="button primary fit">등록</a></li>
	</ul>

	</section>
	</section>
</div>
</body>
<!-- Scripts -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.dropotron.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.js"></script>
<script>var contextPath = "${pageContext.request.contextPath}";</script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" ></script>
<script>

var btImgNum = 0;
var btTextNum = 0;

/* function submitItem() {
	request.setAttribute("btTextNum", btTextNum);
} */

/** 아이템 체크 */
function validateItem() {
    var items = $("input[type='text'][name='item']");
    if(items.length == 0) {
        alert("작성된 아이템이 없습니다.");
        return false;
    }

    var flag = true;
    for(var i = 0; i < items.length; i++) {
        if($(items.get(i)).val().trim() == "") {
            flag = false;
            alert("내용을 입력하지 않은 항목이 있습니다.");
            break;
        }
    }
    return flag;
}

/** UI 설정 */
$(function() {
    $("#itemBoxWrap").sortable({
        placeholder:"itemBoxHighlight",
        start: function(event, ui) {
            ui.item.data('start_pos', ui.item.index());
        },
        stop: function(event, ui) {
            var spos = ui.item.data('start_pos');
            var epos = ui.item.index();
			      reorder();
        }
    });
    //$("#itemBoxWrap").disableSelection();
    $( "#sortable" ).sortable();
    $( "#sortable" ).disableSelection();
});

/** 아이템 순서 조정 */
function reorder() {
    $(".itemBox").each(function(i, box) {
        $(box).find(".itemNum").html(i + 1);
    });
}

/////////////////////////////////////////////////////////////////////////////////////////////

/** 텍스트 아이템 추가 */
function createItem() {
    $(createBox())
    .appendTo("#itemBoxWrap")
    .hover(
        function() {
            $(this).css('backgroundColor', '#f9f9f5');
            $(this).find('.deleteBox').show();
        },
        function() {
            $(this).css('background', 'none');
            $(this).find('.deleteBox').hide();
        }
    )
		.append("<div class='deleteBox'>[삭제]</div>")
		.find(".deleteBox").click(function() {
        var valueCheck = false;
        $(this).parent().find('input').each(function() {
            if($(this).attr("name") != "type" && $(this).val() != '') {
                valueCheck = true;
            }
        });

        if(valueCheck) {
            var delCheck = confirm('입력하신 내용이 있습니다.\n삭제하시겠습니까?');
        }
        if(!valueCheck || delCheck == true) {
            $(this).parent().remove();
            reorder();
        }
    });
    // 숫자를 다시 붙인다.
    reorder();
}

/** 아이템 박스 작성 */
function createBox() {
	++btTextNum;
    var contents = "<div class='itemBox'>"
                 + "<div style='float:left; width:100%;'>"
                 + "<span class='itemNum'></span> "
                 + "<input type='text' name='bttext' style='width:90%; margin-left:20px;'/>"
                 + "</div>"
                 + "</div>";             
    return contents;
}
/* "+btTextNum+" */
/* "+btImgNum+" */
/* request.setAttribute("btTextNum", btTextNum); */
///////////////////////////////////////////////////////////////////////////////////////
/** 이미지 아이템 추가 */
function createItemImg() {
    $(createBoxImg())
    .appendTo("#itemBoxWrap")
    .hover(
        function() {
            $(this).css('backgroundColor', '#f9f9f5');
            $(this).find('.deleteBox').show();
        },
        function() {
            $(this).css('background', 'none');
            $(this).find('.deleteBox').hide();
        }
    )
		.append("<div class='deleteBox'>[삭제]</div>")
		.find(".deleteBox").click(function() {
        var valueCheck = false;
        $(this).parent().find('input').each(function() {
            if($(this).attr("name") != "type" && $(this).val() != '') {
                valueCheck = true;
            }
        });

        if(valueCheck) {
            var delCheck = confirm('입력하신 내용이 있습니다.\n삭제하시겠습니까?');
        }
        if(!valueCheck || delCheck == true) {
            $(this).parent().remove();
            reorder();
        }
    });
    // 숫자를 다시 붙인다.
    reorder();
}

/** 아이템 박스 작성 */
function createBoxImg() {
	++btImgNum;
    var contents = "<div class='itemBox'>"
                 + "<div style='float:left; width:100%;'>"
                 + "<span class='itemNum'></span> "
                 + "<input type='file' name='btimg"+btImgNum+"' style='width:90%; margin-left:20px;'/>"
                 + "</div>"
                 + "</div>";
    return contents;
}

</script>
</html>