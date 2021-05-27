package negocio;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import dominio.Box;
import dominio.Turno;
import excepciones.ColaVaciaException;


public class ServerSocketLlamados implements Runnable{
	

	@Override
	public void run() { //este metodo deberia devolverle a la componente de llamados el cliente que le toca atender o indicarle que no hay ninguno
		
		int port_llamado = Controller.getInstance().getPort_llamado();
			
		try {
			ServerSocket serverSocket = new ServerSocket(port_llamado);
			while (true) {
					
				Socket socket = serverSocket.accept();
					
				ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
				Box box = (Box) input.readObject();
				
				//pido turno al controller pasandole el box que me llama
				try {
					
					Turno turno = Controller.getInstance().getTurno(box); //podria tirar excepcion cola vacia o interrupted
					output.writeObject(turno); //devuelve el turno a la componente de llamados
					Controller.getInstance().informarExtraccion(); //informa al otro server que se extrajo un cliente
					
					
				} catch (ColaVaciaException e) { //en caso de que la cola este vacia
					Controller.getInstance().notificar("nuevo turno = [ Null ] " + "[ box: " + box.getNumero_box() + " ]");
					output.writeObject(null);
				}
				
				input.close();
				output.close();
				socket.close();
					
			}
			} catch (Exception e) {
			e.printStackTrace();
			}

			
			
	}
		
}
