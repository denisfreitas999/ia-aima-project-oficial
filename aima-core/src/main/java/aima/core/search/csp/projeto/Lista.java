package aima.core.search.csp.projeto;

import java.util.ArrayList;

//Classe Lista, possui uma lista com todos os domínios
public class Lista {
	//Lista com todos os domínios do problema.
	private ArrayList<Dominio> lista = new ArrayList<Dominio>();
	
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
	
}
