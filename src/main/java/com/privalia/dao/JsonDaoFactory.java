package com.privalia.dao;

import static com.privalia.util.FileManager.createFile;

import java.io.File;
import com.privalia.common.Alumno;

public class JsonDaoFactory extends DaoFactory {

	public static final String PATH = "alumno.json";
	public static File file = null;

	static {

		file = createFile(PATH);

	}

	@Override
	public IDao<Alumno> getAlumnoDao() {

		return new JsonAlumnoDao();

	}

}
