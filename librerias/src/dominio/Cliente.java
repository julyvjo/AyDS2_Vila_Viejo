package dominio;

import java.io.Serializable;

public class Cliente implements Serializable {

	private String dni;
	
	public Cliente(String dni) {
		this.dni = dni;
	}

	public String getDni() {
		return dni;
	}
	
}
