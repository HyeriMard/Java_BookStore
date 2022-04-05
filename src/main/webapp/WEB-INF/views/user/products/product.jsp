<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<head>
<meta charset="UTF-8">
<title>Chi tiết sản phẩm</title>
<style>
.product-content {
	overflow-x: hiden;
}
.shopBtn:hover {
	background: #2ecc71;
	box-shadow: 10px 10px 5px grey;
}
</style>
</head>
<body>
	<!-- 
Body Section 
-->
	<div class="row product-content">
		<div class="span12">
			<ul class="breadcrumb" style="border-radius: 10px">
				<li><a href="/WebShop/trang-chu">Trang chủ</a> <span class="divider">/</span></li>
				<li class="active">Chi tiết sản phẩm</li>
			</ul>
			<div class="well well-small" style="border-radius: 10px">
				<div class="row-fluid">
					<div class="span5">
						<div id="myCarousel" class="carousel slide cntr">
							<div class="carousel-inner">
								<div class="item active">
									<a href="#"> <img
										src="<c:url value="/assets/user/img/products/${ product.picture }"/>"
										alt="" style="width: 100%"  ></a>
								</div>
							</div>
							
						</div>
					</div>
					<div class="span7">
						<h3>${ product.name }</h3>
						<hr class="soft" />
						<form class="form-horizontal qtyFrm" method="get" action="<c:url value="/AddCart/${ product.id }"/>">
							<div class="control-group">
								<label class="control-label"><span><fmt:formatNumber
											type="number" groupingUsed="true" value="${ product.price }" />₫</span></label>
							</div>
							<p>${ product.title }</p>
							<button type="submit" class="shopBtn"> <span class=" icon-shopping-cart"></span> Thêm vào giỏ hàng </button>
						</form>
					</div>
				</div>
				<hr class="softn clr" />
				<ul id="productDetail" class="nav nav-tabs">
					<li class="active"><a href="#home" data-toggle="tab">Mô tả</a></li>
					<li class=""><a href="#profile" data-toggle="tab"> Sản
							phẩm liên quan </a></li>
				</ul>
				<div id="myTabContent" class="tab-content tabWrapper">
					<div class="tab-pane fade active in" id="home">
						<p>${ product.detail }</p>
					</div>
					<div class="tab-pane fade" id="profile">
						<c:set var="countlist" value=" ${ ProductsByIDCategory.size() }" />
						<c:if test="${ProductsByIDCategory.size() > 0 }">
							<c:set var="countlist" value="1" />
						</c:if>
						<c:forEach var="item" items="${ ProductsByIDCategory }" begin="1" end="${ countlist }"
							varStatus="loop">
							<div class="row-fluid">
								<div class="span2">
									<img
										src="<c:url value="/assets/user/img/products/${ item.picture }"/>"
										alt="">
								</div>
								<div class="span6">
									<h5>${ item.name }</h5>
									<p>${ item.title }</p>
								</div>
								<div class="span4 alignR">
									<form class="form-horizontal qtyFrm">
										<h3>
											<fmt:formatNumber type="number" groupingUsed="true"
												value="${ product.price }" />
											₫
										</h3>
										<div class="btn-group">
											<a href="product_details.html" class="defaultBtn"><span
												class=" icon-shopping-cart"></span> Add to cart</a> <a
												href="product_details.html" class="shopBtn">VIEW</a>
										</div>
									</form>
								</div>
							</div>
							<hr class="soft" />
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Body wrapper -->
</body>
