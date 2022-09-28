package com.ty.many_to_one_ex3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchDetailsBySim {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Mobile mobile = entityManager.find(Mobile.class, 1);

		try {
			List<Sim> sims = mobile.getSims();
			System.out.println("==============MOBILE DETAILS=================");
			System.out.println("ID: " + mobile.getId());
			System.out.println("PRICE: " + mobile.getCost());
			System.out.println("NAME: " + mobile.getName());

			for (Sim sim : sims) {
				System.out.println("==============SIM DETAILS=================");
				System.out.println("ID: " + sim.getId());
				System.out.println("NAME: " + sim.getName());
				System.out.println("SERVICE PROVIDER: " + sim.getProvider());
			}
		} catch (NullPointerException e) {
			System.out.println("Details not found!");
		}

	}
}