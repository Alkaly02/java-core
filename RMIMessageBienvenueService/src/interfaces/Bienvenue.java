package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Bienvenue extends Remote {
	public String direBonjour(String nom) throws RemoteException;
}
