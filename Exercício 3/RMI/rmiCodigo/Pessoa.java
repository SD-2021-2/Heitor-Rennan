package rmiCodigo;

import java.util.*;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Pessoa implements Serializable {
	String nome = "";
	String cargo = "";
	Float salario = 0F;
	int idade = 0;
	String sexo = "";
	Double altura = 0.0;
	Double peso = 0.0;
	boolean maioridade = false;
	boolean aprovado = false;
	Double n1 = 0.0;
	Double n2 = 0.0;
	Double n3 = 0.0;
	String categoria = "";

	public Pessoa() {

	}

	public Pessoa(String nome, String cargo, Float salario) {
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCategoria() {
		return nome;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	public boolean getMaioridade() {
		return maioridade;
	}

	public void setMaioridade(boolean maioridade) {
		this.maioridade = maioridade;
	}

	public boolean getAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	public Double getN1() {
		return n1;
	}

	public void setN1(Double n1) {
		this.n1 = n1;
	}

	public Double getN2() {
		return n2;
	}

	public void setN2(Double n2) {
		this.n2 = n2;
	}

	public Double getN3() {
		return n3;
	}

	public void setN3(Double n3) {
		this.n3 = n3;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
}