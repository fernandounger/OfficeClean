package br.com.officecleantech.controller;

import java.util.ArrayList;

import br.com.officecleantech.model.dao.EstoqueDao;
import br.com.officecleantech.model.entidade.Estoque;

public class EstoqueController {
	EstoqueDao dao = new EstoqueDao();
	
	public void cadastrar(Estoque es) {
		dao.cadastrar(es);
	}
	
	public void alterar(Estoque es) {
		dao.alterar(es);
	}
	
	public ArrayList<Estoque> listar(String LocalizacaoEstoqueBusca) {
		return dao.listar(LocalizacaoEstoqueBusca);
	}
	
	public Estoque buscar(long id) {
		return dao.buscar(id);
	}
	
	public void escluir(Estoque es) {
		dao.excluir(es);
	}
}
