package br.com.officecleantech.view;

import java.io.IOException;

import br.com.officecleantech.controller.FornecedorController;
import br.com.officecleantech.model.entidade.Fornecedor;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class ExcluirFornecedor
 */
public class ExcluirFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirFornecedor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		long Id = 0;
		try {
			Id = Long.parseLong(id);
		} catch (Exception e) {
			System.out.println("Erro na conversão");
			e.printStackTrace();
		}
		
		Fornecedor f = new Fornecedor();
		f.setId(Id);
		
		FornecedorController controller = new FornecedorController();
		controller.excluir(f);
		
		RequestDispatcher rd = request.getRequestDispatcher("fornecedores.jsp");
		rd.forward(request, response);
	}
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
