package factory;

import dominio.Cliente;

public class ClienteFactory {

	private static ClienteFactory instance = null;
	
	private ClienteFactory() {} //constructor private por singleton
	
	public static ClienteFactory getInstance() {
		
		if(instance == null) {
			instance = new ClienteFactory();
		}
		
		return instance;
	}
	
	public  Cliente getCliente(String dni, String nombre, String categoria){
		Cliente cliente = new Cliente(dni, nombre, categoria);
		
		return cliente;
	}
}
