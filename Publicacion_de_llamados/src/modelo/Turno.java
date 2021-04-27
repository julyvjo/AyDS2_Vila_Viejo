package modelo;

public class Turno {

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
