package br.com.esig.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.esig.config.ConnectionFactory;
import br.com.esig.model.Tarefas;

public class TarefasDAO {
	public void save(Tarefas tarefas) {
		if (tarefas == null || tarefas.getTitulo() == null) {
			System.out.println("tarefa não pode ser cadastrada");

			return;
		}

		String sql = "INSERT INTO tarefas(titulo, descricao,responsavel,prioridade, deadline, status) "
				+ "VALUES ( ?,?,?,?,?,?)";

		Connection conn = ConnectionFactory.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, tarefas.getTitulo());
			ps.setString(2, tarefas.getDescricao());
			ps.setString(3, tarefas.getResponsavel());
			ps.setString(4, tarefas.getPrioridade());
			ps.setString(5, tarefas.getDeadline());
			ps.setString(6, "em andamento");

			ps.executeUpdate();

			System.out.println("cadastrado com sucesso");

			ConnectionFactory.close(conn, ps);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(Tarefas deleteTarefas) {

		if (deleteTarefas == null) {
			System.out.println("tarefa não pode ser deletada");
			
			return;
		}
		
		String sql = "DELETE FROM tarefas WHERE id= ?" ;
		
		Connection conn = ConnectionFactory.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, deleteTarefas.getId());
			
			ps.executeUpdate();
			
			System.out.println("deletado com sucesso");
			
			ConnectionFactory.close(conn, ps);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void update(Tarefas atualizarTarefa) {

		if (atualizarTarefa == null) {
			System.out.println("tarefa não pode ser atualizada");
			
			return;
		}
		
		String sql = "UPDATE tarefas SET descricao='tarefa não deletada' WHERE id=10;";
		
		Connection conn = ConnectionFactory.getConnection();

		try {
			Statement stnt = conn.createStatement();
			stnt.executeUpdate(sql);
			
			System.out.println("atualizado com sucesso");
			
			ConnectionFactory.close(conn, stnt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<Tarefas> search(Tarefas buscarTarefas) {

		ArrayList<Tarefas> listaDeTarefas = new ArrayList<Tarefas>();

		StringBuilder sql = new StringBuilder(" SELECT * FROM tarefas WHERE 1 = 1 ");
		Connection conn = ConnectionFactory.getConnection();

		if (buscarTarefas.getId() != 0)
			sql.append(" AND id = '").append(buscarTarefas.getId()).append("' ");

		if (!buscarTarefas.getTitulo().isBlank() && !buscarTarefas.getTitulo().isEmpty()) {
			sql.append(" AND titulo ilike '%").append(buscarTarefas.getTitulo()).append("%' ");
		}
		if (!buscarTarefas.getResponsavel().isBlank() && !buscarTarefas.getResponsavel().isEmpty()) {
			sql.append(" AND responsavel = '").append(buscarTarefas.getResponsavel()).append("' ");
		}
		if (!buscarTarefas.getStatus().isBlank() && !buscarTarefas.getStatus().isEmpty()) {
			sql.append(" AND status = '").append(buscarTarefas.getStatus()).append("' ");
		}
		try {
			PreparedStatement ps = conn.prepareStatement(sql.toString());

			ResultSet rsts = ps.executeQuery();

			while (rsts.next()) {
				listaDeTarefas.add(new Tarefas(rsts.getInt("id"), rsts.getString("titulo"), rsts.getString("descricao"),
						rsts.getString("responsavel"), rsts.getString("prioridade"), rsts.getString("deadline"),
						rsts.getString("status")));
			}

			ConnectionFactory.close(conn, ps, rsts);

			return listaDeTarefas;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
