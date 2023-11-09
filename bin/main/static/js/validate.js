// Register value Check

function registercheck() {
    var id = document.getElementById("id");
    var name = document.getElementById("name");
    var pw = document.getElementById("password");
    var pwc = document.getElementById("passwordchk");
    var birth = document.getElementById("birth");
    var gender = document.getElementsByName("gender");
    var email = document.getElementById("email");


    if (id.value == "") {
        alert("아이디를 입력하세요");
        id.focus();
        return false;
    };

    if (name.value == "") {
        alert("이름을 입력하세요");
        name.focus();
        return false;
    };

    if (pw.value == "") {
        alert("비밀번호를 입력하세요");
        pw.focus();
        return false;
    };

    var pwform = /^(?=.*[a-zA-Z])(?=.*[0-9]).{6,15}$/;
    if (!pwform.test(pw.value)) {
        alert("영문자+숫자 조합으로 6~15자리 사용해야 합니다");
        pw.focus();
        return false;
    };

    if (pwc.value !== pw.value) {
        alert("비밀번호가 일치하지 않습니다!");
        pw.focus();
        return false;
    };
	
	if (gender.value == "") {
		alert("성별을 입력하세요");
		return false;
	}

	if (email.value == "") {
		alert("이메일을 입력하세요");
		email.focus();
		return false;
	}

	var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
    if (!exptext.test(email.value)) {
        alert("올바른 형식의 이메일이 아닙니다");
        email.focus();
        return false;
    };
    
    if (birth.value == "") {
		alert("생년월일을 입력해주세요");
		birth.focus();
		return false;
	}
	
	if (keycheck == 0) {
		alert("이메일 인증을 완료해주세요");
		return false;
	}

    document.register.submit();   
}


function createSpace() {
	var spaceName = document.getElementById("spaceName");
	if (spaceName == "") {
		alert("이름을 입력해 주세요!");
		return false;
	}
	document.createSpace.submit();
}