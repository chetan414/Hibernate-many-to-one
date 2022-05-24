package com.ty.manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveProductReview {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Product product1 = new Product();  
		product1.setName("TV");
		product1.setBrand("Lg");
		product1.setType("LED");
		product1.setCost(15000);
		
		Product product2 = new Product();  
		product2.setName("LapTop");
		product2.setBrand("HP");
		product2.setType("Window");
		product2.setCost(51000);
		
		Product product3 = new Product();  
		product3.setName("Mobile");
		product3.setBrand("POCO");
		product3.setType("Andriod");
		product3.setCost(15000);
		
		Review review = new Review();
		review.setRating(4);
		review.setComment("imporve Shipping speed");
		review.setPassword("prashi123");
		
		product1.setReview(review);
		product2.setReview(review);
		product3.setReview(review);
		
		entityTransaction.begin();
		entityManager.persist(product1);
		entityManager.persist(product2);
		entityManager.persist(product3);
		entityManager.persist(review);
		entityTransaction.commit();
	}

}
