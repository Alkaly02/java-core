package services;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

interface Calculatrice extends Remote {
 	int addition(int a, int b) throws RemoteException;
 	int soustraction(int a, int b) throws RemoteException;
 	int multiplication(int a, int b) throws RemoteException;
 	int division(int a, int b) throws RemoteException, Exception;
}

public class CalculatriceImpl extends UnicastRemoteObject implements Calculatrice {
	
//	public CalculatriceImpl() {
//		super();
//	}
	
	public int addition(int a, int b) throws RemoteException {
		return a+b;
	}
	public int soustraction(int a, int b) throws RemoteException {
		return a-b;
	}
	public int multiplication(int a, int b) throws RemoteException {
		return a*b;
	}
	public int division(int a, int b) throws RemoteException,Exception {
		if(b==0) {
			throw new Exception("Division impossible");
		}
		return a/b;
	}
}