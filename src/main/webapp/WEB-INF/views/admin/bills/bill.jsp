<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hóa đơn</title>
</head>
<body>
<div class="card">
		<div class="card-header">
			<h3 class="card-title">
				<strong class="text-uppercase text-danger">Danh sách thể loại</strong>
			</h3>
			
		</div>
		<!-- test -->
		<div class="card-body">
			<table id="example2" class="table table-bordered">
				<thead>
					<tr>
						<th class="text-center" style="width: 40px">ID</th>
						<th class="text-center" >Email</th>
						<th class="text-center" >Phone</th>
						<th class="text-center" >Tổng tiền</th>


						<th class="text-center" width="200px">Tuỳ chọn</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${ bills }" varStatus="loop">
						<tr>
							<!-- ID -->
							<td class="text-center">${item.id}</td>
							<!-- Tên-->
							<td class="text-center">${item.user}</td>
							<!-- miêu tả -->
							<td class="text-center">${item.phone}</td>
							<!--tổng tiền-->
							<td class="text-center">${item.total}</td>
							
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