package br.com.officecleantech.model.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.officecleantech.model.entidade.Usuario;

class UsuarioDaoTest {

	@Disabled
	@Test
	@DisplayName("teste de cadastro")
	void testCadastro() {
		UsuarioDao dao = new UsuarioDao();
		Usuario u = new Usuario();
		u.setLogin("x@email.com");
		u.setSenha("123");

		assertEquals("sucesso no cadastro", dao.cadastrar(u));

	}

}
