function sendKey(){
	time();
	//$("#time").css("display","block");
	$("#check").css("display","block");
    $.ajax({
    	url:"/sendmail",
        type:"post",
        dataType:"json",
        data:{"email" : $("#email").val()},
        success: function(data){
            alert("인증번호 발송");
            document.getElementById("Confirm").innerHTML(data);
            $("#Confirm").attr("value",data);
        }
	});
};
  
function checKey(){
    var number1 = $("#authKey").val();
    var number2 = $("#Confirm").val();
    console.log(number1);
    console.log("   test   ");
    console.log(number2);

    if(number1 == number2){
        alert("인증되었습니다.");
    }else{
        alert("번호가 다릅니다.");
    }
}

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
				}
			}, 1000);	
	} catch (error) {
		console.log(error);
	}
}