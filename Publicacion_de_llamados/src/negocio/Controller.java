package negocio;

import java.util.ArrayList;

import modelo.Turno;
import vista.Gui;

public class Controller {

	private static Controller instance = null;
	private Gui ventana = new Gui();
	private ArrayList<Turno> turnos = new ArrayList<Turno>();
	private SocketPublicacion sp = new SocketPublicacion();
	
	//constructor privado por patrón Singleton
	private Controller() {
		this.ventana.setVisible(true);
	}
	
	//patron Singleton
	public static Controller getInstance() {
		if(instance == null) {
			instance = new Controller();
		}
		return instance;
	}
	
	//metodos
	
	public void listen() {
		this.sp.run();
	}
	
	//llama al metodo publicarTurno de la ventana pasandole los atributos para cada defaultlistmodel (box y dni)
	public void publicarTurno(Turno turno) {
		
		this.ventana.publicarTurno(turno.getBox().toString(), turno.getCliente().getDni());
	}
	
}
