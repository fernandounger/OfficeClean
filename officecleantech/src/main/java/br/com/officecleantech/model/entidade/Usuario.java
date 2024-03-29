package br.com.officecleantech.model.entidade;

public class Usuario {
	private long Id;
	private String Nome;
	private String Login;
	private String Senha;

	public Usuario() {
		this.Nome = null;
		this.Login = null;
		this.Senha = null;
	}
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

}
