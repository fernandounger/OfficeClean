package br.com.officecleantech.model.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.officecleantech.model.entidade.Fornecedor;

class FornecedorDaoTest {

//	@Disabled
	@Test
	@DisplayName("teste de listagem")
	void testListagem() {
		FornecedorDao dao = new FornecedorDao();
		ArrayList<Fornecedor> lista = dao.listar("");

		assertTrue(lista.size()>0);
//		assertEquals(false, lista.size() == 2);
	}

}


