var ws;
var userName = "";
var chatContainer = document.getElementById("chat-area");

window.addEventListener('DOMContentLoaded', function() {
	userName = $("#name").text();
	wsOpen();
});

function wsOpen() {
	//ws = new WebSocket("ws://" + location.host + "/ws/chat");
	ws = new WebSocket("ws://localhost:8080/ws/chat");
	wsEvt();
}

function wsEvt() {	
	ws.onopen = function(data) {
		//소켓이 열리면 초기화 세팅하기
	}

	ws.onmessage = function(data) {
		var msg = data.data;
		if (msg != null && msg.trim() != '') {
			
			$("#chating").append("<p>" + msg + "</p>");
			chatContainer.scrollTop = chatContainer.scrollHeight;
		}
	}

	document.addEventListener("keypress", function(e) {
		if (e.keyCode == 13) { // ENTER KEY
			send();
		}
	});
}

function send() {
	var msg = $("#chatting").val();
	ws.send(userName + " : " + msg);
	$('#chatting').val("");
}