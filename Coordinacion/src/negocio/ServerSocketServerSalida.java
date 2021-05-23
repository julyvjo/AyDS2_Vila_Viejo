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
	

	
	public void saveCliente(Cliente cliente) { //envia cliente al otro server para que lo almacene
		
		int puerto_envio = Controller.getInstance().getPort_server_salida();
		
		try {
			Socket socket = new Socket("localhost",puerto_envio);
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			out.println("save"); //le indica al otro server la accion a realizar (guardar un cliente)
			
			
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			output.writeObject(cliente);
			
			output.close();
			socket.close();
			
			} catch (Exception e) {
				//si no se puede conectar no hace nada
			}
		
	}
	
	public Cola sync() { //pide sincronizacion al otro server (le devuelve la cola actual)
		Cola cola = null;
		int puerto_envio = Controller.getInstance().getPort_server_salida();
		
		try {
			Socket socket = new Socket("localhost",puerto_envio);
			
			//PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			//out.println("sync"); //le indica al otro server la accion a realizar (pide sincronizacion)
			//out.close();
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			output.writeObject("sync");
			
			
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			cola = (Cola) input.readObject();
			
			output.close();
			input.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			//si no se puede conectar no hace nada
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}
		
		return cola; 
	}
	
	public void pullCliente() { //pide al otro servidor que quite un cliente de la cola
		
		int puerto_envio = Controller.getInstance().getPort_server_salida();
		
		try {
			Socket socket = new Socket("localhost",puerto_envio);
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			out.println("pull"); //le indica al otro server la accion a realizar (pide sincronizacion)
			
			out.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			//si no se puede conectar no hace nada
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String ping(int port) {
		String msg = null;
		
		try {
			Socket socket = new Socket("localhost",port);
			
			//BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			//out.println("ping");
			
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			output.writeObject("ping");
			
			
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			msg = (String) input.readObject();

			//msg = in.readLine();
			
			//in.close();
			//out.close();
			output.close();
			input.close();
			socket.close();
			
			return msg;
			
		} catch (UnknownHostException e) {
			return null;
		} catch (IOException e) {
			return null;
		} catch (ClassNotFoundException e) {
			return null;
		}
		
		
	}

	
}
