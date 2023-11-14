// 윈도우 로딩 시 첫번째 room 키기
window.addEventListener('DOMContentLoaded', function() {
	getElementByXpath("//*[@id='chat-list']/ul[1]/li").onclick();
});


// 비동기 통신을 위한 함수
function showRoom(roomli, roomNo){
	var myArr = [];
	document.getElementById("roomName").innerHTML =  roomli.innerHTML;
	document.getElementById("defaultRoom").style.display = 'block';
	document.getElementById("createBoard").style.display = 'none';
	document.getElementById("createRoom").style.display = 'none';
	
	document.getElementById("chating").innerHTML = '';
	unclickdo(roomli);
	
    $.ajax({
    	url:"/showRoom.do",
        type:"post",
        dataType:"json",
        data:{"value" : roomNo},
        success: function(data){
			$(data).each(function() {
				var roomBoardDTO = [this.boardNo, this.roomNo, this.name, this.title, this.date, this.category, this.content];
				myArr.push(roomBoardDTO);
			});
			addButton(roomNo);
			writeBoardPage(myArr);
        },
        error: function(request, status, error) {
			alert("오류가 발생했습니다.");
			console.log("code : " + request.status);
			console.log("message : " + request.responseText);
			console.log("error : " + error);
		}
	});
};


// 게시판 room 클릭 시 게시판 추가 버튼 띄우기
function addButton(roomNo) {
	var add = document.createElement("button");
	add.setAttribute("onclick", "addBoard("+roomNo+");");
	add.id = "boardAdd";
	add.style = "float:right;";
	add.innerText = "+";
	document.getElementById("roomName").appendChild(add);
}


// 게시판 추가 폼 띄우기
function addBoard(roomNo) {
	document.getElementById("defaultRoom").style.display = 'none';
	document.getElementById("createBoard").style.display = 'block';
	document.getElementById("roomNo").value = roomNo;
	clickdo();
}

// Room 추가 폼 띄우기
function addRoom() {
	document.getElementById("defaultRoom").style.display = 'none';
	document.getElementById("createBoard").style.display = 'none';
	document.getElementById("createRoom").style.display = 'block';
	clickdo();
}

// 비동기 통신 성공 후 board 처리
function writeBoardPage(myArr) {
	for(i = 0; i<myArr.length; i++) {
		var content = `
		<div class="container mt-5" id="${myArr[i][0]}">
    	<div class="card" style="width:600px;">
        	<div class="card-header">
            	작성자: ${myArr[i][2]}
            	<div style="float:right">
            		작성일 ${myArr[i][4]}
           		</div>
        	</div>
        	<div class="card-body">
            	<h5 class="card-title"><strong>제목: ${myArr[i][3]}</strong></h5>
            	<p class="card-text">
                	${myArr[i][6]}
            	</p>
        	</div>
        	<div class="card-footer">
        		<img src="/img/good.png" width="20px;" onclick="like(this, ${myArr[i][0]} , 0);"><div id="howmuch"></div>
        	</div>
    	</div>
		</div>
		`;
		
		$("#chating").append(content);
	}
}

// 비동기 통신 성공 후 chat 처리
function writeChatPage(myArr) {
	
	
	
}


// 리스트 한번만 클릭!
function clickdo() {
	for(var i=1; i<10; i++) {
		for(var j=1; j<10; j++) {
			try {
				var ele = getElementByXpath("//*[@id='chat-list']/ul["+i+"]/li["+j+"]");
				ele.className = 'clickdo';
			}catch(e) {
				break;
			}
		}
	}
}
function unclickdo(roomli) {
	clickdo();
	roomli.className = 'unclickdo';
}
function getElementByXpath(path) {
  return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
}