package rmiCodigo;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;

public class Exer5Impl extends UnicastRemoteObject implements Exer5Interface {
    
    public Exer5Impl() throws RemoteException{
        super();
    }

    @Override
	public Pessoa categoria(Pessoa pessoa) {

		System.out.print("\nVerificando categoria...");

		if (pessoa.getIdade() >= 5 && pessoa.getIdade() <= 7) {
			pessoa.setCategoria("infantil A");
		}

		if (pessoa.getIdade() >= 8 && pessoa.getIdade() <= 10) {
			pessoa.setCategoria("infantil B");
		}

		if (pessoa.getIdade() >= 11 && pessoa.getIdade() <= 13) {
			pessoa.setCategoria("juvenil A");
		}

		if (pessoa.getIdade() >= 14 && pessoa.getIdade() <= 17) {
			pessoa.setCategoria("juvenil B");
		}

		if (pessoa.getIdade() >= 18) {
			pessoa.setCategoria("adulto");
		}

		System.out.print("\n Categoria verificada... Categoria: " + pessoa.getCategoria());
		return pessoa;
	}
}