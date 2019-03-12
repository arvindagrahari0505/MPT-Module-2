package com.capgemini.dao;

import java.util.List;

import com.capgemini.beans.Product;

//Interface for the DAO Layer
public interface IProductRepo {
	
	public Product save(Product product); //Method for saving the product object into table

	public Product update(String productId, Product product); //Method for updating the product object for corresponding productId

	public boolean delete(String productId); //Method for deleting the product object from table

	public Product findOne(String productId); //Method for finding the product object for corresponding productId

	public List<Product> findAll(); //Method for finding all the product object for table
}
