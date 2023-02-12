package br.com.officecleantech.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.officecleantech.model.entidade.ControleSaida;

public class ControleSaidaDao extends Conexao {

	public void cadastrar (ControleSaida cs) {
		String sql = "";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
}
