package negocio;

import java.util.ArrayList;

import dominio.Cliente;
import excepciones.ColaVaciaException;
import modelo.Cola;

public class StrategyFIFO implements IStrategyCola{

	@Override
	public Cliente siguiente(Cola cola) throws ColaVaciaException{
		Cliente cliente = null;
		ArrayList<Cliente> array = cola.getClientes();
		
		if( array.size() < 1 ) {
			throw new ColaVaciaException("Cola vacia");
		}
		
		cliente = array.remove(0);
		
		return cliente;
	}
	
}
