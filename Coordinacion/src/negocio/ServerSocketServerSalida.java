package negocio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import dominio.Cliente;
import modelo.Cola;

public class ServerSocketServerSalida{
	

	
	/**
	 * envia cliente al otro server para que lo almacene
	 * @param cliente
	 */
	public void saveCliente(Cliente cliente) {
		
		int puerto_envio = Controller.getInstance().getPort_server_salida();
		
		try {
			Socket socket = new Socket("localhost",puerto_envio);
			
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			
			output.writeObject("save");
			output.writeObject(cliente);
			
			output.close();
			socket.close();
			
			} catch (Exception e) {
				//si no se puede conectar no hace nada
			}
		
	}
	
	/**
	 * pide sincronizacion al otro server (y el otro le devuelve la cola actual)
	 * @return
	 */
	public Cola sync() {
		Cola cola = null;
		int puerto_envio = Controller.getInstance().getPort_server_salida();
		
		try {
			Socket socket = new Socket("localhost",puerto_envio);
			
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			output.writeObject("sync");
			
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			cola = (Cola) input.readObject();
			
			output.close();
			input.close();
			socket.close();
			
		} catch (Exception e) {
			//si no se puede conectar no hace nada
		}
		
		return cola; 
	}
	
	/**
	 * pide al otro servidor que quite un cliente de la cola
	 */
	public void pullCliente() {
		
		int puerto_envio = Controller.getInstance().getPort_server_salida();
		
		try {
			Socket socket = new Socket("localhost",puerto_envio);
			
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			output.writeObject("pull");
			
			output.close();
			socket.close();
			
		} catch (Exception e) {
			//si no se puede conectar no hace nada
		}
		
	}
	
	/**
	 * Envia "ping" al puerto pasado como parametro y espera un "ping" de respuesta y lo retorna, en caso
	 * de no recibirlo retorna null
	 * @param port
	 * @return
	 */
	public String ping(int port) {
		String msg = null;
		
		try {
			Socket socket = new Socket("localhost",port);
			
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			output.writeObject("ping");
			
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			msg = (String) input.readObject();
			
			output.close();
			input.close();
			socket.close();
			
			return msg;
			
		} catch (Exception e) {
			return null;
		}
		
	}
	

}
