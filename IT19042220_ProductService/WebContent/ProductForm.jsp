<%@page import="model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Form_Product</title>
    <link rel="stylesheet" href="assetsProduct/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assetsProduct/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assetsProduct/css/Application-Form.css">
    <link rel="stylesheet" href="assetsProduct/css/styles.css">
    
    <link rel="stylesheet" href="Views/bootstrap.min.css">
	<script src="Components/jquery-3.2.1.min.js"></script>
	<script src="Components/products.js"></script>
</head>

<body>
   <jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
   <br>  
   <br>
   
<section>
    <h1 class="text-center text-capitalize">Product form</h1>
    
	<div class="container">
		
		
		  <div class="form-outline mb-4">
		  
				<form id="formItem" name="formItem">
				
					Product Name: <input id="ProductName" name="ProductName" type="text"class="form-control form-control-sm"> <br> 
					
					Product Price:<input id="ProductPrice" name="ProductPrice" type="text" class="form-control form-control-sm"> <br>
					 
					Product Manufacture Date: <input id="ManufactureDate" name="ManufactureDate" type="date"class="form-control form-control-sm"> <br> 
					
					Product Expire Date: <input id="ExpireDate" name="ExpireDate" type="date"class="form-control form-control-sm"> <br>
					
					Product Ratings: <input id="ProductRatings" name="ProductRatings" type="text"class="form-control form-control-sm"> <br>
					
					Product No Of Units: <input id="NoOfUnits" name="NoOfUnits" type="text"class="form-control form-control-sm"> <br>
					
 					<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
 					<input type="hidden" id="hidProductIDSave" name="hidProductIDSave" value="">
					 
				</form>
				<br>
				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
				<br>
				<div id="divItemsGrid">
					<%
						Product proObj = new Product();
						out.print(proObj.readProducts());
					%>
				</div>
			</div>
	</div>
    
    	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>

</html>