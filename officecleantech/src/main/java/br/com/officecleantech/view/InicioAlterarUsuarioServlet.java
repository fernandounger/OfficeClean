package br.com.officecleantech.view;

import java.io.IOException;

import br.com.officecleantech.controller.UsuarioController;
import br.com.officecleantech.model.entidade.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class InicioAlterarUsuarioSerlvet
 */
public class InicioAlterarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InicioAlterarUsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String strGet = request.getParameter("redirecionador");

		long get = 0;

//		System.out.println(strGet);

		try {
			get = Long.parseLong(strGet);

		} catch (Exception e) {

		}
		UsuarioController controller = new UsuarioController();
		Usuario u2 = controller.pesquisarUsuario(get);

		request.setAttribute("redirecionador2", u2);

		RequestDispatcher rd = request.getRequestDispatcher("atualizar_usuarios.jsp");
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
