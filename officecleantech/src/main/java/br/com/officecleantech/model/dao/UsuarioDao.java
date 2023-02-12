package br.com.officecleantech.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.officecleantech.model.entidade.Usuario;

public class UsuarioDao extends Conexao {

	public String cadastrar(Usuario u) {
		String mensagem = "";

		try {
			String sql = "INSERT INTO Usuario (Nome, Login, Senha, NivelAcesso) VALUES ( ?, ?, ?, ?)";

			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setString(1, u.getNome());
			ps.setString(2, u.getLogin());
			ps.setString(3, u.getSenha());
			ps.setString(4, u.getNivelAcesso());
			ps.execute();

		} catch (SQLException e) {


		} finally {

			fecharConexao();
		}
		return mensagem;
	}

	public Usuario logar( String login, String password) {
		Usuario u = null;

		String mensagem = "";

		try {
			String sql = "SELECT * FROM Usuario WHERE Login = ? AND Senha = ? ";
			PreparedStatement ps = getConexao().prepareStatement(sql);
		
			ps.setString(1, login);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();



			if (rs.next()) {
				u = new Usuario();
				u.setId(rs.getLong(1));
				u.setNome(rs.getString(2));
				u.setLogin(rs.getString(3));



			} else {

			}

		} catch (SQLException e) {


		} finally {

			fecharConexao();
		}
		return u ;

	}

	public ArrayList<Usuario> listar(String nomeBusca) {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		try {
			String sql = "select * from Usuario where Nome like ? order by Id";
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setString(1, "%" + nomeBusca + "%");

			Usuario u = null;

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new Usuario();
				u.setId(rs.getLong("Id"));
				u.setNome(rs.getString("Nome"));
				u.setLogin(rs.getString("Login"));
				u.setSenha(rs.getString("Senha"));
				u.setNivelAcesso(rs.getString("NivelAcesso"));

				lista.add(u);
			}


		} catch (SQLException e) {



		} finally {
			fecharConexao();
		}
		return lista;
	}

	public Usuario pesquisar(long id) {
		Usuario user = null;

		String sql = "select * from Usuario " + "where Id = ?";

		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setLong(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new Usuario();
				user.setId(rs.getLong("Id"));
				user.setNome(rs.getString("Nome"));
				user.setLogin(rs.getString("Login"));
				user.setSenha(rs.getString("Senha"));
				user.setNivelAcesso(rs.getString("NivelAcesso"));


			}

		} catch (SQLException e) {


			return null;
		} finally {
			fecharConexao();
		}

		return user;
	}

	public  String alterar(Usuario c) {
		String sql = "update Usuario set" + " Nome = ?, " + "Login = ?, " + " Senha = ?, " + "NivelAcesso = ?"
				+ " where Id = ?";

		String mensagem = "";
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setString(1, c.getNome());
			ps.setString(2, c.getLogin());
			ps.setString(3, c.getSenha());
			ps.setString(4, c.getNivelAcesso());
			ps.setLong(5, c.getId());
			ps.execute();


		} catch (SQLException e) {



		} finally {
			fecharConexao();
		}
		return mensagem;
	}

	public String excluir(Usuario u) {
		String sql = "delete from Usuario where Id = ?";

		String mensagem = "";
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setLong(1, u.getId());

			ps.execute();

		} catch (SQLException e) {



		} finally {
			fecharConexao();
		}
		return mensagem;
	}

}
