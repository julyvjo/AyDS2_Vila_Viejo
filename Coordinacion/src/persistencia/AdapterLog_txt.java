package persistencia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AdapterLog_txt implements IAdapterLog{

	@Override
	public void writeLog(String accion) { //log = { registro + cliente | llamado + cliente + box }
		
		try {
			  
            // Se abre el archivo en modo append.
            BufferedWriter out = new BufferedWriter( new FileWriter("log.txt", true) ); //filewriter -> append = true
            
            //obtener fecha y hora y sumarlo al log
            String log = null;// = fecha + hora + accion;
            
            out.write(log);
            out.close();
            
        }
        catch (IOException e) {
            System.out.println("excepcion IO" + e);
        }
		
		
		
	}

}
