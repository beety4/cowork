// 댓글 불러오기
function comment(btnEle, boardNo) {
	btnEle.disabled = true;
	myArr = [];
	$.ajax({
    	url:"/getComment.do",
        type:"post",
        dataType:"json",
        data:{"boardNo" : boardNo},
        success: function(data){	
			$(data).each(function() {
				var commentDTO = [this.commentNo, this.boardNo, this.name, this.content.replace(/(?:\r\n|\r|\n)/g, '<br>')];
				myArr.push(commentDTO);
			});
			writeComment(myArr, boardNo);
        },
        error: function(request, status, error) {
			alert("오류가 발생했습니다.");
			console.log("code : " + request.status);
			console.log("message : " + request.responseText);
			console.log("error : " + error);
		}
	});
}

// 댓글 작성 write 함수
function writeComment(myArr, boardNo) {
	var commentView = document.createElement("div");
	commentView.setAttribute("style", "margin-left: 10px;");
	commentView.innerHTML = `
		<div class='card' style='width: 300px;'>
			<div class='card-header'>
				댓글
			</div>
			<div class='card-body comment-area' id='commentContent-${boardNo}'>
			</div>
			<div class='card-footer'>
				<input type='text' id='commentInput-${boardNo}' placeholder='댓글 입력'>
				<input type='button' onclick='sendComment(${boardNo});' value='작성'>
			</div>
		</div>
	`
	document.getElementById(boardNo).appendChild(commentView);
	writeDetailComment(myArr, boardNo);
}



// 댓글 세부 작성
function writeDetailComment(myArr, boardNo) {
	for(var i=0; i<myArr.length; i++) {
		var content = `<div><strong>${myArr[i][2]}</strong> : ${myArr[i][3]}</div>`;
		document.getElementById("commentContent-"+boardNo).insertAdjacentHTML('beforeend', content);
	}
}



// 댓글 작성
function sendComment(boardNo) {
	myArr = [];
	var content = document.getElementById("commentInput-"+boardNo);
	if(content.value == '') {
		alert('댓글 내용을 작성해 주세요!');
		return;
	}

	$.ajax({
    	url:"/addComment.do",
        type:"post",
        dataType:"json",
        data:{"boardNo" : boardNo, "content" : content.value},
        success: function(data){
			document.getElementById("commentContent-"+boardNo).innerText= '';
			$(data).each(function() {
				var commentDTO = [this.commentNo, this.boardNo, this.name, this.content.replace(/(?:\r\n|\r|\n)/g, '<br>')];
				myArr.push(commentDTO);
			});
			writeDetailComment(myArr, boardNo);
			content.value = '';
        },
        error: function(request, status, error) {
			alert("오류가 발생했습니다.");
			console.log("code : " + request.status);
			console.log("message : " + request.responseText);
			console.log("error : " + error);
		}
	});
}

