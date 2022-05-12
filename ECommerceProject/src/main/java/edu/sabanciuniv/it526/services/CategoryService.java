package edu.sabanciuniv.it526.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.sabanciuniv.it526.entity.Category;
import edu.sabanciuniv.it526.entity.Product;

@Stateless
public class CategoryService {

	@PersistenceContext
	private EntityManager entityManager;

	public Category checkData() {
		try {
			Category category = entityManager
					.createQuery("select c from Category c where c.name ='Ev & Mobilya'", Category.class)
					.getSingleResult();
			return category;
		} catch (Exception e) {
			return null;
		}
	}

	public void save(Category category) {
		entityManager.persist(category);
	}

	
	public void delete(int categoryId) {
		Category toBeRemoved = entityManager.find(Category.class, categoryId);
		
		for(Product p : toBeRemoved.getProducts())
		{
			entityManager.remove(p);
		}
		entityManager.remove(toBeRemoved);

		
	}

	public Category getById(int id) {
		return entityManager.find(Category.class, id);
	}

	public List<Category> getAllCategories() {

		List<Category> categories = entityManager.createQuery("select c from Category c", Category.class)
				.getResultList();

		for (Category category : categories) {
			for (Product product : category.getProducts()) {
				System.out.println(product);
			}
		}

		return categories;
	}

	public void update(Category toBeUpdated) {
		entityManager.merge(toBeUpdated);
	}
}
