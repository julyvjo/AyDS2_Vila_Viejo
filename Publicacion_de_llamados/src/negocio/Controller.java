package negocio;

import vista.Gui;

public class Controller {

	private static Controller instance = null;
	private Gui ventana = new Gui();
	
	//patron Singleton
	public static Controller getInstance() {
		if(instance == null) {
			instance = new Controller();
		}
		return instance;
	}
	
	
	//metodos
	public void publicarTurno() { //parametros Turno turno -> dni + box pasado desde server principal
		
		this.ventana.publicarTurno();//otra vez el turno de parametro
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
