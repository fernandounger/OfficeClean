package br.com.officecleantech.model.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.officecleantech.model.entidade.Fornecedor;
import br.com.officecleantech.model.entidade.Produto;

class FornecedorDaoTest {

	@Disabled
	@Test
	@DisplayName("teste de listagem")
	void testListagem() {
		FornecedorDao dao = new FornecedorDao();
		ArrayList<Fornecedor> lista = dao.listar("");

		assertTrue(lista.size() == 2);
//		assertEquals(false, lista.size() == 2);
	}

	@Disabled
	@Test
	@DisplayName("teste de busca")
	void testBusca() {
		FornecedorDao dao = new FornecedorDao();
		ArrayList<Fornecedor> lista = dao.listar("ro");

//		assertTrue(lista.size()>0);
		assertEquals(lista.size(), 2);
	}
	
}
