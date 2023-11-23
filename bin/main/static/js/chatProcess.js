// 기본 전역 변수
var ws;
var userName = "";
var chatContainer = document.getElementById("chat-area");
var nowRoomNo = 0;
ws = new WebSocket("ws://localhost:8080/ws/chat");

// userName 설정
window.addEventListener('DOMContentLoaded', function() {
	userName = $("#name").text();
});


// 비동기 통신을 위한 함수
function showChatRoom(roomli, roomNo){
	nowRoomNo = roomNo;
	var myArr = [];
	document.getElementById("roomName").innerHTML =  roomli.innerHTML;
	showDisplayRoom("defaultRoom");
	
	// 화면 초기화 및 ul 선택
	document.getElementById("chating").innerHTML = '';
	unclickdo(roomli);
	
	// 웹 소켓 오픈
	ws = new WebSocket("ws://localhost:8080/ws/chat");
	wsEvt();
	
    $.ajax({
    	url:"/ws/showChat.do",
        type:"post",
        dataType:"json",
        data:{"roomNo" : roomNo},
        success: function(data){
			$(data).each(function() {
				var chatDTO = [this.chatNo, this.roomNo, this.name, this.message, this.time, this.messageType];
				myArr.push(chatDTO);
			});
			writeChatPage(myArr);
        },
        error: function(request, status, error) {
			alert("오류가 발생했습니다.");
			console.log("code : " + request.status);
			console.log("message : " + request.responseText);
			console.log("error : " + error);
		}
	});
};


function writeChatPage(myArr) {
	for(i = 0; i<myArr.length; i++) {
		var contentMe = `<div class='chatmsg sent'>${myArr[i][4].split(" ")[1].trim() }&nbsp;<div>${myArr[i][3]}</div></div>`;
		var content = `<div class='chatmsg received'>${myArr[i][2] }<br><div>${myArr[i][3]}</div>&nbsp;${myArr[i][4].split(" ")[1].trim() }</div>`;
		
		if(myArr[i][2] == userName) {
			$("#chating").append(contentMe);
		} else {
			$("#chating").append(content);
		}
		
	}	
}



// 전송 시 DB 저장을 위한 비동기 처리
function saveChat(){
	var roomNo = nowRoomNo;
	var msg = document.getElementById("message").value;
	var messageType = "ENTER";
    $.ajax({
    	url:"/ws/saveChat.do",
        type:"post",
        dataType:"json",
        data:{"roomNo" : roomNo,
        	  "name" : userName,
        	  "message" : msg,
        	  "messageType" : messageType 
        },
        success: function(data){
			if(data != 1) {
				alert('메세지 저장에 실패하였습니다!');
				return;
			} else {
				document.getElementById("message").value = '';
			}
        },
        error: function(request, status, error) {
			alert("오류가 발생했습니다.");
			console.log("code : " + request.status);
			console.log("message : " + request.responseText);
			console.log("error : " + error);
		}
	});
};





function wsEvt() {	
	ws.onopen = function(data) {
		//소켓이 열리면 초기화 세팅하기
		console.log("WS : OPEN!!");
	}

	ws.onmessage = function(data) {
		var getData = data.data;
		console.log(getData);
		var jsonObject = JSON.parse(getData);
		var msg = jsonObject.message;
		
		
		if (msg != null && msg.trim() != '') {
			let match = msg.match(/:(.*)/);
			let onlyMSG = match ? match[1].trim() : null;
			if(jsonObject.name == userName) {
				$("#chating").append("<div class='chatmsg sent'>" + now().split(" ")[1].trim() + "&nbsp;<div>" + onlyMSG + "</div></div>");
			} else {
				$("#chating").append("<div class='chatmsg received'>" + jsonObject.name + "<br><div>" + onlyMSG + "</div>&nbsp;" + now().split(" ")[1].trim() + "</div>");
			}
			chatContainer.scrollTop = chatContainer.scrollHeight;
		}
	}
	
	ws.onclose = function(data) {
		console.log("Ws : CLose!!");
	};
	

	document.addEventListener("keypress", function(e) {
		if (e.keyCode == 13) { // ENTER KEY
			var msg = document.getElementById("message").value;
			if(msg.trim() == '' && msg == null) {
				return;
			}
			send();
		}
	});
}


function now() {
	let today = new Date();
	let year = today.getFullYear();
	let month = today.getMonth() + 1;
	let day = today.getDate();
	
	let hour = today.getHours();
	let minute = today.getMinutes();
	let second = today.getSeconds();
	
	let fullNow = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
	return fullNow;
}


function send() {
	ws.send(makeData());
	saveChat();
}


function makeData() {
	var msg = document.getElementById("message").value;
	var message = userName + " : " + msg;
	var roomNo = nowRoomNo;
	
	const dataResult = { "roomNo" : roomNo,
						 "name" : userName,
						 "message" : message,
						 "time" : now(),
						 "messageType" : "ENTER"
	};
	
	var testda = JSON.stringify(dataResult);
	return testda;
}




