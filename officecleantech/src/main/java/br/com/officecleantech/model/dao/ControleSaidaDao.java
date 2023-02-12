package br.com.officecleantech.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.officecleantech.model.entidade.ControleSaida;
import br.com.officecleantech.model.entidade.Fornecedor;
import br.com.officecleantech.model.entidade.Produto;

public class ControleSaidaDao extends Conexao {

	public void cadastrar (ControleSaida cs) {
		String sql = "insert into ControleSaida (Produto_Id, Quantidade, ValorUnitario, Justificativa) values (?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			
			ps.setLong(1, cs.getProduto().getId());
			ps.setInt(2, cs.getQuantidade());
			ps.setDouble(3, cs.getValorUnitario());
			ps.setString(4, cs.getJustificativa());
			
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
	
	public void alterar (ControleSaida cs) {
		String sql = "update ControleSaida set Produto_Id = ?, Quantidade = ?, ValorUnitario = ?, Justificativa = ? where Id = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			
			ps.setLong(1, cs.getProduto().getId());
			ps.setInt(2, cs.getQuantidade());
			ps.setDouble(3, cs.getValorUnitario());
			ps.setString(4, cs.getJustificativa());
			ps.setLong(5, cs.getId());
			
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
	
	public ArrayList<ControleSaida> listar(String JustificativaBusca) {
		ArrayList<ControleSaida> lista = new ArrayList<ControleSaida>();
		
		String sql = "select * from ControleSaida where Justificativa like ? order by Justificativa";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setString(1, "%" + JustificativaBusca + "%");
			
			ResultSet rs = ps.executeQuery();
			ControleSaida cs;
			
			while (rs.next()) {
				Produto p = new Produto();
				Fornecedor f = new Fornecedor();
				
				cs = new ControleSaida();
				cs.setId(rs.getLong("Id"));
				cs.setDataSaida(rs.getDate("DataSaida"));
				cs.setProduto(p);
				p.setId(rs.getLong("Id"));
				cs.setQuantidade(rs.getInt("Quantidade"));
				cs.setValorUnitario(rs.getDouble("ValorUnitario"));
				cs.setJustificativa(rs.getString("Justificativa"));
				
				lista.add(cs);
			}
		} catch (SQLException e) {
			System.out.println("Erro na consulta");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return lista;
	}
	
	public ControleSaida buscar(long id) {
		ControleSaida cs = null;
		
		String sql = "select * from ControleSaida where Id = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Produto p = new Produto();
				
				cs = new ControleSaida();
				cs.setId(rs.getLong("Id"));
				cs.setDataSaida(rs.getDate("DataSaida"));
				cs.setProduto(p);
				p.setId(rs.getLong("Id"));
				cs.setQuantidade(rs.getInt("Quantidade"));
				cs.setValorUnitario(rs.getDouble("ValorUnitario"));
				cs.setJustificativa(rs.getString("Justificativa"));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return cs;
	}
	
	public void excluir(ControleSaida cs) {
		String sql = "delete from ControleSaida where Id = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setLong(1, cs.getId());
			
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao excluir");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
}
