package rmiCodigo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ExerInterface extends Remote {
	public Pessoa ajusteSalarial(Pessoa pessoa) throws RemoteException;
}