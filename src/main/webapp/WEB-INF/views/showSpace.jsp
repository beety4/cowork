<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%@ page import="basic.domain.room.dto.RoomDTO" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/chatRoom.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<%
	ArrayList<RoomDTO> roomList = (ArrayList<RoomDTO>)request.getAttribute("roomList");
	SpaceDTO spaceDTO = (SpaceDTO)request.getAttribute("spaceDTO");
%>
<!-- Begin Page Content -->
<div class="container-fluid">
	<script type="text/javascript" src="/js/chat.js"></script>
	<script type="text/javascript" src="/js/roomProcess.js"></script>
	<script type="text/javascript" src="/js/LikeProcess.js"></script>
	
	<!-- Page Heading -->
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800"><%=spaceDTO.getSpaceName() %></h1>
	</div>

	<!-- Content Row -->
	<div class="row">
		<div class="col-md-3">
			<!-- Chat Room List -->
			<div class="card">
				<div class="card-header">Rooms
				<button onclick="addRoom()" style="float:right;">+</button>
				</div>
				<div id="chat-list" class="card-body">
					<!-- List of chat rooms goes here -->
					<ul>
						<%
							if(roomList.size() != 0) {
								// 게시판 Room 목록 출력
								for(int i=0; i<roomList.size(); i++) {
									if(roomList.get(i).getRoomType().equals("BOARD")) {
										%>
											<li onclick="showRoom(this,<%=roomList.get(i).getRoomNo() %>)">
											<%=roomList.get(i).getRoomName() %>
											</li>
										<%
									}
								}
							%>
					</ul>
					<hr>
					<ul>
						<%
								// 채팅방 Room 목록 출력
								for(int i=0; i<roomList.size(); i++) {
									if(roomList.get(i).getRoomType().equals("CHAT")) {
										%>
											<li onclick="showRoom(this,<%=roomList.get(i).getRoomNo() %>)">
											<%=roomList.get(i).getRoomName() %>
											</li>
										<%
									}
								}
							} else {
						%>
							<li><del>NO ROOMS</del></li>
						<%
							}
						%>
					</ul>
				</div>
			</div>
		</div>
		
		
		
		
		
		<div class="col-md-9">
			<!-- Chat Area -->
			<div id="defaultRoom" class="card wResize">
				<div id="roomName" class="card-header">Chat Room 1</div>
				<div id="chat-area" class="card-body">
					<div id="chating" class="chating"></div>
				</div>
			</div>

			
			<!-- Chat Area -->
			<div id="createBoard" class="card wResize" style="display:none;">
				<div class="card-header">게시판 등록</div>
				<div id="board-area" class="card-body">
					<div id="chating" class="chating">
							<form action="/createBoard.do" method="post">
								<div class="form-group">
									<label for="title">제목</label> <input type="text"
										class="form-control" id="title" name="title" placeholder="제목을 입력하세요">
								</div>
								 
								<div class="form-group" style="display: none;">
									<input type="text" id="roomNo" name="roomNo">
									<input type="text" id="spaceNo" name="spaceNo" value="<%=spaceDTO.getSpaceNo() %>">
								</div>
								<!--
								<div class="form-group" style="display: none;">
									<label for="category">카테고리</label> <select class="form-control"
										id="category" name="category">
										<option>카테고리를 선택하세요</option>
										<option>기술</option>
										<option>일상</option>
										<option>취미</option>
									</select>
								</div>
								-->
								<div class="form-group">
									<label for="content">내용</label>
									<textarea class="form-control" id="content" name="content" rows="5"
										placeholder="내용을 입력하세요"></textarea>
								</div>
								<button type="submit" class="btn btn-primary">게시글 작성</button>
							</form>
					</div>
				</div>
			</div>
				
				
			<!-- Chat Area -->
			<div id="createRoom" class="card wResize" style="display: none;">
				<div id="roomName" class="card-header">Chat Room 1</div>
				<div id="chat-area" class="card-body">
					<div id="chating" class="chating">
						<form action="/createRoom.do" method="post">
							<div class="form-group">
								<label for="title">Room 이름</label> <input type="text"
									class="form-control" id="roomName" name="roomName"
									placeholder="Room 이름을 입력하세요">
							</div>

							<div class="form-group" style="display: none;">
								<input type="text" id="spaceNo" name="spaceNo"
									value="<%=spaceDTO.getSpaceNo()%>">
							</div>
								<div class="form-group">
									<label for="category">Room 타입</label> <select class="form-control"
										id="roomType" name="roomType">
										<option>BOARD</option>
										<option>CHAT</option>
									</select>
								</div>
							<button type="submit" class="btn btn-primary">Room 생성</button>
						</form>
					</div>
				</div>
			</div>

	</div>
</div>



<%@ include file="footer.jsp"%>