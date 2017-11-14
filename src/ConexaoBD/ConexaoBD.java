package ConexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoBD {
	
public static String status = null;
	
	public static java.sql.Connection getConexao(){
		
		Connection connection = null;
		
		try{
			
			String driverName = "com.mysql.jdbc.Driver"; //com.mysql.jdbc.Driver
			Class.forName(driverName); //Carrega e inicia um objeto da classe cujo nome � passado como par�metro
			
			String url = "jdbc:mysql://localhost/jogo?autoReconnect=true&useSSL=false"; //String url = "jdbc:mysql://localhost/cadastro_pessoas?autoReconnect=true&useSSL=false";
			String username = "root";
			String password = "";
			
			connection = DriverManager.getConnection(url, username, password);
			
			if(connection != null){
				status = "Conectado com sucesso";
			} else{
				status = "Conex�o falhou";
			}
			
			return connection;
			
		} catch (ClassNotFoundException e){
			status = "O driver especificado n�o foi encontrado";
			return null;
		} catch (SQLException e){
			status = "N�o foi poss�vel conectar ao banco de dados";
			return null;
		}
		
	}
	
	public String StatusConnection(){ //Retorna o estado da conex�o
		
		return status;
		
	}
	
	public static boolean FecharConexao(){
		
		try{
			ConexaoBD.getConexao().close();
			return true;
		}catch(SQLException e){
			return false;
		}
		
	}
	
	public static java.sql.Connection ReiniciarConexao(){
		
		FecharConexao();
		
		return ConexaoBD.getConexao();
	}
	

}


