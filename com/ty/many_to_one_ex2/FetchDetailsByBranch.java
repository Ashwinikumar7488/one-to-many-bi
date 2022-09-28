package com.ty.many_to_one_ex2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchDetailsByBranch {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Hospital hospital = entityManager.find(Hospital.class, 1);

		try {
			List<Branch> branches = hospital.getBranches();
			System.out.println("==============HOSPITAL DETAILS=================");
			System.out.println("ID: " + hospital.getId());
			System.out.println("NAME: " + hospital.getName());
			System.out.println("WEBSITE: " + hospital.getWebsite());

			for (Branch branch1 : branches) {
				System.out.println("==============BRANCH DETAILS=================");
				System.out.println("ID: " + branch1.getId());
				System.out.println("CITY: " + branch1.getCity());
				System.out.println("LOCATION: " + branch1.getLocation());
				System.out.println("PHONE: " + branch1.getPhone());

			}
		} catch (NullPointerException e) {
			System.out.println("Details not found!");
		}
	}
}