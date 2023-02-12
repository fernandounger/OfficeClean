package br.com.officecleantech.controller;

import java.util.ArrayList;

import br.com.officecleantech.model.dao.FornecedorDao;
import br.com.officecleantech.model.entidade.Endereco;
import br.com.officecleantech.model.entidade.Fornecedor;

public class FornecedorController {
	FornecedorDao dao = new FornecedorDao();
	
	public void cadastrar(Endereco end, Fornecedor f) {
		dao.cadastrar(end, f);
	}
	
	public void alterar(Endereco end, Fornecedor f) {
		dao.alterar(end, f);
	}
	
	public ArrayList<Fornecedor> listar(String nomeBusca) {
		return dao.listar(nomeBusca);
	}
	
	public Fornecedor buscar(Long Id) {
		return dao.buscar(Id);
	}
	
	public void excluir(Fornecedor f) {
		dao.excluir(f);
	}
}
