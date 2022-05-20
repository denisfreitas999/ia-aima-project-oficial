package aima.core.search.csp.projeto;

import java.util.ArrayList;

//Classe Lista, possui uma lista com todos os domínios
public class Lista {
	//Lista com todos os domínios do problema.
	private ArrayList<Dominio> lista = new ArrayList<Dominio>();
	private int variante;
	private int[] horarioFuncionamento = new int[2];
	
	public Lista(int variante) {
		this.variante = variante;
	}
	
	public Lista(int variante, int horarioInicio, int horarioFim) {
		this.variante = variante;
		horarioFuncionamento[0] = horarioInicio;
		horarioFuncionamento[1] = horarioFim;
	}
	//Métodos Públicos
	public ArrayList<Dominio> getLista() {
		return lista;
	}
	
	public void setDomain(Dominio dominio) {
		lista.add(dominio);
	}
	
	public void setLista(ArrayList<Dominio> lista) {
		this.lista = lista;
	}
	public int getVariante() {
		return variante;
	}
	public void setVariante(int variante) {
		this.variante = variante;
	}

	public int[] getHorarioFuncionamento() {
		return horarioFuncionamento;
	}

	public void setHorarioFuncionamento(int[] horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
	}
	
}
