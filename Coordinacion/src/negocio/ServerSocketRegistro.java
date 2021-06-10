package negocio;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import dominio.Cliente;

public class ServerSocketRegistro implements Runnable{
	

	/**
	 *Escucha en el puerto correspondiente (4xxx)
	 *Recibe los clientes enviados por la componente de registro e invoca metodos
	 *para guardarlos en la cola de clientes, tambien avisa al otro server para
	 *que "imite" al principal y registre tambien al cliente
	 */
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
				Controller.getInstance().informarAgregado(cliente); //pide al controller que avise al otro server del agregado
				Controller.getInstance().writeLog("cliente registrado [ dni: " + cliente.getDni() + " ]"); //pide al log que ingrese un log de registro
				
				socket.close();
					
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	}
	
		
}
