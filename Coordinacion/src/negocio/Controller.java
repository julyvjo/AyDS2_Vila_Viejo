package negocio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import excepciones.ColaVaciaException;
import modelo.Box;
import modelo.Cliente;
import modelo.Cola;
import modelo.Turno;

public class Controller {

	private static Controller instance = null;
	private Cola cola = new Cola();
	private ServerSocketRegistro ssr = new ServerSocketRegistro();
	private ServerSocketLlamados ssl = new ServerSocketLlamados();
	private ServerSocketPublicacion ssp = new ServerSocketPublicacion();
	
	//patron Singleton
	private Controller() {}
	
	public static Controller getInstance() {
		if(instance == null) {
			instance = new Controller();
		}
		return instance;
	}
	
	public void listen() {
		
		Thread hilossr = new Thread(this.ssr);
		Thread hilossl = new Thread(this.ssl);
		
		hilossr.start();
		hilossl.start();
		
	}
	
	public void agregarCliente(Cliente cliente) {
		this.cola.agregarCliente(cliente);
	}
	
	public Turno getTurno(Box box) throws ColaVaciaException {
		
		Turno turno = null;
		
		Cliente cliente;
		cliente = this.cola.siguiente();
		
		turno = new Turno(cliente, box);
			
		return turno;
	}
	
	public void publicarTurno(Turno turno) {
		this.ssp.publicarTurno(turno);
	}
	
	
}
