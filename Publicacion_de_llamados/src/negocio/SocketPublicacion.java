package negocio;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import dominio.Turno;

public class SocketPublicacion implements Runnable{

	@Override
	public void run() {
			
		try {
			ServerSocket serverSocket = new ServerSocket(6000);
			while (true) {
					
				Socket socket = serverSocket.accept();
					
				ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
				Turno turno = (Turno) input.readObject();
				
				Controller.getInstance().publicarTurno(turno); //llamo al controller para publicar el turno
				
				socket.close();
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
		
}
