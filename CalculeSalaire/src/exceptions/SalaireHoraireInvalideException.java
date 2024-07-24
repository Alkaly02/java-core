package exceptions;

public class SalaireHoraireInvalideException extends Exception {
	private String msg;
	public SalaireHoraireInvalideException(String msg) {
		this.msg = msg;
	}
	
	public String getMessage() {
		return super.getMessage();
	}
}
