package aima.core.search.csp.projeto;

import java.util.ArrayList;

//Classe de Domínio, contém um Funcionário e os horários preferíveis deste funcionário.
public class Dominio  {
	//Objeto funcionário
	private Funcionario funcionario;
	
	//Lista com os horários preferíveis deste funcionário.
	private ArrayList<Double> horarios = new ArrayList<Double>();
	
	//Construtor
	public Dominio(Funcionario x, ArrayList<Double> y) {
		this.funcionario = x;
		this.horarios = y;
	}
	
	//Métodos Públicos
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public ArrayList<Double> getHorarios() {
		return horarios;
	}

	public void setHorarios(ArrayList<Double> horarios) {
		this.horarios = horarios;
	}
	
	@Override
	public String toString() {
		return "Dominio [funcionario=" + funcionario + ", horarios=" + horarios + "]";
	}
	
}