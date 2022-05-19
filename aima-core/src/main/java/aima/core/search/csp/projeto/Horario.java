package aima.core.search.csp.projeto;

//Classe Horário, contém a hora escolhida para o funcionario trabalhar e o nome do funcionário.
public class Horario {
	//Valor que representa a hora que o funcionário deve trabalhar
	private Double horas;
	//Nome do funcionário
	private String funcionario;
	
	//Métodos Públicos
	public Horario(Double horas) {
		this.horas = horas;
    }
	
	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}
	
	public Double getHoras() {
		return horas;
	}
	public String getFuncionario() {
		return funcionario;
		
	}
	public void setHoras(Double horas) {
			this.horas = horas;
	}

	@Override
	public String toString() {
		return "Horario [horas=" + horas + ", funcionario=" + funcionario + "]";
	}	
	
}
