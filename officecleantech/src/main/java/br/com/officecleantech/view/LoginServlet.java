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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
//		String name = request.getParameter("Nome");
		String login = request.getParameter("Login");
		String password = request.getParameter("Senha");

//		System.out.println(/* name+ " - "+*/login + " - " + password);

		UsuarioController controller = new UsuarioController();
//		Usuario u = uc.logarUsuario(/*name,*/ login, password);
		Usuario u = new Usuario();
		u = controller.logarUsuario(/*name,*/ login, password);
		String destino = "";
		if (u != null) {
			HttpSession sessao = request.getSession();

			sessao.setAttribute("usuarioLogado", u);
			destino = "usuarios.jsp";
		} else {
//			request.setAttribute("Error", "Acesso Negado");
			request.setAttribute("Error", "");
			destino = "login.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}

}
