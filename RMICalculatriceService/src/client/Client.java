package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import interfaces.Calculatrice;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Registry registry = LocateRegistry.getRegistry("localhost",3333);
			Calculatrice calculatrice = (Calculatrice)registry.lookup("CalculatriceService");
			
			calculatrice.addition(2, 5);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
