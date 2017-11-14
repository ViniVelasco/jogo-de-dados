package Modelo;

import java.util.ArrayList;

public class Jogo {
	private int numero;
	private String nomeVencedor;
	public static ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNomeVencedor() {
		return nomeVencedor;
	}
	public void setNomeVencedor(String nomeVencedor) {
		this.nomeVencedor = nomeVencedor;
	}
	

}
