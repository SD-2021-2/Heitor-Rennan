package rmiCodigo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Exer2Interface extends Remote {
	public Pessoa maioridade(Pessoa pessoa) throws RemoteException;
}