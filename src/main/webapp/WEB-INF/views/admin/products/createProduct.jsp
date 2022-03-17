<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Thêm sản phẩm</title>
</head>
<body>
	<form:form action="them-san-pham" method="POST" modelAttribute="newPro"  enctype="multipart/form-data"  accept-charset="utf-8">
		<div class="card">
			<div class="card-header">
					<h4 class="text-danger">${status}</h4>
				<h3 class="card-title text-uppercase text-danger">
					<strong>Thêm mới</strong>
				</h3>
				<div class="card-tools">
					<button class="btn btn-success btn-sm" name="btnsubmit"
						type="submit">
						<i class="fa fa-save"></i> Lưu
					</button>
					<a class="btn btn-danger btn-sm" href="san-pham" role="button"> <i
						class="fa fa-times"></i> Trở lại
					</a>
				</div>
			</div>
			<div class="card-body">
				<div class="row form-horizontal">
					<div class="col-8">
						<div class="form-group">
							<label for="name" class="control-label">Tên sách</label>
							<form:input class="form-control" type="text"  path="name" />
							
						</div>
						<div class="form-group">
							<label for="name" class="control-label">Tiêu đề</label>
								<form:input class="form-control" type="text" path="title" />
						</div>
						<div class="form-group">
							<label for="detail" class="control-label">Review</label>
								<form:textarea rows="10" class="form-control" type="text" path="detail" />
							
						</div>
					</div>
					<div class="col-4">
						<div class="form-group">
							<label for="price" class="control-label">Giá bán</label> 	
							<form:input class="form-control" type="number" path="price" />
							
						</div>

						<div class="form-group">
							<label for="customFile" class="control-label">Hình</label>
							<div class="custom-file">
								<input type="file" id="img" name="img"
									accept=".PNG,.GIF,.JPG">
							</div>
						</div>
					
						<div class="form-group">
							<label for="IDCategory" class="control-label">Thể loại
								sách
								</label>
							<div class="col-md-10">
							<form:select path="cateID">
									<c:forEach var="item" items="${cates}" varStatus="loop" >
										<option value="${item.id}" >${item.name }</option>
									</c:forEach>
							</form:select>
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form:form>
	<script type="text/javascript">
	
	</script>
</body>

</html>