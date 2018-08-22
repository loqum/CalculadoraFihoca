package com.privalia.common;

public class Alumno {
	
	private int idALumno;
	private String nombre;
	private String apellidos;
	private String dni;
	
	public int getIdALumno() {
		return idALumno;
	}
	
	public void setIdALumno(int idALumno) {
		this.idALumno = idALumno;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(idALumno);
		builder.append(",");
		builder.append(nombre);
		builder.append(",");
		builder.append(apellidos);
		builder.append(",");
		builder.append(dni);
		builder.append("\n");
		return builder.toString();
	}
	
	
	
}
