package br.com.esig.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.esig.DAO.TarefasDAO;
import br.com.esig.model.Tarefas;

@Named
@SessionScoped
public class TarefasMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Tarefas tarefa;

	private ArrayList<Tarefas> listaTarefas = new ArrayList<Tarefas>();
	private TarefasDAO cadastro = new TarefasDAO();
	
	public TarefasMB() {

	}

	// metodo para realizar operacao de cadastro
	public String tarefaCadastrada() {
		listaTarefas.add(tarefa);
		cadastro.save(tarefa);
//		ArrayList<Tarefas> teste = cadastro.search(tarefa);
//		for (Tarefas obj : teste) {
//			System.out.println(obj.getId());
//			System.out.println(obj.getTitulo());
//			System.out.println(obj.getDescricao());
//			System.out.println(obj.getResponsavel());
//			System.out.println(obj.getPrioridade());
//			System.out.println(obj.getDeadline());
//			System.out.println(obj.getStatus());
//			System.out.println("------------------");
//		}
//		
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
