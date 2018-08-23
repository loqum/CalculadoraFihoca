package com.privalia.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.privalia.common.Alumno;
import com.privalia.util.FileManager;

public class JsonAlumnoDao implements IDao<Alumno> {

	public static StringBuilder stringBuilder = new StringBuilder();

	@Override
	public Alumno add(Alumno model) throws IOException, UnsupportedOperationException {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		String json = gson.toJson(model);

		try {
			JsonDaoFactory.getDaoFactory(DaoFactory.JSON);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
			System.out.println();
		}

		FileWriter writer = null;

		try {
			writer = new FileWriter(JsonDaoFactory.PATH);
			

			writer.write(json);

		} catch (IOException e) {
			System.out.println(stringBuilder.append("error: ").append(e));
			throw e;

		} finally {
			writer.close();

		}

		return searchById(model.getIdAlumno());
	}

	public Alumno searchById(int idAlumno) throws IOException {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		Alumno alumno = new Alumno();
		BufferedReader reader = new BufferedReader(new FileReader(JsonDaoFactory.PATH));
		List<Alumno> alumnosLista = new ArrayList<>();

		while (reader.readLine() != null) {
			alumno = gson.fromJson(reader, Alumno.class);
			alumnosLista.add(alumno);
		}

		return alumno;

	}

}
