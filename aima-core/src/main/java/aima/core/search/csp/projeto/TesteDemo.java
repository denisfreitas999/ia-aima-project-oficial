package aima.core.search.csp.projeto;

import java.util.ArrayList;
import java.util.Optional;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.CSP;
import aima.core.search.csp.Variable;
import aima.core.search.csp.solver.inference.*;
import aima.core.search.csp.solver.*;


public class TesteDemo {
	
	public static void main(String[] args) {
		
		//Criação dos funcionários
		Funcionario alicefunc = new Funcionario("Alice", 2.0);
		Funcionario bobfunc = new Funcionario("Bob", 3.0);
		Funcionario charliefunc = new Funcionario("Charlie", 1.0);
		Funcionario davidfunc = new Funcionario("David", 2.0);
		Funcionario evefunc = new Funcionario("Eve", 4.0);
		
		//Criação dos domínios
		//-------------------------------------------------------------
		ArrayList<Double> alicehorarios = new ArrayList<Double>();
		alicehorarios.add(4.0);
		alicehorarios.add(13.0);
		alicehorarios.add(19.0);
		alicehorarios.add(21.0);
		alicehorarios.add(22.0);
		
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
		
		//Criação do csp e iniciação do DailyMapCSP
		CSP<Variable, Double> csp = new DailyMapCSP(lista);
		
		//Criação do caso de teste
		CasoTeste1 teste = new CasoTeste1();

		CspListener.StepCounter<Variable, Double> stepCounter = new CspListener.StepCounter<>();
		CspSolver<Variable, Double> solver;
		Optional<Assignment<Variable, Double>> solution;
		
		System.out.println(Cores.ANSI_BLUE + "############# Execucão #############" + Cores.ANSI_RESET);
		
		solver = new MinConflictsSolver<>(1000);
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println(Cores.ANSI_GREEN + "DailyMapCSP (Minimum Conflicts)" + Cores.ANSI_RESET);
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");
		
		solver = new FlexibleBacktrackingSolver<Variable, Double>().set(new AC3Strategy<>());
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println(Cores.ANSI_GREEN + "DailyMapCSP (Backtracking) AC3" + Cores.ANSI_RESET);
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");
		
		solver = new FlexibleBacktrackingSolver<Variable, Double>().set(new AC3Strategy<>()).set(CspHeuristics.lcv());
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println(Cores.ANSI_GREEN + "DailyMapCSP (Backtracking) AC3 + Lcv" + Cores.ANSI_RESET);
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");
		
		solver = new FlexibleBacktrackingSolver<Variable, Double>().set(new AC3Strategy<>()).set(CspHeuristics.mrv()).set(CspHeuristics.lcv());
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println(Cores.ANSI_GREEN + "DailyMapCSP (Backtracking) AC3 + MRV + Lcv" + Cores.ANSI_RESET);
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");
		
		solver = new FlexibleBacktrackingSolver<Variable,Double>().set(new AC3Strategy<>()).set(CspHeuristics.mrv()).set(CspHeuristics.lcv()).set(CspHeuristics.deg());
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println(Cores.ANSI_GREEN + "DailyMapCSP (Backtracking) AC3 + MRV + LCV + DEG" + Cores.ANSI_RESET);
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");
	}
}
