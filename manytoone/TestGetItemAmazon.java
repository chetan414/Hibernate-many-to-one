package com.ty.manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetItemAmazon {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Item item = entityManager.find(Item.class, 2);

		if (item != null) {
			System.out.println("ID: " + item.getId());
			System.out.println("Name: " + item.getName());
			System.out.println("Price: " + item.getPrice());
			System.out.println("Quantity: " + item.getQuantity());
			System.out.println("--------------------------------------");

			AmazonOrder amazonOrder = item.getAmazonOrder();
			System.out.println("ID: " + amazonOrder.getId());
			System.out.println("Name: " + amazonOrder.getName());
			System.out.println("Address: " + amazonOrder.getAddress());
			System.out.println("Status: " + amazonOrder.getStatus());
		} else {
			System.out.println("Data your searching for is not available");
		}
	}
}
