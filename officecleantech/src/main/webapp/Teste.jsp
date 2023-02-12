<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.com.officecleantech.model.dao.Conexao" %>
<%@ page import="br.com.officecleantech.model.entidade.Fornecedor" %>
<%@ page import="br.com.officecleantech.model.entidade.Endereco" %>
<%@ page import="br.com.officecleantech.model.dao.FornecedorDao" %>
<%@ page import="br.com.officecleantech.model.dao.EnderecoDao" %>    
<%@ page import="java.util.ArrayList" %>
<%@ page import="br.com.officecleantech.model.entidade.Produto" %>
<%@ page import="br.com.officecleantech.model.dao.ProdutoDao" %>
<%@ page import="br.com.officecleantech.model.entidade.Estoque" %>
<%@ page import="br.com.officecleantech.model.dao.EstoqueDao" %>
<%@ page import="br.com.officecleantech.model.entidade.ControleEntrada" %>
<%@ page import="br.com.officecleantech.model.dao.ControleEntradaDao" %>
<%@ page import="br.com.officecleantech.model.entidade.ControleSaida" %>
<%@ page import="br.com.officecleantech.model.dao.ControleSaidaDao" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		Conexao c = new Conexao();
		c.getConexao();
		
		c.fecharConexao();
		
		Endereco end = new Endereco();
		end.setLogradouro("Rua Florêncio Lima");
		end.setNumero(330);
		end.setComplemento("");
		end.setBairro("Sarapui");
		end.setCidade("Duque de Caxias");
		end.setEstado("RJ");
		end.setCep("25050130");
		
		EnderecoDao edao = new EnderecoDao();
		//edao.cadastrar(end);
				
		Fornecedor f = new Fornecedor();
		Endereco endf = new Endereco();
		f.setCnpj("12.456.789/0001-32");
		f.setNome("Armazem Lameirão");
		f.setTelefone("(21)98293-5810");
		f.setEmail("armazemlameirao@gmail.com");
		f.setSite("www.armazemlameirao.com.br");
		f.setEndereco(endf);
		endf.setId(1);
	
		FornecedorDao fdao = new FornecedorDao();
		//fdao.cadastrar(f);
		
		Produto p = new Produto();
		Fornecedor pf = new Fornecedor();
		p.setNome("Pá");
		p.setCategoria("Equipamentos de Limpeza");
		p.setFornecedor(pf);
		pf.setId(1);
		p.setEstoqueMinimo(5);
		p.setEstoqueMaximo(15);
		p.setDescricao("Recolher sujeira");
		
		
		ProdutoDao pdao = new ProdutoDao();
		//pdao.cadastrar(p);
		
		Estoque es = new Estoque();
		Produto pes = new Produto();
		Fornecedor fes = new Fornecedor();
		es.setProduto(pes);
		pes.setId(1);
		es.setFornecedor(fes);
		fes.setId(1);
		es.setQuantidade(2);
		es.setValorUnitario(5.00);
		es.setLocalizacaoEstoque("Arm1Prat2");
		
		EstoqueDao esdao = new EstoqueDao();
		//esdao.cadastrar(es);
		
		ControleEntrada ce = new ControleEntrada();
		Produto pce = new Produto();
		Fornecedor fce = new Fornecedor();
		ce.setProduto(pce);
		pce.setId(1);
		ce.setFornecedor(fce);
		fce.setId(1);
		ce.setQuantidade(2);
		ce.setValorUnitario(5.00);
		
		ControleEntradaDao cedao = new ControleEntradaDao();
		//cedao.cadastrar(ce);
		
		ControleSaida cs = new ControleSaida();
		Produto pcs = new Produto();
		cs.setProduto(pcs);
		pcs.setId(1);
		cs.setQuantidade(2);
		cs.setValorUnitario(5.00);
		cs.setJustificativa("Para realização do serviço nº 01");
		
		ControleSaidaDao csdao = new ControleSaidaDao();
		//csdao.cadastrar(cs);
		
		Endereco endAlterar = new Endereco();
		endAlterar.setLogradouro("Rua das Camelias");
		endAlterar.setNumero(100);
		endAlterar.setComplemento("");
		endAlterar.setBairro("Centro");
		endAlterar.setCidade("Rio de Janeiro");
		endAlterar.setEstado("RJ");
		endAlterar.setCep("22000100");
		endAlterar.setId(2);
		//edao.alterar(endAlterar);
		
		Fornecedor fAlterar = new Fornecedor();
		Endereco endfa = new Endereco();
		fAlterar.setCnpj("12.123.123/0001-32");
		fAlterar.setNome("Armazem do Lameirão");
		fAlterar.setTelefone("(21)98293-5810");
		fAlterar.setEmail("armazemlameirao@gmail.com");
		fAlterar.setSite("www.armazemdolameirao.com.br");
		fAlterar.setEndereco(endfa);
		endfa.setId(1);
		fAlterar.setId(1);
		//fdao.alterar(fAlterar);
		
		Produto pAlterar = new Produto();
		Fornecedor pfa = new Fornecedor();
		pAlterar.setNome("Pá");
		pAlterar.setCategoria("Equipamentos de Limpeza");
		pAlterar.setFornecedor(pf);
		pfa.setId(1);
		pAlterar.setEstoqueMinimo(4);
		pAlterar.setEstoqueMaximo(10);
		pAlterar.setDescricao("Recolher sujeira do chão");
		pAlterar.setId(1);
		//pdao.alterar(pAlterar);	
		
		Estoque esAlterar = new Estoque();
		Produto pesa = new Produto();
		Fornecedor fesa = new Fornecedor();
		esAlterar.setProduto(pesa);
		pesa.setId(1);
		esAlterar.setFornecedor(fesa);
		fesa.setId(1);
		esAlterar.setQuantidade(3);
		esAlterar.setValorUnitario(6.00);
		esAlterar.setLocalizacaoEstoque("Arm2Prat3");
		esAlterar.setId(2);
		//esdao.alterar(esAlterar);
		
		ControleEntrada ceAlterar = new ControleEntrada();
		Produto pcea = new Produto();
		Fornecedor fcea = new Fornecedor();
		ceAlterar.setProduto(pcea);
		pcea.setId(1);
		ceAlterar.setFornecedor(fcea);
		fcea.setId(1);
		ceAlterar.setQuantidade(3);
		ceAlterar.setValorUnitario(6.00);
		ceAlterar.setId(1);
		//cedao.alterar(ceAlterar);
		
		ControleSaida csAlterar = new ControleSaida();
		Produto pcsa = new Produto();
		csAlterar.setProduto(pcsa);
		pcsa.setId(1);
		csAlterar.setQuantidade(3);
		csAlterar.setValorUnitario(6.00);
		csAlterar.setJustificativa("Para realização do serviço nº 02");
		csAlterar.setId(1);
		//csdao.alterar(csAlterar);
		
		ArrayList<Endereco> endLista = edao.listar("");
		for (Endereco a : endLista) {
	%>
		<p><%= a.getId() %> - <%= a.getLogradouro() %> - <%= a.getNumero() %> - <%= a.getComplemento() %> - <%= a.getBairro() %> - <%= a.getCidade() %> - <%= a.getEstado() %> - <%= a.getCep() %></p> 
		
	<%		
		}
		
		ArrayList<Fornecedor> fLista = fdao.listar("");
		for (Fornecedor af: fLista) {
	%>
	<p><%= af.getId() %> - <%= af.getCnpj() %> - <%= af.getNome() %></p>
	<%	
		}
		
		ArrayList<Produto> pLista = pdao.listar("");
		for (Produto ap : pLista) {
	%>
	<p> <%= ap.getId() %> - <%= ap.getNome() %></p>
	<%
		}
		
		ArrayList<Estoque> esLista = esdao.listar("");
		for (Estoque aes : esLista) {
	%>
	<p><%= aes.getId() %> - <%= aes.getLocalizacaoEstoque() %></p>
	<%
		}
		
		ArrayList<ControleEntrada> ceLista = cedao.listar("");
		for (ControleEntrada ace : ceLista) {
	%>
	<p><%= ace.getId() %> - <%= ace.getValorUnitario() %></p>
	<%
		}
		
		ArrayList<ControleSaida> csLista = csdao.listar("");
		for (ControleSaida acs : csLista) {
	%>
	<p><%= acs.getId() %> - <%= acs.getJustificativa() %></p>
	<%
		}
		
		Endereco eb = edao.buscar(1);
	%>
	
	<p><%= eb.getLogradouro() %></p>
	
	<%
		Fornecedor fb = fdao.buscar(1);
	%>
	<p><%= fb.getNome() %></p>
	<%
		Produto pb = pdao.buscar(1);
	%>
	<p><%= pb.getNome() %></p>
	<%
		Estoque esb = esdao.buscar(2);
	%>
	<p><%= esb.getLocalizacaoEstoque() %></p>
	<%
		ControleEntrada ceb = cedao.buscar(1);
	%>
	<p><%= ceb.getDataEntrada() %></p>
	<%
		ControleSaida csb = csdao.buscar(1);
	%>
	<p><%= csb.getDataSaida() %></p>
	<%
		//cs.setId(2);
		//csdao.excluir(cs);
		
		//ce.setId(3);
		//cedao.excluir(ce);
	
		//es.setId(3);
		//esdao.excluir(es);
	
		//p.setId(2);
		//pdao.excluir(p);
	
		//end.setId(2);
		//edao.excluir(end);
		
		//f.setId(2);
		//fdao.excluir(f);
	%>
</body>
</html>