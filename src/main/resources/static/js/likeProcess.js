// 비동기 통신을 위한 함수
function like(imgEle, boardNo, likeType){
	var likeDTO = [];

    $.ajax({
    	url:"/likeAction.do",
        type:"post",
        dataType:"json",
        data:{"boardNo" : boardNo, "likeType" : likeType},
        success: function(data){
			console.log(data);
			$(data).each(function() {
				likeDTO.push(this);
			});
			console.log(likeDTO);
        },
        error: function(request, status, error) {
			alert("오류가 발생했습니다.");
			console.log("code : " + request.status);
			console.log("message : " + request.responseText);
			console.log("error : " + error);
		}
	});
};
