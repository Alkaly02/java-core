package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import interfaces.Bienvenue;

public class ServerRmi {
	public static void main(String[] args) {
		try {
			Bienvenue bienvenue = new BonjourImpl();
			Registry registry = LocateRegistry.createRegistry(4444);
			registry.rebind("BienvenueService", bienvenue);
		}catch(RemoteException e) {
			e.printStackTrace();
		}
	}
}
