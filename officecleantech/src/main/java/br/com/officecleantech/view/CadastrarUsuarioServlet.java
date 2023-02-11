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
 * Servlet implementation class CadastrarUsuarioServlet
 */
public class CadastrarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastrarUsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String login = request.getParameter("login");
		String password = request.getParameter("password");

//		System.out.println(name);

		Usuario user = new Usuario();
		user.setNome(name);
		user.setLogin(login);
		user.setSenha(password);

		UsuarioController controller = new UsuarioController();
		controller.cadastrarUsuario(user);

		RequestDispatcher rd = request.getRequestDispatcher("usuarios.jsp");
		rd.forward(request, response);
	}

}
