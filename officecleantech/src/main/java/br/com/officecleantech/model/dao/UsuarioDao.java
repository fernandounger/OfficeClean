package br.com.officecleantech.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.officecleantech.model.entidade.Usuario;

public class UsuarioDao extends Conexao {

	public void cadastrar(Usuario u) {

		String sql = "INSERT INTO Usuario (Nome, Login, Senha) VALUES ( ?, ?, ?)";

		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setString(1, u.getNome());
			ps.setString(2, u.getLogin());
			ps.setString(3, u.getSenha());
			/*ps.setString(4, u.getNivelAcesso());*/
			ps.execute();

		} catch (SQLException e) {
			System.out.println("Erro no Cadastro");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}

	public Usuario logar(String name, String login, String password) {
		Usuario u = null;

		try {
			String sql = "SELECT * FROM Usuario WHERE Login = ? AND Senha = ?";
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(1, login);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			System.out.println(sql);

			if (rs.next()) {
				u = new Usuario();
				u.setId(rs.getLong(1));
				u.setNome(rs.getString(2));
				u.setLogin(rs.getString(3));
				// u.setSenha(rs.getString("Senha"));
			}
		} catch (SQLException e) {
			System.out.println("Erro na Consulta");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}

		return u;
	}

}