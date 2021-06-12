package negocio;

import dominio.Cliente;
import excepciones.ColaVaciaException;
import modelo.Cola;

public interface IStrategyCola {

	public Cliente siguiente(Cola cola) throws ColaVaciaException;
	
}
