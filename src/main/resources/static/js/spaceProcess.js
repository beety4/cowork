// 초대 요청 비동기 통신
function inviteSpace(spaceNo) {
	var userName = document.getElementById("inviteName");
	if(userName.value == '') {
		alert('이름을 입력해 주세요!');
		return;
	}
	
	$.ajax({
    	url:"/inviteSpace.do",
        type:"post",
        dataType:"json",
        data:{"spaceNo" : spaceNo, "name" : userName.value},
        success: function(data){
			userName.value = '';
			if(data == 1) {
				alert('초대요청이 전송되었습니다!');
			} else if(data == 2){
				alert('이미 추가된 사용자 입니다!.');
			} else if(data == 3) {
				alert('존재하지 않는 사용자 입니다!');
			} else {
				alert('초대요청을 기다리는 사용자 입니다!');
			}
        },
        error: function(request, status, error) {
			alert("오류가 발생했습니다.");
			console.log("code : " + request.status);
			console.log("message : " + request.responseText);
			console.log("error : " + error);
		}
	});
}


// 초대 요청 수락
function inviteAccept(spaceNo) {
	if(!window.confirm("해당 Space 요청을 수락하시겠습니까?")) {
		return;
	}
	
	$.ajax({
    	url:"/inviteAccept.do",
        type:"post",
        dataType:"json",
        data:{"spaceNo" : spaceNo},
        success: function(data){
			if(data == 1) {
				alert('이미 가입된 space 입니다.');
			} else {
				alert('초대요청이 수락되었습니다.');
				window.location.replace("/showSpace.do?spaceNo=" + spaceNo);
			}
        },
        error: function(request, status, error) {
			alert("오류가 발생했습니다.");
			console.log("code : " + request.status);
			console.log("message : " + request.responseText);
			console.log("error : " + error);
		}
	});
}


// 초대 요청 거부
function inviteReject(spaceNo) {
	if(!window.confirm("해당 Space 요청을 거절하시겠습니까?")) {
		return;
	}
	
	$.ajax({
    	url:"/inviteReject.do",
        type:"post",
        dataType:"json",
        data:{"spaceNo" : spaceNo},
        success: function(data){
			alert('초대를 거부하셨습니다.');
			location.reload();
        },
        error: function(request, status, error) {
			alert("오류가 발생했습니다.");
			console.log("code : " + request.status);
			console.log("message : " + request.responseText);
			console.log("error : " + error);
		}
	});
}