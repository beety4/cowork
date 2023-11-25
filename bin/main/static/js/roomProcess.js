// 윈도우 로딩 시 첫번째 room 키기
window.addEventListener('DOMContentLoaded', function() {
	getElementByXpath("//*[@id='chat-list']/ul[1]/li").onclick();
});


// 비동기 통신을 위한 함수
function showRoom(roomli, roomNo){
	var myArr = [];
	document.getElementById("input-data").style.display = 'none';
	
	// 게시판 생성, 방 생성 가리기, 이름 설정
	document.getElementById("mainroomName").innerHTML =  roomli.innerHTML;
	showDisplayRoom("defaultRoom");
	unclickdo(roomli);
	
	if(ws!=null &&  ws.readyState == 1) {
		ws.close();
	}

	nowRoomNo = roomNo;
	
    $.ajax({
    	url:"/showRoom.do",
        type:"post",
        dataType:"json",
        data:{"value" : roomNo},
        success: function(data){
			$(data).each(function() {
				var roomBoardDTO = [this.boardNo, this.roomNo, this.name, this.title, this.date, this.category, this.content.replace(/(?:\r\n|\r|\n)/g, '<br>')];
				myArr.push(roomBoardDTO);
			});
			addButton(roomNo);
			writeBoardPage(myArr, roomNo);
        },
        error: function(request, status, error) {
			alert("오류가 발생했습니다.");
			console.log("code : " + request.status);
			console.log("message : " + request.responseText);
			console.log("error : " + error);
		}
	});
};


// 보여질 CSS 공간 설정
function showDisplayRoom(ele) {
	// 채팅공간 초기화
	document.getElementById("chating").innerHTML = '';
	
	var defaultRoom = document.getElementById("defaultRoom");
	var createBoard = document.getElementById("createBoard");
	var createRoom = document.getElementById("createRoom");
	
	defaultRoom.style.display = 'none';
	createBoard.style.display = 'none';
	createRoom.style.display = 'none';
	
	if(ele == "defaultRoom") {
		defaultRoom.style.display = 'block';
	} else if(ele == "createBoard") {
		createBoard.style.display = 'block';
	} else {
		createRoom.style.display = 'block';
	}
}




// 게시판 room 클릭 시 게시판 추가 버튼 띄우기
function addButton(roomNo) {
	var add = document.createElement("button");
	add.setAttribute("onclick", "addBoard("+roomNo+");");
	add.id = "boardAdd";
	add.style = "float:right;";
	add.innerText = "+";
	document.getElementById("mainroomName").appendChild(add);
}


// 게시판 추가 폼 띄우기
function addBoard(roomNo) {
	showDisplayRoom("createBoard");
	document.getElementById("roomNo").value = roomNo;
	document.getElementById("title").value = '';
	document.getElementById("content").value = '';
}

// Room 추가 폼 띄우기
function addRoom() {
	showDisplayRoom("createRoom");
	document.getElementById("roomName").value = '';
}

// 비동기 통신 성공 후 board 처리
function writeBoardPage(myArr, roomNo) {
	for(i = 0; i<myArr.length; i++) {
		boardNo = myArr[i][0];
		var content = `
		<div class="container mt-5" id="${boardNo}" style="display: flex;">
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
        		<img id="${boardNo}-img-0" src="/img/0.png" width="20px;" onclick="like(this, ${boardNo} , 0);">
        		<div id="${boardNo}-0" style="display: inline;">0</div>
        		<img id="${boardNo}-img-1" src="/img/1.png" width="20px;" onclick="like(this, ${boardNo} , 1);">
        		<div id="${boardNo}-1" style="display: inline;">0</div>
        		<img id="${boardNo}-img-2" src="/img/2.png" width="20px;" onclick="like(this, ${boardNo} , 2);">
        		<div id="${boardNo}-2" style="display: inline;">0</div>
        		<img id="${boardNo}-img-3" src="/img/3.png" width="20px;" onclick="like(this, ${boardNo} , 3);">
        		<div id="${boardNo}-3" style="display: inline;">0</div>
        		<img id="${boardNo}-img-4" src="/img/4.png" width="20px;" onclick="like(this, ${boardNo} , 4);">
        		<div id="${boardNo}-4" style="display: inline;">0</div>
        		<img id="${boardNo}-img-5" src="/img/5.png" width="20px;" onclick="like(this, ${boardNo} , 5);">
        		<div id="${boardNo}-5" style="display: inline;">0</div>
        		
        		<button onclick="comment(this, ${boardNo});" style="float:right;">댓글</button>
        	</div>
    	</div>
		</div>
		`;
		
		$("#chating").append(content);
	}
	
	getLikeByRoomNo(roomNo);
}


// 리스트 한번만 클릭!
function clickdo() {
	// 게시판,채팅방 요소 클릭 가능 설정인데 이상한 코드임!!
	// 일단 임시로 진행하고 나중에 수정 필요
	for(var i=1; i<100; i++) {
		for(var j=1; j<100; j++) {
			try {
				var ele = getElementByXpath("//*[@id='chat-list']/ul["+i+"]/li["+j+"]");
				ele.classList.add('clickdo');
				ele.classList.remove('unclickdo');
				ele.classList.remove('active');
			}catch(e) {
				break;
			}
		}
	}
}
function unclickdo(roomli) {
	clickdo();
	roomli.classList.add('active');
	roomli.classList.add('unclickdo');
}
function getElementByXpath(path) {
  return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
}