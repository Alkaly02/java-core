package exceptions;

public class NomUtilisateurInvalideException extends Exception {
	public String getMessage() {
		return "Nom utilsateur incorrecte";
	}
}
