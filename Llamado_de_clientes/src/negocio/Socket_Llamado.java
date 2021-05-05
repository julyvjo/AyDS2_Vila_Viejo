package negocio;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import modelo.Box;
import modelo.Cliente;
import modelo.Turno;

public class Socket_Llamado {

	public Turno getCliente(Box box) {
		Turno turno = null;
		try {
			Socket socket = new Socket("localhost",5555);
			
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			output.writeObject(box);
			
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			turno = (Turno) input.readObject();
			
			output.close();
			input.close();
			socket.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		return turno;
	}
	
}
