package br.com.officecleantech.model.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.officecleantech.model.entidade.Produto;

class ProdutoDaoTest {

//	@Disabled
	@Test
	@DisplayName("teste de listagem")
	void testListagem() {
		ProdutoDao dao = new ProdutoDao();
		ArrayList<Produto> lista = dao.listar("");

//		assertTrue(lista.size()>0);
		assertEquals(lista.size(), 1);
	}
	
//	@Disabled
	@Test
	@DisplayName("teste de busca")
	void testBusca() {
		ProdutoDao dao = new ProdutoDao();
		ArrayList<Produto> lista = dao.listar("a");

//		assertTrue(lista.size()>0);
		assertEquals(lista.size(), 1);
	}
	

}
