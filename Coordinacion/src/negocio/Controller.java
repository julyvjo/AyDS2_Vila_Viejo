package negocio;

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
	
	
	public synchronized void agregarCliente(Cliente cliente) {
		
		this.cola.agregarCliente(cliente);
		this.notificar("cliente registrado [ dni: " + cliente.getDni() + " ]");
	}
	
	public synchronized Turno getTurno(Box box) throws ColaVaciaException {
		
		Turno turno = null;
		
		Cliente cliente;
		cliente = this.cola.siguiente();
		
		turno = new Turno(cliente, box);
		this.publicarTurno(turno);
		
		this.notificar("nuevo turno [ dni: " + turno.getCliente().getDni() + " ] " + "[ box: " + turno.getBox().toString() + " ]");
			
		return turno;
	}
	
	public void publicarTurno(Turno turno) {
		this.ssp.publicarTurno(turno);
	}
	
	public void notificar(String mensaje) {
		System.out.println(mensaje);
	}
	
	
}
