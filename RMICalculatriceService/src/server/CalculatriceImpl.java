package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import interfaces.Calculatrice;

public class CalculatriceImpl extends UnicastRemoteObject implements Calculatrice{
	private static final long serialVersionUID = 1L;

	public CalculatriceImpl() throws RemoteException {
		super();
	}

	@Override
	public int addition(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public int soustraction(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public int multiplication(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public int division(int a, int b) throws RemoteException, Exception {
		// TODO Auto-generated method stub
		if(b==0) {
			throw new Exception("Division impossible");
		}
		return a/b;
	}

}