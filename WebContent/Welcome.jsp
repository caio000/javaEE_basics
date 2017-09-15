<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Bem vindo!</h2>
	
	
	<div class="page">
		<div class="content">
			<form method="post" action="Login">
				<div class="form-group">
					<label for="user_email">Email:</label>
					<input id="user_email" name="user_email" class="form-control" type="email" required />
				</div>
				
				<div class="form-group">
					<label>Senha:</label>
					<input id="user_password" name="user_password" class="form-control" type="password" required />
				</div>
				
				<div class="form-group">
					<button type="submit">Entrar</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>