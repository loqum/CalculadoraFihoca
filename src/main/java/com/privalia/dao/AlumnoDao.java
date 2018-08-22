package com.privalia.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.privalia.common.Alumno;
import com.privalia.util.FileManager;

public class AlumnoDao implements IDao<Alumno> {

	public BufferedWriter bufferedWriter = null;
	public FileManager fileManager = null;
	public BufferedReader bufferedReader = null;
	public static StringBuilder stringBuilder = new StringBuilder();
	public static String archive = null;

	static {
		if (!FileManager.existFile(FileManager.FILENAME)) {
			FileManager.createFile(FileManager.FILENAME);
		} else {
			System.out.println("Achivo ya creado");
		}
	}

	public AlumnoDao() {
		fileManager = new FileManager();
	}

	public Alumno add(Alumno alumno) throws IOException {

		alumno.setIdAlumno(1);
		alumno.setNombre("Ruben");
		alumno.setApellidos("Fernandez");
		alumno.setDni("48856785I");

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;

		try {
			fileWriter = new FileWriter(FileManager.FILENAME, true);
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.append(alumno.toString()).append("\n");
			
			bufferedWriter.newLine();

		} catch (IOException e) {
			System.out.println(stringBuilder.append("Error: ").append(e));
		} finally {

			if (fileWriter != null) {
				fileWriter.close();
			}

			if (bufferedWriter != null) {
				bufferedWriter.close();
			}

		}

		return getLastAlumnoById(alumno.getIdAlumno());

	}

	private Alumno getLastAlumnoById(int idAlumno) throws IOException {

		BufferedReader bufferedReader = null;
		Alumno alumnoParts = null;

		try {
			bufferedReader = new BufferedReader(new FileReader(FileManager.FILENAME));

			String line = "";
			String[] alumno = null;

			while ((bufferedReader.readLine()) != null) {

				line = bufferedReader.readLine();

				alumno = line.split(",", 4);

				if (Integer.parseInt(alumno[0]) == idAlumno) {
					break;
				}
			}

			alumnoParts = new Alumno(Integer.parseInt(alumno[0]), alumno[1], alumno[2], alumno[3]);

		} catch (IOException ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
			throw ex;
		} finally {

			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}

		return alumnoParts;

	}
	
	

}
