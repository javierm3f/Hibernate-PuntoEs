package edu.tecnilogica.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import edu.tecnilogica.entity.Departments;

public class SelectNamedQuery {
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		try {

			emf = JPAFactory.getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = null;
			try {
				tx = em.getTransaction();
				tx.begin();
				TypedQuery<Departments> query = em.createNamedQuery("Departments.pornombre", Departments.class);
				query.setParameter("name", "Operations"); // El primer argumento
															// debe de coincidir
															// con el que se
															// haya puesto en la
															// NamedQuery en el
															// Bean (Departments
															// en este caso)

				System.out.println(query.getSingleResult().getDepartmentId());

				tx.commit();

			} catch (Exception e) {
				tx.rollback();
				e.printStackTrace();
			} finally {
				em.close(); // lanza excepcion que se puede controlar
			}

		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			emf.close();
		}
	}

}