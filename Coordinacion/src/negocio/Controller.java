package negocio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

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
		this.ssr.run();
		this.ssl.run();
	}
	
	public void agregarCliente(Cliente cliente) {
		this.cola.agregarCliente(cliente);
	}
	
	public void atenderLlamado(Box box) {
		
		//recibe el box que realiza el llamado por parámetro
		
		//saca de la Queue al cliente necesario si existe (si no existe que se hace?)
		
		//fabrica un nuevo turno con cliente extraido + box (lo crea el mismo o llama un factory?)
		
		//####de alguna forma debe devolverle al box que llama el cliente que le corresponde atender####
		
		//llama a this.publicarTurno(turno) con el turno creado como parámetro
		
	}
	
	public void publicarTurno(Turno turno) {
		this.ssp.publicarTurno(turno);
	}
	
	
}
