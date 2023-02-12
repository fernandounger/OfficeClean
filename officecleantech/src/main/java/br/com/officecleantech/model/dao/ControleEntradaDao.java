package br.com.officecleantech.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.officecleantech.model.entidade.ControleEntrada;
import br.com.officecleantech.model.entidade.Fornecedor;
import br.com.officecleantech.model.entidade.Produto;

public class ControleEntradaDao extends Conexao {

	public void cadastrar (ControleEntrada ce) {
		String sql = "insert into ControleEntrada (Produto_Id, Fornecedor_Id, Quantidade, ValorUnitario) values (?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			
			ps.setLong(1, ce.getProduto().getId());
			ps.setLong(2, ce.getFornecedor().getId());
			ps.setInt(3, ce.getQuantidade());
			ps.setDouble(4, ce.getValorUnitario());
			
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
	
	public void alterar (ControleEntrada ce) {
		String sql = "update ControleEntrada set Produto_Id = ?, Fornecedor_Id = ?, Quantidade = ?, ValorUnitario = ? where Id = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			
			ps.setLong(1, ce.getProduto().getId());
			ps.setLong(2, ce.getFornecedor().getId());
			ps.setInt(3, ce.getQuantidade());
			ps.setDouble(4, ce.getValorUnitario());
			ps.setLong(5, ce.getId());
			
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
	
	public ArrayList<ControleEntrada> listar(String ValorUnitarioBusca) {
		ArrayList<ControleEntrada> lista = new ArrayList<ControleEntrada>();
		
		String sql = "select * from ControleEntrada where ValorUnitario like ? order by ValorUnitario";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setString(1, "%" + ValorUnitarioBusca + "%");
			
			ResultSet rs = ps.executeQuery();
			ControleEntrada ce;
			
			while (rs.next()) {
				Produto p = new Produto();
				Fornecedor f = new Fornecedor();
				
				ce = new ControleEntrada();
				ce.setId(rs.getLong("Id"));
				ce.setDataEntrada(rs.getDate("DataEntrada"));
				ce.setProduto(p);
				p.setId(rs.getLong("Id"));
				ce.setFornecedor(f);
				f.setId(rs.getLong("Id"));
				ce.setQuantidade(rs.getInt("Quantidade"));
				ce.setValorUnitario(rs.getDouble("ValorUnitario"));
				
				lista.add(ce);
			}
		} catch (SQLException e) {
			System.out.println("Erro na consulta");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return lista;
	}
	
	public ControleEntrada buscar(long id) {
		ControleEntrada ce = null;
		
		String sql = "select * from ControleEntrada where Id = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Produto p = new Produto();
				Fornecedor f = new Fornecedor();
				
				ce = new ControleEntrada();
				ce.setId(rs.getLong("Id"));
				ce.setDataEntrada(rs.getDate("DataEntrada"));
				ce.setProduto(p);
				p.setId(rs.getLong("Id"));
				ce.setFornecedor(f);
				f.setId(rs.getLong("Id"));
				ce.setQuantidade(rs.getInt("Quantidade"));
				ce.setValorUnitario(rs.getDouble("ValorUnitario"));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return ce;
	}
	
	public void excluir(ControleEntrada ce) {
		String sql = "delete from ControleEntrada where Id = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setLong(1, ce.getId());
			
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao excluir");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
}
