package negocio;

import java.io.ObjectOutputStream;
import java.net.Socket;

import dominio.Cliente;

public class Socket_Registro {
	
	public void agregarCliente(Cliente cliente) {
		try {
			Socket socket = new Socket("localhost",4444);
			
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			
			output.writeObject(cliente);
			
			
			output.close();
			socket.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
}
