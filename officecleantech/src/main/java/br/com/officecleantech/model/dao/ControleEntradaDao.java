package br.com.officecleantech.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.officecleantech.model.entidade.ControleEntrada;
import br.com.officecleantech.model.entidade.Estoque;
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
	
	public void alterar (Estoque es) {
		String sql = "update Estoque set Produto_Id = ?, Fornecedor_Id = ?, Quantidade = ?, ValorUnitario = ?, LocalizacaoEstoque = ? where Id = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			
			ps.setLong(1, es.getProduto().getId());
			ps.setLong(2, es.getFornecedor().getId());
			ps.setInt(3, es.getQuantidade());
			ps.setDouble(4, es.getValorUnitario());
			ps.setString(5, es.getLocalizacaoEstoque());
			ps.setLong(6, es.getId());
			
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
	
	public ArrayList<Estoque> listar(String LocalizacaoEstoqueBusca) {
		ArrayList<Estoque> lista = new ArrayList<Estoque>();
		
		String sql = "select * from Estoque where LocalizacaoEstoque like ? order by LocalizacaoEstoque";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setString(1, "%" + LocalizacaoEstoqueBusca + "%");
			
			ResultSet rs = ps.executeQuery();
			Estoque es;
			
			while (rs.next()) {
				Produto p = new Produto();
				Fornecedor f = new Fornecedor();
				
				es = new Estoque();
				es.setId(rs.getLong("Id"));
				es.setProduto(p);
				p.setId(rs.getLong("Id"));
				es.setFornecedor(f);
				f.setId(rs.getLong("Id"));
				es.setQuantidade(rs.getInt("Quantidade"));
				es.setValorUnitario(rs.getDouble("ValorUnitario"));
				es.setLocalizacaoEstoque(rs.getString("LocalizacaoEstoque"));
				
				lista.add(es);
			}
		} catch (SQLException e) {
			System.out.println("Erro na consulta");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return lista;
	}
	
	public Estoque buscar(long id) {
		Estoque es = null;
		
		String sql = "select * from Estoque where Id = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Produto p = new Produto();
				Fornecedor f = new Fornecedor();
				
				es = new Estoque();
				es.setId(rs.getLong("Id"));
				es.setProduto(p);
				p.setId(rs.getLong("Id"));
				es.setFornecedor(f);
				f.setId(rs.getLong("Id"));
				es.setQuantidade(rs.getInt("Quantidade"));
				es.setValorUnitario(rs.getDouble("ValorUnitario"));
				es.setLocalizacaoEstoque(rs.getString("LocalizacaoEstoque"));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return es;
	}
	
	public void excluir(Estoque es) {
		String sql = "delete from Estoque where Id = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setLong(1, es.getId());
			
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao excluir");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
}
