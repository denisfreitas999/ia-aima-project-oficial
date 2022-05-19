package aima.core.search.csp.projeto;

import java.util.ArrayList;
import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Variable;

//Classe Restricao, contém a restrição que verifica se determinado horário está contido no domínio de horários preferíveis de um
//funcionário
public class ValidaHorarioConstraint implements Constraint<Variable, Double> {
	//Variável 1
	private Variable var1;
	//Variável 2
	private Variable var2;
	//Escopo com as duas variáveis
	private List<Variable> scope;
	//Construtor
	public ValidaHorarioConstraint(Variable var1, Variable var2) {
		this.var1 = var1;
		this.var2 = var2;
		scope = new ArrayList<Variable>(2);
		scope.add(var1);
		scope.add(var2);	
	}
	
	//Método que verifica e valida a restrição
	@Override
	public boolean isSatisfiedWith(Assignment<Variable, Double> assignment) {
		Double value1 = assignment.getValue(var1);
		if(var1.getHorarios().contains(value1)) return true;
		return false;
		
	}

	//Métodos Públicos
	@Override
	public List<Variable> getScope() {
		return scope;
	}
	
	public Variable getVar1() {
		return var1;
	}


	public void setVar1(Variable var1) {
		this.var1 = var1;
	}


	public Variable getVar2() {
		return var2;
	}


	public void setVar2(Variable var2) {
		this.var2 = var2;
	}

	public void setScope(List<Variable> scope) {
		this.scope = scope;
	}
}
