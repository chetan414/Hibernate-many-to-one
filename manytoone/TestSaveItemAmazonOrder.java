package com.ty.manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveItemAmazonOrder {
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Item item1 = new Item();
		item1.setName("Formal Shirt for Men");
		item1.setPrice(2500);
		item1.setQuantity(2);
		
		Item item2 = new Item();
		item2.setName("Formal Pant for Men");
		item2.setPrice(3000);
		item2.setQuantity(3);
		
		Item item3 = new Item();
		item3.setName("HP Laptop Charger");
		item3.setPrice(6000);
		item3.setQuantity(1);
		
		AmazonOrder amazonOrder = new AmazonOrder();
		amazonOrder.setAddress("Banshankari");
		amazonOrder.setName("Office wear");
		amazonOrder.setStatus("Will be deliverd in 2 days");
		
		item1.setAmazonOrder(amazonOrder);
		item2.setAmazonOrder(amazonOrder);
		item3.setAmazonOrder(amazonOrder);
		
		entityTransaction.begin();
		entityManager.persist(amazonOrder);
		entityManager.persist(item1);
		entityManager.persist(item2);
		entityManager.persist(item3);
		entityTransaction.commit();
	}
}
