package Controle;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

import Modelo.Jogador;
import Modelo.Jogo;
import Modelo.Lancamento;
import Visão.Main;
import Visão.Mensagens;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class IniciarJogoPadraoController {
	
	@FXML
    private TextField textQuantidadeJogadores;

    @FXML
    private Label lblQuantidadeJogadores;

    @FXML
    private TextField textQuantidadeJogadas;

    @FXML
    private Label lblQuantidadeJogadas;

    @FXML
    private Label lblTamanhoNome;

    @FXML
    private TextField textTamanhoNome;

    @FXML
    private CheckBox checkNomeAuto;

    @FXML
    private CheckBox checkNomeManual;

    @FXML
    private Label lblNomeJogador1;

    @FXML
    private TextField textJogador1;

    @FXML
    private Label lblNomeJogador2;

    @FXML
    private TextField textJogador2;

    @FXML
    private Label lblNomeJogador3;

    @FXML
    private TextField textJogador3;

    @FXML
    private Label lblNomeJogador14;

    @FXML
    private TextField textJogador4;

    @FXML
    private Label lblNomeJogador5;

    @FXML
    private TextField textJogador5;

    @FXML
    private Label lblNomeJogador6;

    @FXML
    private TextField textJogador6;

    @FXML
    private Label lblNomeJogador7;

    @FXML
    private TextField textJogador7;

    @FXML
    private Button btnJogar;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnLimpar;
    
    @FXML
    private Button definir;

    @FXML
    void definirClick(ActionEvent event) {
    	int quantidadeJogadores = Integer.parseInt(textQuantidadeJogadores.getText());
    	
    	if(quantidadeJogadores == 3){
    		textJogador1.setDisable(false);
    		textJogador2.setDisable(false);
    		textJogador3.setDisable(false);
    		textJogador4.setDisable(true);
    		textJogador5.setDisable(true);
    		textJogador6.setDisable(true);
    		textJogador7.setDisable(true);
    	}  else if(quantidadeJogadores == 4) {
    		textJogador1.setDisable(false);
    		textJogador2.setDisable(false);
    		textJogador3.setDisable(false);
    		textJogador4.setDisable(false);
    		textJogador5.setDisable(true);
    		textJogador6.setDisable(true);
    		textJogador7.setDisable(true);
    	} else if(quantidadeJogadores == 5) {
    		textJogador1.setDisable(false);
    		textJogador2.setDisable(false);
    		textJogador3.setDisable(false);
    		textJogador4.setDisable(false);
    		textJogador5.setDisable(false);
    		textJogador6.setDisable(true);
    		textJogador7.setDisable(true);
    	} else if(quantidadeJogadores == 6) {
    		textJogador1.setDisable(false);
    		textJogador2.setDisable(false);
    		textJogador3.setDisable(false);
    		textJogador4.setDisable(false);
    		textJogador5.setDisable(false);
    		textJogador6.setDisable(false);
    		textJogador7.setDisable(true);
    	} else if(quantidadeJogadores == 7) {
    		textJogador1.setDisable(false);
    		textJogador2.setDisable(false);
    		textJogador3.setDisable(false);
    		textJogador4.setDisable(false);
    		textJogador5.setDisable(false);
    		textJogador6.setDisable(false);
    		textJogador7.setDisable(false);
    	}

    }
    
    @FXML
    void jogarClick(ActionEvent event) {
    	int quantidadeJogadores = Integer.parseInt(textQuantidadeJogadores.getText());
    	int quantidadeJogadas = Integer.parseInt(textQuantidadeJogadas.getText());
    	definirJogadores(quantidadeJogadores);
    	definirJogadas(Jogo.jogadores, quantidadeJogadas);
    	desempatadora(Jogo.jogadores);
    	ordena();
    	ordenaLancamentos();
    	for(Jogador j : Jogo.jogadores){
    		System.out.println(j.getNome() + " Jogadas: ");
    		for(Lancamento l : j.lancamentos){
    			System.out.print(l.getDado1());
    			System.out.print(l.getDado2());
    		}
    		System.out.println("Total:" + j.getTotalPontos());
    	}
    }
    
    public void definirJogadas(ArrayList<Jogador> jogadores, int jogadas){
    	Random gerador = new Random();
    	for(Jogador jogador : jogadores){
    		for (int i = 0; i < jogadas; i++){
    			int dado = gerador.nextInt(6) + 1;
        		int dado2 = gerador.nextInt(6) + 1;
    			Lancamento lancamento = new Lancamento();
    			lancamento.setDado1(dado);
    			lancamento.setDado2(dado2);
    			jogador.setTotalPontos(dado + dado2 + jogador.getTotalPontos()); //Aparentemente está atualizando automaticamente no ArrayList
    			jogador.lancamentos.add(lancamento);
    			double d = dado2;
    			double totalComposto = 0;
    			//totalComposto = d/100;
    			totalComposto = d;
    			jogador.setTotalComposto(totalComposto + jogador.getTotalComposto());
    			
    			
    		}  
    		jogador.setTotalComposto(jogador.getTotalComposto()/100 %.2f);
    		jogador.setTotalPontos(jogador.getTotalPontos() + jogador.getTotalComposto());
    		String resultado = String.format("%.2f", jogador.getTotalPontos());
    		jogador.setResultadoString(resultado);
    		System.out.println(jogador.getResultadoString());
    		//System.out.println(jogador.getTotalPontos());
    	}
    	
    }
    
    public boolean desempatadora(ArrayList<Jogador> jogadores){
    	ArrayList<Jogador> auxiliar = new ArrayList<Jogador>();
    	auxiliar.addAll(jogadores);
    	if(jogadores.size() == 3){
    		
		}
    	for(int i = 1; i < auxiliar.size(); i++){
    		int anterior = i - 1;
    		int atual = i;
    		Jogador j = new Jogador();
    		j.setTotalPontos(jogadores.get(atual).getTotalPontos());
    		Jogador novo = new Jogador();
    		do{
    		if(j.getTotalPontos() == novo.getTotalPontos()){
    			Random gerador = new Random();
    			double dado = gerador.nextInt(6) + 1;
    			dado = dado/100 %.2f;
    			jogadores.get(atual).setTotalPontos(jogadores.get(atual).getTotalPontos() + dado);
    			double dado2 = gerador.nextInt(6) + 1;
    			dado2 = dado/100 %.2f;
    			jogadores.get(anterior).setTotalPontos(jogadores.get(anterior).getTotalPontos() + dado2);
    		}
    		}while(j.getTotalPontos() == novo.getTotalPontos());
    		
    	}

    	auxiliar.clear();
		return false;
		
    	
    }
    
    
    public void definirJogadores(int quantidadeJogadores){
    	int tamanho = Integer.parseInt(textTamanhoNome.getText());
    	if(quantidadeJogadores == 3){
    		Jogador jogador1 = new Jogador();
    		Jogador jogador2 = new Jogador();
    		Jogador jogador3 = new Jogador();
    		
    		if(textJogador1.getText().length() > tamanho || textJogador1.getText().length() < tamanho){
    			Mensagens.nomeIncorreto();
    		} else if(textJogador2.getText().length() > tamanho || textJogador2.getText().length() < tamanho){
    			Mensagens.nomeIncorreto();
    		} else if(textJogador3.getText().length() > tamanho || textJogador3.getText().length() < tamanho){
    			Mensagens.nomeIncorreto();
    		} else{
    	
	    		jogador1.setNome(textJogador1.getText());
	    		jogador2.setNome(textJogador2.getText());
	    		jogador3.setNome(textJogador3.getText());
	    		Jogo.jogadores.add(jogador1);
	    		Jogo.jogadores.add(jogador2);
	    		Jogo.jogadores.add(jogador3);
	    		
    		}
    		
    	} else if(quantidadeJogadores == 4){
    		Jogador jogador1 = new Jogador();
    		Jogador jogador2 = new Jogador();
    		Jogador jogador3 = new Jogador();
    		Jogador jogador4 = new Jogador();
    		if(textJogador1.getText().length() > tamanho || textJogador1.getText().length() < tamanho){
    			Mensagens.nomeIncorreto();
    		} else if(textJogador2.getText().length() > tamanho || textJogador2.getText().length() < tamanho){
    			Mensagens.nomeIncorreto();
    		} else if(textJogador3.getText().length() > tamanho || textJogador3.getText().length() < tamanho){
    			Mensagens.nomeIncorreto();
    		} else if (textJogador4.getText().length() > tamanho || textJogador4.getText().length() < tamanho){
    			Mensagens.nomeIncorreto();
    		}
    		else{
    		
    		jogador1.setNome(textJogador1.getText());
    		jogador2.setNome(textJogador2.getText());
    		jogador3.setNome(textJogador3.getText());
    		jogador4.setNome(textJogador4.getText());
    		
    		Jogo.jogadores.add(jogador1);
    		Jogo.jogadores.add(jogador2);
    		Jogo.jogadores.add(jogador3);
    		Jogo.jogadores.add(jogador4);
    		}
    		
    	} else if(quantidadeJogadores == 5){
    		Jogador jogador1 = new Jogador();
    		Jogador jogador2 = new Jogador();
    		Jogador jogador3 = new Jogador();
    		Jogador jogador4 = new Jogador();
    		Jogador jogador5 = new Jogador();

    		
    		if(textJogador1.getText().length() > tamanho || textJogador1.getText().length() < tamanho){
    			Mensagens.nomeIncorreto();
    		} else if(textJogador2.getText().length() > tamanho || textJogador2.getText().length() < tamanho){
    			Mensagens.nomeIncorreto();
    		} else if(textJogador3.getText().length() > tamanho || textJogador3.getText().length() < tamanho){
    			Mensagens.nomeIncorreto();
    		} else if (textJogador4.getText().length() > tamanho || textJogador4.getText().length() < tamanho){
    			Mensagens.nomeIncorreto();
    		} else if (textJogador5.getText().length() > tamanho || textJogador5.getText().length() < tamanho){
    			Mensagens.nomeIncorreto();
    		}
    		else{
    		
    		jogador1.setNome(textJogador1.getText());
    		jogador2.setNome(textJogador2.getText());
    		jogador3.setNome(textJogador3.getText());
    		jogador4.setNome(textJogador4.getText());
    		jogador5.setNome(textJogador5.getText());
    		
    		Jogo.jogadores.add(jogador1);
    		Jogo.jogadores.add(jogador2);
    		Jogo.jogadores.add(jogador3);
    		Jogo.jogadores.add(jogador4);
    		Jogo.jogadores.add(jogador5);
    		}
    		
    	} else if(quantidadeJogadores == 6){
    		Jogador jogador1 = new Jogador();
    		Jogador jogador2 = new Jogador();
    		Jogador jogador3 = new Jogador();
    		Jogador jogador4 = new Jogador();
    		Jogador jogador5 = new Jogador();
    		Jogador jogador6 = new Jogador();
    		if(textJogador1.getText().length() > tamanho || textJogador1.getText().length() < tamanho){
    			Mensagens.nomeIncorreto();
    		} else if(textJogador2.getText().length() > tamanho || textJogador2.getText().length() < tamanho){
    			Mensagens.nomeIncorreto();
    		} else if(textJogador3.getText().length() > tamanho || textJogador3.getText().length() < tamanho){
    			Mensagens.nomeIncorreto();
    		} else if (textJogador4.getText().length() > tamanho || textJogador4.getText().length() < tamanho){
    			Mensagens.nomeIncorreto();
    		} else if (textJogador5.getText().length() > tamanho || textJogador5.getText().length() < tamanho){
    			Mensagens.nomeIncorreto();
    		} else if (textJogador6.getText().length() > tamanho || textJogador6.getText().length() < tamanho){
    			Mensagens.nomeIncorreto();
    		} 
    		else{
    		
    		jogador1.setNome(textJogador1.getText());
    		jogador2.setNome(textJogador2.getText());
    		jogador3.setNome(textJogador3.getText());
    		jogador4.setNome(textJogador4.getText());
    		jogador5.setNome(textJogador5.getText());
    		jogador6.setNome(textJogador6.getText());
    		
    		Jogo.jogadores.add(jogador1);
    		Jogo.jogadores.add(jogador2);
    		Jogo.jogadores.add(jogador3);
    		Jogo.jogadores.add(jogador4);
    		Jogo.jogadores.add(jogador5);
    		Jogo.jogadores.add(jogador6);
    		}
    		
    	} 
    	else if(quantidadeJogadores == 7){
    		Jogador jogador1 = new Jogador();
    		Jogador jogador2 = new Jogador();
    		Jogador jogador3 = new Jogador();
    		Jogador jogador4 = new Jogador();
    		Jogador jogador5 = new Jogador();
    		Jogador jogador6 = new Jogador();
    		Jogador jogador7 = new Jogador();
    		if(textJogador1.getText().length() > tamanho || textJogador1.getText().length() < tamanho){
    			Mensagens.nomeIncorreto();
    		} else if(textJogador2.getText().length() > tamanho || textJogador2.getText().length() < tamanho){
    			Mensagens.nomeIncorreto();
    		} else if(textJogador3.getText().length() > tamanho || textJogador3.getText().length() < tamanho){
    			Mensagens.nomeIncorreto();
    		} else if (textJogador4.getText().length() > tamanho || textJogador4.getText().length() < tamanho){
    			Mensagens.nomeIncorreto();
    		} else if (textJogador5.getText().length() > tamanho || textJogador5.getText().length() < tamanho){
    			Mensagens.nomeIncorreto();
    		} else if (textJogador6.getText().length() > tamanho || textJogador6.getText().length() < tamanho){
    			Mensagens.nomeIncorreto();
    		} else if (textJogador7.getText().length() > tamanho || textJogador7.getText().length() < tamanho){
    			Mensagens.nomeIncorreto();
    		} 
    		else{
    		
    		jogador1.setNome(textJogador1.getText());
    		jogador2.setNome(textJogador2.getText());
    		jogador3.setNome(textJogador3.getText());
    		jogador4.setNome(textJogador4.getText());
    		jogador5.setNome(textJogador5.getText());
    		jogador6.setNome(textJogador6.getText());
    		jogador7.setNome(textJogador7.getText());
    		
    		Jogo.jogadores.add(jogador1);
    		Jogo.jogadores.add(jogador2);
    		Jogo.jogadores.add(jogador3);
    		Jogo.jogadores.add(jogador4);
    		Jogo.jogadores.add(jogador5);
    		Jogo.jogadores.add(jogador6);
    		Jogo.jogadores.add(jogador7);
    		}
    		
    	} 
    }
    
    public void ordenaTotal(ArrayList<Jogador> jogadores){
    	ArrayList<Jogador> auxiliar = new ArrayList<Jogador>();
    	
    	//lógica funcionando perfeitamente, porém para ordenar apenas 3 jogadores.
    	for(int i = 0; i < jogadores.size(); i++){
    		Jogador anterior = new Jogador();
    		Jogador novo = new Jogador();
    		if(i == 0){
    			
    			anterior.setTotalPontos(jogadores.get(i).getTotalPontos());
    			anterior.setNome(jogadores.get(i).getNome());
    			auxiliar.add(anterior);
    		} else {
    			anterior.setTotalPontos(jogadores.get(i-1).getTotalPontos());
    			anterior.setNome(jogadores.get(i-1).getNome());
    			novo.setTotalPontos(jogadores.get(i).getTotalPontos());
    			novo.setNome(jogadores.get(i).getNome());
    			if(novo.getTotalPontos() >  anterior.getTotalPontos()){
    				auxiliar.remove(i - 1);
    				auxiliar.add(novo);
    				auxiliar.add(anterior);
    			} else {
    				auxiliar.add(novo);
    			}
    			
    		}
    		
    	}
    	
    	ArrayList<Jogador> perfeito = new ArrayList<Jogador>();
    	
    	for(int i = 0; i < auxiliar.size(); i++){
    		int tamanho = auxiliar.size();
    		if(tamanho == 4){
    			if(auxiliar.get(i).getTotalPontos() > auxiliar.get(1).getTotalPontos()){
    				Jogador anterior = new Jogador();
    				Jogador proximo = new Jogador();
    				perfeito.add(anterior);
    				perfeito.add(proximo);
    				
    				
    			}
    		}
    	}
    	Jogo.jogadores.clear();
    	Jogo.jogadores.addAll(auxiliar);
    	
    }
    
    public void ordena(){
    	Collections.sort(Jogo.jogadores); //A Collection pega os valores que são sobrescritos na classe Jogador e os utiliza para realizar a ordenação.
    }
    
    public void ordenaLancamentos(){
    	for(Jogador jogador : Jogo.jogadores){
    		Collections.sort(jogador.lancamentos);
    		
    		
    	}
    	
    }
    
    @FXML
    void sairClick(ActionEvent event) {
    	MenuTipoJogoController.menuTipo.close();
    	Main.myStage.show();
    }

}
