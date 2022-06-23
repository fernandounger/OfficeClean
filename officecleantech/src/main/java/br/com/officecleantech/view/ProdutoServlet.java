package br.com.officecleantech.view;

import java.io.IOException;

import br.com.officecleantech.controller.FornecedorController;
import br.com.officecleantech.controller.ProdutoController;
import br.com.officecleantech.model.entidade.Fornecedor;
import br.com.officecleantech.model.entidade.Produto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProdutoServlet
 */
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigoBarra = request.getParameter("codigoBarra");
		String nome = request.getParameter("nome");
		String categoria = request.getParameter("categoria");
		String fornecedor = request.getParameter("fornecedor");
		String descricao = request.getParameter("descricao");
		String estoqueMaximo = request.getParameter("estoqueMaximo");
		String estoqueMinimo = request.getParameter("estoqueMinimo");
		
		long CodigoBarra = 0;
		int EstoqueMaximo = 0;
		int EstoqueMinimo = 0;
		long Fornecedor = 0;
		
		try {
			CodigoBarra = Long.parseLong(codigoBarra);
			EstoqueMaximo = Integer.parseInt(estoqueMaximo);
			EstoqueMinimo = Integer.parseInt(estoqueMinimo);
			Fornecedor = Long.parseLong(fornecedor);
		} catch (Exception e) {
			System.out.println("Erro ao receber");
			e.printStackTrace();
		}
		
		FornecedorController fcontroller = new FornecedorController();
		Fornecedor f = new Fornecedor();
		f.setId(Fornecedor);
		f.setNome(nome);
		
		Produto p = new Produto();
		p.setCodigoBarra(CodigoBarra);
		p.setNome(nome);
		p.setCategoria(categoria);
		p.setFornecedor(f);
		p.setDescricao(descricao);
		p.setEstoqueMaximo(EstoqueMaximo);
		p.setEstoqueMinimo(EstoqueMinimo);
		
		ProdutoController controller = new ProdutoController();
		controller.cadastrar(p);
		fcontroller.listar(fornecedor);
		
		RequestDispatcher rd = request.getRequestDispatcher("produtos.jsp");
		rd.forward(request, response);
	}

}
