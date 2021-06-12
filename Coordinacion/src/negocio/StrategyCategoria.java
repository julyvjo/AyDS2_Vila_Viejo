package negocio;

import java.util.ArrayList;
import java.util.Iterator;

import dominio.Cliente;
import excepciones.ColaVaciaException;
import modelo.Cola;

public class StrategyCategoria implements IStrategyCola{

	@Override
	public Cliente siguiente(Cola cola)  throws ColaVaciaException{
		
		Cliente cliente = null;
		Iterator<Cliente> itcola = cola.getClientes().iterator();
		ArrayList<Cliente> array = cola.getClientes();
		int i = 0;
		int index_gold = -1;
		int index_silver = -1;
		int index_bronze = -1;
		
		if( array.size() < 1 ) {
			throw new ColaVaciaException("Cola vacia");
		}
		
		while(itcola.hasNext() && index_gold == -1) {
			
			cliente = itcola.next();
			
			if( cliente.getCategoria().equals("gold") ) {
				
				index_gold = i;
				
			}else if( cliente.getCategoria().equals("silver") && index_silver == -1 ) {
							
				index_silver = i;
				
			}else if( cliente.getCategoria().equals("bronze") && index_bronze == -1 ) {
				
				index_bronze = i;
			}
			
			i++;
		}
		
		//por cual motivo dejo de iterar? categoria gold o fin de cola?
		if( index_gold != -1 ) {
			
			cliente = array.remove(index_gold);
		}else if( index_silver != -1 ) {
			
			cliente = array.remove(index_silver);
		}else{
			
			cliente = array.remove(index_bronze);
		}
		
		return cliente;
		
	}

}
