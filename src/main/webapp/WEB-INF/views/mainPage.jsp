<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="basic.domain.space.dto.SpaceDTO" %>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/chatRoom.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


<style>
	th, td {
		text-align : center;
		vertical-align : buttom;
	}
</style>

<script type="text/javascript" src="/js/spaceProcess.js"></script>

<!-- Begin Page Content -->
<div class="container-fluid" style="align:center; width:70%;">
	<script type="text/javascript" src="/js/chat.js"></script>
	<!-- Page Heading -->
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800"></h1>
	</div>

	<div style="text-align: center;">
	<img src="/assets/logo.png" width="600px;">
	<h2>자유롭게 대화하고 정보를 나누세요</h2>
	<br><br><br><br><br><br>
	</div>



	<%
		ArrayList<SpaceDTO> inviteList = (ArrayList<SpaceDTO>)request.getAttribute("inviteList");
	%>


	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">이미지</th>
				<th scope="col">SpaceName</th>
				<th scope="col">소유자</th>
				<th scope="col">수락/거절</th>
			</tr>
		</thead>
		<tbody>
			<%
				if(inviteList.size() != 0) {
					for(int i=0; i<inviteList.size(); i++) {
						%>
						<tr style="height: 100px;">
							<th scope="row">
								<img src="/space/<%=inviteList.get(i).getSpaceImg() %>" width="150px;">
							</th>
							<td><%=inviteList.get(i).getSpaceName() %></td>
							<td><%=inviteList.get(i).getOwner() %></td>
							<td>
								<input type="button" class="btn btn-success" onclick="inviteAccept(<%=inviteList.get(i).getSpaceNo() %>);" value="수락">
								<input type="button" class="btn btn-danger" onclick="inviteReject(<%=inviteList.get(i).getSpaceNo() %>);" value="거절">
							</td>
						</tr>
					<%
					}
				} else {
			%>
				<tr>
					<td colspan="4"><del>새로운 Space 초대 내역이 없습니다.</del></td>
				</tr>
			<%
				}
			%>
		</tbody>
	</table>


</div>



<%@ include file="footer.jsp"%>