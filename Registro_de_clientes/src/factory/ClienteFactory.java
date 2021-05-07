package factory;

import dominio.Cliente;

public class ClienteFactory {

	public static Cliente getCliente(String dni){
		Cliente cliente = new Cliente(dni);
		
		return cliente;
	}
}
