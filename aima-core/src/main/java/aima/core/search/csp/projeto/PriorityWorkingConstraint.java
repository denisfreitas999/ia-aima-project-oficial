package aima.core.search.csp.projeto;

import java.util.ArrayList;
import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Variable;

public class PriorityWorkingConstraint implements Constraint<Variable, Double> {
	//Variável 1
	private Variable var1;
	//Variável 2
	private Variable var2;
	//Escopo com as duas variáveis
	private List<Variable> scope;
	//Construtor
	public PriorityWorkingConstraint(Variable var1, Variable var2) {
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
		Double value2 = assignment.getValue(var2);
		if(value1 == null && value2 == null) return true;
		if(value1 == value2) return false;
		if(value1 != null) {
			for(Variable var : assignment.getVariables()) {
				String nameVar = var.getName().substring(0, var.getName().length() - 1);
				if(var1.getFuncionariosPrioritarios().contains(nameVar))
					if(assignment.getValue(var) > value1) return false;	
			}
			if(var1.getHorarios().contains(value1) && value2 == null) return true;
		}
		if(value2 != null) {
			for(Variable var : assignment.getVariables()) {
				String nameVar = var.getName().substring(0, var.getName().length() - 1);
				if(var2.getFuncionariosPrioritarios().contains(nameVar))
					if(assignment.getValue(var2) > value2) return false;	
			}
			if(var2.getHorarios().contains(value2) && value1 == null) return true;
		}
		if(var1.getHorarios().contains(value1) && var2.getHorarios().contains(value2)) return true;
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