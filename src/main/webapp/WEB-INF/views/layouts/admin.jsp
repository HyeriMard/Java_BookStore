<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<title><decorator:title default="Master-layout" /></title>
<script src="//cdn.ckeditor.com/4.15.1/standard/ckeditor.js"></script>
<!-- Font Awesome -->
<link
	href="<c:url value="/assets/admin/plugins/fontawesome-free/css/all.min.css"/>"
	rel="stylesheet" />
<!-- DataTables -->
<link rel="stylesheet"
	href="<c:url value="/assets/admin/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css" />" />

<link rel="stylesheet"
	href="<c:url value="/assets/admin/plugins/datatables-responsive/css/responsive.bootstrap4.min.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/assets/admin/plugins/datatables-buttons/css/buttons.bootstrap4.min.css" /> " />
<!-- Theme style -->
<link rel="stylesheet"
	href="<c:url value="/assets/admin/dist/css/adminlte.min.css"/>" />
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" />

<script src="<c:url value="/assets/admin/Scripts/jquery-3.4.1.min.js"/>"></script>
<decorator:head />
</head>
<body>

	<%@include file="/WEB-INF/views/layouts/admin/header_ad.jsp"%>
	<decorator:body />
	<%@include file="/WEB-INF/views/layouts/admin/footer_ad.jsp"%>

	<script>
		$.widget.bridge('uibutton', $.ui.button)
	</script>
	<!-- jQuery -->
	<script src="<c:url value="/assets/admin/plugins/jquery/jquery.min.js"/>"></script>
	<!-- Bootstrap 4 -->
	<script
		src="<c:url value="/assets/admin/plugins/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
	<!-- DataTables  & Plugins -->
	<script
		src="<c:url value="/assets/admin/plugins/datatables/jquery.dataTables.min.js"/>"></script>
	<script
		src="<c:url value="/assets/admin/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"/>"></script>
	<script
		src="<c:url value="/assets/admin/plugins/datatables-responsive/js/dataTables.responsive.min.js"/>"></script>
	<script
		src="<c:url value="/assets/admin/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"/>"></script>
	<script
		src="<c:url value="/assets/admin/plugins/datatables-buttons/js/dataTables.buttons.min.js"/>"></script>
	<script
		src="<c:url value="/assets/admin/plugins/datatables-buttons/js/buttons.bootstrap4.min.js"/>"></script>
	<script src="<c:url value="/assets/admin/plugins/jszip/jszip.min.js"/>"></script>
	<script
		src="<c:url value="/assets/admin/plugins/pdfmake/pdfmake.min.js"/>"></script>
	<script
		src="<c:url value="/assets/admin/plugins/pdfmake/vfs_fonts.js"/>"></script>
	<script
		src="<c:url value="/assets/admin/plugins/datatables-buttons/js/buttons.html5.min.js"/>"></script>
	<script
		src="<c:url value="/assets/admin/plugins/datatables-buttons/js/buttons.print.min.js"/>"></script>
	<script
		src="<c:url value="/assets/admin/plugins/datatables-buttons/js/buttons.colVis.min.js"/>"></script>
	<!-- bs-custom-file-input -->
	<script
		src="<c:url value="/assets/admin/plugins/bs-custom-file-input/bs-custom-file-input.min.js"/>"></script>
	<!-- AdminLTE App -->

	<script src="<c:url value="/assets/admin/dist/js/adminlte.min.js"/>"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="<c:url value="/assets/admin/dist/js/demo.js"/>"></script>
	<!-- Page specific script -->
	<script src="<c:url value="/assets/admin/mainAdmin.js"/>"></script>
	<decorator:getProperty property="page.script">
	</decorator:getProperty>
	<script>
		$(function() {
			$("#example1").DataTable(
					{
						"responsive" : true,
						"lengthChange" : false,
						"autoWidth" : false,
						"buttons" : [ "copy", "csv", "excel", "pdf", "print",
								"colvis" ]
					}).buttons().container().appendTo(
					'#example1_wrapper .col-md-6:eq(0)');
			$('#example2').DataTable({
				"paging" : true,
				"lengthChange" : false,
				"searching" : false,
				"ordering" : true,
				"info" : true,
				"autoWidth" : false,
				"responsive" : true,
			});
		});
	</script>
</body>
</html>