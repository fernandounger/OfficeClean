package br.com.officecleantech.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.officecleantech.model.entidade.Endereco;
import br.com.officecleantech.model.entidade.Fornecedor;
import br.com.officecleantech.model.entidade.Produto;

public class FornecedorDao extends Conexao {

	public ArrayList<Fornecedor> listar(String nomeBusca) {
		ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();

		try {
			String sql = "select * from listagemFornecedor where Nome like ? order by Id";
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setString(1, "%" + nomeBusca + "%");

			Fornecedor f = null;
			Endereco end = null;

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = new Fornecedor();
				f.setId(rs.getLong("Id"));
				f.setNome(rs.getString("Nome"));
				f.setTelefone(rs.getString("Telefone"));
				f.setEmail(rs.getString("Email"));

				end = new Endereco();
				end.setEstado(rs.getString("Estado"));
				end.setCidade(rs.getString("Cidade"));
				end.setCep(rs.getString("CEP"));
				end.setBairro(rs.getString("Bairro"));
				end.setLogradouro(rs.getString("Logradouro"));
				end.setNumero(rs.getInt("Numero"));
				end.setComplemento(rs.getString("Complemento"));
				f.setEndereco(end);
				lista.add(f);
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
