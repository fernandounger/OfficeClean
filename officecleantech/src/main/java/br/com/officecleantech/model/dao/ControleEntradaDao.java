package br.com.officecleantech.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.officecleantech.model.entidade.ControleEntrada;

public class ControleEntradaDao extends Conexao {

	public void cadastrar (ControleEntrada ce) {
		String sql = "";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
	}
}
