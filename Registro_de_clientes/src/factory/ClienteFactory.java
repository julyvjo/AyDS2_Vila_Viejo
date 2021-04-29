package factory;

import modelo.Cliente;

public class ClienteFactory {

	public static Cliente getCliente(String dni){
		Cliente cliente = new Cliente(dni);
		
		return cliente;
	}
}
