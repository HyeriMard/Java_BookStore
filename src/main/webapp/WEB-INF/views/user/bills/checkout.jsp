<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<title>Thanh toán</title>
<body>
	<div class="row">
		<div class="span12">
			<ul class="breadcrumb">
				<li><a href="/WebShop/trang-chu">Trang chủ</a> <span class="divider">/</span></li>
				<li><a href="/WebShop/trang-chu/gio-hang">Giỏ hàng</a> <span class="divider">/</span></li>
				<li class="active">Thanh toán</li>
			</ul>
			<div class="row">
				<div class="span12">
					<div class="well">
					 <form:form action="checkout" method="POST" modelAttribute="bills" class="form-horizontal">
							<h3>Thanh toán đơn hàng</h3>
							<div class="control-group">
								<label class="control-label"> Họ tên <sup>*</sup></label>
								<div class="controls">
									<form:input class="span3" type="text"
										placeholder="Nhập họ và tên" path="display_name" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label"> Email <sup>*</sup></label>
								<div class="controls">
									<form:input class="span3" type="email" placeholder="Nhập email"
										path="user" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label"> Số điện thoại liên hệ <sup>*</sup></label>
								<div class="controls">
									<form:input class="span3" type="text"
										placeholder="Nhập số điện thoại liên hệ" path="phone" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label"> Địa chỉ <sup>*</sup></label>
								<div class="controls">
									<form:textarea rows="5" cols="30" path="address" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label"> Ghi chú <sup>*</sup></label>
								<div class="controls">
									<form:textarea rows="5" cols="30" path="note" />
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<input type="submit" name="submitAccount" value="Thanh toán"
										class="shopBtn exclusive">
								</div>
							</div>
						</form:form>
					</div>
				</div>
				<div class="span1">&nbsp;</div>
			</div>
		</div>
	</div>
</body>
</html>