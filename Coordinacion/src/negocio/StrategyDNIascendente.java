package negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import dominio.Cliente;
import excepciones.ColaVaciaException;
import modelo.Cola;

public class StrategyDNIascendente implements IStrategyCola, Serializable{

	@Override
	public Cliente siguiente(Cola cola)  throws ColaVaciaException{
		
		Iterator<Cliente> itcola = cola.getClientes().iterator();
		ArrayList<Cliente> array = cola.getClientes();
		Cliente cliente = null;
		int i = 0;
		int extraido_index = -1;
		int dni = Integer.MAX_VALUE;
		
		while(itcola.hasNext()) {
			
			cliente = itcola.next();
			
			if(extraido_index == -1) {
				
				extraido_index = i;
				dni = Integer.parseInt(cliente.getDni());
				
			}else if( Integer.parseInt(cliente.getDni()) < dni ) {
				
				extraido_index = i;
				dni = Integer.parseInt(cliente.getDni());
			}
			
			i++;
		}
		
		if( extraido_index == -1) {
			throw new ColaVaciaException("Cola vacia");
		}
		
		cliente = array.remove(extraido_index);
		
		return cliente;
		
	}
	
	
	
	
	
	

}
