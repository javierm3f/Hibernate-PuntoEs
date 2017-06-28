package edu.tecnilogica.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import edu.tecnilogica.entity.Registrotabla;

public class IdAutogenerado {
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		try {

			emf = JPAFactory.getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = null;
			try { // TRANSACCION
				tx = em.getTransaction();
				tx.begin();

				Registrotabla reg = new Registrotabla();
				Registrotabla reg2 = new Registrotabla();
				Registrotabla reg3 = new Registrotabla();

				em.persist(reg);
				em.persist(reg2);
				em.persist(reg3);

				tx.commit();

			} catch (Exception e) {
				tx.rollback();
				e.printStackTrace();
			} finally {
				em.close(); // lanza excepción que se puede controlar
			}

		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			emf.close();
		}
	}

}
