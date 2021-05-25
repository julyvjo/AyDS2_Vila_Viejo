package negocio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;


public class SocketMonitor implements Runnable{
	private final int port = 8000;
	private ServerSocket serverSocket;

	@Override
	public void run() {
		
		try {
			this.serverSocket = new ServerSocket(port);
			this.serverSocket.setSoTimeout(10000);			// tiempo de espera del serverSocket para el metodo accept()
			while (true) {
					
				Socket socket = serverSocket.accept();
				
				ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
				
				int idServer = (int) input.readObject();

				Controller.getInstance().estadoServers(idServer);
				
				socket.close();
			}
			
		} catch (SocketTimeoutException e) {				// tiempo de espera terminado
			
			try {
				this.serverSocket.close();					// se cierra el serverSocket
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Thread.interrupted();							// el hilo es interrumpido para ser reseteado
			
			Controller.getInstance().estadoServers(0);
			Controller.getInstance().reset();				// reseteo el hilo del socketMonitor
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
