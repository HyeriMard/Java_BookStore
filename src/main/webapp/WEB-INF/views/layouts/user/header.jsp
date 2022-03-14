<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<header id="header">
	<div class="row">
		<div class="span12" style="text-align: center">
				<a class="logo" href=""><span></span> <img
					src="<c:url value="/assets/user/img/logoa.png"/>"
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
				<form action="#" class="navbar-search pull-right" style="margin-right: 10px">
					<input type="text" placeholder="Search" class="search-query span2" >
				</form>
			</div>
		</div>
	</div>
</div>