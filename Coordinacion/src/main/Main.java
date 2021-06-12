package main;

import negocio.Controller;

public class Main {

	public static void main(String[] args) {

		Controller controller = Controller.getInstance();
		
		System.out.println("iniciando...\n\n");
		
		controller.setID();
		
		controller.portResolve(); //invoca un metodo que setea los puertos a usar por el servidor
		
		controller.pedirSincronizacionCola(); //pide sincronizacion al servidor activo, si no existe queda la cola de clietnes vacia
		
		controller.setStrategy();
		

		System.out.println("# Server running - ID = " + controller.getServer_id() + "\n");
		System.out.println(
				
				"Puerto de registro = " + controller.getPort_registro() + "\n" +
				"Puerto de llamado = " + controller.getPort_llamado() + "\n" +
				"Puerto de publicacion = " + controller.getPort_publicacion() + "\n" +
				"Puerto de entrada (server) = " + controller.getPort_server_entrada() + "\n" +
				"Puerto de salida (server) = " + controller.getPort_server_salida() + "\n" +
				"Puerto de monitor = " + controller.getPort_monitor() + "\n"
				
				);
		controller.listen(); //activa los hilos del server para comunicaciones
		controller.heartbeat(); //envia un pulso al monitor para demostrar que esta activo
	}

}
