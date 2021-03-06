package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//IT19042220
//Weerasinghe W.S.H.

public class Product {

	// A common method to connect to the DB

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, user name, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/product", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	// Insert Methods

	public String insertProduct(String name, String price, String manu, String exp, String rating, String units) {
		String output = "";
		try {
			Connection con = connect();
			
			if (con == null) {
				return "Error while connecting to the Database for inserting.";
			}
			// create a prepared statement
			String query = " insert into product (`productID`,`ProductName`,`ProductPrice`,`ManufactureDate`,`ExpireDate`,`ProductRatings`,`NoOfUnits`)"
					+ " values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, name);
			preparedStmt.setDouble(3, Double.parseDouble(price));
			preparedStmt.setString(4, manu);
			preparedStmt.setString(5, exp);
			preparedStmt.setString(6, rating);
			preparedStmt.setString(7, units);

			// execute the statement
			preparedStmt.execute();
			con.close();

			String newItems = readProducts();

			output = "{\"status\":\"success\", \"data\": \"" + newItems + "\"}";

		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": " + " \"Error while inserting the Product.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}
	// Read Methods

	public String readProducts() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border='1' class='table' ><tr class='thead-dark'><th >Product Name</th>" + " <th>Product Price</th><th>Manufacture Date</th>"
					+ "<th>Expire Date</th> " + "<th>Product Ratings</th> "+ "<th>No Of Units</th> " + "<th>Update</th><th>Remove</th></tr>";
			
			String query = "select * from product";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				String productID = Integer.toString(rs.getInt("productID"));
				String ProductName = rs.getString("ProductName");
				String ProductPrice = Double.toString(rs.getDouble("ProductPrice"));
				String ManufactureDate = rs.getString("ManufactureDate");
				String ExpireDate = rs.getString("ExpireDate");
				String ProductRatings = rs.getString("ProductRatings");
				String NoOfUnits = rs.getString("NoOfUnits");

				// Add into the html table
				output += "<tr><td><input id='hidProductIDUpdate' name='hidProductIDUpdate' type='hidden' value='" + productID
						+ "'>" + ProductName + "</td>";
				output += "<td>" + ProductPrice + "</td>";
				output += "<td>" + ManufactureDate + "</td>";
				output += "<td>" + ExpireDate + "</td>";
				output += "<td>" + ProductRatings + "</td>";
				output += "<td>" + NoOfUnits + "</td>";

				// buttons
				output += "<td><input name='btnUpdate'  type='button' value='Update'  class='btnUpdate btn btn-secondary'></td>"
						+ "<td><input name='btnRemove' type='button' value='Remove'   class='btnRemove btn btn-danger' 	 data-productid='"
						+ productID + "'>" + "</td></tr>";
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the Products.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	// Update Methods

	public String updateProduct(String ID, String name, String price, String manu, String exp, String rating,String units) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE product SET ProductName=?,ProductPrice=?,ManufactureDate=?,ExpireDate=?,ProductRatings=?,NoOfUnits=?WHERE productID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, name);
			preparedStmt.setDouble(2, Double.parseDouble(price));
			preparedStmt.setString(3, manu);
			preparedStmt.setString(4, exp);
			preparedStmt.setString(5, rating);
			preparedStmt.setString(6, units);
			preparedStmt.setInt(7, Integer.parseInt(ID));

			// execute the statement
			preparedStmt.execute();
			con.close();
			String newItems = readProducts();
			output = "{\"status\":\"success\", \"data\": \"" + newItems + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while updating the Product.\"}";
			System.err.println(e.getMessage());
		}
		return output;

	}

	// Delete Methods

	public String deleteProduct(String productID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from product where productID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(productID));
			// execute the statement
			preparedStmt.execute();
			con.close();

			String newItems = readProducts();
			output = "{\"status\":\"success\", \"data\": \"" + newItems + "\"}";

		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while deleting the product.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}
}