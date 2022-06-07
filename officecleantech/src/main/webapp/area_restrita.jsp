<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="br.com.officecleantech.model.entidade.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Área Restrita</title>
</head>
<body>
	<%
	if (session.getAttribute("usuarioLogado") == null) {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
	Usuario u = (Usuario) session.getAttribute("usuarioLogado");
	%>
	<h1>
		Olá,
		<%=u.getNome()%></h1>
		
		<a href="LogoffServlet">Sair</a>
</body>
</html>