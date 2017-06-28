package edu.tecnilogica.services;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

import org.hibernate.CallbackException;
import org.hibernate.EntityMode;
import org.hibernate.Interceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

public class MyInterceptor implements Interceptor {

	public void afterTransactionBegin(Transaction arg0) {
		// TODO Auto-generated method stub

	}

	public void afterTransactionCompletion(Transaction arg0) {
		// TODO Auto-generated method stub

	}

	public void beforeTransactionCompletion(Transaction arg0) {
		// TODO Auto-generated method stub

	}

	public int[] findDirty(Object arg0, Serializable arg1, Object[] arg2, Object[] arg3, String[] arg4, Type[] arg5) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getEntity(String arg0, Serializable arg1) throws CallbackException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEntityName(Object arg0) throws CallbackException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object instantiate(String arg0, EntityMode arg1, Serializable arg2) throws CallbackException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isTransient(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void onCollectionRecreate(Object arg0, Serializable arg1) throws CallbackException {
		// TODO Auto-generated method stub

	}

	public void onCollectionRemove(Object arg0, Serializable arg1) throws CallbackException {
		// TODO Auto-generated method stub

	}

	public void onCollectionUpdate(Object arg0, Serializable arg1) throws CallbackException {
		// TODO Auto-generated method stub

	}

	public void onDelete(Object arg0, Serializable arg1, Object[] arg2, String[] arg3, Type[] arg4)
			throws CallbackException {
		// TODO Auto-generated method stub

	}

	public boolean onFlushDirty(Object arg0, Serializable arg1, Object[] arg2, Object[] arg3, String[] arg4,
			Type[] arg5) throws CallbackException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onLoad(Object arg0, Serializable arg1, Object[] arg2, String[] arg3, Type[] arg4)
			throws CallbackException {
		// TODO Auto-generated method stub
		return false;
	}

	public String onPrepareStatement(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean onSave(Object arg0, Serializable arg1, Object[] arg2, String[] arg3, Type[] arg4)
			throws CallbackException {
		System.out.println("Entra en onSave");

		System.out.println("Entity: " + arg0.getClass().getSimpleName());
		System.out.println("ID: " + arg1.toString());
		System.out.println("State: " + Arrays.toString(arg2));

		return false;
	}

	public void postFlush(Iterator arg0) throws CallbackException {
		// TODO Auto-generated method stub

	}

	public void preFlush(Iterator arg0) throws CallbackException {
		// TODO Auto-generated method stub

	}

}
