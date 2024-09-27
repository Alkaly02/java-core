package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import interfaces.Calculatrice;

public class ClientRMI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Registry registryClient = LocateRegistry.getRegistry("localhost", 5555);
			Calculatrice serviceCalculatrice = (Calculatrice)registryClient.lookup("CalculatriceService");
			
			 System.out.println("Addition 2+2: "+ serviceCalculatrice.addition(2, 2));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
