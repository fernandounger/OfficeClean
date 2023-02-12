package br.com.officecleantech.view;

import java.io.IOException;

import br.com.officecleantech.controller.ProdutoController;
import br.com.officecleantech.model.entidade.Produto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExcluirProduto
 */
public class ExcluirProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirProduto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigoBarra = request.getParameter("codigoBarra");
		
		long CodigoBarra = 0;
		try {
			CodigoBarra = Long.parseLong(codigoBarra);
		} catch (Exception e) {
			System.out.println("Erro na conversao");
			e.printStackTrace();
		}
		
		Produto p = new Produto();
		p.setCodigoBarra(CodigoBarra);
		
		ProdutoController controller = new ProdutoController();
		controller.excluir(p);
		
		RequestDispatcher rd = request.getRequestDispatcher("produtos.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
