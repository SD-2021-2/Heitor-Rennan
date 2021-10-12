package rmiCodigo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Exer3Interface extends Remote {
	public Pessoa media(Pessoa pessoa) throws RemoteException;
}