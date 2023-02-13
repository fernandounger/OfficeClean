package br.com.officecleantech.view;

import java.io.IOException;

import br.com.officecleantech.controller.EnderecoController;
import br.com.officecleantech.controller.FornecedorController;
import br.com.officecleantech.model.entidade.Endereco;
import br.com.officecleantech.model.entidade.Fornecedor;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FornecedorServlet
 */
public class FornecedorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FornecedorServlet() {
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
		String logradouro = request.getParameter("logradouro");
		String numero = request.getParameter("numero");
		String complemento = request.getParameter("complemento");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String cep = request.getParameter("cep");
		String cnpj = request.getParameter("cnpj");
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String site = request.getParameter("site");
		
		int Numero = 0;
		try {
			Numero = Integer.parseInt(numero);
		} catch (Exception e) {
			System.out.println("Erro ao receber");
			e.printStackTrace();
		}
		
		Endereco end = new Endereco();
		end.setLogradouro(logradouro);
		end.setNumero(Numero);
		end.setComplemento(complemento);
		end.setBairro(bairro);
		end.setCidade(cidade);
		end.setEstado(estado);
		end.setCep(cep);
		
		EnderecoController econtroller = new EnderecoController();
		
		econtroller.cadastrar(end);
		
		
		Fornecedor f = new Fornecedor();
		f.setCnpj(cnpj);
		f.setNome(nome);
		f.setTelefone(telefone);
		f.setEmail(email);
		f.setSite(site);
		f.setEndereco(end);
		
		
		
		FornecedorController fcontroller = new FornecedorController();
		
		fcontroller.cadastrar(f);
		
		RequestDispatcher rd = request.getRequestDispatcher("fornecedores.jsp");
		rd.forward(request, response);
	}

}