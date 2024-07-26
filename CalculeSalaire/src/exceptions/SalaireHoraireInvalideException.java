package exceptions;

public class SalaireHoraireInvalideException extends Exception {
	public SalaireHoraireInvalideException(String msg) {
		super(msg);
	}
	
	public String getMessage() {
		return super.getMessage();
	}
}
