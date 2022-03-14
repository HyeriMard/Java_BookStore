<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DeleteProduct</title>
</head>
<body>

	<div class="container-fluid">
	<h4>${status}</h4>
		<div class="main-body">
			<div class="row">
				<div class="col-md-8">
					<div class="card mb-3">
						<div class="card-body">
							<div class="row">
								<div class="col-sm-12">
									<div class="row">
										<div class="col-sm-8">
											<strong class="text-uppercase text-danger">Thông tin</strong>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-3">
											<h5 class="mb-0">
												<strong>Tên</strong>
											</h5>
										</div>
										<div class="col-sm-9 text-secondary">${ product.name }</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-3">
											<h5 class="mb-0">
												<strong>Tiêu đề</strong>
											</h5>
										</div>
										<div class="col-sm-9 text-secondary">${ product.title }
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-3">
											<h5 class="mb-0">
												<strong>Thể loại</strong>
											</h5>
										</div>
										<div class="col-sm-9 text-secondary">${ cate.name }
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-3">
											<h5 class="mb-0">
												<strong>Mô tả</strong>
											</h5>
										</div>
										<div class="col-sm-9 text-secondary">${ product.detail }
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-3">
											<h5 class="mb-0">
												<strong>Giá</strong>
											</h5>
										</div>
										<div class="col-sm-9 text-secondary">${ product.price }
										</div>
									</div>
									<hr>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<img class="img"
								src="/WebShop/assets/user/img/products/${ product.picture }"
								alt="img_product" width="300">
				
					
				</div>
			</div>
			
			<form action="/WebShop/admin/xoa-san-pham/${product.id}" method="POST">
				<div class="form-actions no-color">
					<div class="row">
						<div class="container-fluid">
							<div class="col-md-12">
								<h4>
									<strong class="text-danger">Bạn có chắc muốn xóa, thao
										tác này không thể khôi phục!</strong>
								</h4>
							</div>
							<div class="col-md-6">
								<input type="submit" name="btnsubmit" value="Xóa"
									class="btn btn-lg btn-danger text-right" />

							</div>
						</div>
					</div>

				</div>
			</form>
		</div>
	</div>
</body>
</html>