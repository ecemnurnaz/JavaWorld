package edu.sabanciuniv.it526.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.sabanciuniv.it526.entity.User;

@Stateless
public class UserService {

	@PersistenceContext
	private EntityManager entityManager;

	public User checkData() {
		try {
			User user = entityManager.createQuery("select u from User u where u.id =1", User.class)
					.getSingleResult();
			return user;
		} catch (Exception e) {
			return null;
		}
	}
	public List<User> getAllUsers() {

		List<User> users = entityManager.createQuery("select u from User u", User.class).getResultList();

		return users;
	}

	public void save(User user) {
		
		entityManager.persist(user);
	}
	
	public User getUserById(int userId) {
		return entityManager.find(User.class, userId);
		
	}
}
