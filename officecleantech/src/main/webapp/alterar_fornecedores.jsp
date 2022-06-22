<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.com.officecleantech.model.entidade.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Fornecedor</title>
</head>
<body>
	<!-- Modal de Produto Alterar -->
      <div class="modal fade" id="exampleModalAtt" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-md" role="document">
          <div class="modal-content">
            <div class="modal-header" style="border: 0;">
              <h5 class="modal-title" id="exampleModalLabel"></h5>
              <button type="button" class="close text-white" data-dismiss="modal" aria-label="Close" style="background-color: red; border:none; border-radius: 8px;
                    padding: 5px 10px;">
                <span aria-hidden="true" class="">&times;</span>
              </button>
            </div>
            <div class="modal-body">
            <%
            	Fornecedor fornecedorAlterar = (Fornecedor) request.getAttribute("Fornecedor");
            	Endereco enderecoAlterar = (Endereco) request.getAttribute("Endereco");
            %>
              <form class="" method="post" action="ExecutaAlterarFornecedor">
                <div class="form-group d-flex gap-3 mb-2 flex-column  columnInput">
                  <input type="text" class="form-control shadow-none" id="recipient-name" name="nome" value="<%= fornecedorAlterar.getNome() %>">
                  <input type="email" class="form-control shadow-none" id="recipient-name" name="email"
                    value="<%= fornecedorAlterar.getEmail() %>">
                </div>

                <div class="form-group d-flex gap-3 mb-2 flex-column  columnInput">
                  <input type="number" class="form-control shadow-none" id="recipient-name" name="telefone" value="<%= fornecedorAlterar.getTelefone() %>">
                  <input type="number" class="form-control shadow-none" id="recipient-name" name="cnpj" value="<%= fornecedorAlterar.getCnpj() %>">
                  <input type="text" class="form-control shadow-none" id="recipient-name" name="site" value="<%= fornecedorAlterar.getSite() %>">
                </div>

                <div class="form-group d-flex gap-4 mb-2 flex-row columnInput">
                  <input type="number" class="form-control shadow-none" id="recipient-name" name="cep" value="<%= enderecoAlterar.getCep() %>">
                  <input type="text" class="form-control shadow-none" id="recipient-name" name="bairro" value="<%= enderecoAlterar.getBairro() %>">
                </div>

                <div class="form-group d-flex gap-4 mb-2 flex-row columnInput">
                  <select class="form-select shadow-none" aria-label="Default select example"
                    style="padding: 0.375rem 0.75rem" name="estado">
                    <option selected>Estado</option>
                    <option value="<%= enderecoAlterar.getEstado() %>"><%= enderecoAlterar.getEstado() %></option>
                    <option value="AC">AC</option>
                    <option value="AL">AL</option>
                    <option value="AP">AP</option>
                    <option value="AM">AM</option>
                    <option value="BA">BA</option>
                    <option value="CE">CE</option>
                    <option value="DF">DF</option>
                    <option value="ES">ES</option>
                    <option value="GO">GO</option>
                    <option value="MA">MA</option>
                    <option value="MT">MT</option>
                    <option value="MS">MS</option>
                    <option value="MG">MG</option>
                    <option value="PA">PA</option>
                    <option value="PB">PB</option>
                    <option value="PR">PR</option>
                    <option value="PE">PE</option>
                    <option value="PI">PI</option>
                    <option value="RJ">RJ</option>
                    <option value="RN">RN</option>
                    <option value="RS">RS</option>
                    <option value="RO">RO</option>
                    <option value="RR">RR</option>
                    <option value="SC">SC</option>
                    <option value="SP">SP</option>
                    <option value="SE">SE</option>
                    <option value="TO">TO</option>
                  </select>
                  <input type="text" class="form-control shadow-none" id="recipient-name" name="cidade" value="<%= enderecoAlterar.getCidade() %>">
                </div>

                <div class="form-group d-flex gap-4 mb-2 flex-row columnInput">
                  <input type="text" class="form-control shadow-none" id="recipient-name" name="logradouro" value="<%= enderecoAlterar.getLogradouro() %>">
                  <input type="number" class="form-control shadow-none" id="recipient-name" name="numeroo" value="<%= enderecoAlterar.getNumero() %>">
                </div>
                <div class="form-group d-flex gap-3 mb-2 flex-column  columnInput">
                  <input type="text" class="form-control shadow-none" id="recipient-name" name="complemento" value="<%= enderecoAlterar.getComplemento() %>">
                  <input type="hidden" name="id" value="<%= fornecedorAlterar.getId() %>">
                  <input type="hidden" name="enderecoId" value="<%= fornecedorAlterar.getEndereco() %>">
                  <input type="hidden" name="enderecoId" value="<%= enderecoAlterar.getId() %>">
                </div>

                <div class="modal-footer">
                  <button type="submit" class="btn text-white w-100"
                    style="background-color: #2678D1; letter-spacing: 7px; padding: 12px 0; font-weight: 600;">ALTERAR</button>
                </div>
              </form>
            </div>

          </div>
        </div>
      </div>
      <!-- Fim Modal de Produto -->
</body>
</html>