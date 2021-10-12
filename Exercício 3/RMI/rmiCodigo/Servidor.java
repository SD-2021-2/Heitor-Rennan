package rmiCodigo;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Servidor {

	private Pessoa pessoa;

	public void Servidor() throws RemoteException{
	}

	public static void main(String[] args){
		try {

			ExerImpl ExerImpl = new ExerImpl();
			Exer2Impl Exer2Impl = new Exer2Impl();
			Exer3Impl Exer3Impl = new Exer3Impl();
			Exer4Impl Exer4Impl = new Exer4Impl();
			Exer5Impl Exer5Impl = new Exer5Impl();

			Naming.bind("ReajusteSalarial", ExerImpl); 
			Naming.bind("Maioridade", Exer2Impl);
			Naming.bind("Media", Exer3Impl);
			Naming.bind("PesoIdeal", Exer4Impl);
			Naming.bind("Categoria", Exer5Impl);

            System.err.println("Servidor pronto... esperando...");
            
        } catch (Exception e) {
        	System.err.println("Erro: " + e.toString());
          e.printStackTrace();
        }
	}
}
