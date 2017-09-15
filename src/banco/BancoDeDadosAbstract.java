package banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class BancoDeDadosAbstract implements IBancoDeDados {
	
	  	protected String host;
	  	protected String username;
	  	protected String password;
	  	protected String database;
	  	protected int port;
	  	private Connection connection;
		private boolean isConnect;

	       
	   //---------------- GERENCIAR CONEXAO -------------------------------------------

	  	public boolean connect () {
	  		// TODO: Criar conexão com o banco de dados
	  		return false;
	  	}

	   //---------------------- COMANDOS SQL ------------------------------------------
	       public boolean executarComandosSQL(String sql) {
	           try {
	               Statement stmt = connection.createStatement();
	               stmt.execute(sql);
	               return true;
	           } catch (Exception e) {
	               System.out.println(e.getMessage());
	               return false;
	           }
	       }

	       public ResultSet pegarResultadoSQL(String sql) {
	           ResultSet rs = null;
	           try {
	               Statement stmt = connection.createStatement();
	               rs = stmt.executeQuery(sql);
	               return rs;
	           } catch (Exception e) {
	               System.out.println(e.getMessage());
	           }
	           return rs;
	       }
	       
	    
}
