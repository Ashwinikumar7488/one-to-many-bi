package com.ty.many_to_one_ex2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveDetails {

	public static void main(String[] args) {

		Hospital hospital = new Hospital();
		hospital.setName("Apolo");
		hospital.setWebsite("www.apolo.com");
		
		Branch branch1 = new Branch();
		branch1.setLocation("Patia");
		branch1.setCity("Bhubaneswar");
		branch1.setPhone(7488233140l);
		
		Branch branch2 = new Branch();
		branch2.setLocation("Sadar");
		branch2.setCity("Hazaribagh");
		branch2.setPhone(7077113703l);
		
		Branch branch3 = new Branch();
		branch3.setLocation("Basavangudi");
		branch3.setCity("Bengaluru");
		branch3.setPhone(9934357211l);
		
		List<Branch> branches = new ArrayList<Branch>();
		branches.add(branch1);
		branches.add(branch2);
		branches.add(branch3);
				
		branch1.setHospital(hospital);
		branch2.setHospital(hospital);
		branch3.setHospital(hospital);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityManager.persist(branch1);
		entityManager.persist(branch2);
		entityManager.persist(branch3);
		entityTransaction.commit();
		
		System.out.println("Details Saved Successfully!");

	}
}
