package modelo;

import java.io.Serializable;

public class Turno implements Serializable{

	private Cliente cliente;
	private Box box;
	
	public Turno(Cliente cliente, Box box) {
		
		this.cliente = cliente;
		this.box = box;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Box getBox() {
		return box;
	}
	
}
