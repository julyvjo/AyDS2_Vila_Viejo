package modelo;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

import excepciones.ColaVaciaException;

public class Cola {

	private Queue<Cliente> cola = new PriorityQueue<Cliente>();
	
//getters
	public Queue<Cliente> getClientes() {
		return cola;
	}




//metodos
	public Cliente siguiente() throws ColaVaciaException{
		
		Cliente cliente = null;
		Queue<Cliente> cola = this.getClientes();
		
		cliente = cola.poll(); //recupera y remueve el siguiente en la cola, si la cola es vacia devuelve null
		
		if( cliente == null) {
			throw new ColaVaciaException("Cola vacia");
		}
		
		return cliente;
	}
	
	public void agregarCliente(Cliente cliente){
		
		Queue<Cliente> cola = this.getClientes();
		
		cola.add(cliente);
	}
	
	
	
	
	
	
	
}
