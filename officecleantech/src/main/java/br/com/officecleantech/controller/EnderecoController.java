package br.com.officecleantech.controller;

import java.util.ArrayList;

import br.com.officecleantech.model.dao.EnderecoDao;
import br.com.officecleantech.model.entidade.Endereco;

public class EnderecoController {
	EnderecoDao dao = new EnderecoDao();
	
	public void cadastrar(Endereco end) {
		dao.cadastrar(end);
	}
	
	public void alterar(Endereco end) {
		dao.alterar(end);
	}
	
	public ArrayList<Endereco> listar(String Logradouro) {
		return dao.listar(Logradouro);
	}
	
	public Endereco buscar(long id) {
		return dao.buscar(id);
	}
	
	public void excluir(Endereco end) {
		dao.excluir(end);
	}
}
