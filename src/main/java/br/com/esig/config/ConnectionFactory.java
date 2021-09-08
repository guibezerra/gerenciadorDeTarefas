package br.com.esig.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
//o driveManager devolve um conexao baseado na url passada no metodo 
	public Connection getConnection() {
		String url = "jdbc:postgresql://localhost:5432/gerenciandotarefas";
		String user = "postgres";
		String password = "admin";
		
		try {
			Connection connection = DriverManager.getConnection(url,user,password);
			
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

}
