<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="br.com.officecleantech.model.entidade.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<h1>A Vida é Muito Boa e Sempre Vai Dar Certo!</h1>

	<form method="post" action="LoginServlet">
		<input type="text" name="Nome" /> <input type="text" name="Login" />
		<input type="password" name="Senha" /> <input type="submit"
			value="Entrar" />
	</form>

	<p>
		Não é Cadastrado? <a href="sign_up.jsp">Cadastre-se</a>
	</p>

	<%
	if (request.getAttribute("Error") != null) {
	%>
	<p><%=request.getAttribute("Error")%>
	</p>
	<%
	}
	%>

</body>
</html>