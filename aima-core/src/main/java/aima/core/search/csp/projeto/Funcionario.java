package aima.core.search.csp.projeto;

import java.util.ArrayList;

//Classe funcionário, temos o nome do funcionário e a quantidade de horas que ele deve trabalhar.
public class Funcionario {
	//Nome do funcionário
	private String nome;
	//Quantidade de horas que ele deve trabalhar
	private Double horas;
	// Se o funcionario foi vacinado ou nao
	private boolean vacinado;
	private ArrayList<String> funcionariosPrioritarios;
	//Construtores
	
	// Construtor da variante normal
	public Funcionario(String nome, Double horas) {
		super();
		this.nome = nome;
		this.horas = horas;
	}
	
	// Construtor da variante da prioridade de trabalho
	public Funcionario(String nome, Double horas, ArrayList<String> funcionariosPrioritarios) {
		super();
		this.nome = nome;
		this.horas = horas;
		this.funcionariosPrioritarios = funcionariosPrioritarios;
	}
	
	// Construtor da variante do novo normal
	public Funcionario(String nome, Double horas, boolean vacinado) {
		super();
		this.nome = nome;
		this.horas = horas;
		this.vacinado = vacinado;
	}

	
	//Métodos Públicos
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getHoras() {
		return horas;
	}

	public void setHoras(Double horas) {
		this.horas = horas;
	}
	
	public boolean isVacinado() {
		return vacinado;
	}

	public void setVacinado(boolean vacinado) {
		this.vacinado = vacinado;
	}
	
	public ArrayList<String> getFuncionariosPrioritarios() {
		return funcionariosPrioritarios;
	}

	public void setFuncionariosPrioritarios(ArrayList<String> funcionariosPrioritarios) {
		this.funcionariosPrioritarios = funcionariosPrioritarios;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", horas=" + horas + "]";
	}
	
}
