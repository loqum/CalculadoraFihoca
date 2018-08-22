
package com.privalia.util;

import java.io.File;

public class FileManager {
	
	
	public static File createFile(String archivo) {
		
		File fichero = new File(archivo);
		return fichero;
	}
	
	public static boolean fileExist(String archivo) {
		
		return new File(archivo).exists();
	}

}