package br.com.officecleantech.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.officecleantech.model.entidade.Fornecedor;
import br.com.officecleantech.model.entidade.Produto;

public class ProdutoDao extends Conexao {

	/*
	 * public String cadastrar(Produto p) { String mensagem = "";
	 * 
	 * String sql =
	 * "INSERT INTO Produto (Nome, Categoria, Fornecedor_Id, EstoqueMinimo, EstoqueMaximo, Descricao) VALUES(?,?,?,?,?,?)"
	 * ; try { PreparedStatement ps = getConexao().prepareStatement(sql);
	 * ps.setString(1, p.getNome()); ps.setString(2, p.getCategoria()); ps.setInt(3,
	 * valorFornecedor); ps.setInt(2, p.getEstoqueMinimo()); ps.setInt(2,
	 * p.getEstoqueMaximo()); ps.setString(2, p.getDescricao());
	 * 
	 * 
	 * ps.executeUpdate();
	 * 
	 * // Fim primeira inserção
	 * 
	 * // recuperando last_inser_id() ResultSet rs = ps.getGeneratedKeys();
	 * rs.next(); int valorFornecedor = rs.getInt(1);
	 * 
	 * // Segunda Inserção sql =
	 * "INSERT INTO Fornecedor (CNPJ, Nome, Telefone, Email, Site, Endereco_Id) VALUES(?,?,?,?,?,?)"
	 * ;
	 * 
	 * ps = getConexao().prepareStatement(sql); ps.setString(1, f.getCnpj());
	 * ps.setString(2, f.getNome()); ps.setString(3, f.getTelefone());
	 * ps.setString(4, f.getEmail()); ps.setString(5, f.getSite()); ps.setInt(6,
	 * valorEndereco);
	 * 
	 * ps.executeUpdate();
	 * 
	 * // System.out.print(valorPessoa); // System.out.print(valorEndereco);
	 * mensagem = "tudo certo"; } catch (SQLException e) { mensagem = "deu ruim";
	 * e.printStackTrace(); } finally { fecharConexao(); }
	 * 
	 * return mensagem; }
	 */

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
}
