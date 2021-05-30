package negocio;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import dominio.Cliente;

public class Socket_Registro {
	private final int port1 = 4000;
	private final int port2 = 4100;
	private int port = port1;
	
	
	public void agregarCliente(Cliente cliente) {
		try {
			conecta(port, cliente);
			
		} catch(Exception e) { 		//falla al conectar con el port
			System.out.println("host exception");
			if(port == port1) 					//si no puede conectar con el primer puerto se cambia el port principal por el de reserva (sea cual sea de los dos)
				port = port2;
			else
				port = port1;
				
			try {
				conecta(port, cliente); 		//reintenta conectar usando el port de reserva
				
			} catch(Exception e1) {
				
				e1.printStackTrace();	
			}
			
		}
	}
	
	
	public void conecta(int port, Cliente cliente) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", port);
			
		ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			
		output.writeObject(cliente);
			
		output.close();
		socket.close();
	}
	
}
