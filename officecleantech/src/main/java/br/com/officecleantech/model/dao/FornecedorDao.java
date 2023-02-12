package br.com.officecleantech.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.officecleantech.model.entidade.Endereco;
import br.com.officecleantech.model.entidade.Fornecedor;

public class FornecedorDao extends Conexao {

	public void cadastrar(Fornecedor f) {
		String sql = "insert into Fornecedor (CNPJ, Nome, Telefone, Email, Site, Endereco_Id) values (?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
				
			ps.setString(1, f.getCnpj());
			ps.setString(2, f.getNome());
			ps.setString(3, f.getTelefone());
			ps.setString(4, f.getEmail());
			ps.setString(5, f.getSite());
			ps.setLong(6, f.getEndereco().getId());
			
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
	
	public void alterar(Fornecedor f) {
		String sql = "update Fornecedor set CNPJ = ?, Nome = ?, Telefone = ?, Email = ?, Site = ?, Endereco_Id = ? where Id = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			
			ps.setString(1, f.getCnpj());
			ps.setString(2, f.getNome());
			ps.setString(3, f.getTelefone());
			ps.setString(4, f.getEmail());
			ps.setString(5, f.getSite());
			ps.setLong(6, f.getEndereco().getId());
			ps.setLong(7, f.getId());
			
			ps.execute();
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
		
			while (rs.next()) {
				Endereco end = new Endereco();
				
				f = new Fornecedor();
				f.setId(rs.getLong("Id"));
				f.setCnpj(rs.getString("CNPJ"));
				f.setNome(rs.getString("Nome"));
				f.setTelefone(rs.getString("Telefone"));
				f.setEmail(rs.getString("Email"));
				f.setSite(rs.getString("Site"));
				f.setEndereco(end);
				end.setId(rs.getLong("Id"));
										
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
	
	public Fornecedor buscar(long id) {
		Fornecedor f = null;
		
		String sql = "select * from listagemFornecedor where Id = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Endereco end = new Endereco();
				
				f = new Fornecedor();
				f.setId(rs.getLong("Id"));
				f.setCnpj(rs.getString("CNPJ"));
				f.setNome(rs.getString("Nome"));
				f.setTelefone(rs.getString("Telefone"));
				f.setEmail(rs.getString("Email"));
				f.setSite(rs.getString("Site"));
				f.setEndereco(end);
				end.setId(rs.getLong("Id"));
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
			
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao excluir");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
}

