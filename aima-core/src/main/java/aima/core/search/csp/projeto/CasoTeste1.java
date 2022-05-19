package aima.core.search.csp.projeto;

import java.util.ArrayList;

//Classe de teste
public class CasoTeste1 {
	//Matriz de horários [abriga o funcionário e o horário que será escolhido para ele trabalhar]
	private final Horario[][] horario= new Horario[12][2];
	
	//Construtor
	//Preenchimento dos horários vagos com o valor null
	public CasoTeste1(){
		for (int i = 0; i<12;i++) {
			for(int j = 0;j<2;j++) {
				this.horario[i][j] = new Horario(null);
			}
		}
	}
	
	//Get da matriz.
	public Horario[][] getHorario() {
		return this.horario;
	}
	
	//Função para ajustar o nome na tabela de impressão
	public String ajustarNome(String nome) {
		int letras = nome.length();
		if(letras == 15) {
			return nome;
		}else {
			while(letras < 15) {
				nome += " ";
				letras++;
			}
		}
		
		return nome;
	}
	
	//Atribui um funcionário a posição fornecida na matriz de horários de acordo com a hora em que ele for 
	//selecionado para trabalhar.
	public void setFuncionario(String funcionario, Double horas) {
		
		if(horas == 1.0) {
			horario[0][0].setFuncionario(funcionario);
			horario[0][0].setHoras(horas);
		}else if(horas == 2.0) {
			horario[1][0].setFuncionario(funcionario);
			horario[1][0].setHoras(horas);
		}else if(horas == 3.0) {
			horario[2][0].setFuncionario(funcionario);
			horario[2][0].setHoras(horas);
		}else if(horas == 4.0) {
			horario[3][0].setFuncionario(funcionario);
			horario[3][0].setHoras(horas);
		}else if(horas == 5.0) {
			horario[4][0].setFuncionario(funcionario);
			horario[4][0].setHoras(horas);
		}else if(horas == 6.0) {
			horario[5][0].setFuncionario(funcionario);
			horario[5][0].setHoras(horas);
		}else if(horas == 7.0) {
			horario[6][0].setFuncionario(funcionario);
			horario[6][0].setHoras(horas);
		}else if(horas == 8.0) {
			horario[7][0].setFuncionario(funcionario);
			horario[7][0].setHoras(horas);
		}else if(horas == 9.0) {
			horario[8][0].setFuncionario(funcionario);
			horario[8][0].setHoras(horas);
		}else if(horas == 10.0) {
			horario[9][0].setFuncionario(funcionario);
			horario[9][0].setHoras(horas);
		}else if(horas == 11.0) {
			horario[10][0].setFuncionario(funcionario);
			horario[10][0].setHoras(horas);
		}else if(horas == 12.0) {
			horario[11][0].setFuncionario(funcionario);
			horario[11][0].setHoras(horas);
		}else if(horas == 13.0) {
			horario[0][1].setFuncionario(funcionario);
			horario[0][1].setHoras(horas);
		}else if(horas == 14.0) {
			horario[1][1].setFuncionario(funcionario);
			horario[1][1].setHoras(horas);
		}else if(horas == 15.0) {
			horario[2][1].setFuncionario(funcionario);
			horario[2][1].setHoras(horas);
		}else if(horas == 16.0) {
			horario[3][1].setFuncionario(funcionario);
			horario[3][1].setHoras(horas);
		}else if(horas == 17.0) {
			horario[4][1].setFuncionario(funcionario);
			horario[4][1].setHoras(horas);
		}else if(horas == 18.0) {
			horario[5][1].setFuncionario(funcionario);
			horario[5][1].setHoras(horas);
		}else if(horas == 19.0) {
			horario[6][1].setFuncionario(funcionario);
			horario[6][1].setHoras(horas);
		}else if(horas == 20.0) {
			horario[7][1].setFuncionario(funcionario);
			horario[7][1].setHoras(horas);
		}else if(horas == 21.0) {
			horario[8][1].setFuncionario(funcionario);
			horario[8][1].setHoras(horas);
		}else if(horas == 22.0) {
			horario[9][1].setFuncionario(funcionario);
			horario[9][1].setHoras(horas);
		}else if(horas == 23.0) {
			horario[10][1].setFuncionario(funcionario);
			horario[10][1].setHoras(horas);
		}else if(horas == 24.0) {
			horario[11][1].setFuncionario(funcionario);
			horario[11][1].setHoras(horas);
		}else {
			System.out.println("ERRO: O Hor�rio " + horas + " � inv�lido. Digite um hor�rio entre 1:00 e 23:00 considerando saltos de 1 em 1 hora");
		}
	}
	
	//Transforma a Matrix para string
	public String toString()
	{
	    String frase = new String();
	    ArrayList<String> hora_dia = new ArrayList<String>();
	    frase += Cores.ANSI_BLACK + "            [ AM ]           [ PM ]\n" + Cores.ANSI_RESET;
	    hora_dia.add(Cores.ANSI_BLACK + "1:00  " + Cores.ANSI_RESET);
	    hora_dia.add(Cores.ANSI_BLACK + "2:00  " + Cores.ANSI_RESET);
	    hora_dia.add(Cores.ANSI_BLACK + "3:00  " + Cores.ANSI_RESET);
	    hora_dia.add(Cores.ANSI_BLACK + "4:00  " + Cores.ANSI_RESET);
	    hora_dia.add(Cores.ANSI_BLACK + "5:00  " + Cores.ANSI_RESET);
	    hora_dia.add(Cores.ANSI_BLACK + "6:00  " + Cores.ANSI_RESET);
	    hora_dia.add(Cores.ANSI_BLACK + "7:00  " + Cores.ANSI_RESET);
	    hora_dia.add(Cores.ANSI_BLACK + "8:00  " + Cores.ANSI_RESET);
	    hora_dia.add(Cores.ANSI_BLACK + "9:00  " + Cores.ANSI_RESET);
	    hora_dia.add(Cores.ANSI_BLACK + "10:00 " + Cores.ANSI_RESET);
	    hora_dia.add(Cores.ANSI_BLACK + "11:00 " + Cores.ANSI_RESET);
	    hora_dia.add(Cores.ANSI_BLACK + "12:00 " + Cores.ANSI_RESET);
	    
	    for(int i = 0; i < 12; i++)
	        {
	    		frase += hora_dia.get(i);
	            for(int j = 0; j < 2; j++)
	                {
	            		frase += "[";
	                    if (horario[i][j].getFuncionario() == null){
	                    	frase += Cores.ANSI_BLACK + "---------------" + Cores.ANSI_RESET;
	                    }else {
	                    	
	                    	frase += Cores.ANSI_BLUE +  ajustarNome(horario[i][j].getFuncionario()) + Cores.ANSI_RESET;
	                    }
	                    frase += "]";
	                }
	            frase += '\n';
	        }
	    
	    System.out.println();
	    System.out.println("Os horários disponibilizados para os funcionário são: ");
	    return frase;
	}
}

