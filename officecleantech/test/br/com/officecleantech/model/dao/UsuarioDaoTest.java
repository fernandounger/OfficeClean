package br.com.officecleantech.model.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.officecleantech.model.entidade.Usuario;

class UsuarioDaoTest {

	@Disabled
	@Test
	@DisplayName("teste de login")
	void testLogin() {
		UsuarioDao dao = new UsuarioDao();
		Usuario u = new Usuario();
		u.setLogin("zaque@email.com");
		u.setSenha("123");
		dao.logar("zaque@email.com", "123");

		assertEquals(/* "sucesso na busca" */dao.logar(null, null),
				dao.logar(u.getLogin(), u.getSenha())/* , controller.logarUsuario(u.getLogin(),u.getSenha()) */);

	}

	@Disabled
	@Test
	@DisplayName("teste de cadastro")
	void testCadastro() {
		UsuarioDao dao = new UsuarioDao();
		Usuario u = new Usuario();
		u.setNome("lorem");
		u.setLogin("y@email.com");
		u.setSenha("123");

		assertEquals("sucesso no cadastro", dao.cadastrar(u));

	}

	@Disabled
	@Test
	@DisplayName("teste de listagem")
	void testListagem() {
		UsuarioDao dao = new UsuarioDao();
		ArrayList<Usuario> lista = dao.listar("");
//		ArrayList<Pessoa> lista = dao.listar("patata");
		assertTrue(lista.size() > 0);
//		assertTrue(lista.size() == 0);

	}

	@Disabled
	@Test
	@DisplayName("teste de atualizacao")
	void testAtualizacao() {
		UsuarioDao dao = new UsuarioDao();
		Usuario u = new Usuario();
		u.setId(4);
		u.setNome("lorem");
		u.setLogin("lorem@email.com");
		u.setSenha("lorem");

		assertEquals("sucesso na atualizacao", dao.alterar(u));
	}

	@Disabled
	@Test
	@DisplayName("teste de pesquisa")
	void testPesquisa() {
		UsuarioDao dao = new UsuarioDao();
		Usuario u = new Usuario();
		u.setId(3);
		Usuario u2 = new Usuario();
		u2.setId(3);

		assertEquals(u2.getId(), dao.pesquisar(u.getId()).getId());
//		assertTrue(p.getPessoaId()==2);
	}

	@Disabled
	@Test
	@DisplayName("teste de exclusao")
	void testExclusao() {
		UsuarioDao dao = new UsuarioDao();

		Usuario u = new Usuario();
		u.setId(3);

		assertEquals("sucesso na exclusao", dao.excluir(u));
	}

}
