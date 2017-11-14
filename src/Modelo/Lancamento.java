package Modelo;

public class Lancamento implements Comparable<Lancamento> {
	private int dado1;
	private int dado2;
	
	public int getDado1() {
		return dado1;
	}
	public void setDado1(int dado1) {
		
		if(dado1 >= 1 && dado1 <= 6){
		this.dado1 = dado1;
		}
		
	}
	public int getDado2() {
		return dado2;
	}
	
	public void setDado2(int dado2) {
		
		if(dado2 >= 1 && dado2 <= 6){
		this.dado2 = dado2;
		}
		
	}
	@Override
	public int compareTo(Lancamento outrolancamento) {
		if (this.dado1 < outrolancamento.dado1) {
            return -1; //Se o número de pontos da pessoa atual atual é menor do que da Pessoa retorno -1
        }
		else if (this.dado1  > outrolancamento.dado1) {
            return 1; //Se for maior retornamos 1
        }else if (this.dado2 < outrolancamento.dado2) {
            return -1; //Se o número de pontos da pessoa atual atual é menor do que da Pessoa retorno -1
        }
		else if (this.dado2  > outrolancamento.dado2) {
            return 1; //Se for maior retornamos 1
        }
        return 0;
	}

}
