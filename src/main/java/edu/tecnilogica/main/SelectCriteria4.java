package edu.tecnilogica.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import edu.tecnilogica.entity.Employees;

public class SelectCriteria4 {
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		try {

			emf = JPAFactory.getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = null;
			try { // TRANSACCION
				tx = em.getTransaction();
				tx.begin();
				CriteriaBuilder cb = em.getCriteriaBuilder();

				CriteriaQuery<MiniEmpleado> cq = cb.createQuery(MiniEmpleado.class);
				Root<Employees> root = cq.from(Employees.class);

				Path<Integer> pathID = root.get("employeeId");
				Path<String> pathName = root.get("firstName");

				cq.select(cb.construct(MiniEmpleado.class, pathID, pathName));

				TypedQuery<MiniEmpleado> tq = em.createQuery(cq);
				List<MiniEmpleado> lista = tq.getResultList();

				for (MiniEmpleado me : lista) {
					System.out.println("ID: " + me.getEmployeeId());
					System.out.println("Name: " + me.getFirstName());
					System.out.println("-----------------");

				}

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