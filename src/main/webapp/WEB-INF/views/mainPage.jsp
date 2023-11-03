<%@ include file="header.jsp"%>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
/* Style for chat list and chat area */
#chat-list, #chat-area {
	height: 468px; /* You can adjust the height as needed */
	border: 1px solid #ccc;
	overflow-y: auto;
	/* Enable scrollbar only when content exceeds the container height */
}
</style>

<!-- Begin Page Content -->
<div class="container-fluid">
	<script type="text/javascript" src="/js/chat.js"></script>
	<!-- Page Heading -->
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">ChatRoom</h1>
	</div>

	<!-- Content Row -->
	<div class="row">
		<div class="col-md-3">
			<!-- Chat Room List -->
			<div class="card">
				<div class="card-header">Chat Rooms</div>
				<div id="chat-list" class="card-body">
					<!-- List of chat rooms goes here -->
					<ul>
						<li>Chat Room 1</li>
						<li>Chat Room 2</li>
						<li>Chat Room 3</li>
						<!-- Add more chat rooms as needed -->
					</ul>
				</div>
			</div>
		</div>
		<div class="col-md-9">
			<!-- Chat Area -->
			<div class="card">
				<div class="card-header">Chat Room 1</div>
				<div id="chat-area" class="card-body">
					<div id="chating" class="chating"></div>
					<!-- Chat messages go here 
					<div class="message">
						<strong>User 1:</strong> Hello!
					</div>
					<div class="message">
						<strong>User 2:</strong> Hi there!
					</div>
					 More chat messages go here -->
					
				</div>
			</div>
			<div id="yourMsg">
			<table class="inputTable">
				<tr>
					<th>msg : </th>
					<th><input id="chatting" placeholder="text"></th>
					<th><button onclick="send()" id="sendBtn">send</button></th>
				</tr>
			</table>
		</div>
		</div>
	</div>
</div>



<%@ include file="footer.jsp"%>