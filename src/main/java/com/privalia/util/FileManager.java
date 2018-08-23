
package com.privalia.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileManager {

	public static File createFile(String archivo) {

		File fichero = new File(archivo);
		return fichero;
	}

	public static boolean fileExist(String archivo) {

		return new File(archivo).exists();
	}

	public static String readFile(File file) throws IOException {

		FileInputStream fileStream = null;
		byte[] data = null;

		try {
			fileStream = new FileInputStream(file);
			data = new byte[(int) file.length()];
			fileStream.read(data);
			
		} catch (IOException e) {
			System.out.println(e);
			
		} finally {
			fileStream.close();
		}

		return new String(data, "UTF-8");
	}

}
