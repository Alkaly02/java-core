package exceptions;

public class NombreHeuresInvalideException extends Exception {
	public String getMessage() {
		return "Veuillez fournir un salaire superieur a 0";
	}
}
