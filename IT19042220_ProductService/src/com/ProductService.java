package com;

import model.Product;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

// IT19042220
// Weerasinghe W.S.H.

@Path("/Products")

public class ProductService {
	
	Product itemObj = new Product();
	
// Read all the data	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems() {
		return itemObj.readProducts();
	}
	
// For Insert values
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertProduct(@FormParam("ProductName") String ProductName,
			@FormParam("ProductPrice") String ProductPrice,
			@FormParam("ManufactureDate") String ManufactureDate, 
			@FormParam("ExpireDate") String ExpireDate, 
	        @FormParam("ProductRatings") String ProductRatings, 
            @FormParam("NoOfUnits") String NoOfUnits) 
	{
		String output = itemObj.insertProduct(ProductName, ProductPrice, ManufactureDate, ExpireDate,ProductRatings,NoOfUnits);
		return output;
	}

// For Update values
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateProduct(String itemData) {
		// Convert the input string to a JSON object
		JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject();
		// Read the values from the JSON object
		String productID = itemObject.get("productID").getAsString();
		String ProductName = itemObject.get("ProductName").getAsString();
		String ProductPrice = itemObject.get("ProductPrice").getAsString();
		String ManufactureDate = itemObject.get("ManufactureDate").getAsString();
		String ExpireDate = itemObject.get("ExpireDate").getAsString();
		String ProductRatings = itemObject.get("ProductRatings").getAsString();
		String NoOfUnits = itemObject.get("NoOfUnits").getAsString();
		String output = itemObj.updateProduct(productID,ProductName, ProductPrice, ManufactureDate, ExpireDate,ProductRatings,NoOfUnits);
		return output;
	}

// For Delete values
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteProduct(String itemData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(itemData, "", Parser.xmlParser());

		// Read the value from the element <productID>
		String productID = doc.select("productID").text();
		String output = itemObj.deleteProduct(productID);
		return output;
	}
}