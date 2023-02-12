package br.com.officecleantech.controller;

import java.util.ArrayList;

import br.com.officecleantech.model.dao.ControleEntradaDao;
import br.com.officecleantech.model.entidade.ControleEntrada;

public class ControleEntradaController {
	ControleEntradaDao dao = new ControleEntradaDao();
	
	public void cadastrar(ControleEntrada ce) {
		dao.cadastrar(ce);
	}
	
	public void alterar(ControleEntrada ce) {
		dao.alterar(ce);
	}
	
	public ArrayList<ControleEntrada> listar(String ValorUnitarioBusca) {
		return dao.listar(ValorUnitarioBusca);
	}
	
	public ControleEntrada buscar(long id) {
		return dao.buscar(id);
	}
	
	public void excluir(ControleEntrada ce) {
		dao.excluir(ce);
	}
}
