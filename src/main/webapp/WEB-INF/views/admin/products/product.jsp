<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Quản lý sản phẩm</title>
</head>
<body>
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
</body>
</html>