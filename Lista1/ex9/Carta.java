/*
 * Carta.java
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Carta extends Remote {
    String nome() throws RemoteException;
}
