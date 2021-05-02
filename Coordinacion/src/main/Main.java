package main;

import negocio.Controller;

public class Main {

	public static void main(String[] args) {

		Controller controller = Controller.getInstance();
		
		System.out.println("server ejecutandose");
		controller.listen(); //pone a escuchar a los sockets ssr y ssl
		
	}

}
