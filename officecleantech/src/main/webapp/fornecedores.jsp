<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="br.com.officecleantech.controller.FornecedorController" %>
<%@ page import="br.com.officecleantech.controller.EnderecoController" %>
<%@ page import="br.com.officecleantech.model.entidade.Fornecedor" %>
<%@ page import="br.com.officecleantech.model.entidade.Endereco" %>
<%@ page import="br.com.officecleantech.model.entidade.Usuario" %>
<%@ page import="br.com.officecleantech.model.dao.EnderecoDao" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link
		href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,300;0,400;0,500;0,600;0,700;1,600&display=swap"
		rel="stylesheet">
	<title>Fornecedores - OCT</title>
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
		integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
		crossorigin="anonymous" referrerpolicy="no-referrer" />
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
		integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
		crossorigin="anonymous" referrerpolicy="no-referrer" />
	<!-- CSS only -->
	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
		crossorigin="anonymous">
	<link rel="stylesheet" href="./css/style.css">
	<!-- Scrollbar Custom CSS -->
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">
</head>
<body>
	<!-- tratamento login -->
	<% if (session.getAttribute("usuarioLogado")==null) { RequestDispatcher
		rd=request.getRequestDispatcher("login.jsp"); rd.forward(request, response); } Usuario
		u=(Usuario) session.getAttribute("usuarioLogado"); %>
	<!-- fim tratamento login-->
	<!-- tratamento busca -->
	<% String nomeBuscar=request.getParameter("nomeBuscar"); if
						(nomeBuscar==null) { nomeBuscar="" ; } %>
	<!-- fim tratamento busca -->
	<div class="wrapper">
	<div class="wrapper">
		<!-- Sidebar  -->
		<nav id="sidebar">
			<div class="sidebar-header">
				<a href="#"> <img src="./img/oct.png" alt="Logo Office Clean Tech"
						style="height: 60px;"></a>
			</div>
			<ul class="list-unstyled components">
				<li class="active">
					<div class="icons-menu">
						<i class="fa-solid fa-house"></i> <a href="#homeSubmenu"
							data-toggle="collapse" aria-expanded="false">Dashboard</a>
					</div>
				</li>
				<li>
					<div class="icons-menu">
						<i class="fa-solid fa-box-archive"></i> <a href="produtos.jsp">Produtos</a>
					</div>
				</li>
				<li><a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false"
						class="dropdown-toggle ">Relatórios</a>
					<ul class="collapse list-unstyled" id="pageSubmenu">
						<li>
							<div class="icons-menu">
								<i class="fa-solid fa-arrow-up"></i> <a href="relatorio_entrada.jsp">Entrada</a>
							</div>
						</li>
						<li>
							<div class="icons-menu">
								<i class="fa-solid fa-arrow-down"></i> <a href="relatorio_saida.jsp">Saída</a>
							</div>
						</li>
					</ul>
				</li>
				<li>
					<div class="icons-menu">
						<i class="fa-solid fa-users"></i> <a href="fornecedores.jsp">Fornecedores</a>
					</div>
				</li>
				<li>
					<div class="icons-menu">
						<i class="fa-solid fa-user-plus"></i> <a href="usuarios.jsp">Usuários</a>
					</div>
				</li>
				<li id="li-logoff">
					<div class="icons-menu logoff">
						<i class="fa-solid fa-power-off"></i> <a href="LogoffServlet">Sair</a>
					</div>
				</li>
			</ul>
		</nav>
		<!-- Fim Sidebar  -->
		<main id="content">
			<!-- Menu -->
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="container-fluid">
					<button type="button" id="sidebarCollapse" class="btn text-white"
						style="background-color: #77B800;">
						<i class="fas fa-align-left"></i> <span>Menu</span>
					</button>
				</div>
			</nav>
			<!-- Fim Menu -->
			<!-- Large modal -->
			<header class="d-flex align-items-center gap-4 justify-content-between"
				id="header__btn">
				<button type="button" class="btn text-white" data-toggle="modal"
					data-target="#exampleModal" data-whatever="@mdo"
					style="background-color: #2678D1;" id="btnProduto">Cadastrar
					Fornecedor</button>
				<div class="search-container">
					<% //String nomeBuscar=request.getParameter("nomeBuscar"); if
						//(nomeBuscar==null) { nomeBuscar="" ; } %>
						<form action="" method="post">
							<input type="text" placeholder="Buscar fornecedor"
								name="nomeBuscar" value="<%=nomeBuscar%>">
							<button type="submit">
								<i class="fa fa-search"></i>
							</button>
						</form>
				</div>
			</header>
			<!-- Modal de Fornecedor -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered modal-md" role="document">
					<div class="modal-content">
						<div class="modal-header" style="border: 0;">
							<h5 class="modal-title" id="exampleModalLabel"></h5>
							<button type="button" class="close text-white"
								data-dismiss="modal" aria-label="Close"
								style="background-color: red; border: none; border-radius: 8px; padding: 5px 10px;">
								<span aria-hidden="true" class="">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<form class="" method="post" action="FornecedorServlet">
								<div
									class="form-group d-flex gap-3 mb-2 flex-column  columnInput">
									<input type="text" class="form-control shadow-none"
										id="recipient-name" name="nome"
										placeholder="Nome do fornecedor" required>
									<input type="email" class="form-control shadow-none"
										id="recipient-name" name="email"
										placeholder="email@dominio.com" required>
								</div>
								<div
									class="form-group d-flex gap-3 mb-2 flex-column  columnInput">
									<input type="number" class="form-control shadow-none"
										id="recipient-name" name="telefone"
										placeholder="Telefone" required>
									<input type="number" class="form-control shadow-none"
										id="recipient-name" name="cnpj" placeholder="CNPJ" required>
									<input type="text" class="form-control shadow-none"
										id="recipient-name" name="site" placeholder="Site" required>
								</div>
								<div
									class="form-group d-flex gap-4 mb-2 flex-row columnInput">
									<input type="number" class="form-control shadow-none"
										id="recipient-name" name="cep" placeholder="CEP" required>
									<input type="text" class="form-control shadow-none"
										id="recipient-name" name="bairro"
										placeholder="Bairro" required>
								</div>
								<div
									class="form-group d-flex gap-4 mb-2 flex-row columnInput">
									<select class="form-select shadow-none"
										aria-label="Default select example"
										style="padding: 0.375rem 0.75rem" name="estado" required>
										<option selected>Estado</option>
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
									<input type="text" class="form-control shadow-none"
										id="recipient-name" name="cidade"
										placeholder="Cidade" required>
								</div>
								<div
									class="form-group d-flex gap-4 mb-2 flex-row columnInput">
									<input type="text" class="form-control shadow-none"
										id="recipient-name" name="logradouro"
										placeholder="Logradouro" required>
									<input type="number" class="form-control shadow-none"
										id="recipient-name" name="numero" placeholder="N°" required>
								</div>
								<div
									class="form-group d-flex gap-3 mb-2 flex-column  columnInput">
									<input type="text" class="form-control shadow-none"
										id="recipient-name" name="complemento"
										placeholder="Complemento">
								</div>
								<div class="modal-footer">
									<button type="submit" class="btn text-white w-100"
										style="background-color: #2678D1; letter-spacing: 7px; padding: 12px 0; font-weight: 600;">CADASTRAR</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- Fim Modal de Fornecedor -->
			<!-- Lista Fornecedor -->
			<div class="table-responsive table-wrapper-scroll-y my-custom-scrollbar"
				style="margin-top: 40px; border-radius: 8px; box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.15);">
				<table class="table">
					<thead
						style="box-shadow: 0px 4px 4px rgb(0 0 0/ 5%); border-radius: 8px;">
						<tr>
							<th scope="col">fId</th>
							<th scope="col">Nome</th>
							<th scope="col">CNPJ</th>
							<th scope="col">Telefone</th>
							<th scope="col">E-mail</th>
							<th scope="col">Site</th>
							<th scope="col">endId</th>
							<th scope="col">Logradouro</th>
							<th scope="col">Número</th>
							<th scope="col">Complemento</th>
							<th scope="col">Bairro</th>
							<th scope="col">Cidade</th>
							<th scope="col">Estado</th>
							<th scope="col">CEP</th>
							<th scope="col">Ações</th>
						</tr>
					</thead>
					<tbody>
						<% FornecedorController controller = new FornecedorController();
							ArrayList<Fornecedor> lista = controller.listar(nomeBuscar);
							Endereco end = new Endereco();
							for (Fornecedor f : lista) {
							%>
							<tr>
								<td scope="row">
									<%=f.getId()%>
								</td>
								<td>
									<%=f.getNome()%>
								</td>
								<td>
									<%=f.getCnpj()%>
								</td>
								<td>
									<%=f.getTelefone()%>
								</td>
								<td>
									<%=f.getEmail()%>
								</td>
								<td>
									<%=f.getSite()%>
								</td>
								<td>
									<%= f.getEndereco().getId() %>
								</td>
								<td>
									<%=f.getEndereco().getLogradouro()%>
								</td>
								<td>
									<%=f.getEndereco().getNumero()%>
								</td>
								<td>
									<%=f.getEndereco().getComplemento()%>
								</td>
								<td>
									<%=f.getEndereco().getBairro()%>
								</td>
								<td>
									<%=f.getEndereco().getCidade()%>
								</td>
								<td>
									<%=f.getEndereco().getEstado()%>
								</td>
								<td>
									<%=f.getEndereco().getCep()%>
								</td>
								<td>
									<div class="d-flex gap-2">
										<div class="text-primary" data-toggle="modal"
											data-target="#exampleModalAtt">
											<button type="button" class="btn text-white" data-toggle="modal"
					data-target="#exampleModal1" data-whatever="@mdo"
					style="background-color: #2678D1;" id="btnProduto">Atualizar Fornecedor</button>
										</div>
										<div class="text-danger">
											<a href="ExcluirFornecedor?id=<%=f.getId()%>"
												onclick="return confirm('Deseja excluir esse registro?')"><i
													class="fa-solid fa-xmark"></i></a>
										</div>
									</div>
								</td>
							</tr>
							<% } %>
					</tbody>
				</table>
			</div>
			<!-- Fim do Lista Fornecedor -->
			<!-- Modal Atualizar Fornecedor -->
			<div class="modal fade" id="exampleModal1" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered modal-md" role="document">
					<div class="modal-content">
						<div class="modal-header" style="border: 0;">
							<h5 class="modal-title" id="exampleModalLabel"></h5>
							<button type="button" class="close text-white"
								data-dismiss="modal" aria-label="Close"
								style="background-color: red; border: none; border-radius: 8px; padding: 5px 10px;">
								<span aria-hidden="true" class="">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<form class="" method="post" action="IniccioAlterarFornecedor">
								<div
									class="form-group d-flex gap-3 mb-2 flex-column  columnInput">
									<input type="text" class="form-control shadow-none"
										id="recipient-name" name="nome"
										placeholder="Nome do fornecedor" >
									<input type="email" class="form-control shadow-none"
										id="recipient-name" name="email"
										placeholder="email@dominio.com" >
								</div>
								<div
									class="form-group d-flex gap-3 mb-2 flex-column  columnInput">
									<input type="number" class="form-control shadow-none"
										id="recipient-name" name="telefone"
										placeholder="Telefone" >
									<input type="number" class="form-control shadow-none"
										id="recipient-name" name="cnpj" placeholder="CNPJ" >
									<input type="text" class="form-control shadow-none"
										id="recipient-name" name="site" placeholder="Site" >
								</div>
								<div
									class="form-group d-flex gap-4 mb-2 flex-row columnInput">
									<input type="number" class="form-control shadow-none"
										id="recipient-name" name="cep" placeholder="CEP" >
									<input type="text" class="form-control shadow-none"
										id="recipient-name" name="bairro"
										placeholder="Bairro" required>
								</div>
								<div
									class="form-group d-flex gap-4 mb-2 flex-row columnInput">
									<select class="form-select shadow-none"
										aria-label="Default select example"
										style="padding: 0.375rem 0.75rem" name="estado" >
										<option selected>Estado</option>
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
									<input type="text" class="form-control shadow-none"
										id="recipient-name" name="cidade"
										placeholder="Cidade" >
								</div>
								<div
									class="form-group d-flex gap-4 mb-2 flex-row columnInput">
									<input type="text" class="form-control shadow-none"
										id="recipient-name" name="logradouro"
										placeholder="Logradouro" >
									<input type="number" class="form-control shadow-none"
										id="recipient-name" name="numero" placeholder="N°" >
								</div>
								<div
									class="form-group d-flex gap-3 mb-2 flex-column  columnInput">
									<input type="text" class="form-control shadow-none"
										id="recipient-name" name="complemento"
										placeholder="Complemento">
								</div>
								<div class="modal-footer">
									<button type="submit" class="btn text-white w-100"
										style="background-color: #2678D1; letter-spacing: 7px; padding: 12px 0; font-weight: 600;">CADASTRAR</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- Fim Modal Atualizar Fornecedor -->
		</main>
		<!-- jQuery CDN - Slim version (=without AJAX) -->
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
			integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
			crossorigin="anonymous"></script>
		<!-- Popper.JS -->
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
			integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
			crossorigin="anonymous"></script>
		<!-- Bootstrap JS -->
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
			integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
			crossorigin="anonymous"></script>
		<!-- jQuery Custom Scroller CDN -->
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.concat.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function () {
				$("#sidebar").mCustomScrollbar({
					theme: "minimal"
				});
				$('#sidebarCollapse').on('click', function () {
					$('#sidebar, #content').toggleClass('active');
					$('.collapse.in').toggleClass('in');
					$('a[aria-expanded=true]').attr('aria-expanded', 'false');
				});
			});
		</script>
	</div>
</body>
</html>