package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerRmi {
	
//	creer une interface qui etand de Remote
//	Creer une classe qui implemente l'interface en etandant en meme temps la class UnicastRemoteObject
//	On cree une instance de la classe implementee
//	On enregistre l'instance dans le registre en lui attribuant un nom en utilisant la methode rebind de registry

	public static void main(String[] args) {
		try {
			CalculatriceImpl calculatrice = new CalculatriceImpl();
			Registry registry = LocateRegistry.createRegistry(5555);
			registry.rebind("CalculatriceService", calculatrice);
			System.out.print("En attente du client");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
