package negocio;

import java.io.IOException;

public class Controller {
	private static Controller instance = null;
	private SocketMonitor sm;
	private Thread hilosm;
	private String estadoS1;							// "offline" -- "running";
	private String estadoS2;							// "offline" -- "running";
	private int pulso_ant;
	
	//patron Singleton
	private Controller() {
		this.sm = new SocketMonitor();
		this.hilosm = new Thread(this.sm);
		this.hilosm.start();
		this.estadoS1 = "offline";
		this.estadoS2 = "offline";
		this.pulso_ant = 0;
	}
		
	public static Controller getInstance() {
		if(instance == null) {
			instance = new Controller();
		}
		return instance;
	}
	
	// resetea el socketMonitor
	public void reset() {
		this.hilosm = new Thread(this.sm);
		hilosm.start();
	}
	
	
	// monitoreo de servers
	public void estadoServers(int idServer) {
	
		if(idServer == 1) {										// pulso del server 1
			if(this.estadoS1.equals("offline"))					// si el estado es "offline" lo cambia a "running"
				this.estadoS1 = "running";
			if(this.pulso_ant == idServer)						// si el pulso anterior lo mando el mismo server quiere decir
				this.estadoS2 = "offline";						// que el otro server esta caido
		}
		
		else if(idServer == 2) {
			if(this.estadoS2.equals("offline"))
				this.estadoS2 = "running";						// idem pulso del server 1
			if(this.pulso_ant == idServer)
				this.estadoS1 = "offline";
		}
		
		else if(idServer == 0) {								// se termino el tiempo de espera y no llego ningun pulso
			this.estadoS1 = "offline";
			this.estadoS2 = "offline";
		}
		
		this.refreshOutput();
		this.pulso_ant = idServer;
	}
	
	
	public void refreshOutput() {	
		this.clearScreen();
		System.out.println("\n----- Monitoreo Servers -----\n"
				+ "\n\nServer #1: is " + this.estadoS1
				+ "\n\nServer #2: is " + this.estadoS2);
	}
	
	
	// metodo para limpiar consola
	public void clearScreen() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
