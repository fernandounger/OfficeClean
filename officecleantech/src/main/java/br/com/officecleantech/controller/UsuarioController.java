package br.com.officecleantech.controller;

import java.util.ArrayList;

import br.com.officecleantech.model.dao.UsuarioDao;
import br.com.officecleantech.model.entidade.Usuario;

public class UsuarioController {

	UsuarioDao dao = new UsuarioDao();

	public String cadastrarUsuario(Usuario u) {

		return dao.cadastrar(u);

	}

	public Usuario logarUsuario(/* String name, */ String login, String password) {

		return dao.logar(/* name, */ login, password);
	}

	
	  public ArrayList<Usuario> listarUsuario(String nomeBusca) {
	  
	  return dao.listar(nomeBusca); }
	 

	public Usuario pesquisarUsuario(long id) {
		return dao.pesquisar(id);
	}

	public void alterarUsuario(Usuario u) {
		dao.alterar(u);
	}

	public void excluirUsuario(Usuario u) {
		dao.excluir(u);
	}

}
