<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<head>
<title>Trang chủ</title>
<style>
.imagi {
	object-fit: fill;
	object-fit: cover;
	height: 300px;
}

.newimg {
	object-fit: cover;
	width: auto;
	height: 250px;
}

.thumbnail:hover {
	box-shadow: 10px 10px 5px grey;
}

.span9 {
	border-radius: 50px 20px;
}

.imgSlide {
	border-radius: 50px 20px;
}

.np {
	border-radius: 50px 20px;
}

.sld {
	border-radius: 50px 20px;
}
</style>
</head>


<body>
	<!-- 
Body Section 
-->
	<div class="row">
		<div id="sidebar" class="span3" style="border-radius: 10px">
			<div class="well well-small">
				<ul class="nav nav-list">
					<c:forEach var="item" items="${ categorys }">
						<li><a href='<c:url value="/san-pham/${ item.id }"/>'><span
								class="icon-circle-blank"></span> ${ item.name }</a></li>
						<li>
					</c:forEach>
					<li><a class="totalInCart" href="<c:url value="list_cart"/>"><strong>
								Đã mua <span class="badge badge-success pull-right"
								style="line-height: 18px;"><fmt:formatNumber
										type="number" groupingUsed="true" value="${ TotalPriceCart }" />
									₫</span>
						</strong></a></li>
				</ul>
			</div>

			<a class="shopBtn btn-block" href="#">Upcoming products <br>
				<small>Click to view</small></a> <br>
			<h3>Có thể bạn quan tâm</h3>
			<c:if test="${ fourproduct.size() > 0 }">
				<ul class="nav nav-list promowrapper">
					<c:forEach var="item" items="${ fourproduct }" varStatus="loop">
						<li>
							<div class="thumbnail">
								<a class="zoomTool"
									href="<c:url value="/chi-tiet-san-pham/${ item.id }"/>"
									title="add to cart"><span class="icon-search"></span> Xem
									nhanh</a> <img
									src="<c:url value="/assets/user/img/products/${ item.picture }"/>"
									alt="bootstrap template">
								<div class="caption">
									<h4>
										<a class="defaultBtn"
											href="<c:url value="/chi-tiet-san-pham/${ item.id }"/>">
											Xem </a> <span class="pull-right"><fmt:formatNumber
												type="number" groupingUsed="true" value="${ item.price }" />₫</span>
									</h4>
								</div>
							</div>
						</li>
				</ul>
				</c:forEach>
			</c:if>
		</div>
		<div class="span9">
			<div class="well np">
				<div id="myCarousel" class="carousel slide homCar">
					<div class="carousel-inner sld">
						<c:forEach var="item" items="${ slides }" varStatus="index">
							<c:if test="${index.first }">
								<div class="item active">
							</c:if>
							<c:if test="${not index.first }">
								<div class="item">
							</c:if>
							<img class="imgSlide" style="width: 100%"
								src="<c:url value="/assets/user/img/slide/${ item.img }"/>"
								alt="456">
							<div class="carousel-caption">
								<h4 style="border-radius: 5px">${ item.caption }</h4>
								<p>
									<span style="border-radius: 5px">${ item.content }</span>
								</p>
							</div>
					</div>
					</c:forEach>
				</div>
				<a class="left carousel-control" href="#myCarousel"
					data-slide="prev" style="border-radius: 15px">&lsaquo;</a> <a
					class="right carousel-control" href="#myCarousel" data-slide="next"
					style="border-radius: 15px">&rsaquo;</a>
			</div>
		</div>

		<!--
New Products
-->
		<div class="well well-small" style="border-radius: 10px">
			<h3>Sản phẩm mới</h3>
			<hr class="soften" />
			<div class="row-fluid">
				<div id="newProductCar" class="carousel slide">
					<div class="carousel-inner">
						<c:if test="${ new_product.size() > 0 }">
							<div class="item active">
								<ul class="thumbnails">
									<c:forEach var="item" items="${ new_product }" varStatus="loop">
										<li class="span3">
											<div class="thumbnail">
												<a class="zoomTool"
													href="<c:url value="/chi-tiet-san-pham/${ item.id }"/>"
													title="add to cart"> <span class="icon-search"></span>
													Xem nhanh
												</a> <a href="<c:url value="/chi-tiet-san-pham/${ item.id }"/>">
													<img class="newimg"
													src="<c:url value="/assets/user/img/products/${ item.picture }"/>"
													alt="">
												</a>
											</div>
										</li>
										<c:if
											test="${ (loop.index + 1) % 4 == 0 || (loop.index + 1) == new_product.size() }">
								</ul>
							</div>
							<c:if test="${ (loop.index + 1) < new_product.size() }">
								<div class="item">
									<ul class="thumbnails">
							</c:if>
						</c:if>
						</c:forEach>
						</c:if>
					</div>
					<a class="left carousel-control" href="#newProductCar"
						data-slide="prev">&lsaquo;</a> <a class="right carousel-control"
						href="#newProductCar" data-slide="next">&rsaquo;</a>
				</div>
			</div>
		</div>
		<!--
	Featured Products
	-->
		<div class="well well-small" style="border-radius: 10px">
			<h3>
				<a class="btn btn-mini pull-right" href="products.html"
					title="View more"> Xem thêm <span class="icon-plus"></span></a> Sản
				phẩm nổi bật
			</h3>
			<hr class="soften" />
			<div class="row-fluid">
				<c:if test="${ highlight.size() > 0 }">
					<ul class="thumbnails">
						<c:forEach var="item" items="${ highlight }" varStatus="loop">
							<li class="span4">
								<div class="thumbnail">
									<a class="zoomTool"
										href="<c:url value="/chi-tiet-san-pham/${ item.id }"/>"
										title="add to cart"> <span class="icon-search"></span> Xem
										nhanh
									</a> <a href="<c:url value="/chi-tiet-san-pham/${ item.id }"/>">
										<img class="imagi"
										src="<c:url value="/assets/user/img/products/${ item.picture }"/>"
										alt="">
									</a>
									<div class="caption">
										<h5>${ item.name }</h5>
										<h4>
											<a class="defaultBtn"
												href="<c:url value="/chi-tiet-san-pham/${ item.id }"/>"
												title="Click to view"><span class="icon-zoom-in"></span></a>
											<a class="shopBtn"
												href="<c:url value="/AddCart/${ item.id }"/>"
												title="add to cart"><span class="icon-plus"></span></a> <span
												class="pull-right"><fmt:formatNumber type="number"
													groupingUsed="true" value="${ item.price }" />₫</span>
										</h4>
									</div>
								</div>
							</li>
							<c:if
								test="${ (loop.index + 1) % 3 == 0 || (loop.index + 1) == highlight.size() }">
					</ul>
					<c:if test="${ (loop.index + 1) < highlight.size() }">
						<ul class="thumbnails">
					</c:if>
				</c:if>
				</c:forEach>
				</c:if>
			</div>
		</div>
		<hr>
		<div class="well well-small" style="border-radius: 10px">
			<a class="btn btn-mini pull-right"
				href="<c:url value="/tat-ca-san-pham"/>"> Xem thêm <span
				class="icon-plus"></span></a> Tất cả sản phẩm
		</div>
	</div>
	</div>
</body>

