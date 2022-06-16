	var check = false;

	function formSubmit() {
		var form = document.joinForm;
		if ('' == form.userid.value || !check) {
			alert('아이디를 확인해주세요.');
			form.userid.focus();
			return false;

		} else if ('' == form.userpw.value) {
			alert('비밀번호를 입력해주세요.');
			form.userpw.focus()
			return false;

		} else if ('' == form.username.value) {
			alert('닉네임을 입력해주세요.');
			form.username.focus();
			return false;

		} else if ('' == form.useremail.value) {
			alert('이메일를 입력해주세요.');
			form.useremail.focus();
			return false;
		}

		form.submit();
	}
	
	function checkid(userid){
		check = false;
		if(userid == ""){
			$("#idCheck_text").text("아이디를 작성해주세요.");
		}else{
			$.ajax({
				url: contextPath + "/join/MemberCheckIdOk.me?userid="+userid,
				type: 'get',
				dataType: 'text',
				success: function(data){
					if(data.trim() == 'ok'){
						$("#idCheck_text").text("사용할 수 있는 아이디입니다.");
						check= true;
					}else{
						$("#idCheck_text").text("중복된 아이디입니다.");
					}
				},
				error: function(){
					console.log("오류");
				}
			})
		}
	}
	
	$("input[name='userid']").keyup(function(event){
		var id = $("input[name='userid']").val();
		checkid(id);
	})
	
