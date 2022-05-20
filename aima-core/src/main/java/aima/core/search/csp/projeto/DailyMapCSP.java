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
						switch(lista.getVariante()) {
							case 1: // variante normal
								addVariable(new Variable(dominio.getFuncionario().getNome() + j, dominio.getHorarios()));
								break;
							
							case 2: //variante dependencia do funcionario
								addVariable(new Variable(dominio.getFuncionario().getNome() + j, dominio.getHorarios(), dominio.getFuncionario().getFuncionariosPrioritarios()));
								break;
							
							case 3: //variante nova normalidade
								addVariable(new Variable(dominio.getFuncionario().getNome() + j, dominio.getHorarios(), dominio.getFuncionario().isVacinado()));
								break;
							case 4: // variante restricao de horario
								addVariable(new Variable(dominio.getFuncionario().getNome() + j, dominio.getHorarios()));
								break;
						}
					}
					//Adição dos domínios
					if(lista.getVariante() == 4) {
						for(Double hour: dominio.getHorarios())
							if(!hours.contains(hour) && hour <= lista.getHorarioFuncionamento()[1] && hour >= lista.getHorarioFuncionamento()[0])
								hours.add(hour);
					}
					else
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
							switch(lista.getVariante()) {
								case 1: // variante normal
									addConstraint(new NotEqualConstraint<>(var1, var2));
									addConstraint(new ValidaHorarioConstraint(var1, var2));
									//addConstraint(new EarlyConstraint(var1, var2));
									break;
								
								case 2: //variante dependencia do funcionario
									addConstraint(new PriotityWorkingConstraint(var1, var2));
									break;
								
								case 3: //variante nova normalidade
									addConstraint(new NewNormalityConstraint(var1, var2));
									break;
								case 4: // variante restricao de horario
									addConstraint(new NotEqualConstraint<>(var1, var2));
									addConstraint(new ValidaHorarioConstraint(var1, var2));
									break;
							}
						}
					}
					contador++;
				}
			}
}

	

