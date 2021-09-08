package br.com.esig.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.esig.model.Tarefas;

@SessionScoped
@Named
public class ListarTarefasMB implements Serializable {

	@Inject
	private Tarefas tarefa;
	
	//consultas
	
}
