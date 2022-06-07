<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Viver é Ter a Certeza de Estar Vivo!</h1>

	<form method="post" action="SignUpServlet">
		<input type="text" name="Nome" required/> <input type="text" name="Login" required/>
		<input type="password" name="Senha" required/>
		<!--<input type="text" name="NivelAcesso" />*/-->
		<input type="submit" value="Entrar" />
			
	</form>
</body>
</html>