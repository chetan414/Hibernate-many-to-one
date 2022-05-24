package com.ty.manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveHospitalBranch {
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Branch branch1 = new Branch();
		branch1.setName("Appollo Hospital");
		branch1.setState("Karnataka");
		branch1.setCountry("India");
		branch1.setPhone(9876543210l);
		
		Branch branch2 = new Branch();
		branch2.setName("Appollo Hospital");
		branch2.setState("Hydrabhad");
		branch2.setCountry("India");
		branch2.setPhone(9876509876l);
		
		Branch branch3 = new Branch();
		branch3.setName("Appollo Hospital");
		branch3.setState("Delhi");
		branch3.setCountry("India");
		branch3.setPhone(9812345678l);
		
		Hospital hospital = new Hospital();
		hospital.setName("Appollo");
		hospital.setWeb("www.Appollo hospital.com");
		
		branch1.setHospital(hospital);
		branch2.setHospital(hospital);
		branch3.setHospital(hospital);
		
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityManager.persist(branch1);
		entityManager.persist(branch2);
		entityManager.persist(branch3);
		entityTransaction.commit();
	}
}
