package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import interfaces.Bienvenue;

public class ClientRMI {

	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost", 4444);
			Bienvenue bienvenueService = (Bienvenue)registry.lookup("BienvenueService");
			
			String nomUtilisateur = new String();
			Scanner scn = new Scanner(System.in);
			System.out.print("Donner votre nom: ");
			nomUtilisateur = scn.nextLine();
			System.out.println(bienvenueService.direBonjour(nomUtilisateur));
			scn.close();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		catch (NotBoundException e) {
			e.printStackTrace();
		}

	}

}
