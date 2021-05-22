package negocio;

import excepciones.ColaVaciaException;
import dominio.Box;
import dominio.Cliente;
import modelo.Cola;
import dominio.Turno;

public class Controller {

	private static Controller instance = null;
	
	private int port_registro;
	private int port_llamado;
	private int port_publicacion;
	private int port_server_salida;
	private int port_server_entrada;
	private int server_id;
	
	
	private Cola cola = new Cola();
	private ServerSocketRegistro ssr = new ServerSocketRegistro();
	private ServerSocketLlamados ssl = new ServerSocketLlamados();
	private ServerSocketPublicacion ssp = new ServerSocketPublicacion();
	private ServerSocketServerEntrada ssse = new ServerSocketServerEntrada(); //recibe mensajes del otro server
	private ServerSocketServerSalida ssss = new ServerSocketServerSalida(); //envia mensajes al otro server
	
	//patron Singleton
	private Controller() {}
	
	public static Controller getInstance() {
		if(instance == null) {
			instance = new Controller();
		}
		return instance;
	}
	
	public Cola getCola() {
		return this.cola;
	}
	
	public int getPort_registro() {
		return port_registro;
	}

	public int getPort_llamado() {
		return port_llamado;
	}

	public int getPort_publicacion() {
		return port_publicacion;
	}

	public int getPort_server_salida() {
		return port_server_salida;
	}

	public int getPort_server_entrada() {
		return port_server_entrada;
	}
	
	public int getServer_id() {
		return server_id;
	}

	public void pullCliente() {
		try {
			Cliente cliente = this.cola.siguiente();
			this.notificar("Cliente extraido [ dni: " + cliente.getDni() + " ]");
		} catch (ColaVaciaException e) {
			//si la cola esta vacia no afecta, simplemente no se hace nada
		}
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
	
	public void portResolve() {
		
		int offset;
		
		String msg = this.ssss.ping(7000);
		
		if(msg == "ping") { //si recibe ping, el otro server está corriendo en el puerto 7000
			offset = 100;
			this.server_id = 2;
		}else {
			offset = 0;
			this.server_id = 1;
		}
		
		System.out.println("MENSAJE = "+ msg); //quitar
		
		this.port_registro = 4000 + offset;
		this.port_llamado = 5000 + offset;
		this.port_publicacion = 6000 + offset;
		this.port_server_entrada = 7000 + offset;
		this.port_server_salida = 7100 - offset;
	}
	
	public void informarAgregado(Cliente cliente) {
		
		this.ssss.saveCliente(cliente);
	}
	
	public void informarExtraccion() {
		
		this.ssss.pullCliente();
	}
	
	public void pedirSincronizacionCola() {
		
		this.cola = this.ssss.sync();
	}
	
	
}
