<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="br.com.officecleantech.model.entidade.Usuario" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;500;600;700&display=swap"
		rel="stylesheet">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.2/font/bootstrap-icons.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
		integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
		crossorigin="anonymous" referrerpolicy="no-referrer" />
	<title>Login</title>
	<link rel="stylesheet" href="./css/login.css">
</head>
<body>
	<section>
		<div class="container">
			<div class="header__login">
				<img src="./img/oct.png" alt="">
				<p>Insira <span>EMAIL</span> e <span>SENHA</span> e clique no botão ENTRAR.</p>
				<hr>
			</div>
			<form action="LoginServlet" method="post">
				<p class="message__error">O e-mail e/ou senha não conferem</p>
				<div class="input__email">
					<label for="email">Email</label>
					<input id="email" name="Login" type="email" placeholder="email@dominio.com"
						autocomplete="off" required>
				</div>
				<div class="input__senha">
					<label for="senha">Senha</label>
					<input id="senha" name="Senha" type="password" placeholder="Digite sua senha">
				</div>
				<div>
					<button type="submit">Entrar</button>
				</div>
			</form>
		</div>
	</section>
	<% if (request.getAttribute("Error") !=null) { %>
		<p>
			<%=request.getAttribute("Error")%>
		</p>
		<% } %>
</body>
</html>