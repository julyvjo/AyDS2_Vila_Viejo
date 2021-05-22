package negocio;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import dominio.Cliente;

public class ServerSocketRegistro implements Runnable{
	

	@Override
	public void run() {
		
		int port_registro = Controller.getInstance().getPort_registro();
		
		try {
			ServerSocket serverSocket = new ServerSocket(port_registro);
			while (true) {
					
				Socket socket = serverSocket.accept();
					
				ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
				Cliente cliente = (Cliente) input.readObject();
				
				Controller.getInstance().agregarCliente(cliente); //llamo al controller para agregar al cliente
				//Controller.getInstance().informarAgregado(cliente); //pide al controller que avise al otro server del agregado
				
				socket.close();
					
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	}
	
		
}
