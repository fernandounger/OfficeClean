package br.com.officecleantech.teste;

import br.com.officecleantech.model.dao.Conexao;

public class TesteConexao {

	public static void main(String[] args) {
	
		Conexao c = new Conexao();
		System.out.println(c.getConexao());
		
	}

}
