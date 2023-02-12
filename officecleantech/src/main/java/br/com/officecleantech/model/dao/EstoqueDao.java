package br.com.officecleantech.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.officecleantech.model.entidade.Estoque;

public class EstoqueDao extends Conexao {

	public void cadastrar (Estoque es) {
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
