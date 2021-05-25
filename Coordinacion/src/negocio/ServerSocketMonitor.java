package negocio;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketMonitor implements Runnable{

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000);						// manda un pulso cada 3 segundos
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.heartbeat(Controller.getInstance().getServer_id(), Controller.getInstance().getPort_monitor());
		}
	}
	
	public void heartbeat(int idServer, int port) {
		
		try {
			Socket socket = new Socket("localhost",port);
			
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			output.writeObject(idServer);	
			
			output.close();
			socket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
