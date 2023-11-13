<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>


<div class="container mt-5">
    <h2 class="mb-4">게시글 상세보기</h2>

    <div class="card" style="width:600px;">
        <div class="card-header">
            작성자: 글쓴이 이름
            <div style="float:right">
            	작성일 2023-11-11
            </div>
        </div>
        <div class="card-body">
            <h5 class="card-title"><strong>제목: 게시글 제목</strong></h5>
            <p class="card-text">
                게시글 내용이 여기에 들어갑니다. 내용이 많을 경우 스크롤바가 표시됩니다.
            </p>
        </div>
    </div>
</div>




<div class="container mt-5">
    <div class="row">
        <!-- 왼쪽: 채팅 목록 -->
        <div class="col-md-4">
            <h4>채팅 목록</h4>
            <ul class="list-group">
                <li class="list-group-item">친구 1</li>
                <li class="list-group-item">친구 2</li>
                <li class="list-group-item">친구 3</li>
                <!-- 여기에 채팅 목록이 동적으로 추가될 수 있습니다. -->
            </ul>
        </div>

        <!-- 오른쪽: 채팅 내역 -->
        <div class="col-md-8">
            <h4>채팅 내역</h4>
            <div class="card">
                <div class="card-body">
                    <!-- 여기에 채팅 내역이 동적으로 추가될 수 있습니다. -->
                </div>
            </div>
        </div>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>