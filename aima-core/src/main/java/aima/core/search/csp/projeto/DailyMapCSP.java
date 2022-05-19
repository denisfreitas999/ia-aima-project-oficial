package aima.core.search.csp.projeto;

import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;
import java.util.ArrayList;

//Classe DailyMapCSP, aqui são preenchidas as listas com as variáveis, os domínios e as restrições do CSP
public class DailyMapCSP extends CSP<Variable, Double>{
	
	//Construtor
	public DailyMapCSP(Lista lista){
				//Criação e adição das variáveis
				int contador = 0;
				ArrayList<Double> hours = new ArrayList<>();
				for(Dominio dominio : lista.getLista()) {
					for(int j = 0; j < dominio.getFuncionario().getHoras(); j++) {
						addVariable(new Variable(dominio.getFuncionario().getNome() + j, dominio.getHorarios()));
					}
					//Adição dos domínios
					for(Double hour : dominio.getHorarios())
						if(!hours.contains(hour)) hours.add(hour);
				}
				Domain<Double> hoursDomain = new Domain<>(hours);
				for(Variable var : getVariables())
					setDomain(var, hoursDomain);
					//Criação e adição das restrições
					for(int i = 0; i < getVariables().size(); i++) {
					for(int c= contador; c < getVariables().size(); c++) {
						if(i != c) {
							Variable var1 = getVariables().get(i);
							Variable var2 = getVariables().get(c);
							addConstraint(new NotEqualConstraint<>(var1, var2));
							addConstraint(new Restricao(var1, var2));
							System.out.println("var1: " + var1 + ". Var2: " + var2);
						}
					}
					contador++;
				}
			}
}

	

