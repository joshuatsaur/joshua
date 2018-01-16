package com.joshua.spring.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.joshua.spring.model.Product;

@Repository
public class ProductDAO {
	@PersistenceContext
	private EntityManager em;
	
	public List<Product> findAll() {
		return em.createQuery("SELECT p FROM Product p").getResultList();
	}
	
	public void persist(Product product) {
		em.persist(product);
	}
}
