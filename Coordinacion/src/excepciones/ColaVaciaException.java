package excepciones;

public class ColaVaciaException extends Exception{

	private String mensaje;

	public ColaVaciaException(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}
	
}
