<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>


<!-- Begin Page Content -->
<div class="container-fluid">
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">Create Space</h1>
	</div><br>

	<!-- Content Row -->
	<div class="row d-flex justify-content-center">
	
	
		<form action="createSpace" method="post" name="createSpace" enctype="multipart/form-data">
			<table class="table" style="text-align: center; border: 1px solid #dddddd;">
				<thead>
					<tr>
						<th colspan="2" style="background-color: #eeeeee; text-align: center;">새 공간 만들기</th>
					</tr>
				<tbody>
					<tr>
						<td><input type="text" placeholder="Space 이름" name="spaceName"
							id="spaceName" maxlength="100" style="width: 920px;"></td>
					</tr>
					<tr>
						<td><a style="float: left;">Space 이미지 : &nbsp;</a> <input
							type="file" name="file" id="file" style="float: left;"></td>
					</tr>
				</tbody>
			</table>
			<button onclick="createSpace();" style="float: right;">생성</button>
		</form>



	</div>
</div>


<%@ include file="footer.jsp"%>