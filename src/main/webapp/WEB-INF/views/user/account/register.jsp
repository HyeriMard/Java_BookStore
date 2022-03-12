<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<title>Đăng ký</title>
<body>
	<div class="row">
		<div class="span12">
			<ul class="breadcrumb">
				<li><a href="/trang-chu">Trang chủ</a> <span class="divider">/</span></li>
				<li class="active">Tài khoản</li>
			</ul>
			<h3>Tài khoản</h3>
			<hr class="soft" />
			<div class="row">
				<div class="span4">
					<div class="well">
						<h5>Đăng ký</h5>
						<br /> Nhập địa chỉ email<br /> <br />
						<form:form action="dang-ky" method="POST" modelAttribute="user">
							<div class="control-group">
								<label class="control-label" for="inputEmail">E-mail</label>
								<div class="controls">
									<form:input class="span3" type="email" placeholder="Nhập email"
										path="user" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">Mật khẩu</label>
								<div class="controls">
									<form:input class="span3" type="password"
										placeholder="Nhập mật khẩu" path="password" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">Họ và tên</label>
								<div class="controls">
									<form:input class="span3" type="text"
										placeholder="Nhập họ và tên" path="display_name" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">Địa chỉ</label>
								<div class="controls">
									<form:input class="span3" type="text"
										placeholder="Nhập địa chỉ" path="address" />
								</div>
							</div>
							<div class="controls">
								<button type="submit" class="btn block">Đăng ký</button>
							</div>
						</form:form>
					</div>
				</div>
				<div class="span1">&nbsp;</div>
				<div class="span4">
					<div class="well">
						<h5>Đăng nhập</h5>
						<form:form action="dang-nhap" method="POST" modelAttribute="user">
							<div class="control-group">
								<label class="control-label" for="inputEmail">Tài khoản</label>
								<div class="controls">
									<form:input class="span3" type="email" placeholder="Nhập email"
										path="user" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputPassword">Mật
									khẩu</label>
								<div class="controls">
									<form:input class="span3" type="password"
										placeholder="Nhập mật khẩu" path="password" />
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<button type="submit" class="defaultBtn" style="border-radius: 15px">Đăng nhập</button>
									<a href="#">Quên mật khẩu</a>
								</div>
							</div>
							<c:if test="${ statusLogin }">
								<h4> ${ statusLogin } </h4>
							</c:if>
						</form:form>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>