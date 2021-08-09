/*
 * Pessoa.java
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Pessoa extends Remote {
    boolean maiorDeIdade(String nome, String sexo,double idade) throws RemoteException;
    double pesoIdeal(String sexo,double altura)throws RemoteException;
}
