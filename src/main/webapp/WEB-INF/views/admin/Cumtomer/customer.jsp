<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="card">
		<div class="card-header">
			<h3 class="card-title">
				<strong class="text-uppercase text-danger">Danh sách người dùng</strong>
			</h3>
			
		</div>
		<!-- test -->
		<div class="card-body">
			<table id="example2" class="table table-bordered">
				<thead>
					<tr>
						<th class="text-center" style="width: 40px">Email</th>
						<th class="text-center" >Tên người dùng</th>
						<th class="text-center" >Địa chỉ</th>


						<th class="text-center" width="200px">Chi tiết</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${ accounts }" varStatus="loop">
						<tr>
							
							<!-- Tên-->
							<td class="text-center">${item.user}</td>
							<!-- miêu tả -->
							<td class="text-center">${item.display_name}</td>
							<!--tổng tiền-->
							<td class="text-center">${item.address}</td>
							
							<!--Chức năng-->
							<td class="text-center">
								 <a class="btn btn-info btn-sm" href="chi-tiet-don/${item.id}" role="button"> <i
										class="fas fa-eye"></i>
								</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>