package negocio;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import dominio.Cliente;

public class ServerSocketRegistro implements Runnable{

	@Override
	public void run() {
			
		try {
			ServerSocket serverSocket = new ServerSocket(4444);
			while (true) {
					
				Socket socket = serverSocket.accept();
					
				ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
				Cliente cliente = (Cliente) input.readObject();
				
				Controller.getInstance().agregarCliente(cliente); //llamo al controller para agregar al cliente	
				
				socket.close();
					
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	}
		
}
