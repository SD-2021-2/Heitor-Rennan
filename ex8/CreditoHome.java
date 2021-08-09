/*
 * CreditoHome.java
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CreditoHome extends Remote {
    double calculaCredito() throws RemoteException;
    void setSaldo(double saldo) throws RemoteException;
}
