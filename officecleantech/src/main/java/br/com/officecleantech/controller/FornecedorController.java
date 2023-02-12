package br.com.officecleantech.controller;

import java.util.ArrayList;

import br.com.officecleantech.model.dao.FornecedorDao;
import br.com.officecleantech.model.entidade.Fornecedor;

public class FornecedorController {
	FornecedorDao dao = new FornecedorDao();
	
	public void cadastrar(Fornecedor f) {
		dao.cadastrar(f);
	}
	
	public void alterar(Fornecedor f) {
		dao.alterar(f);
	}
	
	public ArrayList<Fornecedor> listar(String nomeBusca) {
		return dao.listar(nomeBusca);
	}
	
	public Fornecedor buscar(long id) {
		return dao.buscar(id);
	}
	
	public void excluir(Fornecedor f) {
		dao.excluir(f);
	}
}
