// 비동기 통신을 위한 함수
function like(imgEle, boardNo, likeType){
	var likeDTO = [];

    $.ajax({
    	url:"/likeAction.do",
        type:"post",
        dataType:"json",
        data:{"boardNo" : boardNo, "likeType" : likeType},
        success: function(data){	
			$(data).each(function() {
				var roomBoardDTO = [this.likeType, this.cnt];
				likeDTO.push(roomBoardDTO);
			});
			
			showLikeCnt(boardNo, likeDTO);
			showSelectUp(boardNo, likeType);
        },
        error: function(request, status, error) {
			alert("오류가 발생했습니다.");
			console.log("code : " + request.status);
			console.log("message : " + request.responseText);
			console.log("error : " + error);
		}
	});
};


function showLikeCnt(boardNo, likeDTO) {
	for(i =0; i<6; i++) {
		var cntEle = document.getElementById(boardNo + "-" + likeDTO[i][0]);
		cntEle.innerText = likeDTO[i][1];
	}

}

function showSelectUp(boardNo, likeType) {
	showSelectDown(boardNo);
	var what = document.getElementById(boardNo+"-"+likeType);
	what.className = 'selectUp';
}
function showSelectDown(boardNo) {
	for(i=0; i<6; i++) {
		var where = document.getElementById(boardNo+"-"+i);
		where.className = '';
	}
}
