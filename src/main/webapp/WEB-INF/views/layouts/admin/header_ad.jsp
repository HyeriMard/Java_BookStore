<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<div class="wrapper">
        <!-- Navbar -->
        <nav class="main-header navbar navbar-expand navbar-white navbar-light">
            <!-- Left navbar links -->
           
            <!-- Right navbar links -->
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button">
                        <i class="fas fa-th-large"></i>
                    </a>
                </li>
            </ul>
        </nav>
        <!-- /.navbar -->
        <!-- Main Sidebar Container -->
        <aside class="main-sidebar sidebar-dark-primary elevation-4">
            <!-- Brand Logo -->
            <a href="#" class="brand-link  text-center">
                <span class="brand-text font-weight-light text-white"><strong> Hệ thống </strong></span>
            </a>

            <!-- Sidebar -->
            <div class="sidebar">
                <!-- Sidebar user (optional) -->
                <div class="user-panel mt-3 pb-3 mb-3 d-flex text-center">
                    <div class="info" style="margin-left:80px !important;">
                        <h3 class="card-title text-uppercase text-danger"><strong></strong> </h3>
                    </div>
                </div>

                <!-- Sidebar Menu -->
                <nav class="mt-2">
                    <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu"
                        data-accordion="false">

                       
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="nav-icon fas fa-tachometer-alt"></i>
                                    <p>
                                        Sản phẩm
                                        <i class="right fas fa-angle-left"></i>
                                    </p>
                                </a>
                                <ul class="nav nav-treeview">
                                    <li class="nav-item ml-2 ">
                                        <a href="/WebShop/admin/san-pham" class="nav-link ">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>Danh sách Sách</p>
                                        </a>
                                    </li>
                                    <li class="nav-item ml-2 ">

                                        <a href="/WebShop/admin/the-loai" class="nav-link ">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>Thể loại sách</p>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                         
                            <li class="nav-item">
                                <a href="/WebShop/admin/don-hang" class="nav-link">
                                    <i class="far fa-circle nav-icon text-success"></i>
                                    <p>Đơn hàng</p>
                                </a>
                            </li>
                            
                            <li class="nav-item">
                                <a href="/WebShop/admin/khach-hang" class="nav-link">
                                    <i class="far fa-circle nav-icon text-success"></i>
                                    <p>Khách hàng</p>
                                </a>
                            </li>
                           
                      

                       
                        <li class="nav-item ml-2">
                            <a href="/WebShop/admin/logout" class="nav-link">
                                <i class="nav-icon far fa-circle text-danger"></i>
                                <p class="text">Đăng xuất</p>
                            </a>
                        </li>
                        
                    </ul>
                </nav>
                <!-- /.sidebar-menu -->
            </div>
            <!-- /.sidebar -->
        </aside>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header"></section>
            <!-- Main content -->
            <section class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12">