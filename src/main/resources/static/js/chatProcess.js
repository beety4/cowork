// 비동기 통신을 위한 함수
function showChatRoom(roomli, roomNo){
	var myArr = [];
	var lType = [];
	document.getElementById("roomName").innerHTML =  roomli.innerHTML;
	document.getElementById("defaultRoom").style.display = 'block';
	document.getElementById("createBoard").style.display = 'none';
	document.getElementById("createRoom").style.display = 'none';
	
	document.getElementById("chating").innerHTML = '';
	unclickdo(roomli);
	
    $.ajax({
    	url:"/showChatRoom.do",
        type:"post",
        dataType:"json",
        data:{"roomNo" : roomNo},
        success: function(data){
			$(data).each(function() {
				var roomBoardDTO = [this.boardNo, this.roomNo, this.name, this.title, this.date, this.category, this.content];
				//var likeTypeDTO = [this.likeTypeDTO.likeType, this.likeType.DTO.cnt];
				myArr.push(roomBoardDTO);
				//lType.push(likeTypeDTO);
			});
			addButton(roomNo);
			writeBoardPage(myArr, lType);
        },
        error: function(request, status, error) {
			alert("오류가 발생했습니다.");
			console.log("code : " + request.status);
			console.log("message : " + request.responseText);
			console.log("error : " + error);
		}
	});
};