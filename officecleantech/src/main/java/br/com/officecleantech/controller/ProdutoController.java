package br.com.officecleantech.controller;

import java.util.ArrayList;

import br.com.officecleantech.model.dao.ProdutoDao;
import br.com.officecleantech.model.entidade.Produto;

public class ProdutoController {
	ProdutoDao dao = new ProdutoDao();
	
	public void cadastrar(Produto p) {
		dao.cadastrar(p);
	}
	
	public void alterar(Produto p) {
		dao.alterar(p);
	}
	
	public ArrayList<Produto> listar(String nomeBusca) {
		return dao.listar(nomeBusca);
	}
	
	public Produto buscar(long id) {
		return dao.buscar(id);
	}
	
	public void excluir(Produto p) {
		dao.excluir(p);
	}
}