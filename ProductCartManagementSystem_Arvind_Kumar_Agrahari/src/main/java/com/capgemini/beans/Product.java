package com.capgemini.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

//Creating an entity of Product with Table name Product
@Entity
@Table(name = "Product")
public class Product {
	
	//Creating an attribute of productId as an primary key for table Product and set column name as id
	@Id
	@Column(name = "id")
	@NotNull(message = "Product Id could not be null")  //Validating productId because productId could not be null
	@NotEmpty(message = "Product Id could not be empty") //Validating productId because productId could not be empty
	@Pattern(regexp = "[a-z][0-9]{2}", message = "Product Id is invalid") //Validating pattern of productId so that it's first character alphabet and then 2 numbers
	private String productId;

	//Creating an attribute of productName and set column name as name for table Product
	@Column(name = "name")
	@NotNull(message = "Product Name could not be null") //Validating productName because productName could not be null
	@NotEmpty(message = "Product Name could not be empty") //Validating productName because productName could not be empty
	@Pattern(regexp = "[A-Z][a-z]+", message = "Product Name is invalid") //Validating pattern of productName so that first alphabet of name is capital and then small
	private String productName;

	//Creating an attribute of productModel and set column name as model for table Product
	@Column(name = "model")
	@NotNull(message = "Model Name could not be null") //Validating productModel because productModel could not be null
	@NotEmpty(message = "Model Name could not be empty")  //Validating productModel because productModel could not be empty
	@Size(min = 2, message = "Model Name must contains atleast two characters") //Validating size of characters for productModel so that size can not be less than 2
	private String productModel;

	//Creating an attribute of productPrice and set column name as price for table Product
	@Column(name = "price")
	@NotNull(message = "Price could not be null") //Validating productPrice because productPrice could not be null
	@Range(min = 0, message = "Product Price should not be negative") //Validating productPrice so that price could not be negative
	private double productPrice;

	
	//Getters and Setters for all attribute
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

}
