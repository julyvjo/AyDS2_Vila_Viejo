package main;

import negocio.Controller;

public class Main {

	public static void main(String[] args) {

		Controller controller = Controller.getInstance();
		controller.portResolve();
		controller.pedirSincronizacionCola();
		
		System.out.println("# Server running - ID = " + controller.getServer_id() + "\n");
		System.out.println(
				
				"Puerto de registro = " + controller.getPort_registro() + "\n" +
				"Puerto de llamado = " + controller.getPort_llamado() + "\n" +
				"Puerto de publicacion = " + controller.getPort_publicacion() + "\n" +
				"Puerto de entrada (server) = " + controller.getPort_server_entrada() + "\n" +
				"Puerto de salida (server) = " + controller.getPort_server_salida() + "\n"
				
				);
		controller.listen(); //pone a escuchar a los sockets ssr y ssl
	}

}
