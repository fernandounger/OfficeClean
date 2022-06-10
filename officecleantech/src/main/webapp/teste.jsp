<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="br.com.officecleantech.model.dao.ProdutoDao"%>
<%@page import="br.com.officecleantech.model.entidade.Produto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World</h1>

	<!-- teste buscar -->

	<%
	ProdutoDao dao = new ProdutoDao();

	Produto p = dao.buscar(2);
	%>

	<p><%=p.getCodigoBarra()%>
		-
		<%=p.getNome()%></p>

	<!-- fim teste buscar -->

</body>
</html>