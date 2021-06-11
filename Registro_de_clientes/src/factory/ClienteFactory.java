package factory;

import dominio.Cliente;

public class ClienteFactory {

	public static Cliente getCliente(String dni, String nombre, String categoria){
		Cliente cliente = new Cliente(dni, nombre, categoria);
		
		return cliente;
	}
}
