package edu.tecnilogica.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;

import edu.tecnilogica.entity.Regions;
import edu.tecnilogica.services.MyLoadListener;

public class MainLoadListener {

	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		try {
			emf = JPAFactory.getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();

			// Activar Listener Eventos para Hibernate 5
			SessionFactoryImpl sfi = emf.unwrap(SessionFactoryImpl.class);
			EventListenerRegistry registry = sfi.getServiceRegistry().getService(EventListenerRegistry.class);
			registry.getEventListenerGroup(EventType.LOAD).appendListener(new MyLoadListener());

			Session sesion = sfi.openSession();
			Transaction tx = null;
			try { // TRANSACCION
				tx = sesion.beginTransaction();
				Regions rg = sesion.get(Regions.class, new BigDecimal(1));

				tx.commit();

			} catch (Exception e) {
				tx.rollback();
				e.printStackTrace();
			} finally {
				sesion.close();
			}

		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			emf.close();
		}
	}

}