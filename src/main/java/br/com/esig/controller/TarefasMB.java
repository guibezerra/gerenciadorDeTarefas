package br.com.esig.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.jboss.weld.bean.builtin.ee.HttpServletRequestBean;

import br.com.esig.DAO.TarefasDAO;
import br.com.esig.model.Tarefas;

@Named
@SessionScoped
public class TarefasMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Tarefas tarefa = new Tarefas();

	private ArrayList<Tarefas> listaDeTarefas = new ArrayList<Tarefas>();
	private TarefasDAO cadastro = new TarefasDAO();

	public TarefasMB() {
		
	}
	public void initMethod() {
		this.listaDeTarefas = new ArrayList<Tarefas>();
		this.tarefa = new Tarefas();
	}
	public String initForm() {
		initMethod();

		return "/listarTarefas.xhtml";
	}
	// metodo para realizar operacao de cadastro
	public String tarefaCadastrada() {
		cadastro.save(tarefa);

		return "";
	}
	// metodo para realizar operacao de busca
	public String buscarTarefas() {

		this.listaDeTarefas = cadastro.search(tarefa);
		
		System.out.println("busca realizada");
		
		return "";
	}
	// metodo deletar 
	public String deletarTarefas(int id) {
		this.tarefa = new Tarefas();
		
		tarefa.setId(id);
		cadastro.delete(tarefa);
		
		this.listaDeTarefas.remove(tarefa);
		
		System.out.println("tarefa deletada");
		
		return "";
	}

	public Tarefas getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefas tarefa) {
		this.tarefa = tarefa;
	}

	public ArrayList<Tarefas> getListaDeTarefas() {
		return listaDeTarefas;
	}

	public void setListaDeTarefas(ArrayList<Tarefas> listaTarefas) {
		this.listaDeTarefas = listaTarefas;
	}

}
