window.addEventListener('DOMContentLoaded', function() {
	err = document.getElementById("err").innerText;
	
	if(err == "null") {
		return;
	}
	
	switch(err) {
		case "101":
			alert("아이디 또는 비밀번호가 맞지 않습니다.");
			location.href="/sign/sign-in.do";
			return;
		case "102":
			alert("내부 시스템 에러");
			location.href="/sign/sign-in.do";
			return;
		case "103":
			alert("존재하지 않는 계정입니다.");
			location.href="/sign/sign-in.do";
			return;
		case "104":
			alert("인증 요청이 거부되었습니다.");
			location.href="/sign/sign-in.do";
			return;
		case "105":
			alert("알 수 없는 에러 입니다.");
			location.href="/sign/sign-in.do";
			return;
		case "121":
			alert("회원가입에 실패하였습니다!");
			location.href="/sign/sign-in.do";
			return;
		default:
			return;
	}
});