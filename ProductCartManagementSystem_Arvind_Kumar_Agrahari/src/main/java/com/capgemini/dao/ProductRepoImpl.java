package com.capgemini.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.beans.Product;

/*
 * Creating Repository Layer Implementation class
 * This Layer is responsible for the All the CRUD operation from database
 * This class is transactional and handle all the CRUD operation using JPA
 */
@Repository
@Transactional
public class ProductRepoImpl implements IProductRepo {

	// Instantiated for EntityManager using PersistenceContext annotation
	@PersistenceContext
	private EntityManager entityManager;

	// Method for saving Product object into table
	@Override
	public Product save(Product product) {
		entityManager.persist(product); // Saving object
		return findOne(product.getProductId()); // finding and returning the Product object
	}
	
	//Method for updating the Product object for corresponding productId
	@Override
	public Product update(String productId, Product product) {
		Product findProduct = entityManager.find(Product.class, productId); // finding the Product Object
		// Modify the Product object
		findProduct.setProductModel(product.getProductModel());
		findProduct.setProductName(product.getProductName());
		findProduct.setProductPrice(product.getProductPrice());
		return findOne(product.getProductId()); // finding and returning the Product object
	}

	// Method for deleting the Product object for corresponding productId
	@Override
	public boolean delete(String productId) {
		Product findProduct = entityManager.find(Product.class, productId); // finding the Product Object
		entityManager.remove(findProduct); // Delete that object from database
		return true;
	}

	// Method for finding the Product object for corresponding productId
	@Override
	public Product findOne(String productId) {
		Product product = new Product(); 
		product = entityManager.find(Product.class, productId); // finding the Product Object
		return product; // returning the product object
	}

	// Method for finding all the Product object
	@Override
	public List<Product> findAll() {
		return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList(); // finding all the Product object and returning it
	}
}
