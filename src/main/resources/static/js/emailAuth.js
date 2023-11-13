var timeattack = 0;
var keycheck = 0;

// 이메일 전송 함수
function sendKey(){
	time();
	$("#check").css("display","block");
    $.ajax({
    	url:"/sendmail",
        type:"post",
        dataType:"text",
        data:{"email" : $("#email").val()},
        success: function(data){
            $('#getAuthKey').text(data);
        },
        error: function(request, status, error) {
			console.log("code : " + request.status);
			console.log("message : " + request.responseText);
			console.log("error : " + error);
		}
        
	});
};
  
// 인증 키 확인 -- 수정필요!!!
// html 코드상에 display none으로 할 시 
// 인증번호 그냥 털림 -> DB사용 or 다른방법 사용해야함~
function checKey(){
    var num1 = $("#authKey").val();
    var num2 = $("#getAuthKey").text();

	if(timeattack == 1) {
		alert("시간이 초과되었습니다!");
		return;
	}

    if(num1 == num2){
        alert("인증되었습니다.");
        keycheck = 1;
    }else{
        alert("번호가 다릅니다.");
    }
}

// 지정한 시간 타이머
function time() {
	var time = 180;	// 3분 -> 180초
	var min = "";
	var sec = "";
	try {
        var what = document.getElementById("time");
        what.style.display = 'block';
          
        	var x = setInterval(function() {
				min = parseInt(time/60);
				sec = time%60;
				   
				document.getElementById("time").innerHTML = min + "분" + sec + "초";
				time--;
				   
				if(time<0) {
					clearInterval(x);
					document.getElementById("time").innerHTML = "시간초과";
					document.getElementById("getAuthKey").innerHTML = "OUT8OUT2OUT";
					timeattack = 1;
					keycheck = 0;
				}
			}, 1000);	
	} catch (error) {
		console.log(error);
	}
}