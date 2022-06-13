package br.com.officecleantech.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.officecleantech.model.entidade.Usuario;

class UsuarioControllerTest {

	@Disabled
	@Test
	@DisplayName("teste de cadastro")
	void testCadastro() {
		UsuarioController controller = new UsuarioController();
		Usuario u = new Usuario();
//		u.setNome("sujeito");
		u.setLogin("y@email.com");
		u.setSenha("123");

		assertEquals("sucesso no cadastro", controller.cadastrarUsuario(u));

	}

}
