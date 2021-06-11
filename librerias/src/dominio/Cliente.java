package dominio;

import java.io.Serializable;

public class Cliente implements Serializable {

	private String dni;
	private String nombre;
	private String categoria;
	
	public Cliente(String dni, String nombre, String categoria) {
		this.dni = dni;
		this.nombre = nombre;
		this.categoria = categoria;
	}

	public String getDni() {
		return dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getCategoria() {
		return categoria;
	}
}
