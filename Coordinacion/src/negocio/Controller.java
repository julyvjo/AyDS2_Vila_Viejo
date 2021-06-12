package negocio;

import excepciones.ColaVaciaException;

import java.util.Scanner;

import dominio.Box;
import dominio.Cliente;
import modelo.Cola;
import persistencia.AdapterLog_txt;
import dominio.Turno;

public class Controller {

	private static Controller instance = null;
	
	private int port_registro;
	private int port_llamado;
	private int port_publicacion;
	private int port_server_salida;
	private int port_server_entrada;
	private int port_monitor;
	private int server_id;
	
	
	private Cola cola = new Cola();
	private IStrategyCola estrategia;
	private ServerSocketRegistro ssr = new ServerSocketRegistro();
	private ServerSocketLlamados ssl = new ServerSocketLlamados();
	private ServerSocketPublicacion ssp = new ServerSocketPublicacion();
	private ServerSocketServerEntrada ssse = new ServerSocketServerEntrada(); //recibe mensajes del otro server
	private ServerSocketServerSalida ssss = new ServerSocketServerSalida(); //envia mensajes al otro server
	private ServerSocketMonitor ssm = new ServerSocketMonitor();
	private AdapterLog_txt log = new AdapterLog_txt(); //graba los logs en txt [fecha, hora, eventos]
	
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
	
	public int getPort_monitor() {
		return port_monitor;
	}
	
	public int getServer_id() {
		return server_id;
	}
	
	public IStrategyCola getStrategy() {
		return this.estrategia;
	}

	/**
	 * extrae un cliente de la cola, este metodo es invocado cuando se extrae un cliente desde el server
	 * principal y le avisa a la instancia pasiva que haga la misma accion para seguir sincronizados
	 */
	public void pullCliente() {
		try {
			Cliente cliente = this.estrategia.siguiente(this.cola);
			this.notificar("Cliente extraido [ dni: " + cliente.getDni() + " ]");
		} catch (ColaVaciaException e) {
			//si la cola esta vacia no afecta, simplemente no se hace nada
		}
	}
	
	/**
	 * Pone a escuchar a los hilos del controller para las comunicaciones
	 * server socket registro, server socket llamados, server socket server entrada
	 */
	public void listen() {
		
		Thread hilossr = new Thread(this.ssr);
		Thread hilossl = new Thread(this.ssl);
		Thread hilossse = new Thread(this.ssse);
		
		hilossr.start();
		hilossl.start();
		hilossse.start();
		
	}
	
	/**
	 * Envia un pulso periodicamente al monitor para demostrar que esta online
	 */
	public void heartbeat() {
		Thread hilossm = new Thread(this.ssm);
		hilossm.start();
	}
	
	/**
	 * Agrega un nuevo cliente que es pasado por parametro, a la cola de clientes
	 * @param cliente
	 */
	public synchronized void agregarCliente(Cliente cliente) {
		
		this.cola.agregarCliente(cliente);
		this.notificar("cliente registrado [ dni: " + cliente.getDni() + " ]");
	}
	
	/**
	 * Genera un nuevo turno a partir del siguiente cliente en la cola y el numero de box pasado por parametro y lo retorna
	 * @param box
	 * @return turno
	 * @throws ColaVaciaException: en caso de que la cola de clientes este vacia y no pueda generar el turno
	 */
	public synchronized Turno getTurno(Box box) throws ColaVaciaException {
		
		Turno turno = null;
		
		Cliente cliente = this.estrategia.siguiente(this.cola);
		
		turno = new Turno(cliente, box);
		this.publicarTurno(turno);
		
		this.notificar("nuevo turno [ dni: " + turno.getCliente().getDni() + " ] " + "[ box: " + turno.getBox().toString() + " ]");
			
		return turno;
	}
	
	/**
	 * se comunica con la aplicacion de publicacion pasandole el turno a publicar
	 * @param turno
	 */
	public void publicarTurno(Turno turno) {
		this.ssp.publicarTurno(turno);
	}
	
	/**
	 * Notifica por un mensaje en consola algun evento realizado en la aplicacion
	 * @param mensaje
	 */
	public void notificar(String mensaje) {
		System.out.println(mensaje);
	}
	
	/**
	 * Se invoca inicialmente para configurar los puertos que usa el server.
	 * 
	 * Los servers a utilizar son instancias de la misma componente, en este metodo
	 * se configuran sus ID para identificarlos y los puertos que usan porque algunos no pueden
	 * ser compartidos.
	 * 
	 * -> Los puertos 4xxx refieren al registro de clientes
	 * -> Los puertos 5xxx refieren al llamado de clientes
	 * -> El puerto 6000 refiere a la publicacion de turnos
	 * -> Los puertos 7xxx refieren a los utilizados de server a server (sincronizacion)
	 * -> El puerto 8000 refiere al monitor
	 * 
	 * Los puertos completados con "xxx" indican que tomaran valores como "000" o "100" dependiendo si es
	 * una instancia de server u otra, el server ID = 1 toma el 4000 y el ID = 2 toma el 4100 (el registro se
	 * comunicara con uno u otro dependiendo quien sea el principal). EL server principal por defecto es el
	 * que usa ID = 1 pero esto puede cambiar a medida que se desconectan y reconectan los servers. Los servers
	 * en si no saben quien cumple que rol, lo diferencian mediante la comunicacion de las componentes externas:
	 * 
	 * por ej: si la componente de registro manda un cliente al server ID = 2 ese servidor se comporta como el activo
	 * (registra al cliente y se lo envia al otro server para sincronizar)
	 * 
	 */
	public void portResolve() {
		
		int offset = 0;
		
		if(this.server_id == 1) { //si recibe null, el otro server no está corriendo
			offset = 0;
		}else if(this.server_id == 2){ //si recibe ping el otro server está corriendo
			offset = 100;
		}
		
		this.port_registro = 4000 + offset;
		this.port_llamado = 5000 + offset;
		this.port_publicacion = 6000;
		this.port_server_entrada = 7000 + offset;
		this.port_server_salida = 7100 - offset;
		this.port_monitor = 8000;
	}
	
	/**
	 * Informa al otro server que se agrego un cliente a la cola de clientes para que tambien lo agregue
	 * Pasa este cliente agregado como parametro para que el otro server pueda agregarlo tambien
	 * @param cliente
	 */
	public void informarAgregado(Cliente cliente) {
		
		this.ssss.saveCliente(cliente);
	}
	
	/**
	 * Informa al otro server que se extrajo un cliente de la cola, para que el otro haga lo mismo y
	 * se mantengan sincronizados
	 */
	public void informarExtraccion() {
		
		this.ssss.pullCliente();
	}
	
	/**
	 * Pide al otro server la cola de clientes completa para sincronizarse, este metodo se invoca
	 * unicamente cuando el la aplicacion comienza, luego se  mantienen sincronizados mediante los
	 * otros metodos de avisos y envios.
	 */
	public void pedirSincronizacionCola() {
		Cola cola;
		
		cola = this.ssss.sync();
		
		if(cola != null) {
			this.cola = cola;
		}
	}
	
	public IStrategyCola pedirSincronizacionStrategy() {
		
		return this.ssss.sync_estrategia();
	}
	
	public void writeLog(String accion) {
		
		this.log.writeLog(accion);
	}
	
	public void setID() {
		
		String msg = this.ssss.ping(7000);
		
		if(msg == null) { //si recibe null, el otro server no está corriendo
			this.server_id = 1;
		}else if(msg.equals("ping")){ //si recibe ping el otro server está corriendo
			this.server_id = 2;
		}
	}
	
	public void setStrategy() {
		
		IStrategyCola estrategia = this.pedirSincronizacionStrategy();
		
		if(estrategia == null) {
			
			Scanner leer = new Scanner(System.in);
			
			System.out.println("Seleccione metodo de atencion:\n\n 1. Orden de llegada\n 2. DNI ascendente\n 3. Prioridad por categoria ");
			
			int n = leer.nextInt();
			
			while( n < 1 |3 < n ) {
				
				n = leer.nextInt();
			}
			
			if(n == 1) {
				this.estrategia = new StrategyFIFO();
			}else if(n == 2) {
				this.estrategia = new StrategyDNIascendente();
			}else {
				this.estrategia = new StrategyCategoria();
			}
			
		}else {
			
			this.estrategia = estrategia;
		}	
	}
	
}
