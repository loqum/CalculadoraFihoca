package com.privalia.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import com.privalia.common.Alumno;
import com.privalia.util.FileManager;

public class AlumnoDao implements IDao<Alumno>{
	
	static String PATH = null;
	static {
		PATH = "alumnos.txt";
		if(!FileManager.fileExist(PATH)){
			
			FileManager.createFile(PATH);
			
		}
	}
	

	public Alumno add(Alumno alumno) throws IOException{
		
		FileWriter fileWriter = null;
			
		try {
	
			fileWriter = new FileWriter(PATH, true);
			fileWriter.write(alumno.toString());
			
			
		}catch(Exception e) {
				
				System.out.println("Ha fallado la inserción");
				throw e;
		}
		finally {
			
			if(fileWriter != null) {
					
				fileWriter.close();
					
			}
		}
		return getLastAlumnoByID(alumno.getIdAlumno());
	}
	
	private Alumno getLastAlumnoByID(int id) throws IOException {
		
		BufferedReader buffredReader = null;
		Alumno alumno = new Alumno();
		boolean alumnoFound = false;
		
		try {
			buffredReader = new BufferedReader(new FileReader(PATH));
			String linea;
		
			while ((linea = buffredReader.readLine()) != null){
			
				String [] datos = linea.split("," , 4);
				if(datos[0].equals(String.valueOf(id))) {
					
					alumno.setIdAlumno(id);
					alumno.setNombre(datos[1]);
					alumno.setApellidos(datos[2]);
					alumno.setDni(datos[3]);
					break;
				}
				
			}

		}catch(IOException e) {
			
			System.out.println("Error");
			throw e;
			
		}finally {
			
			buffredReader.close();
		}
		
		return alumno;
	}
}
