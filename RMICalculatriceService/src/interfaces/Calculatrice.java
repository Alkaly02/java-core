package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculatrice extends Remote {
	public int addition(int a, int b) throws RemoteException;
	public int soustraction(int a, int b) throws RemoteException;
	public int multiplication(int a, int b) throws RemoteException;
	public int division(int a, int b) throws RemoteException, Exception;
}
