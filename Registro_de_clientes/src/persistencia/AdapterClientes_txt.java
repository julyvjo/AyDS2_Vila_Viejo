package persistencia;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import dominio.Cliente;
import factory.ClienteFactory;

public class AdapterClientes_txt implements IAdapterClientes{

	@Override
	public Cliente readCliente(String dni) {
		Cliente cliente = null;
		String cadena, nroDni, nombre, categoria;
		
		try {
			  
			BufferedReader in = new BufferedReader(new FileReader("clientes.txt"));
			
			nroDni = "";
            cadena = in.readLine();
            
            while(cadena !=  null && !nroDni.equals(dni)) {
            	List<String> tokens =  Arrays.asList(cadena.split("-"));
            	nroDni = tokens.get(0).trim();
            	if(nroDni.equals(dni)) {
            		nombre = tokens.get(1).trim();
            		categoria = tokens.get(2).trim();
            		
            		cliente = ClienteFactory.getInstance().getCliente(dni, nombre, categoria);
            	}
            	
            	cadena = in.readLine();
            }
            
            in.close();
            
        }
        catch (IOException e) {
            System.out.println("excepcion IO" + e);
        }
		
		return cliente;
	}

}
