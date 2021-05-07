package negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dominio.Box;
import dominio.Turno;
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
			Turno turno = (Turno) this.socketLlamado.getTurno(box);
			
			
			if(turno != null) {
				this.ventana.mostrarCliente(turno.getCliente().getDni()); //paso el dni a la ventana para publicar
			}else {
				this.ventana.mostrarCliente("No hay clientes en espera");
			}
			
		}
	}
	
	
}
