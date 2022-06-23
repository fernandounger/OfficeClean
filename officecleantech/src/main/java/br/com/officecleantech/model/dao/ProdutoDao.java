package br.com.officecleantech.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.officecleantech.model.entidade.Fornecedor;
import br.com.officecleantech.model.entidade.Produto;

public class ProdutoDao extends Conexao {

	public void cadastrar (Produto p) {
		String sql = "insert into Produto (CodigoBarra, Nome, Categoria, Fornecedor_Id, EstoqueMinimo, EstoqueMaximo, Descricao) values (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
					
			ps.setLong(1, p.getCodigoBarra());
			ps.setString(2, p.getNome());
			ps.setString(3, p.getCategoria());
			ps.setLong(4, p.getFornecedor().getId());
			ps.setInt(5, p.getEstoqueMinimo());
			ps.setInt(6, p.getEstoqueMaximo());
			ps.setString(7, p.getDescricao());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
	
	public void alterar(Produto p) {
		String sql = "update Produto set CodigoBarra = ?, Nome = ?, Categoria = ?, Fornecedor_Id = (select max(Id) from Fornecedor), EstoqueMinimo = ?, EstoqueMaximo = ?, Descricao = ? where CodigoBarra = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			
			ps.setLong(1, p.getCodigoBarra());
			ps.setString(2, p.getNome());
			ps.setString(3, p.getCategoria());
			ps.setLong(4, p.getFornecedor().getId());
			ps.setInt(5, p.getEstoqueMinimo());
			ps.setInt(6, p.getEstoqueMaximo());
			ps.setString(7, p.getDescricao());
			
			ps.executeUpdate();
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

			Fornecedor f = null;
			Produto p;

			while (rs.next()) {
				f = new Fornecedor();
				f.setNome("Fornecedor");
				
				p = new Produto();
				p.setCodigoBarra(rs.getLong("CodigoBarra"));
				p.setNome(rs.getString("Nome"));
				p.setCategoria(rs.getString("Categoria"));
				p.setFornecedor(f);
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
	
	public Produto buscar(Long Id) {
		Produto p = null;
		Fornecedor f;
		
		String sql = "select * from listagemProduto where Id = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setLong(1, Id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				f = new Fornecedor();
				f.setNome("Fornecedor");
				
				p = new Produto();
				p.setCodigoBarra(rs.getLong("CodigoBarra"));
				p.setNome(rs.getString("Nome"));
				p.setCategoria(rs.getString("Categoria"));
				p.setFornecedor(f);
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
		String sql = "delete from Produto where CodigoBarra = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareCall(sql);		
			ps.setLong(1, p.getCodigoBarra());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao excluir");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
}

