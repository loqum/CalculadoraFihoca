package com.privalia.dao;

import com.privalia.common.Alumno;

public abstract class DaoFactory {
	
	public static final String TXT = "com.privalia.dao.TxtAlumnoDao.java";
	public static final String JSON = "com.privalia.dao.JsonAlumnoDao.java";
	
	public abstract IDao<Alumno> getAlumnoDao();
	
	public static DaoFactory getDaoFactory(String whichFactory) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		DaoFactory daoFactory = null;
		
		try {
			
			Class<?> classDefinition = Class.forName(whichFactory);
			daoFactory = (DaoFactory) classDefinition.newInstance();
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			throw e;
		} catch (InstantiationException e) {
			System.out.println(e);
			throw e;
		} catch (IllegalAccessException e) {
			System.out.println(e);
			throw e;
		}
		
				
		return daoFactory;
		
	}

}
