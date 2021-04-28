package negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Cliente;
import vista.GUI_Registro;

public class Controller implements ActionListener{

	private static Controller instance = null;
	private GUI_Registro ventana;
	
	//constructor privado por patrón Singleton
	private Controller() {
		this.ventana = new GUI_Registro();
		this.ventana.setActionListener(this);
	}
	
	//patron Singleton
	public static Controller getInstance() {
		if(instance == null) {
			instance = new Controller();
		}
		return instance;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.consultaInput();
	}

	public void consultaInput() {
		String dni = this.ventana.getInput();
		this.agregarCliente(dni);
	}
	
	public void agregarCliente(String dni) {
		Cliente cliente = new Cliente(dni);
		//Pasarlo al controller de coordinacion
		
		System.out.println(cliente.getDni());
	}
	
}
