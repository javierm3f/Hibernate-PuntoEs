package edu.tecnilogica.main;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Employees;

public class MainHibernateEj1 {
	public static void main(String[] args) {
		SessionFactory sf = null;
		try {

			sf = HibernateFactory.getSessionFactory();
			Session sesion = sf.openSession();
			Transaction tx = null;
			try { // TRANSACCION
				tx = sesion.beginTransaction();
				Employees emp = null;
				BigDecimal aumento = null;
				for (int id = 100; id <= 206; id++) {
					emp = sesion.get(Employees.class, id);
					aumento = new BigDecimal(1.07);
					emp.setSalary(emp.getSalary().multiply(aumento));
					// sesion.update(emp);//Si el objeto esta en estado
					// persistent no es necesario este paso
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
