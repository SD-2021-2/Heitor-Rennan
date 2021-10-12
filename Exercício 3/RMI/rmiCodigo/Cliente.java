package rmiCodigo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.*;
import java.util.Scanner;

public class Cliente {

	private static ExerInterface exerInterface;
	private static Exer2Interface exer2Interface;
	private static Exer3Interface exer3Interface;
	private static Exer4Interface exer4Interface;
	private static Exer5Interface exer5Interface;

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		Scanner sc = new Scanner(System.in);

		//Escolher o exercicio da lista		
		while(true) {
			System.out.print("\n");
			System.out.print("Exercicio da lista: ");
			int exercicio = sc.nextInt();

			//Pegar informacoes do funcionario
			Pessoa pessoa = infos(exercicio);

			//Chamada para o servico
			switch(exercicio) {
				case 1:
					pessoa = servicoReajusteSalarial(pessoa, exerInterface);

					System.out.print("\n\nNome: " + pessoa.getNome() + "\nSalario: " + pessoa.getSalario());
					break;
				case 2:
					pessoa = servicoMaioridade(pessoa, exer2Interface);				

					if (pessoa.getMaioridade()) {
						System.out.print("\n" + pessoa.getNome() + " eh de maioridade");
					} else {
						System.out.print("\n" + pessoa.getNome() + " nao eh de maioridade");
					}
					
					break;
				case 3:
					pessoa = servicoMedia(pessoa, exer3Interface);				

					if (pessoa.getAprovado()) {
						System.out.print("\n" + pessoa.getNome() + " foi aprovado(a).");
					} else {
						System.out.print("\n" + pessoa.getNome() + " foi reprovado(a).");
					}
					
					break;
				case 4:
					pessoa = servicoPesoIdeal(pessoa, exer4Interface);				

					System.out.print("\n Peso ideal: " + pessoa.getPeso());
					
					break;
				case 5:
					pessoa = servicoCategoria(pessoa, exer5Interface);				

					System.out.print("\n Categoria: " + pessoa.getCategoria() + ".");
					
					break;
			}
		}
		
	}

	//Fazer chamada para os servicos
	public static Pessoa servicoReajusteSalarial(Pessoa pessoa, ExerInterface exerInterface) throws MalformedURLException, RemoteException, NotBoundException{
		exerInterface = (ExerInterface) Naming.lookup("ReajusteSalarial");
		pessoa = exerInterface.ajusteSalarial(pessoa);

		return pessoa;
	}

	public static Pessoa servicoMaioridade(Pessoa pessoa, Exer2Interface exer2Interface) throws MalformedURLException, RemoteException, NotBoundException{
		exer2Interface = (Exer2Interface) Naming.lookup("Maioridade");
		pessoa = exer2Interface.maioridade(pessoa);

		return pessoa;
	}

	public static Pessoa servicoMedia(Pessoa pessoa, Exer3Interface exer3Interface) throws MalformedURLException, RemoteException, NotBoundException{
		exer3Interface = (Exer3Interface) Naming.lookup("Media");
		pessoa = exer3Interface.media(pessoa);

		return pessoa;
	}

	public static Pessoa servicoPesoIdeal(Pessoa pessoa, Exer4Interface exer4Interface) throws MalformedURLException, RemoteException, NotBoundException{
		exer4Interface = (Exer4Interface) Naming.lookup("PesoIdeal");
		pessoa = exer4Interface.pesoIdeal(pessoa);

		return pessoa;
	}

	public static Pessoa servicoCategoria(Pessoa pessoa, Exer5Interface exer5Interface) throws MalformedURLException, RemoteException, NotBoundException{
		exer5Interface = (Exer5Interface) Naming.lookup("Categoria");
		pessoa = exer5Interface.categoria(pessoa);

		return pessoa;
	}

	//Pegar informações do usuario na tela
	public static Pessoa infos(int exercicio) {
		Pessoa pessoa = new Pessoa();
		Scanner sc = new Scanner(System.in);

		switch(exercicio) {
			//exercicio 1
			case 1:
				System.out.print("Nome: ");
				String nome = sc.nextLine();
				pessoa.setNome(nome);

				System.out.print("Cargo: ");
				String cargo = sc.nextLine();
				pessoa.setCargo(cargo);

				System.out.print("Salario: ");
				float salario = sc.nextFloat();
				pessoa.setSalario(salario);
				break;

			//exercicio 2
			case 2:
				System.out.print("Nome: ");
				String nome2 = sc.nextLine();
				pessoa.setNome(nome2);
				
				System.out.print("Sexo: ");
				String sexo = sc.nextLine();
				pessoa.setSexo(sexo);

				System.out.print("Idade: ");
				int idade = sc.nextInt();
				pessoa.setIdade(idade);
				break;

			//exercicio 3
			case 3:
				System.out.print("N1: ");
				Double n1 = sc.nextDouble();
				pessoa.setN1(n1);

				System.out.print("N2: ");
				Double n2 = sc.nextDouble();
				pessoa.setN2(n2);

				System.out.print("N3: ");
				Double n3 = sc.nextDouble();
				pessoa.setN3(n3);
				break;

			//exercicio 4
			case 4:
				System.out.print("Sexo: ");
				String sexo2 = sc.nextLine();
				pessoa.setSexo(sexo2);

				System.out.print("Altura: ");
				Double altura = sc.nextDouble();
				pessoa.setAltura(altura);
				break;

			//exercicio 5
			case 5:
				System.out.print("Idade: ");
				int idade5 = sc.nextInt();
				pessoa.setIdade(idade5);
				break;
		}

		return pessoa;
	}
}
