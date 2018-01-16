package com.joshua.spring.bo;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joshua.spring.model.Product;
import com.joshua.spring.service.ProductDAO;

@Service("ProductBO")
@Transactional
public class ProductBO {
	@Autowired
	private ProductDAO productDAO;
	
	public void add(Product product) {
		productDAO.persist(product);
	}

	public void addAll(Collection<Product> products) {
		for (Product pd : products) {
			productDAO.persist(pd);
		}
	}
	
	public List<Product> listAll() {
		return productDAO.findAll();
	}
}
