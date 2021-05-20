package negocio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import dominio.Box;
import dominio.Turno;

public class Socket_Llamado {
	private int port1 = 5000;
	private int port2 = 5100;
	private int port = port1;

	public Turno getTurno(Box box) {
		Turno turno = null;
		
		try {
			
			turno = conecta(port, box);
			
		} catch (UnknownHostException e) { //falla al conectar con el port
				
				if(port == port1) { //si no puede conectar con el primer puerto se cambia el port principal por el de reserva (sea cual sea de los dos)
					port = port2;
				}else {
					port = port1;
				}
				
				try {
					
					turno = conecta(port, box); //reintenta conectar usando el port de reserva
					
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return turno;
	}
	
	public Turno conecta(int port, Box box) throws UnknownHostException, IOException, ClassNotFoundException {
		Turno turno = null;
		
		Socket socket = new Socket("localhost",port);
		
		ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
		output.writeObject(box);
		
		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
		turno = (Turno) input.readObject();
		
		output.close();
		input.close();
		socket.close();
		
		return turno;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
