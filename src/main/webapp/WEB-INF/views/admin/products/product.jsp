<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý sản phẩm</title>
</head>
<body>

	<div class="card">
		<div class="card-header">
			<h3 class="card-title">
				<strong class="text-uppercase text-danger">Danh sách sản phẩm</strong>
			</h3>
			<div class="card-tools">
				<a class="btn btn-success btn-sm" href="them-san-pham" role="button">
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
						<th width="100px">Ảnh</th>
						<th class="text-center">Tên</th>
						<th class="text-center">Tiêu đề</th>
						<th class="text-center">Thể loại</th>
						<th class="text-center">Giá</th>
						
						<th class="text-center" width="200px">Tuỳ chọn</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${ highlight }" varStatus="loop">
						<tr>
							<!-- ID -->
							<td class="text-center">${item.id}</td>
							<!-- Hình-->
							<td class="text-center"><img class="img"
								src="<c:url value="/assets/user/img/products/${ item.picture }"/>"
								alt="img_product" width="80"></td>
							<!-- Tên-->
							<td class="text-center">${item.name}</td>
							<!-- Tieu de -->
							<td class="text-center">${item.title}</td>
							<!-- Thể loai-->
							<td class="text-center">
								<c:forEach var="cate" items="${ cates }" varStatus="loop">
									<c:if test="${cate.id ==item.cateID}">
											${cate.name}
									</c:if>
									
								</c:forEach>
							</td>
							<!--Giá-->
							<td class="text-center"><fmt:formatNumber type="number" groupingUsed="true" value="${item.price}" /> ₫</td>
							<!--Chức năng-->
							<td class="text-center">
								<a class="btn btn-info btn-sm"  href="sua-san-pham/${item.id}" role="button">
								 	<i class="fas fa-edit"></i>
								</a> 
								<a class="btn btn-danger btn-sm" href="comfirm-xoa-san-pham/${item.id}" role="button"> 
								<i class="fas fa-trash-alt"></i>
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