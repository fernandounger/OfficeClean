package br.com.officecleantech.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.officecleantech.model.entidade.Fornecedor;
import br.com.officecleantech.model.entidade.Produto;

public class ProdutoDao extends Conexao {

	public ArrayList<Produto> listar(String listagem) {
		ArrayList<Produto> lista = new ArrayList<Produto>();

		try {
			String sql = "select * from listagemProduto";
			PreparedStatement ps = getConexao().prepareStatement(sql);
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

}
