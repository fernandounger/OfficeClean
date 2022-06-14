package br.com.officecleantech.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.officecleantech.model.entidade.Endereco;
import br.com.officecleantech.model.entidade.Fornecedor;

public class FornecedorDao extends Conexao {

	public String cadastrar(Fornecedor f) {
		String mensagem = "";

		String sql = "INSERT INTO Endereco (Logradouro, Numero, Complemento, Bairro, Cidade, Estado, CEP) VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, f.getEndereco().getLogradouro());
			ps.setInt(2, f.getEndereco().getNumero());
			ps.setString(3, f.getEndereco().getComplemento());
			ps.setString(4, f.getEndereco().getBairro());
			ps.setString(5, f.getEndereco().getCidade());
			ps.setString(6, f.getEndereco().getEstado());
			ps.setString(7, f.getEndereco().getCep());
			

			ps.executeUpdate();

			// Fim primeira inserção

			// recuperando last_inser_id()
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int valorEndereco = rs.getInt(1);

			// Segunda Inserção
			sql = "INSERT INTO Fornecedor (CNPJ, Nome, Telefone, Email, Site, Endereco_Id) VALUES(?,?,?,?,?,?)";

			ps = getConexao().prepareStatement(sql);
			ps.setString(1, f.getCnpj());
			ps.setString(2, f.getNome());
			ps.setString(3, f.getTelefone());
			ps.setString(4, f.getEmail());
			ps.setString(5, f.getSite());
			ps.setInt(6, valorEndereco);

			ps.executeUpdate();

//			System.out.print(valorPessoa);
//			System.out.print(valorEndereco);
			mensagem = "tudo certo";
		} catch (SQLException e) {
			mensagem = "deu ruim";
			e.printStackTrace();
		} finally {
			fecharConexao();
		}

		return mensagem;
	}

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
