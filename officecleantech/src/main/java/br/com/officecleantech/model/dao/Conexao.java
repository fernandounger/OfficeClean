package br.com.officecleantech.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private String caminho = "jdbc:mysql://localhost:3306/estoquebd";
	private String usuario = "root";
	private String senha = "";

	private Connection conn = null;

	public Connection getConexao() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(caminho, usuario, senha);
			System.out.println("Conectado com sucesso");

		} catch (ClassNotFoundException e) {
			System.out.println("Não Encontrou o Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Erro ao acessar o banco de dados");
			e.printStackTrace();
		}
		return conn;

	}

	public void fecharConexao() {
		try {
			System.out.println("Conexão Fechada");
			conn.close();
		} catch (SQLException e) {
			System.out.println("Deu Problema");
			e.printStackTrace();
		}
	}

}
