package br.com.officecleantech.controller;

import java.util.ArrayList;

import br.com.officecleantech.model.dao.ControleSaidaDao;
import br.com.officecleantech.model.entidade.ControleSaida;

public class ControleSaidaController {
	ControleSaidaDao dao = new ControleSaidaDao();
	
	public void cadastrar(ControleSaida cs) {
		dao.cadastrar(cs);
	}
	
	public void alterar(ControleSaida cs) {
		dao.alterar(cs);
	}
	
	public ArrayList<ControleSaida> listar(String JustificativaBusca) {
		return dao.listar(JustificativaBusca);
	}
	
	public ControleSaida buscar(long id) {
		return dao.buscar(id);
	}
	
	public void excluir(ControleSaida cs) {
		dao.excluir(cs);
	}
}
