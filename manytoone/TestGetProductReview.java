package com.ty.manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetProductReview {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Product product = entityManager.find(Product.class, 1);
		if (product != null) {
			System.out.println("Product Id  :" + product.getId());
			System.out.println("Product Name  :" + product.getName());
			System.out.println("Product Brand  :" + product.getBrand());
			System.out.println("Product Type  :" + product.getType());
			System.out.println("Product Cost  :" + product.getCost());
			System.out.println("--------------------------------------");
			Review review = product.getReview();
			System.out.println("Review Id    :" + review.getId());
			System.out.println("Review Rating:" + review.getRating());
			System.out.println("Review Comment:" + review.getComment());
			System.out.println("Review Password:" + review.getPassword());
		} else {
			System.out.println("No Data is Found");
		}
	}
}
