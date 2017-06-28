package edu.tecnilogica.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Registro;

import edu.tecnilogica.services.MyInterceptor;

public class MainInterceptor {
	public static void main(String[] args) {
		SessionFactory sf = null;
		try {

			sf = HibernateFactory.getSessionFactory();
			Session sesion = sf.withOptions().interceptor(new MyInterceptor()).openSession(); // La
																								// sesion
																								// informa
																								// al
																								// interceptor

			Transaction tx = null;
			try {
				tx = sesion.beginTransaction();

				Registro reg = new Registro();
				sesion.save(reg);

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
			sf.close();
		}
	}

}