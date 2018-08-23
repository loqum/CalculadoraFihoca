package com.privalia.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.privalia.common.Alumno;
import com.privalia.util.FileManager;

public class TxtAlumnoDao implements IDao<Alumno> {

	public static String PATH = "alumnos.txt";
	
	static {
		if (!FileManager.fileExist(PATH)) {

			FileManager.createFile(PATH);

		}
	}

	public Alumno add(Alumno alumno) throws IOException {

		FileWriter fileWriter = null;

		try {

			fileWriter = new FileWriter(PATH, true);
			fileWriter.write(alumno.toString().concat("\n"));

		} catch (Exception e) {

			System.out.println("Ha fallado la inserción");
			throw e;
		} finally {

			if (fileWriter != null) {

				fileWriter.close();

			}
		}
		return getLastAlumnoByID(alumno.getIdAlumno());
	}

	private Alumno getLastAlumnoByID(int idAlumno) throws IOException {

		BufferedReader reader = null;
		Alumno alumno = new Alumno();

		try {
			reader = new BufferedReader(new FileReader(PATH));
			String linea;

			while ((linea = reader.readLine()) != null) {

				String[] datos = linea.split(",", 4);
				if (datos[0].equals(String.valueOf(idAlumno))) {

					alumno.setIdAlumno(idAlumno);
					alumno.setNombre(datos[1]);
					alumno.setApellidos(datos[2]);
					alumno.setDni(datos[3]);
					break;
				}

			}

		} catch (IOException e) {

			System.out.println("Error");
			throw e;

		} finally {

			reader.close();
		}

		return alumno;
	}
}
