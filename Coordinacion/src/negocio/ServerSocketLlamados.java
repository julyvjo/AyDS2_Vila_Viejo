package negocio;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import modelo.Box;
import modelo.Cliente;

public class ServerSocketLlamados implements Runnable{

	@Override
	public void run() {
		
		//este metodo deberia devolverle a la componente de llamados el cliente que le toca atender o indicarle que no hay ninguno
			
		try {
			ServerSocket serverSocket = new ServerSocket(5555);
			while (true) {
					
				Socket socket = serverSocket.accept();
					
				ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
				Box box = (Box) input.readObject();
					
				System.out.println("Box conectado = " + box.getNumero_box() + "\n");
				
				//socket.getRemoteSocketAddress();
				
				socket.close();
					
			}
			} catch (Exception e) {
			e.printStackTrace();
			}

			
			
	}
		
}
