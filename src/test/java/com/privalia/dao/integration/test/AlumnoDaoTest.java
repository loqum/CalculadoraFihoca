package com.privalia.dao.integration.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.privalia.common.Alumno;
import com.privalia.dao.AlumnoDao;

@RunWith(Parameterized.class)
public class AlumnoDaoTest {

	@Test
	public void testAdd() throws UnsupportedOperationException, IOException {
//		assertTrue(condition);
		
		Alumno a1 = new Alumno();
		a1.setIdAlumno(1);
		a1.setNombre("Ruben");
		a1.setApellidos("Fernandez");
		a1.setDni("54647489J");
		
		AlumnoDao aDao = new AlumnoDao();
		Alumno aInserted = aDao.add(a1);

		assertTrue(aInserted.equals(a1));

	}
	
	private Alumno alumnoEnviado;
	private Alumno alumnoEsperado;
	
	public AlumnoDaoTest(Alumno alumnoEnviado, Alumno alumnoEsperado) {
		super();
		this.alumnoEsperado = alumnoEsperado;
		this.alumnoEnviado = alumnoEnviado;
	}
	
	@Parameterized.Parameters
	public static Collection<Object> input() {
		Alumno alumnoEnviado = new Alumno(1,"e","e","323922h");
		Alumno alumnoEsperado = new Alumno(1,"e","e","323922h");
		return Arrays.asList(new Object[][]{ {alumnoEnviado}, {alumnoEsperado}});
	}
	
	@Test
	public void parameterizedTestAdd() throws IOException {
		AlumnoDao alumnoDao = new AlumnoDao();
		Alumno alumnoDevuelto = alumnoDao.add(alumnoEnviado);
		assertTrue(alumnoDevuelto.equals(alumnoEsperado));
	}

}
