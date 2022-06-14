package br.com.officecleantech.view;

import java.io.IOException;

import br.com.officecleantech.controller.UsuarioController;
import br.com.officecleantech.model.entidade.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExcluirUsuarioServlet
 */
public class ExcluirUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExcluirUsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strGet = request.getParameter("get");

		long get = 0;
		try {
			get = Long.parseLong(strGet);
		} catch (Exception e) {
			System.out.println("Erro na conversão");
		}

		UsuarioController controller = new UsuarioController();
		Usuario u = new Usuario();
		u.setId(get);

		controller.excluirUsuario(u);

		RequestDispatcher rd = request.getRequestDispatcher("usuarios.jsp");
		rd.forward(request, response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
