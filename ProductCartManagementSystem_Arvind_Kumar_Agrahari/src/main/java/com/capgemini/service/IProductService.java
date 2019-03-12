package com.capgemini.service;

import java.util.List;

import com.capgemini.beans.Product;
import com.capgemini.exception.InvalidProductException;
import com.capgemini.exception.NoDataFoundException;

//Interface for the Service Layer
public interface IProductService {
	public Product saveProduct(Product product) throws InvalidProductException; //Method for saving the product object

	public Product updateProduct(String productId, Product product) throws InvalidProductException; //Method for updating the product object for corresponding productId

	public String deleteProduct(String productId) throws InvalidProductException; //Method for deleting the product object for corresponding productId

	public Product findProduct(String productId) throws NoDataFoundException; //Method for finding the product object for corresponding productId

	public List<Product> findAllProducts() throws NoDataFoundException;  //Method for finding all the product object for table
}
