package br.com.esig.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.esig.config.ConnectionFactory;
import br.com.esig.model.Tarefas;

@Named
@SessionScoped
public class TarefasMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Tarefas tarefa;

	private ArrayList<Tarefas> listaTarefas = new ArrayList<Tarefas>();
	
	ConnectionFactory conn = new ConnectionFactory();
	
	public TarefasMB () {
		
	}
	
	//metodo para verificar sucesso da operacao
	public String tarefaCadastrada() {
		listaTarefas.add(tarefa);
		System.out.println("Tarefa "+tarefa.getTitulo()+" cadastrada com sucesso");
		System.out.println("Descricao "+tarefa.getDescricao());
		System.out.println("Responsavel "+tarefa.getResponsavel());
		System.out.println("Prioridade "+tarefa.getPrioridade());
		System.out.println("Deadline "+tarefa.getDeadline());
		
		System.out.println("conexao "+conn.getConnection());
		
	return "";
	}

	public Tarefas getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefas tarefa) {
		this.tarefa = tarefa;
	}

	public ArrayList<Tarefas> getListaTarefas() {
		return listaTarefas;
	}

	public void setListaTarefas(ArrayList<Tarefas> listaTarefas) {
		this.listaTarefas = listaTarefas;
	}

}
