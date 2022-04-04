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
	<div class="container-fluid">
		<div class="main-body">
			<div class="col-md-12">
				<div class="card mb-3">
					<div class="card-body">
						<div class="row">
							<div class="col-sm-5">
								<div class="row">
									<div class="col-sm-8">
										<strong class="text-uppercase text-danger">Thông tin
											đơn hàng</strong>
									</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-3">
										<h5 class="mb-0">
											<strong>Mã đơn</strong>
										</h5>
									</div>
									<div class="col-sm-9 text-secondary" style="font-family: Arial">

										${bill.id}</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-3">
										<h5 class="mb-0">
											<strong>Email</strong>
										</h5>
									</div>
									<div class="col-sm-9 text-secondary" style="font-family: Arial">
										${bill.user}</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-3">
										<h5 class="mb-0">
											<strong>Tên người dùng</strong>
										</h5>
									</div>
									<div class="col-sm-9 text-secondary">${bill.display_name}</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-3">
										<h5 class="mb-0">
											<strong>Phone</strong>
										</h5>
									</div>
									<div class="col-sm-9 text-secondary">${bill.phone}</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-3">
										<h5 class="mb-0">
											<strong>Địa chỉ</strong>
										</h5>
									</div>
									<div class="col-sm-9 text-secondary">${bill.address}</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>