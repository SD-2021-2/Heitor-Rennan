package rmiCodigo;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;

public class ExerImpl extends UnicastRemoteObject implements ExerInterface {
    
    public ExerImpl() throws RemoteException{
        super();
    }

    @Override
	public Pessoa ajusteSalarial(Pessoa pessoa) {

		System.out.print("\nAjustando salario...");

		switch(pessoa.getCargo()) {
			case "operador" :
				pessoa.setSalario(pessoa.getSalario() + pessoa.getSalario() * 0.20F);
				break;
			case "programador" :
				pessoa.setSalario(pessoa.getSalario() + pessoa.getSalario() * 0.18F);
				break;
		}

		System.out.print("\nSalario Reajustado... Nome: " + pessoa.getNome() + " - Cargo: " + pessoa.getCargo());
		
		return pessoa;
	}
}