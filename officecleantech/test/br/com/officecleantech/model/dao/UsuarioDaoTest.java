package br.com.officecleantech.model.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.officecleantech.model.entidade.Usuario;

class UsuarioDaoTest {

//	@Disabled
	@Test
	@DisplayName("teste de cadastro")
	void testCadastro() {
		UsuarioDao dao = new UsuarioDao();
		Usuario u = new Usuario();
//		p.setNome("");
//		p.setIdade();

		assertEquals("sucesso no cadastro", dao.cadastrar(u));

	}

}
