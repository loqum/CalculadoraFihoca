package com.privalia.dao.integration.test;



import static org.junit.Assert.assertTrue;

import java.io.IOException;


import org.junit.Test;
import org.junit.runner.RunWith;


import com.privalia.common.Alumno;
import com.privalia.dao.AlumnoDAO;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;



@RunWith(JUnitParamsRunner.class)
public class AlumnoDAOTest {
	
	  
	

	@Test
    @Parameters(method = "containsParameters")
	public void testAdd(Alumno alumnoEnviado, Alumno alumnoEsperado) throws UnsupportedOperationException, IOException {
		
		AlumnoDAO alumnoDao = new AlumnoDAO();
		Alumno alumnoDevuelto = alumnoDao.add(alumnoEnviado);
		boolean resultado=alumnoDevuelto.equals(alumnoEsperado);
		assertTrue(resultado);
				

	}
	
	  		
			public Object[] containsParameters() {
		    	
		    	Alumno alumnoEnviado = new Alumno();
				alumnoEnviado.setIdALumno(2);
				alumnoEnviado.setNombre("Pepe");
				alumnoEnviado.setApellidos("Soto");
				alumnoEnviado.setDni("38115062z");
				
				Alumno alumnoEsperado = new Alumno();
				alumnoEsperado.setIdALumno(2);
				alumnoEsperado.setNombre("Pepe");
				alumnoEsperado.setApellidos("Soto");
				alumnoEsperado.setDni("38115062z");
				
				Alumno alumnoEnviado1 = new Alumno();
				alumnoEnviado1.setIdALumno(3);
				alumnoEnviado1.setNombre("Neus");
				alumnoEnviado1.setApellidos("Sabater");
				alumnoEnviado1.setDni("454545454x");
				
				Alumno alumnoEsperado1 = new Alumno();
				alumnoEsperado1.setIdALumno(3);
				alumnoEsperado1.setNombre("Pepe");
				alumnoEsperado1.setApellidos("Soto");
				alumnoEsperado1.setDni("454545454x");
				
		        return new Object[]{
		                new Object[]{alumnoEnviado, alumnoEsperado},
		                new Object[]{alumnoEnviado1, alumnoEsperado1}
		        };
		    }
		

}
