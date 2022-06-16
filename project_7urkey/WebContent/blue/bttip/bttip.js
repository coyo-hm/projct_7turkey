function test() {
	var text = $("#selectFilter");
	var result = "";
	if ($("input:checkbox[id='m']").is(":checked")) {
		result += "남 / ";
	}
	if ($("input:checkbox[id='w']").is(":checked")) {
		result += "여 / ";
	}
	for (var i = 1; i <= 5; i++) {
		let temp = $("input:checkbox[id='age" + i + "']");
		if (temp.is(":checked")) {
			result += temp.val() + "대 / ";
		}
	}
	for (var i = 1; i <= 5; i++) {
		let temp = $("input:checkbox[id='eye" + i + "']");
		if (temp.is(":checked")) {
			result += temp.val() + " / ";
		}
	}
	for (var i = 1; i <= 4; i++) {
		let temp = $("input:checkbox[id='nose" + i + "']");
		if (temp.is(":checked")) {
			result += temp.val() + " / ";
		}
	}
	for (var i = 1; i <= 4; i++) {
		let temp = $("input:checkbox[id='lip" + i + "']");
		if (temp.is(":checked")) {
			result += temp.val() + " / ";
		}
	}
	for (var i = 1; i <= 5; i++) {
		let temp = $("input:checkbox[id='face" + i + "']");
		if (temp.is(":checked")) {
			result += temp.val() + " / ";
		}
	}
	for (var i = 1; i <= 4; i++) {
		let temp = $("input:checkbox[id='type" + i + "']");
		if (temp.is(":checked")) {
			result += temp.val() + " / ";
		}
	}
	for (var i = 1; i <= 4; i++) {
		let temp = $("input:checkbox[id='tone" + i + "']");
		if (temp.is(":checked")) {
			result += temp.val() + " / ";
		}
	}
	for (var i = 1; i <= 4; i++) {
		let temp = $("input:checkbox[id='season" + i + "']");
		if (temp.is(":checked")) {
			result += temp.val() + " / ";
		}
	}
	for (var i = 1; i <= 5; i++) {
		let temp = $("input:checkbox[id='theme" + i + "']");
		if (temp.is(":checked")) {
			result += temp.val() + " / ";
		}
	}
	$(text).text(result);
}
$(document).ready(function() {
	var subject = $('input[type=checkbox]');
	$(subject).each(function(index, item) {
		$(item).click(test);
	});
});
function selectAll() {
	$("form[name='bttipForm']").attr("action",
			contextPath + "/blue/bttip/BeautyList.bt")
	bttipForm.submit();
}
function refresh() {
	var subject = $('input[type=checkbox]');
	var text = $("#selectFilter");
	$(text).text("");
	$(subject).each(function(index, item) {
		$(item).prop("checked", false);
	});
}
function checkbttip() {
	var check = false;
	var index = document.bttipForm;

	var gendercnt = 0;
	var agecnt = 0;
	var eyecnt = 0;
	var nosecnt = 0;
	var lipcnt = 0;
	var facecnt = 0;
	var typecnt = 0;
	var tonecnt = 0;
	var seasoncnt = 0;
	var themecnt = 0;

	for (var i = 0; i < index.gender.length; i++) {
		if (index.gender[i].checked) {
			gendercnt++;
		}
	}
	if (gendercnt == 2) {
		alert("한 항목당 1개 선택가능합니다");
		return false;
	}

	for (var i = 0; i < index.age.length; i++) {
		if (index.age[i].checked) {
			agecnt++;
		}
	}
	if (agecnt == 2) {
		alert("한 항목당 1개 선택가능합니다");
		return false;
	}

	for (var i = 0; i < index.eye.length; i++) {
		if (index.eye[i].checked) {
			eyecnt++;
		}
	}
	if (eyecnt == 2) {
		alert("한 항목당 1개 선택가능합니다");
		return false;
	}

	for (var i = 0; i < index.nose.length; i++) {
		if (index.nose[i].checked) {
			nosecnt++;
		}
	}
	if (nosecnt == 2) {
		alert("한 항목당 1개 선택가능합니다");
		return false;
	} else if (nosecnt == 1) {
		nosecnt = 0;
	}

	for (var i = 0; i < index.lip.length; i++) {
		if (index.lip[i].checked) {
			lipcnt++;
		}
	}
	if (lipcnt == 2) {
		alert("한 항목당 1개 선택가능합니다");
		return false;
	}

	for (var i = 0; i < index.face.length; i++) {
		if (index.face[i].checked) {
			facecnt++;
		}
	}
	if (facecnt == 2) {
		alert("한 항목당 1개 선택가능합니다");
		return false;
	}

	for (var i = 0; i < index.tone.length; i++) {
		if (index.tone[i].checked) {
			tonecnt++;
		}
	}
	if (tonecnt == 2) {
		alert("한 항목당 1개 선택가능합니다");
		return false;
	}

	for (var i = 0; i < index.type.length; i++) {
		if (index.type[i].checked) {
			typecnt++;
		}
	}
	if (typecnt == 2) {
		alert("한 항목당 1개 선택가능합니다");
		return false;
	}

	for (var i = 0; i < index.tone.length; i++) {
		var tonecnt = 0
		if (index.tone[i].checked) {
			tonecnt++;
		}
	}
	if (tonecnt == 2) {
		alert("한 항목당 1개 선택가능합니다");
		return false;
	}

	for (var i = 0; i < index.season.length; i++) {
		if (index.season[i].checked) {
			seasoncnt++;
		}
	}
	if (seasoncnt == 2) {
		alert("한 항목당 1개 선택가능합니다");
		return false;
	}

	for (var i = 0; i < index.theme.length; i++) {
		if (index.theme[i].checked) {
			themecnt++;
		}
	}
	if (themecnt == 2) {
		alert("한 항목당 1개 선택가능합니다");
		return false;
	}

	if (gendercnt == 0 && agecnt == 0 && eyecnt == 0 && nosecnt == 0
			&& lipcnt == 0 && facecnt == 0 && typecnt == 0 && tonecnt == 0
			&& seasoncnt == 0 && themecnt == 0) {
		alert("선택된 항목이 없습니다");
		return false;
	}

	index.submit();

}
function searchBttip() {
	$("form[name='bttipForm']").attr("action",
			contextPath + "/bttip/BeautySearch.bt")
	bttipForm.submit();
}