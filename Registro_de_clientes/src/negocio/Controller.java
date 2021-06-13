package negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import persistencia.AdapterClientes_txt;
import persistencia.IAdapterClientes;
import dominio.Cliente;
import vista.GUI_Registro;

public class Controller implements ActionListener{

	private static Controller instance = null;
	private GUI_Registro ventana;
	private Socket_Registro socketRegistro = new Socket_Registro();
	private IAdapterClientes adapter;
	
	//constructor privado por patrón Singleton
	private Controller() {
		this.ventana = new GUI_Registro();
		this.ventana.setActionListener(this);
		this.adapter = new AdapterClientes_txt();
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
		
		Cliente cliente = this.buscarCliente(dni);
		
		if(cliente != null) {
			this.socketRegistro.agregarCliente(cliente);
			this.ventana.mensajeRegistroExitoso();
		}
		else
			this.ventana.mensajeFalloRegistro();;
		
	}
	
	public Cliente buscarCliente(String dni) {
		
		Cliente cliente = this.adapter.readCliente(dni);
		
		return cliente;		
		
	}
	
}
