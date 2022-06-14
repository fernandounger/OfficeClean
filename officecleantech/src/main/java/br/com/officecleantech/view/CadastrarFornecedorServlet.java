package br.com.officecleantech.view;

import java.io.IOException;

import br.com.officecleantech.model.dao.FornecedorDao;
import br.com.officecleantech.model.entidade.Endereco;
import br.com.officecleantech.model.entidade.Fornecedor;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CadastrarFornecedorServlet
 */
public class CadastrarFornecedorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastrarFornecedorServlet() {
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
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String cnpj = request.getParameter("cnpj");
		String site = request.getParameter("site");

		String patio = request.getParameter("patio");
		String strNumber = request.getParameter("number");
		String complement = request.getParameter("complement");
		String district = request.getParameter("district");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");

		int number = 0;

		try {
			number = Integer.parseInt(strNumber);
		} catch (Exception e) {

		}

		FornecedorDao dao = new FornecedorDao();
		Fornecedor f = new Fornecedor();
		Endereco en = new Endereco();

		f.setNome(name);
		f.setEmail(email);
		f.setTelefone(telephone);
		f.setCnpj(cnpj);
		f.setSite(site);

		en.setLogradouro(patio);
		en.setNumero(number);
		en.setComplemento(complement);
		en.setBairro(district);
		en.setCidade(city);
		en.setEstado(state);
		en.setCep(zip);
		f.setEndereco(en);
		dao.cadastrar(f);

		System.out.println(f.getNome());

		RequestDispatcher rd = request.getRequestDispatcher("produto.jsp");
		rd.forward(request, response);

	}
}
