/*
 * Server.java
 */

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject
                    implements Pessoa {
   private String nome;
   private String sexo;
   private double idade;

  public Server() throws RemoteException {
       super();
  }
	
   
   
   public boolean maiorDeIdade(String nome, String sexo,double idade){
	   System.out.println(nome+sexo+idade);
	   double base = 18.0;
	    
	   if (sexo.compareTo("feminino")== 0){
		   base = 21.0;
	   }
	   return (idade >= base);
   } 
   

    public static void main(String args[]) {

        try {
          Pessoa obj = new Server();
          Registry registry = LocateRegistry.getRegistry("localhost");
	      registry.rebind("Pessoa", obj);
	      System.out.println("Pessoa bound in registry");
        } catch (Exception e) {
	      System.out.println("Pessoa Server err: " + e.getMessage());
	      e.printStackTrace();
        }
    }
}
