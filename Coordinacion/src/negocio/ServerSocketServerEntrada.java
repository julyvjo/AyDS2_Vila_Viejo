package negocio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import dominio.Cliente;
import modelo.Cola;

public class ServerSocketServerEntrada implements Runnable{

	/**
	 *Escucha en el puerto correspondiente (7xxx)
	 *Recibe mensajes exclusivamente del otro servidor y dependiendo el string que obtenga
	 *invoca una u otra accion (guardar cliente, enviar cola de clientes, extraer cliente o devolver ping)
	 */
	@Override
	public void run() {
		
		int puerto_escucha = Controller.getInstance().getPort_server_entrada();
		
		try {
			
			ServerSocket serverSocket = new ServerSocket(puerto_escucha);
			
			while (true) {
					
				Socket socket = serverSocket.accept();
				
				ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
				String msg = (String) input.readObject();
				
				//System.out.println("MSG = " + msg);
				
				if(msg.equals("save")) { //guarda el cliente que le manda el otro server
					
					Cliente cliente = (Cliente) input.readObject();
					Controller.getInstance().agregarCliente(cliente);
					
				}else if(msg.equals("sync")) { //manda cola al otro server para sincronizarlo
					
					ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
					Cola cola = Controller.getInstance().getCola();
					output.writeObject(cola);
					output.close();
					
				}else if(msg.equals("pull")) { //saca al proximo cliente de su propia cola
					
					Controller.getInstance().pullCliente();
					
				}else if(msg.equals("ping")) {
					
					ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
					output.writeObject("ping");
					output.close();
				}

				input.close();
				socket.close();
					
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} //fin run
	
	
}
