package com.capgemini.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.beans.Product;
import com.capgemini.exception.InvalidProductException;
import com.capgemini.exception.NoDataFoundException;
import com.capgemini.service.IProductService;

//Creating a controller class for spring boot application
@RestController
@Validated
public class ProductController {
	
	//Instantiated for Service layer using Autowired annotation
	@Autowired
	private IProductService productService;
	
	//Creating a request mapper for taking product object and adding product into database
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public Product createProduct(@Valid @RequestBody Product product) throws InvalidProductException {
		/*
		 * Passing the product object to service layer for saving into table
		 * Returning the Product object
		 */
		return productService.saveProduct(product); 
	}
	
	//Creating a request mapper for taking product id from path variable,product object and adding product into table
	@RequestMapping(value = "/products/{productId}", method = RequestMethod.PUT)
	public Product updateProduct(@PathVariable String productId,@Valid @RequestBody Product product) throws InvalidProductException {
		/*
		 * Passing the product object to service layer for updating into table
		 * Returning the Product object
		 */
		return productService.updateProduct(product.getProductId(), product); 
	}

	//Creating a request mapper for taking product id from path variable for deleting product from table
	@RequestMapping(value = "/deleteProduct/{productId}", method = RequestMethod.DELETE)
	public String deleteProduct(@PathVariable String productId) throws InvalidProductException {
		/*
		 * Passing the product object to service layer for deleting from table
		 * Returning the String message
		 */
		return productService.deleteProduct(productId);
	}

	//Creating a request mapper for taking product id from path variable for finding product from table
	@RequestMapping(value = "/viewProduct/{productId}", method = RequestMethod.GET)
	public Product searchProduct(@PathVariable String productId) throws NoDataFoundException {
		/*
		 * Passing the product id to service layer for getting product object from table
		 * Returning the Product object
		 */
		return productService.findProduct(productId);
	}

	//Creating a request mapper for finding all product from table
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> viewAllProducts() throws NoDataFoundException {
		/*
		 * Calling the service layer method for getting all the product object from table
		 * Returning the List of all Product object
		 */
		return productService.findAllProducts(); 
	}
}