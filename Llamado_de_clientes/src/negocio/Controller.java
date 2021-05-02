package negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Box;
import modelo.Cliente;
import vista.GUI_Box;

public class Controller implements ActionListener{

	private static Controller instance = null;
	private GUI_Box ventana;
	private Socket_Llamado socketLlamado = new Socket_Llamado();
	
	//constructor privado por patrón Singleton
	private Controller() {
		this.ventana = new GUI_Box("1");
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
		if(e.getActionCommand().equals("Proximo")) {
			Box box = new Box(Integer.parseInt((String)e.getSource()));
			Cliente cliente = (Cliente) this.socketLlamado.getCliente(box);
			this.ventana.mostrarCliente(cliente);
		}
	}
	
	
}
