package com.privalia.util;

import java.io.File;

public class FileManager {
	
	public static final String FILENAME = "alumno.txt";
	public static File file;
	
	public static File createFile(String name) {
		file = new File(FILENAME);
		
		return file;
	}
	
	public static boolean existFile(String name) {
		return new File(FILENAME).exists();
		
	}

}
