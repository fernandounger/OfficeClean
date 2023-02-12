package br.com.officecleantech.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.officecleantech.model.entidade.Fornecedor;
import br.com.officecleantech.model.entidade.Produto;

public class ProdutoDao extends Conexao {

	public void cadastrar (Produto p) {
		String sql = "insert into Produto (Nome, Categoria, Fornecedor_Id, EstoqueMinimo, EstoqueMaximo, Descricao) values (?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
					
			ps.setString(1, p.getNome());
			ps.setString(2, p.getCategoria());
			ps.setLong(3, p.getFornecedor().getId());
			ps.setInt(4, p.getEstoqueMinimo());
			ps.setInt(5, p.getEstoqueMaximo());
			ps.setString(6, p.getDescricao());
			
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
	
	public void alterar(Produto p) {
		String sql = "update Produto set Nome = ?, Categoria = ?, Fornecedor_Id = ?, EstoqueMinimo = ?, EstoqueMaximo = ?, Descricao = ? where Id = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			
			ps.setString(1, p.getNome());
			ps.setString(2, p.getCategoria());
			ps.setLong(3, p.getFornecedor().getId());
			ps.setInt(4, p.getEstoqueMinimo());
			ps.setInt(5, p.getEstoqueMaximo());
			ps.setString(6, p.getDescricao());
			ps.setLong(7, p.getId());
			
			ps.execute();
 		} catch (SQLException e) {
			System.out.println("Erro na atualização");
			e.printStackTrace();
	 	} finally {
			fecharConexao();
		}
	}
	
	public ArrayList<Produto> listar(String nomeBusca) {
		ArrayList<Produto> lista = new ArrayList<Produto>();
		
		String sql = "select * from listagemProduto where Nome like ? order by Nome";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setString(1, "%" + nomeBusca + "%");
			
			ResultSet rs = ps.executeQuery();

			Produto p;

			while (rs.next()) {
				Fornecedor f = new Fornecedor();
				
				p = new Produto();
				p.setId(rs.getLong("Id"));
				p.setNome(rs.getString("Nome"));
				p.setCategoria(rs.getString("Categoria"));
				p.setFornecedor(f);
				f.setId(rs.getLong("Id"));
				p.setEstoqueMinimo(rs.getInt("EstoqueMinimo"));
				p.setEstoqueMaximo(rs.getInt("EstoqueMaximo"));
				p.setDescricao(rs.getString("Descricao"));
				
				lista.add(p);
			}

		} catch (SQLException e) {
			System.out.println("Falha na Listagem");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}

		return lista;
	}
	
	public Produto buscar(long id) {
		Produto p = null;
		
		String sql = "select * from listagemProduto where Id = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Fornecedor f = new Fornecedor();
				
				p = new Produto();
				p.setId(rs.getLong("Id"));
				p.setNome(rs.getString("Nome"));
				p.setCategoria(rs.getString("Categoria"));
				p.setFornecedor(f);
				f.setId(rs.getLong("Id"));
				p.setEstoqueMinimo(rs.getInt("EstoqueMinimo"));
				p.setEstoqueMaximo(rs.getInt("EstoqueMaximo"));
				p.setDescricao(rs.getString("Descricao"));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return p;
	}
	
	public void excluir(Produto p) {
		String sql = "delete from Produto where Id = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);		
			ps.setLong(1, p.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao excluir");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
}

