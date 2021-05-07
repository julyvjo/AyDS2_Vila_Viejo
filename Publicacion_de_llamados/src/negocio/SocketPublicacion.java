package negocio;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import dominio.Turno;

public class SocketPublicacion implements Runnable{

	@Override
	public void run() {
			
		try {
			ServerSocket serverSocket = new ServerSocket(6666);
			while (true) {
					
				Socket socket = serverSocket.accept();
					
				ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
				Turno turno = (Turno) input.readObject();
					
				System.out.println("Turno = " + turno.toString() + "\n");
				
				Controller.getInstance().publicarTurno(turno); //llamo al controller para publicar el turno
				
				socket.close();
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
		
}
