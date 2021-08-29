/*
 * CreditoServer.java
 */

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;

public class CreditoServer extends UnicastRemoteObject
                    implements CreditoHome {
   private double saldo;

  public CreditoServer() throws RemoteException {
       super();
  }

   public void setSaldo(double saldo) {
       this.saldo = saldo;
   }

   public double calculaCredito() {
       double credito = 0.0;

       if ( this.saldo >= 0  && this.saldo <= 200 )
          credito = 0.0;
       else if ( this.saldo >= 201  && this.saldo <= 400 )
          credito = this.saldo * 0.2;
       else if ( this.saldo >= 401  && this.saldo <= 600 )
          credito = this.saldo * 0.3;
       else if ( this.saldo >= 601 )
          credito = this.saldo * 0.4;
       return credito;
   }

    public static void main(String args[]) {

        try {
          CreditoHome obj = new CreditoServer();
	    // Bind this object instance to the name "Cliente"
	    Naming.rebind("//localhost/CreditoHome", obj);
	    System.out.println("CreditoServer bound in registry");
        } catch (Exception e) {
	    System.out.println("CreditoServer err: " + e.getMessage());
	    e.printStackTrace();
        }
    }
}
