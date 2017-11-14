package Modelo;

import java.util.ArrayList;

public class Jogador implements Comparable<Jogador> {
	private String nome;
	private int id;
	private double totalPontos;
	private double totalComposto;
	private String resultadoString;
	public ArrayList<Lancamento> lancamentos = new ArrayList<Lancamento>(); // Collection irá receber todos os dados lançados pelo usuário
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public double getTotalPontos() {
		return totalPontos;
	}
	public void setTotalPontos(double totalPontos) {
		this.totalPontos = totalPontos;
	}
	public double getTotalComposto() {
		return totalComposto;
	}
	public void setTotalComposto(double totalComposto) {
		if(this.totalComposto == 0.1){
			this.totalComposto = 0.10;
		} else {
			this.totalComposto = totalComposto;
		}
	}
	public String getResultadoString() {
		return resultadoString;
	}
	public void setResultadoString(String resultadoString) {
		this.resultadoString = resultadoString;
	}

	@Override
	public int compareTo(Jogador outroJogador) {
		if (this.totalPontos < outroJogador.totalPontos) {
            return 1; //Se o número de pontos da pessoa atual atual é menor do que da Pessoa retorno 1
        }
		else if (this.totalPontos > outroJogador.totalPontos) {
            return -1; //Se for maior retornamos -1
        }
        return 0;
	}

	

}
