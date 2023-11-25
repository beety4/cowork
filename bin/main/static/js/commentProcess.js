// 댓글 불러오기
function comment(roomNo) {
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

function writeComment(myArr) {
	var add = document.createElement("div");
}