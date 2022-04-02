<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Thêm thể loại</title>
</head>
<body>
	<div class="col-8">
		<form:form action="them-the-loai" method="POST"  modelAttribute="newCate" accept-charset="utf-8">
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
					<a class="btn btn-danger btn-sm" href="the-loai" role="button"> <i
						class="fa fa-times"></i> Trở lại
					</a>
				</div>
			</div>
			<div class="card-body">
				<div class="row form-horizontal">
					<div class="col-12">
						<div class="form-group">
							<label for="name" class="control-label">Tên thể loại</label>
								<form:input class="form-control" type="text" path="name" />
							
						</div>
						
						<div class="form-group">
							<label for="detail" class="control-label">miêu tả</label>
								<form:textarea rows="10" class="form-control" type="text" path="description" />
							
						</div>
					</div>
					
				</div>
			</div>
		</div>
	</form:form>
	
	</div>
	
</body>

</html>