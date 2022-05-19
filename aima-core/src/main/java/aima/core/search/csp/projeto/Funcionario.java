package aima.core.search.csp.projeto;	

//Classe funcionário, temos o nome do funcionário e a quantidade de horas que ele deve trabalhar.
public class Funcionario {
	//Nome do funcionário
	private String nome;
	//Quantidade de horas que ele deve trabalhar
	private Double horas;
	
	//Construtor
	public Funcionario(String nome, Double horas) {
		super();
		this.nome = nome;
		this.horas = horas;
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

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", horas=" + horas + "]";
	}
}
