<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Home_main</title>
    <link rel="stylesheet" href="assetsDash/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assetsDash/css/Bold-BS4-CSS-Image-Slider.css">
    <link rel="stylesheet" href="assetsDash/css/styles.css">
    <link rel="stylesheet" href="assetsDash/css/Swipe-Slider-7.css">
</head>

<body>
    <jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
    <div></div><!-- Paradise Slider -->
	<div id="fw_al_001" class="carousel slide ps_slide_y ps_indicators_y swipe_y ps_easeOutQuint" data-ride="carousel" data-pause="hover" data-interval="5000" data-duration="2500">

		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#fw_al_001" data-slide-to="0" class="active"></li>
			<li data-target="#fw_al_001" data-slide-to="1"></li>
			<li data-target="#fw_al_001" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper For Slides -->
		<div class="carousel-inner" role="listbox">

			<!-- First Slide -->
			<div class="carousel-item active">

				<!-- Slide Background -->
				<img src="assets/img/h6.jpeg" alt="fw_al_001_01">

				<!-- Slide Text Layer -->
				<div class="fw_al_001_slide">
					<h3 data-animation="animated fadeInUp">Gadget Badget </h3>
					<h1 data-animation="animated fadeInUp">Sell a Product</h1>
					<p data-animation="animated fadeInUp">Earn more Money</p>
					<a onclick="window.location.href ='ProductForm.jsp';" data-animation="animated fadeInUp" style="color: white;">Add </a>
				</div>
			</div>
			<!-- End of Slide -->

			<!-- Second Slide -->
			<div class="carousel-item">

				<!-- Slide Background -->
				<img src="assets/img/h5.jpg" alt="fw_al_001_02">

				<!-- Slide Text Layer -->
				<div class="fw_al_001_slide">
					<h3 data-animation="animated fadeInUp">Gadget Badget </h3>
					<h1 data-animation="animated fadeInUp">dolor loborti eros</h1>
					<p data-animation="animated fadeInUp">lorem 2018, ipsum out of sapien, consequa</p>
					<a href="#" data-animation="animated fadeInUp">quamr rutrumt</a>
				</div>
			</div>
			<!-- End of Slide -->

			<!-- Third Slide -->
			<div class="carousel-item">

				<!-- Slide Background -->
				<img src="assets/img/h2.jpg" alt="fw_al_001_03">

				<!-- Slide Text Layer -->
				<div class="fw_al_001_slide">
					<h3 data-animation="animated fadeInUp">Gadget Badget </h3>
					<h1 data-animation="animated fadeInUp">Sell a Product</h1>
					<p data-animation="animated fadeInUp">Earn more Money</p>
					<a onclick="window.location.href ='ProductForm.jsp';" data-animation="animated fadeInUp" style="color: white;">Add </a>
				</div>
			</div>
			<!-- End of Slide -->

		</div><!-- End of Wrapper For Slides -->

	</div> <!-- End Paradise Slider -->

	


 <!-- End -->
    <div></div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/Swipe-Slider-7.js"></script>
    
    	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>

</html>