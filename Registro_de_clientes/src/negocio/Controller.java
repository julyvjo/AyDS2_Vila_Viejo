package negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import factory.ClienteFactory;
import modelo.Cliente;
import vista.GUI_Registro;

public class Controller implements ActionListener{

	private static Controller instance = null;
	private GUI_Registro ventana;
	private Socket_Registro socketRegistro = new Socket_Registro();
	
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
		
		String dni = (String) e.getSource(); //el evento e trae el dni por parametro
		Cliente cliente = ClienteFactory.getCliente(dni);
		this.socketRegistro.agregarCliente(cliente);
	}
	
}
