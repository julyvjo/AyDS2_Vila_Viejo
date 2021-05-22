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

	@Override
	public void run() {
		
		int puerto_escucha = Controller.getInstance().getPort_server_entrada();
		
		try {
			
			ServerSocket serverSocket = new ServerSocket(puerto_escucha);
			
			while (true) {
					
				Socket socket = serverSocket.accept();
				
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String msg = in.readLine();
				
				if(msg.equals("save")) { //guarda el cliente que le manda el otro server
					
					ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
					Cliente cliente = (Cliente) input.readObject();
					
					Controller.getInstance().agregarCliente(cliente);
					input.close();
					
				}else if(msg.equals("sync")) { //manda cola al otro server para sincronizarlo
					
					ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
					Cola cola = Controller.getInstance().getCola();
					output.writeObject(cola);
					output.close();
					
				}else if(msg.equals("pull")) { //saca al proximo cliente de su propia cola
					
					Controller.getInstance().pullCliente();
					
				}else if(msg.equals("ping")) {
					
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					out.write("ping"); //retorna ping al llamado de ping
					out.close();
				}
				
				socket.close();
					
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} //fin run
	
	
}
