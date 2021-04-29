package negocio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import modelo.Cliente;
import modelo.Cola;

public class Controller {

	private static Controller instance = null;
	private Cola cola = new Cola();
	private ServerSocketRegistro ssr = new ServerSocketRegistro();
	private ServerSocketLlamados ssl = new ServerSocketLlamados();
	private ServerSocketPublicacion ssp = new ServerSocketPublicacion();
	
	//patron Singleton
	public static Controller getInstance() {
		if(instance == null) {
			instance = new Controller();
		}
		return instance;
	}
	
	public void agregarCliente(Cliente cliente) {
		this.cola.agregarCliente(cliente);
	}
	
	
	
	
}
