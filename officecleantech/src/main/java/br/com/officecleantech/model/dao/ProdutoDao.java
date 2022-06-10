package br.com.officecleantech.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.officecleantech.model.entidade.Fornecedor;
import br.com.officecleantech.model.entidade.Produto;

public class ProdutoDao extends Conexao {

	public ArrayList<Produto> listar(String nomeBusca) {
		ArrayList<Produto> lista = new ArrayList<Produto>();

		try {
			String sql = "select * from listagemProduto where Nome like ? order by CodigoBarra";
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setString(1, "%" + nomeBusca + "%");
			ResultSet rs = ps.executeQuery();

			Produto p = null;
			Fornecedor f = null;

			while (rs.next()) {
				p = new Produto();
				p.setCodigoBarra(rs.getLong("CodigoBarra"));
				p.setNome(rs.getString("Nome"));
				p.setCategoria(rs.getString("Categoria"));
				f = new Fornecedor();
				f.setNome(rs.getString("Fornecedor"));
				p.setFornecedor(f);
				lista.add(p);
			}
			System.out.println("Sucesso na Listagem");

		} catch (SQLException e) {
			System.out.println("Falha na Listagem");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}

		return lista;
	}

//	public Produto buscar(long id) {
//		Produto produto = null;
//
//		String sql = "select * from listagemProduto " + "where CodigoBarra = ?";
//
//		try {
//			PreparedStatement ps = getConexao().prepareStatement(sql);
//			ps.setLong(1, id);
//			
//
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				produto = new Produto();
//				produto.setCodigoBarra(rs.getLong("CodigoBarra"));
//				produto.setNome(rs.getString("Nome"));
//				produto.setCategoria(rs.getString("Categoria"));
//			}
//			System.out.println("Sucesso no Buscar");
//		} catch (SQLException e) {
//			System.out.println("Falha no Buscar");
//			e.printStackTrace();
//		} finally {
//			fecharConexao();
//		}
//
//		return produto;
//	}

	public Produto buscar(long id) {

		String sql = "select * from listagemProduto WHERE CodigoBarra = ?";

		Produto p = null;

		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setLong(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				p = new Produto();
				p.setCodigoBarra(rs.getLong("CodigoBarra"));
				p.setNome(rs.getString("Nome"));

			}
			System.out.println("Sucesso no Buscar");

		} catch (SQLException e) {
			System.out.println("Falha no Buscar");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}

		return p;

	}

}
