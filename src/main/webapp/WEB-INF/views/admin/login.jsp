<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form action="/WebShop/login/" modelAttribute="userLogin" method="post" >
        <div class="swapper mt-md-5 ">
            <h3 class="text-center text-danger">ĐĂNG NHẬP HỆ THỐNG</h3>
            <h5>${status}</h5>
            <div class="row">
                <div class="col-4">
                    <img src="<c:url value="/assets/admin/logo.png"/>"  class="img-fluid">
                </div>
                <div class="col-8 ml-4">
                    <div class="form-group">
                        <h6><strong>Tên đăng nhập</strong></h6>
                        <form:input class="form-control" type="text"  path="user" />
                       
                    </div>
                    <div class="form-group">
                    <h6><strong>Mật khẩu</strong></h6>
                         <form:input class="form-control" type="password"  path="password" />
                    </div>
                    <div class="mt-2" >
                        <input type="submit" name="btn_submit" value="Đăng nhập" class="btn btn-success"/>
                    </div>
                </div>
            </div>
        </div>
    </form:form>
</body>

</html>