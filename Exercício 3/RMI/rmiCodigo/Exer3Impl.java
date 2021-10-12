package rmiCodigo;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;

public class Exer3Impl extends UnicastRemoteObject implements Exer3Interface {
    
    public Exer3Impl() throws RemoteException{
        super();
    }

    @Override
	public Pessoa media(Pessoa pessoa) {

		System.out.print("\nVerificando notas...");

		Double m = ( pessoa.getN1() + pessoa.getN2() ) / 2;
		System.out.print(m);
		
		if (m >= 7.0) {
			pessoa.setAprovado(true);
			System.out.print("\nNotas verificadas... " + pessoa.getNome() + " aprovado(a).");
		} else if (m > 3.0 && m < 7.0) {
			m = ( m + pessoa.getN3() ) / 2;
			if (m >= 5.0) {
				pessoa.setAprovado(true);
				System.out.print("\nNotas verificadas... " + pessoa.getNome() + " aprovado(a).");
			}
		} else {
			System.out.print("\nNotas verificadas... " + pessoa.getNome() + " reprovado(a).");
		}

		return pessoa;
	}
}