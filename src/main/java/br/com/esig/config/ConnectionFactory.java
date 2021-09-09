package br.com.esig.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
//o driveManager devolve um conexao baseado na url passada no metodo 
	static final String Driver = "org.postgresql.Driver";
	static final String url = "jdbc:postgresql://127.0.0.1:5432/gerenciandotarefas";
	static final String user = "postgres";
	static final String password = "admin";

// metodo estatico, pois a conexao e a mesma independente de quantas vezes ele for chamado 
	public static Connection getConnection() {

		try {
			Class.forName(Driver);
			Connection connection = DriverManager.getConnection(url, user, password);
			
			return connection;

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// sobrecarga do metodo close para Connection, statements e ResultSet
	public static void close(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection conn, Statement stnt) {
		close(conn);

		try {
			if (stnt != null) {
				stnt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, Statement stnt, ResultSet rsts) {
		close(conn,stnt);
		
		try {
			if (rsts != null) {
				rsts.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
