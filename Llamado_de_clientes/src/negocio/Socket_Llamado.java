package negocio;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import modelo.Box;
import modelo.Cliente;

public class Socket_Llamado {

	public Cliente getCliente(Box box) {
		Cliente cliente = null;
		try {
			Socket socket = new Socket("localhost",5555);
			
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			output.writeObject(box);
			
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			//cliente = (Cliente) input.readObject();
			cliente = new Cliente("37398782");
			
			output.close();
			input.close();
			socket.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		return cliente;
	}
	
}
