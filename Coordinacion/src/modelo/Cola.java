package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import dominio.Cliente;

public class Cola implements Serializable{

	//private Queue<Cliente> cola = new LinkedList<Cliente>();
	private ArrayList<Cliente> cola = new ArrayList<Cliente>();
	
//getters
	public ArrayList<Cliente> getClientes() {
		return cola;
	}

	
	public void agregarCliente(Cliente cliente){
		
		//Queue<Cliente> cola = this.getClientes();
		ArrayList<Cliente> cola = this.getClientes();
		
		cola.add(cliente);
		
	}
	
	/*
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
	*/
	
	
	
	
	
	
}
