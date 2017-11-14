package Modelo;

import java.sql.Connection;

import ConexaoBD.ConexaoBD;

public class JogadorDAO {
	
	private Connection connection;
	
	public JogadorDAO() {
		this.connection = ConexaoBD.getConexao();
	}

}
