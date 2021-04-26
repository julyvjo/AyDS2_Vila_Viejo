package negocio;

public class Controller {

	private static Controller instance = null;
	
	//patron Singleton
	public static Controller getInstance() {
		if(instance == null) {
			instance = new Controller();
		}
		return instance;
	}
	
}
