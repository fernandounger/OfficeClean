package br.com.officecleantech.controller;

import java.util.ArrayList;

import br.com.officecleantech.model.dao.UsuarioDao;
import br.com.officecleantech.model.entidade.Usuario;

public class UsuarioController {

	UsuarioDao dao = new UsuarioDao();

	public String cadastrarUsuario(Usuario u) {

		return dao.cadastrar(u);

	}

	public Usuario logarUsuario( String login, String password) {

		return dao.logar( login, password);
	}

	
	  public ArrayList<Usuario> listarUsuario(String nomeBusca) {
	  
	  return dao.listar(nomeBusca); }
	 

	public Usuario pesquisarUsuario(long id) {
		return dao.pesquisar(id);
	}

	public String alterarUsuario(Usuario u) {
		return dao.alterar(u);
	}

	public String excluirUsuario(Usuario u) {
		return dao.excluir(u);
	}

}
