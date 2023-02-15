package br.com.officecleantech.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.officecleantech.model.entidade.Endereco;

public class EnderecoDao extends Conexao {
	
	public Long cadastrar (Endereco end) {
		String sql = "insert into Endereco (Logradouro, Numero, Complemento, Bairro, Cidade, Estado, CEP) values (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		
			ps.setString(1, end.getLogradouro());
			ps.setInt(2, end.getNumero());
			ps.setString(3, end.getComplemento());
			ps.setString(4, end.getBairro());
			ps.setString(5, end.getCidade());
			ps.setString(6, end.getEstado());
			ps.setString(7, end.getCep());
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			
			return rs.getLong(1);
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar");
			e.printStackTrace();
			return null;
		} finally {
			fecharConexao();
		}
	}
	
	public void alterar(Endereco end) {
		String sql = "update Endereco set Logradouro = ?, Numero = ?, Complemento = ?, Bairro = ?, Cidade = ?, Estado = ?, CEP = ? where Id = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			
			ps.setString(1, end.getLogradouro());
			ps.setInt(2, end.getNumero());
			ps.setString(3, end.getComplemento());
			ps.setString(4, end.getBairro());
			ps.setString(5, end.getCidade());
			ps.setString(6, end.getEstado());
			ps.setString(7, end.getCep());
			ps.setLong(8, end.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro na atualização");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
	
	public ArrayList<Endereco> listar(String logradouroBusca) {
		ArrayList<Endereco> lista = new ArrayList<Endereco>();
		
		String sql = "select * from Endereco where Logradouro";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setString(1, "%" + logradouroBusca + "%");
			
			ResultSet rs = ps.executeQuery();
			
			Endereco end;
			
			while (rs.next()) {
				end = new Endereco();
				end.setId(rs.getLong("Id"));
				end.setLogradouro(rs.getString("Logradouro"));
				end.setNumero(rs.getInt("Numero"));
				end.setComplemento(rs.getString("Complemento"));
				end.setBairro(rs.getString("Bairro"));
				end.setCidade(rs.getString("Cidade"));
				end.setEstado(rs.getString("Estado"));
				end.setCep(rs.getString("CEP"));
				
				lista.add(end);
			}
		} catch (SQLException e) {
			System.out.println("Falha na Listagem");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return lista;
	}
	
	public Endereco buscar(long id) {
		Endereco end = null;
		
		String sql = "select * from Endereco where Id = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
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

		return end;
	}
	
	public void excluir(Endereco end) {
		String sql = "delete from Endereco where Id = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setLong(1, end.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao excluir");
			e.printStackTrace();			
		} finally {
			fecharConexao();
		}
	}
}
