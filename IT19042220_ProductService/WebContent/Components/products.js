$(document).ready(function() {
	if ($("#alertSuccess").text().trim() == "") {
		$("#alertSuccess").hide();
	}
	$("#alertError").hide();
});

// SAVE ============================================

$(document).on("click", "#btnSave", function(event) {
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();
	
	// Form validation-------------------
	var status = validateProductForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	// If valid------------------------
	var type = ($("#hidProductIDSave").val() == "") ? "POST" : "PUT";
	$.ajax({
		url : "ProductAPI",
		type : type,
		data : $("#formItem").serialize(),
		dataType : "text",
		complete : function(response, status) {
			onProductSaveComplete(response.responseText, status);
		}
	});
});

// This is an save success JS Methods

function onProductSaveComplete(response, status) {

	if (status == "success") {
		var resultSet = JSON.parse(response);

		if (resultSet.status.trim() == "success") {

			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();

			$("#divItemsGrid").html(resultSet.data);

		} else if (resultSet.status.trim() == "error") {

			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {

		$("#alertError").text("Error while saving.");
		$("#alertError").show();

	} else {

		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hidItemIDSave").val("");
	$("#formItem")[0].reset();
}

// This is an update Success Methods Js

$(document).on("click", ".btnUpdate", function(event) {
	
	$("#hidProductIDSave").val($(this).data("productid"));
	$("#ProductName").val($(this).closest("tr").find('td:eq(0)').text());
	$("#ProductPrice").val($(this).closest("tr").find('td:eq(1)').text());
	$("#ManufactureDate").val($(this).closest("tr").find('td:eq(2)').text());
	$("#ExpireDate").val($(this).closest("tr").find('td:eq(3)').text());
	$("#ProductRatings").val($(this).closest("tr").find('td:eq(4)').text());
	$("#NoOfUnits").val($(this).closest("tr").find('td:eq(5)').text());
});

// This is an Delete Success Methods Js

$(document).on("click", ".btnRemove", function(event) {
	
	$.ajax({
		url : "ProductAPI",
		type : "DELETE",
		data : "productID=" + $(this).data("productid"),
		dataType : "text",
		complete : function(response, status) {
			
			onProductDeleteComplete(response.responseText, status);
		}
	});
});


function onProductDeleteComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);

		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();

			$("#divItemsGrid").html(resultSet.data);

		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}

}
//// CLIENT-MODEL================================================================
function validateProductForm() {

	// ProductName
	if ($("#ProductName").val().trim() == "") {
		return "Insert Product Name.";
	}

	// ProductPrice-------------------------------
	if ($("#ProductPrice").val().trim() == "") {
		return "Insert Product Price.";
	}
	
	// is numerical value
	var tmpPrice = $("#ProductPrice").val().trim();
	if (!$.isNumeric(tmpPrice)) {
		return "Insert a numerical value for Product CostPrice.";
	}

	// convert to decimal price
	$("#ProductPrice").val(parseFloat(tmpPrice).toFixed(2));
	
	
	// ManufactureDate
	if ($("#ManufactureDate").val().trim() == "") {
		return "Insert Product Manufacture Date.";
	}
	
	// ExpireDate
	if ($("#ExpireDate").val().trim() == "") {
		return "Insert Product Expire Date.";
	}
	
	// ProductRatings
	if ($("#ProductRatings").val().trim() == "") {
		return "Insert Product Product Ratings.";
	}
	
	// NoOfUnits
	if ($("#NoOfUnits").val().trim() == "") {
		return "Insert Product No Of Units.";
	}
	
	return true;
}
