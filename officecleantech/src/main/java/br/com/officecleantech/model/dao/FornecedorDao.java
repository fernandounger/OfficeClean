package br.com.officecleantech.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.CallableStatement;

import br.com.officecleantech.model.entidade.Endereco;
import br.com.officecleantech.model.entidade.Fornecedor;

public class FornecedorDao extends Conexao {

	public void cadastrar(Endereco end, Fornecedor f) {
		String call = "CALL cadastra_End (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			CallableStatement cs = (CallableStatement) getConexao().prepareCall(call);
				
			cs.setString("C_Logradouro", end.getLogradouro());
			cs.setInt("C_Numero", end.getNumero());
			cs.setString("C_Complemento", end.getComplemento());
			cs.setString("C_Bairro", end.getBairro());
			cs.setString("C_Cidade", end.getCidade());
			cs.setString("C_Estado", end.getEstado());
			cs.setString("C_CEP", end.getCep());
			cs.setString("C_CNPJ", f.getCnpj());
			cs.setString("C_Nome", f.getNome());
			cs.setString("C_Telefone", f.getTelefone());
			cs.setString("C_Email", f.getEmail());
			cs.setString("C_Site", f.getSite());
			
			cs.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
	
	public void alterar(Endereco end, Fornecedor f) {
		String call = "CALL altera_End (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, (select max(Endereco_Id) from Fornecedor), ?)";
		
		try {
			CallableStatement cs = (CallableStatement) getConexao().prepareCall(call);
			cs.setString("C_Logradouro", end.getLogradouro());
			cs.setInt("C_Numero", end.getNumero());
			cs.setString("C_Complemento", end.getComplemento());
			cs.setString("C_Bairro", end.getBairro());
			cs.setString("C_Cidade", end.getCidade());
			cs.setString("C_Estado", end.getEstado());
			cs.setString("C_CEP", end.getCep());
			cs.setString("C_CNPJ", f.getCnpj());
			cs.setString("C_Nome", f.getNome());
			cs.setString("C_Telefone", f.getTelefone());
			cs.setString("C_Email", f.getEmail());
			cs.setString("C_Site", f.getSite());
			cs.setLong("C_Endereco_Id", end.getId());
			cs.setLong("C_IdFornecedor", f.getId());
			cs.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
	
	public ArrayList<Fornecedor> listar(String nomeBusca) {
		ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();

		String sql = "select * from listagemFornecedor where Nome like ? order by Nome";
		
		try {	
			PreparedStatement ps = getConexao().prepareStatement(sql);	
			ps.setString(1, "%" + nomeBusca + "%");
			
			ResultSet rs = ps.executeQuery();
			Fornecedor f;
			Endereco end = null;
		
			while (rs.next()) {
				f = new Fornecedor();
				f.setId(rs.getLong("Id"));
				f.setCnpj(rs.getString("CNPJ"));
				f.setNome(rs.getString("Nome"));
				f.setTelefone(rs.getString("Telefone"));
				f.setEmail(rs.getString("Email"));
				f.setSite(rs.getString("Site"));
				f.setEndereco(end);

				end = new Endereco();
				end.setId(rs.getLong("Id"));
				end.setLogradouro(rs.getString("Logradouro"));
				end.setNumero(rs.getInt("Numero"));
				end.setComplemento(rs.getString("Complemento"));
				end.setBairro(rs.getString("Bairro"));
				end.setCidade(rs.getString("Cidade"));
				end.setEstado(rs.getString("Estado"));
				end.setCep(rs.getString("CEP"));
										
				lista.add(f);
			}

		} catch (SQLException e) {
			System.out.println("Erro na consulta");
			e.printStackTrace();

		} finally {
			fecharConexao();
		}
		return lista;
	}
	
	public Fornecedor buscar(Long Id) {
		Fornecedor f = null;
		Endereco end = null;
		
		String sql = "select * from listagemFornecedor where Id = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setLong(1, Id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				f = new Fornecedor();
				f.setId(rs.getLong("Id"));
				f.setCnpj(rs.getString("CNPJ"));
				f.setNome(rs.getString("Nome"));
				f.setTelefone(rs.getString("Telefone"));
				f.setEmail(rs.getString("Email"));
				f.setSite(rs.getString("Site"));
				f.setEndereco(end);
				
				end = new Endereco();
				end.setId(rs.getLong("Id"));
				end.setLogradouro(rs.getString("Logradouro"));
				end.setNumero(rs.getInt("Numero"));
				end.setComplemento(rs.getString("Complemento"));
				end.setBairro(rs.getString("Bairro"));
				end.setCidade(rs.getString("Cidade"));
				end.setEstado(rs.getString("Estado"));
				end.setCep(rs.getString("CEP"));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return f;
	}
	
	public void excluir(Fornecedor f) {
		String sql = "delete from Fornecedor where Id = ? ";
				
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setLong(1, f.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao excluir");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}

}

