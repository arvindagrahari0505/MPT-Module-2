package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.beans.Product;
import com.capgemini.dao.IProductRepo;
import com.capgemini.exception.InvalidProductException;
import com.capgemini.exception.NoDataFoundException;

/*
 * Creating Service Layer Implementation class
 * This Layer is responsible for throwing the exception for corresponding data value and interacting to DAO Layer
 */
@Service
public class ProductServiceImpl implements IProductService {

	//Instantiated for DAO layer using Autowired annotation
	@Autowired
	private IProductRepo productRepository;

	// Method for saving Product object
	@Override
	public Product saveProduct(Product product) throws InvalidProductException {
		Product findProduct = productRepository.findOne(product.getProductId()); //finding Product object
		// check whether product is already present or not
		if (findProduct == null) {
			return productRepository.save(product); // passing the product object into DAO layer for saving
		}
		throw new InvalidProductException("This product already created"); // Throwing exception if product already added
	}

	// Method for updating the Product object for corresponding productId
	@Override
	public Product updateProduct(String productId, Product product) throws InvalidProductException {
		Product findProduct = productRepository.findOne(productId); //finding Product object
		// check whether product is already present or not
		if (findProduct != null) {
			return productRepository.update(productId, product); // passing the product object into DAO layer for updating
		}
		throw new InvalidProductException("Product not updated because of invalid product id"); // Throwing exception if product is not added before
	}

	// Method for updating the Product object for corresponding productId
	@Override
	public String deleteProduct(String productId) throws InvalidProductException {
		Product findProduct = productRepository.findOne(productId); //finding Product object
		// check whether product is already present or not
		if (findProduct != null) {
			return productRepository.delete(productId) ? "Product is deleted successfully" : "Product is not deleted successfully"; // passing the product id into DAO layer for deleting
		}
		throw new InvalidProductException("Product not deleted because of invalid product id"); // Throwing exception if product is not added before
	}

	
	// Method for finding the Product object for corresponding productId
	@Override
	public Product findProduct(String productId) throws NoDataFoundException {
		Product product = productRepository.findOne(productId); //finding Product object
		// check whether product is already present or not
		if (product == null) {
			throw new NoDataFoundException("This Product is not in database");  // Throwing exception if product is not added before
		}
		return product; //returning the product object
	}

	// Method for finding all the Product object
	@Override
	public List<Product> findAllProducts() throws NoDataFoundException {
		List<Product> products = productRepository.findAll(); //finding all Product object
		// check whether product is there any product object or not in database
		if (products == null) {
			throw new NoDataFoundException("There is no data in database");  // Throwing exception if there is no product object in table
		}
		return products; //returning all the product object
	}
}
