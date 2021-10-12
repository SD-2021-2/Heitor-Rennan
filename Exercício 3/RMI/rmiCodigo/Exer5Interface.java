package rmiCodigo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Exer5Interface extends Remote {
	public Pessoa categoria(Pessoa pessoa) throws RemoteException;
}