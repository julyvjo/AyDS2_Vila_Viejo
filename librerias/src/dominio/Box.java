package dominio;

import java.io.Serializable;

public class Box implements Serializable{

	private int numero_box;

	public Box(int numero_box) {
		this.numero_box = numero_box;
	}
	
	public int getNumero_box() {
		return numero_box;
	}

	@Override
	public String toString() {
		
		return String.valueOf(this.numero_box);
	}
	
}
