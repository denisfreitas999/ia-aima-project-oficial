package aima.core.search.csp.projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.CSP;
import aima.core.search.csp.Variable;
import aima.core.search.csp.solver.CspHeuristics;
import aima.core.search.csp.solver.CspListener;
import aima.core.search.csp.solver.CspSolver;
import aima.core.search.csp.solver.FlexibleBacktrackingSolver;
import aima.core.search.csp.solver.inference.AC3Strategy;

//Classe demo, classe principal e executável do projeto.
public class demo {
	
	public static void main(String[] args) {
		//Criação dos funcionários
		Funcionario alicefunc = new Funcionario("Alice", 2.0, true);
		Funcionario bobfunc = new Funcionario("Bob", 3.0, false);
		Funcionario charliefunc = new Funcionario("Charlie", 1.0, true);
		Funcionario davidfunc = new Funcionario("David", 2.0, false);
		Funcionario evefunc = new Funcionario("Eve", 4.0, false);
		
		//Criação dos domínios
		//-------------------------------------------------------------
		ArrayList<Double> alicehorarios = new ArrayList<Double>();
		alicehorarios.add(4.0);
		alicehorarios.add(13.0);
		alicehorarios.add(19.0);
		alicehorarios.add(21.0);
		alicehorarios.add(22.0);;
		
		Dominio alicedomain = new Dominio(alicefunc, alicehorarios);
		//-------------------------------------------------------------
		//-------------------------------------------------------------
		ArrayList<Double> bobhorarios = new ArrayList<Double>();
		bobhorarios.add(6.0);
		bobhorarios.add(9.0);
		bobhorarios.add(10.0);
		bobhorarios.add(14.0);
		bobhorarios.add(15.0);
		bobhorarios.add(21.0);
		
		Dominio bobdomain = new Dominio(bobfunc, bobhorarios);
		//-------------------------------------------------------------
		//-------------------------------------------------------------
		ArrayList<Double> charliehorarios = new ArrayList<Double>();
		charliehorarios.add(5.0);
		charliehorarios.add(8.0);
		charliehorarios.add(10.0);
		charliehorarios.add(13.0);
		charliehorarios.add(14.0);
		charliehorarios.add(21.0);
		charliehorarios.add(22.0);
		charliehorarios.add(23.0);
		
		Dominio charliedomain = new Dominio(charliefunc, charliehorarios);
		//-------------------------------------------------------------
		//-------------------------------------------------------------
		ArrayList<Double> davidhorarios = new ArrayList<Double>();
		davidhorarios.add(1.0);
		davidhorarios.add(3.0);
		davidhorarios.add(4.0);
		davidhorarios.add(5.0);
		davidhorarios.add(6.0);
		davidhorarios.add(7.0);
		davidhorarios.add(19.0);
		davidhorarios.add(23.0);
		
		Dominio daviddomain = new Dominio(davidfunc, davidhorarios);
		//-------------------------------------------------------------
		//-------------------------------------------------------------
		ArrayList<Double> evehorarios = new ArrayList<Double>();
		evehorarios.add(2.0);
		evehorarios.add(4.0);
		evehorarios.add(7.0);
		evehorarios.add(10.0);
		evehorarios.add(11.0);
		evehorarios.add(13.0);
		evehorarios.add(14.0);
		evehorarios.add(15.0);
		evehorarios.add(18.0);
		evehorarios.add(21.0);
		
		Dominio evedomain = new Dominio(evefunc, evehorarios);
		//-------------------------------------------------------------
		//-------------------------------------------------------------
		
		//Adição dos domínios a Lista
		Lista lista = new Lista(1);
		lista.setDomain(alicedomain);
		lista.setDomain(bobdomain);
		lista.setDomain(charliedomain);
		lista.setDomain(daviddomain);
		lista.setDomain(evedomain);
		
		//Testando toString da matriz com adição dos funcionários nos horários que serão escolhidos pelo CSP.
		/*CasoTeste1 teste1 = new CasoTeste1();
		//Alice
		teste1.setFuncionario(0, 1, alicefunc, 13.0);
		teste1.setFuncionario(6, 1, alicefunc, 19.0);
		
		//Bob
		teste1.setFuncionario(5, 0, bobfunc, 6.0);
		teste1.setFuncionario(8, 0, bobfunc, 9.0);
		teste1.setFuncionario(9, 0, bobfunc, 10.0);
		
		//Charlie
		teste1.setFuncionario(4, 0, charliefunc, 5.0);
		
		//David
		teste1.setFuncionario(0, 0, davidfunc, 1.0);
		teste1.setFuncionario(2, 0, davidfunc, 3.0);
		
		//Eve
		teste1.setFuncionario(1, 0, evefunc, 2.0);
		teste1.setFuncionario(3, 0, evefunc, 4.0);
		teste1.setFuncionario(10, 0, evefunc, 11.0);
		teste1.setFuncionario(5, 1, evefunc, 18.0);
		
		System.out.println(teste1.toString());*/
		
		//Criação do csp e iniciação do DailyMapCSP
		CSP<Variable, Double> csp = new DailyMapCSP(lista);
		
		//Criação do caso de teste
		CasoTeste1 teste = new CasoTeste1();
		
		CspListener.StepCounter<Variable, Double> stepCounter = new CspListener.StepCounter<>();
		CspSolver<Variable, Double> solver;
		Optional<Assignment<Variable, Double>> solution;
		
		solver = new FlexibleBacktrackingSolver<Variable, Double>().set(new AC3Strategy<>()).set(CspHeuristics.lcv());
		//solver = new FlexibleBacktrackingSolver<Variable, Double>().set(new AC3Strategy<>()).set(CspHeuristics.mrv()).set(CspHeuristics.lcv());
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println(Cores.ANSI_GREEN+ "############# Execucão #############" + Cores.ANSI_RESET);
		System.out.println("Caso de Teste 1");
		solution = solver.solve(csp);
		System.out.println(stepCounter.getResults() + "\n");
		try {
			Assignment<Variable, Double> solucao = solution.get();
			List<Variable> variaveis = solucao.getVariables();
			String[] funcionarios = new String[24];
			switch(lista.getVariante()) {
				case 3:
					for(int i = 0; i < funcionarios.length; i++) 
						funcionarios[i] = "";
					for(Variable var : variaveis)
						funcionarios[solucao.getValue(var).intValue()] += var.getName().substring(0, var.getName().length() - 1) + " ";
					for(int i = 0; i < funcionarios.length; i++) 
						if(funcionarios[i] != null)
							teste.setFuncionario(funcionarios[i], (double) i);
					break;
				default:
					for(Variable var : variaveis) {
						funcionarios[solucao.getValue(var).intValue()] = var.getName().substring(0, var.getName().length() - 1);
						teste.setFuncionario(var.getName().substring(0, var.getName().length() - 1), solucao.getValue(var));
					}
					break;
			}
			
				//Teste preliminar
				 
				/*for(int i = 0; i < 24; i++) {
					System.out.println(i + ":00. Funcionario: " + funcionarios[i]);
				}*/
				
			System.out.println(teste.toString());
		}
		catch(NoSuchElementException e){
			System.out.println("O CSP não possui solução!\n");
		}
	}
}