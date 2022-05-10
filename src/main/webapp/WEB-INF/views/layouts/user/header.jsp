<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<header id="header">
	<div class="row">
		<div class="span12" style="text-align: center">
			<a class="logo" href="/WebShop/trang-chu"><span></span> <img
				src="<c:url value="/assets/user/img/n5h1.png"/>"
				alt="bootstrap sexy shop"> </a>
		</div>
	</div>
</header>

<!--
Navigation Bar Section 
-->
<div class="navbar">
	<div class="navbar-inner">
		<div class="container" style="border-radius: 15px">
			<div class="nav-collapse">
				<ul class="nav">
					<c:forEach var="item" items="${ menus }" varStatus="index">
						<c:if test="${index.first }">
							<li class="active">
						</c:if>
						<c:if test="${not index.first }">
							<li class="">
						</c:if>
						<a href="<c:url value="${ item.url }"/>"> ${ item.name } </a>
						</li>
					</c:forEach>
				</ul>
				<form:form action="/WebShop/search" method="GET" accept-charset="utf-8" class="navbar-search pull-right">
					<input name="keyword" value="${keyword}" required size="30" type="text" placeholder="Nhập từ khóa" class="search-query span2 ">
					<button type="submit" class="socialNw pull-right" style="margin-left: 5px;margin-right: 5px;padding-bottom:5px;"> Tìm kiếm </button>
				</form:form>
			</div>
		</div>
	</div>
</div>