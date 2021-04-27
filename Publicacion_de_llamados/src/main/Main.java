package main;

import modelo.Box;
import modelo.Cliente;
import modelo.Turno;
import negocio.Controller;

public class Main {

	public static void main(String[] args) {
		
		Controller controller = Controller.getInstance();

		//#### sacar este codigo y reemplazar por networking ####			//
		Turno turno1 = new Turno(new Cliente("41783676"), new Box(5));		//
		Turno turno2 = new Turno(new Cliente("51783676"), new Box(3));		//
		Turno turno3 = new Turno(new Cliente("61783676"), new Box(1));		//
		
		
		controller.publicarTurno(turno1);									//
		controller.publicarTurno(turno2);									//
		controller.publicarTurno(turno3);									//
		
		controller.publicarTurno(turno1);									//
		controller.publicarTurno(turno1);									//
		controller.publicarTurno(turno1);									//
		controller.publicarTurno(turno1);									//
		controller.publicarTurno(turno1);									//
		controller.publicarTurno(turno1);									//
		controller.publicarTurno(turno1);									//
		controller.publicarTurno(turno1);									//
		controller.publicarTurno(turno1);									//
		controller.publicarTurno(turno1);									//
		//#### sacar este codigo y reemplazar por networking ####			//
	}

}
