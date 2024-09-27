package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class CalculatriceServer {
//	Registry
	public static void main(String[] args) {
		try {
			CalculatriceImpl calculatriceService = new CalculatriceImpl();
			Registry registry = LocateRegistry.createRegistry(3333);
			registry.rebind("CalculatriceService", calculatriceService);
			System.out.println("En attente");
			}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
