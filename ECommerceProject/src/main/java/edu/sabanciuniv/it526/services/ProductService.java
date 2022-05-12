package edu.sabanciuniv.it526.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.sabanciuniv.it526.entity.Product;

@Stateless
public class ProductService {

	@PersistenceContext
	private EntityManager entityManager;

	public void save(Product product) {
		entityManager.persist(product);
	}

	public void delete(int id) {

		Product toBeRemoved = entityManager.find(Product.class, id);

		entityManager.remove(toBeRemoved);

	}

	public Product getById(int id) {
		return entityManager.find(Product.class, id);
	}

	public List<Product> getAllProduct() {

		List<Product> products = entityManager.createQuery("select p from Product p", Product.class).getResultList();

		for (Product product : products) {
			System.out.println(product);
		}

		return products;
	}

	public void update(Product toBeUpdated) {
		entityManager.merge(toBeUpdated);
	}
	
	public List<Product> findByCategoryId(int category_id) {
		
		List<Product> products = new ArrayList<Product>();

		products = entityManager.createQuery("select p from Product p where category_id=category_id", Product.class).getResultList();
		
		for (Product product : products) {
			System.out.println(product);
		}


		return products;

	}

}
