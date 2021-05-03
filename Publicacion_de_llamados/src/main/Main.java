package main;

import modelo.Box;
import modelo.Cliente;
import modelo.Turno;
import negocio.Controller;

public class Main {

	public static void main(String[] args) {
		
		Controller controller = Controller.getInstance();

		controller.listen();

	}

}
