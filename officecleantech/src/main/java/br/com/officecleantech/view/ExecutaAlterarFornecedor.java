package br.com.officecleantech.view;

import java.io.IOException;

import br.com.officecleantech.controller.FornecedorController;
import br.com.officecleantech.model.entidade.Endereco;
import br.com.officecleantech.model.entidade.Fornecedor;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExecutaAlterarFornecedor
 */

@SuppressWarnings("unused")
public class ExecutaAlterarFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecutaAlterarFornecedor() {
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
		String numero = request.getParameter("numeroo");
		String complemento = request.getParameter("complemento");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String cep = request.getParameter("cep");
		String id = request.getParameter("id");
		String cnpj = request.getParameter("cnpj");
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String site = request.getParameter("site");
		String endereco = request.getParameter("endereco");
		
		int Numero = 0;
		long Id = 0;
		long End = 0;
		
		try {
			Numero = Integer.parseInt(numero);
			Id = Long.parseLong(id);
			End = Long.parseLong(endereco);
		} catch(Exception e) {
			System.out.println("Erro na conversão");
			e.printStackTrace();
		}
		
		Endereco end = new Endereco();
		end.setId(End);
		end.setLogradouro(logradouro);
		end.setNumero(Numero);
		end.setComplemento(complemento);
		end.setBairro(bairro);
		end.setCidade(cidade);
		end.setEstado(estado);
		end.setCep(cep);
		
		Fornecedor f = new Fornecedor();
		f.setId(Id);
		f.setCnpj(cnpj);
		f.setNome(nome);
		f.setTelefone(telefone);
		f.setEmail(email);
		f.setSite(site);
				
		
		FornecedorController controller = new FornecedorController();
		controller.alterar(end, f);
		
		RequestDispatcher rd = request.getRequestDispatcher("fornecedores.jsp");
		rd.forward(request, response);
		
	}

}
