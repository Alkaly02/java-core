package server;

import interfaces.Bienvenue;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BonjourImpl extends UnicastRemoteObject implements Bienvenue {
	private static final long serialVersionUID = 1L;

	public BonjourImpl() throws RemoteException {
		super();
	}
	
	@Override
	public String direBonjour(String nom) {
		return "Bonjour "+nom;
	}
}
