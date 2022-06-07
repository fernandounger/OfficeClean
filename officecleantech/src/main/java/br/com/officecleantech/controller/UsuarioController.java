package br.com.officecleantech.controller;

import br.com.officecleantech.model.dao.UsuarioDao;
import br.com.officecleantech.model.entidade.Usuario;

public class UsuarioController {

	UsuarioDao dao = new UsuarioDao();

	public void cadastrarUsuario(Usuario u) {
		 dao.cadastrar(u);

	}

	public Usuario logarUsuario(String name, String login, String password) {

		return dao.logar(name, login, password);
	}

}
