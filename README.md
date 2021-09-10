# Gerenciador de Tarefas

![alt text](https://raw.githubusercontent.com/guibezerra/gerenciadorDeTarefas/main/img/imagem.jpg)

## O que foi implementado
1) A aplicação foi criada com Java Web utilizando JSF. 
2) Consegui utilizar a persistência com o banco de dados PostgreSQL.
3) Implementei os métodos de CRUD onde, o metódo "update" não consegue ser utilizado pois não consegui integra-lo ao front da aplicação, porém o testei manualmente e consigo alterar uma tupla por meio da aplicação.
4) O metodo "delete" funciona, porém como estou usando um array para mostrar as tuplas obtidas ao usar o método de busca, não consigo renderiza-lo de forma assincrona, sem que haja uma nova consulta no banco de dados.
5) O front da aplicação não está totalmente implementado, falta estilizar e torna-lo responsivo.

## Instruções de uso
 - Importar o project no Eclipse como Existing Maven Project
 - Adicionar como servidor o Tomcat 9. Caso exista servidor, excluir, adicionar o Tomcat 9, Next e adicionar o projeto.
 - Acessar pelo navegador o endereço: http://localhost:8080/gerenciadorDeTarefas/cadastraTarefa.xhtml 

Para as operações com o banco de dados funcionarem, é preciso ter o PostgreSQL instalado, editar os atributos da classe ConnectionFactory com os dados do seu banco e efetuar os seguintes comandos:

    CREATE DATABASE tarefas;
    CREATE TABLE IF NOT EXISTS tarefas (
	    id INTEGER IDENTITY PRIMARY KEY,
	    titulo VARCHAR(70) NOT NULL,
	    descricao VARCHAR(250),
	    reponsavel VARCHAR(50) NOT NULL,
	    prioridade VARCHAR(5) NOT NULL,
	    deadline VARCHAR(10),
	    status VARCHAR(14) NOT NULL
    );





