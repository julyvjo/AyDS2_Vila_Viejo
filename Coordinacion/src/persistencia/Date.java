package persistencia;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date {

	
	public static String getFechaYHoraActual() {
		String fyh = null;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        fyh = dtf.format(LocalDateTime.now());
		
		return fyh;
	}
	
}
