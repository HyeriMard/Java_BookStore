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
				<strong class="text-uppercase text-danger">Danh sách thể loại</strong>
			</h3>
			<div class="card-tools">
				<a class="btn btn-success btn-sm" href="them-the-loai" role="button">
					<i class="fas fa-plus"></i> Thêm mới
				</a>
			</div>
		</div>
		<!-- test -->
		<div class="card-body">
			<table id="example2" class="table table-bordered">
				<thead>
					<tr>
						<th class="text-center" style="width: 40px">ID</th>
						<th class="text-center" >Tên</th>
						<th class="text-center" style="width: 1000px">Miêu tả</th>


						<th class="text-center" width="200px">Tuỳ chọn</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${ cates }" varStatus="loop">
						<tr>
							<!-- ID -->
							<td class="text-center">${item.id}</td>
							<!-- Tên-->
							<td class="text-center">${item.name}</td>
							<!-- miêu tả -->
							<td class="text-center">${item.description}</td>
							<!--Chức năng-->
							<td class="text-center"><a class="btn btn-info btn-sm"
								href="sua-the-loai/${item.id}"role="button"> <i class="fas fa-edit"></i>
							</a> <a class="btn btn-danger btn-sm" href= "xoa-the-loai/${item.id} " role="button"> <i
									class="fas fa-trash-alt"></i>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>