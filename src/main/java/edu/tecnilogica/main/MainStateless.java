package edu.tecnilogica.main;


import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Registro;

public class MainStateless {
	public static void main(String[] args) {
		SessionFactory sf = null;
		try {

			sf = HibernateFactory.getSessionFactory();
			StatelessSession sesion = sf.openStatelessSession();
			Transaction tx = null;
			try { // TRANSACCION
				tx = sesion.beginTransaction();
				for (int i = 0; i < 5000; i++) {
					sesion.insert(new Registro());
				}

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
