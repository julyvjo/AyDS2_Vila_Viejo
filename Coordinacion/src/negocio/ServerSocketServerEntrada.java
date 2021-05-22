package negocio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import dominio.Cliente;

public class ServerSocketServerEntrada implements Runnable{
	private int puerto_envio = 7000;
	private int puerto_escucha = 7000;
	

	@Override
	public void run() {
		
		if(Controller.getInstance().getPort() == 0) {
			this.puerto_envio += 100;
		}else {
			this.puerto_escucha += 100;
		}
		
		
		try {
			ServerSocket serverSocket = new ServerSocket(puerto_escucha);
			while (true) {
					
				Socket socket = serverSocket.accept();
				
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String msg = in.readLine();
				
				if(msg.equals("save")) { //guarda el cliente que le manda el otro server
					//guarda
					
					ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
					Cliente cliente = (Cliente) input.readObject();
					
					Controller.getInstance().agregarCliente(cliente);
					input.close();
					
				}else if(msg.equals("sync")) { //manda cola al otro server para sincronizarlo
					//sincroniza
					
					ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
					//Cola cola = Controller.getInstance().getCola();
					//output.writeObject(cola);
					output.close();
					
				}else if(msg.equals("pull")) { //saca al proximo cliente de su propia cola
					
					//Controller.getInstance(). "sacarCliente(); o .siguiente()"
				}
				
				socket.close();
					
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} //fin run
	
	
}
