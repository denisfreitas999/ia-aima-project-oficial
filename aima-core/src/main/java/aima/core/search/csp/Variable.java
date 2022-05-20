package aima.core.search.csp;
import java.util.ArrayList;

/**
 * A variable is a distinguishable object with a name.
 *
 * @author Ruediger Lunde
 */
//Classe Variable, original do aima, serve para criação das variáveis e foi levemente modificada para guardar
//o domínio de cada funcionário respectivamente.
public class Variable {
    private final String name;
    private ArrayList<Double> horarios;
    private boolean vacinado;
    private ArrayList<String> funcionariosPrioritarios;
    
    public Variable(String name, ArrayList<Double> horarios) {
        this.name = name;
        this.horarios = horarios;
    }
    
    public Variable(String name, ArrayList<Double> horarios, ArrayList<String> funcionariosPrioritarios) {
        this.name = name;
        this.horarios = horarios;
        this.funcionariosPrioritarios = funcionariosPrioritarios;
    }
    
    public Variable(String name, ArrayList<Double> horarios, boolean vacinado) {
        this.name = name;
        this.horarios = horarios;
        this.vacinado = vacinado;
    }
    
    public Variable(String name) {
        this.name = name;
    }
    
    public final String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

    /** Variables with equal names are equal. */
    @Override
    public final boolean equals(Object obj) {
        return (obj != null && obj.getClass() == getClass()) && name.equals(((Variable) obj).name);
    }

    @Override
    public final int hashCode() {
        return name.hashCode();
    }

	public ArrayList<Double> getHorarios() {
		return horarios;
	}

	public void setHorarios(ArrayList<Double> horarios) {
		this.horarios = horarios;
	}

	public boolean isVacinado() {
		return vacinado;
	}

	public void setVacinado(boolean vacinado) {
		this.vacinado = vacinado;
	}

	public ArrayList<String> getFuncionariosPrioritarios() {
		return funcionariosPrioritarios;
	}

	public void setFuncionariosPrioritarios(ArrayList<String> funcionariosPrioritarios) {
		this.funcionariosPrioritarios = funcionariosPrioritarios;
	}
	
}
