package br.com.officecleantech.model.entidade;

public class Estoque {
	private long id;
	private int quantidade;
	private double valorUnitario;
	private String localizacaoEstoque;
	
	private Produto produto;
	private Fornecedor fornecedor;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public double getValorUnitario() {
		return valorUnitario;
	}
	
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	public String getLocalizacaoEstoque() {
		return localizacaoEstoque;
	}
	
	public void setLocalizacaoEstoque(String localizacaoEstoque) {
		this.localizacaoEstoque = localizacaoEstoque;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	

}
