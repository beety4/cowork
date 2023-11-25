// RoomNo 이동 시 좋아요 가져오기
function getLikeByRoomNo(roomNo) {
	myArr = [];
	$.ajax({
    	url:"/getLikeCntALL.do",
        type:"post",
        dataType:"json",
        data:{"roomNo" : roomNo},
        success: function(data){	
			$(data).each(function() {
				var likeCntDTO = [this.boardNo, this.likeType, this.cnt, this.tf];
				myArr.push(likeCntDTO);
			});
			writeLike(myArr);
        },
        error: function(request, status, error) {
			alert("오류가 발생했습니다.");
			console.log("code : " + request.status);
			console.log("message : " + request.responseText);
			console.log("error : " + error);
		}
	});
}


// 좋아요 버튼 눌렀을 때 서버에서 작업 후 똑같이 print
function like(imgEle, boardNo, likeType){
    $.ajax({
    	url:"/likeAction.do",
        type:"post",
        dataType:"json",
        data:{"boardNo" : boardNo, "likeType" : likeType, "roomNo" : nowRoomNo},
        success: function(data){
			$(data).each(function() {
				var likeCntDTO = [this.boardNo, this.likeType, this.cnt, this.tf];
				myArr.push(likeCntDTO);
			});
			writeLike(myArr);
        },
        error: function(request, status, error) {
			alert("오류가 발생했습니다.");
			console.log("code : " + request.status);
			console.log("message : " + request.responseText);
			console.log("error : " + error);
		}
	});
};


// 게시글의 0이 아닌 좋아요 작성
function writeLike(myArr) {
	for(var i=0; i<myArr.length; i++) {
		var likeIt = document.getElementById(myArr[i][0]+"-"+myArr[i][1]);
		likeIt.innerText = myArr[i][2];
		
		// 내가 눌렀던 Type인지 TF 확인
		if(myArr[i][3] == 1) {
			likeIt.style.color = 'red';
		} else {
			likeIt.style.color = 'black';
		}
	}
}

