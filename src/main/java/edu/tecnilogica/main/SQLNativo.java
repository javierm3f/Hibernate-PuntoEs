package edu.tecnilogica.main;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Employees;

public class SQLNativo {
	public static void main(String[] args) {
		SessionFactory sf = null;
		try {

			sf = HibernateFactory.getSessionFactory();
			Session sesion = sf.openSession();
			Transaction tx = null;
			try {
				tx = sesion.beginTransaction();

				SQLQuery query = sesion.createSQLQuery("SELECT * FROM EMPLOYEES");
				query.addEntity(Employees.class);
				List<Employees> lista = query.list();
				for (Employees emp : lista) {
					System.out.println("ID: " + emp.getEmployeeId() + "\nemail: " + emp.getEmail());
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
