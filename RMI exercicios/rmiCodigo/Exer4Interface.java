package rmiCodigo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Exer4Interface extends Remote {
	public Pessoa pesoIdeal(Pessoa pessoa) throws RemoteException;
}