package rmiCodigo;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;

public class Exer4Impl extends UnicastRemoteObject implements Exer4Interface {
    
    public Exer4Impl() throws RemoteException{
        super();
    }

    @Override
	public Pessoa pesoIdeal(Pessoa pessoa) {

		System.out.print("\nVerificando peso ideal...");

		Double peso = 0.0;

		if (pessoa.getSexo().equals("masculino")) {
			peso = ( 72.7 * pessoa.getAltura() ) - 58.0;
		}

		if (pessoa.getSexo().equals("feminino")) {
			peso = ( 62.1 * pessoa.getAltura() ) - 44.7;
		}

		pessoa.setPeso(peso);

		System.out.print("\nPeso ideal verificada... " + "o peso e: " + peso);
		return pessoa;
	}
}