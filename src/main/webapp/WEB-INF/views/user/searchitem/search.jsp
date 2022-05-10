<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<head>
<title>Danh sách tất cả sản phẩm</title>
<style>
.imagi {
	object-fit: fill;
	object-fit: cover;
	height: 300px;
}
.thumbnail{
	border-radius: 15px;
}
.thumbnail:hover {
	box-shadow: 10px 10px 5px grey;
}

.pagination {
	display: flex;
	justify-content: center;
}

.pagination a {
	color: black;
	float: left;
	margin: 1px;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 2px solid #ddd;
	border-radius: 10px;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.h3 {
	justify-content: center;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>
</head>
<body>
	<div class="well well-small">
		<h3>Kết quả tìm kiếm với từ khóa  ' ${ keyword } '</h3>
		<div class="row">
			<span style="margin-left: 25px">Lọc danh sách sản phẩm</span> <select
				class="pull-right">
				<option>A - Z</option>
				<option>Cao thấp</option>
			</select>
		</div>
		<c:if test="${ list.size() > 0 }">
			<div class="row-fluid">
				<ul class="thumbnails">
					<c:forEach var="item" items="${ productsPaginate }"
						varStatus="loop">
						<li class="span4">
							<div class="thumbnail">
								<a href="product_details.html" class="overlay"></a> <a
									class="zoomTool" style="border-radius: 15px;" href="<c:url value="/chi-tiet-san-pham/${ item.id }"/>"
									title="add to cart"><span class="icon-search"></span> Xem
									chi tiết</a> <a
									href="<c:url value="/chi-tiet-san-pham/${ item.id }"/>"> <img
									class="imagi"
									src="<c:url value="/assets/user/img/products/${ item.picture }"/>"
									alt=""></a>
								<div class="caption cntr">
									<p>${ item.name }</p>
									<p>
										<strong><fmt:formatNumber type="number"
												groupingUsed="true" value="${ item.price }" /> ₫</strong>
									</p>
									<h4>
										<a class="shopBtn" style="border-radius: 15px;" href="<c:url value="/AddCart/${ item.id }"/>" title="add to cart"> Thêm vào
											giỏ hàng </a>
									</h4>
									<br class="clr">
								</div>
							</div>
						</li>
						<c:if
							test="${ (loop.index + 1) % 3 == 0 || (loop.index + 1) == productsPaginate.size() }">
				</ul>
			</div>
			<c:if test="${ (loop.index + 1) < productsPaginate.size() }">
				<div class="row-fluid">
					<ul class="thumbnails">
			</c:if>
		</c:if>
		</c:forEach>
		</c:if>
	</div>
	<div class="pagination">
		<c:if test="${ paginateInfo.currentPage > 1 }">
			<a href="<c:url value="/search/1"/>">&laquo;</a>
		</c:if>
		<c:forEach var="item" begin="1" end="${ paginateInfo.totalPage }"
			varStatus="loop">
			<c:if test="${ (loop.index) == paginateInfo.currentPage }">
				<a href="<c:url value="/search/${ loop.index }"/>"
					class="active">${ loop.index }</a>
			</c:if>
			<c:if test="${ (loop.index) != paginateInfo.currentPage }">
				<a href="<c:url value="/search/${ loop.index }"/>">${ loop.index }</a>
			</c:if>
		</c:forEach>
		<c:if test="${ paginateInfo.currentPage < paginateInfo.totalPage }">
			<a
				href="<c:url value="/search/${ paginateInfo.totalPage }"/>">&raquo;</a>
		</c:if>
	</div>
</body>
