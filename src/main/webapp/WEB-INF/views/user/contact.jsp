<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<title>Liên hệ</title>
<body>
	<div class="well well-small">
		<h1>Visit us</h1>
		<hr class="soften" />
		<div class="row-fluid">
			<div class="span8 relative">
				<iframe style="width: 100%; height: 350px" frameborder="0"
					scrolling="no" marginheight="0" marginwidth="0"
					src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.420594896575!2d106.7829140144228!3d10.855580060696974!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3175276e7ea103df%3A0xb6cf10bb7d719327!2sHUTECH%20University%20-%20E%20Campus%20(SHTP)!5e0!3m2!1svi!2s!4v1647527587787!5m2!1svi!2s"
					width="600" height="450" style="border:0;" allowfullscreen=""
					loading="lazy"></iframe>
			</div>

			<div class="span4">
				<h4>Gửi mail phản hồi</h4>
				<form class="form-horizontal">
					<fieldset>
						<div class="control-group">

							<input type="text" placeholder="name" class="input-xlarge" />

						</div>
						<div class="control-group">

							<input type="text" placeholder="email" class="input-xlarge" />

						</div>
						<div class="control-group">

							<input type="text" placeholder="subject" class="input-xlarge" />

						</div>
						<div class="control-group">
							<textarea rows="3" id="textarea" class="input-xlarge"></textarea>

						</div>

						<button class="shopBtn" type="submit">Gửi mail</button>

					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>