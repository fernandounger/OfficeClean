package br.com.officecleantech.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.officecleantech.model.entidade.Usuario;

class UsuarioControllerTest {

//	@Disabled
	@Test
	@DisplayName("teste de login")
	void testLoginUsuario() {
		UsuarioController controller = new UsuarioController();
		Usuario u = new Usuario();
		u.setLogin("zaque@email.com");
		u.setSenha("123");
		controller.logarUsuario("zaque@email.com", "123");

		assertEquals(/*"sucesso na busca"*/controller.logarUsuario(null, null),controller.logarUsuario(u.getLogin(),  u.getSenha())/*, controller.logarUsuario(u.getLogin(),u.getSenha())*/);

	}

	@Disabled
	@Test
	@DisplayName("teste de cadastro")
	void testCadastroUsuario() {
		UsuarioController controller = new UsuarioController();
		Usuario u = new Usuario();
		u.setNome("sujeito");
		u.setLogin("x@email.com");
		u.setSenha("123");

		assertEquals("falha no cadastro", controller.cadastrarUsuario(u));

	}

	@Disabled
	@Test
	@DisplayName("teste de listagem")
	void testListagem() {
		UsuarioController controller = new UsuarioController();
		ArrayList<Usuario> lista = controller.listarUsuario("");
//		ArrayList<Pessoa> lista = dao.listar("patata");
		assertTrue(lista.size() > 0);
//		assertTrue(lista.size() == 0);

	}

	@Disabled
	@Test
	@DisplayName("teste de atualizacao")
	void testAtualizacao() {
		UsuarioController controller = new UsuarioController();
		Usuario u = new Usuario();
		u.setId(1);
		u.setNome("lorem");
		u.setLogin("lorem@email.com");
		u.setSenha("lorem");

		assertEquals("sucesso na atualizacao", controller.alterarUsuario(u));
	}

	@Disabled
	@Test
	@DisplayName("teste de pesquisa")
	void testPesquisa() {
		UsuarioController controller = new UsuarioController();
		Usuario u = new Usuario();
		u.setId(2);
		Usuario u2 = new Usuario();
		u2.setId(3);

		assertEquals(u2.getId(), controller.pesquisarUsuario(u.getId()).getId());
//		assertTrue(p.getPessoaId()==2);
	}

	@Disabled
	@Test
	@DisplayName("teste de exclusao")
	void testExclusao() {
		UsuarioController controller = new UsuarioController();

		Usuario u = new Usuario();
		u.setId(1);

		assertEquals("sucesso na exclusao", controller.excluirUsuario(u));
	}

}
