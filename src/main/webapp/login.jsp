      <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
    <%@ taglib prefix="auth" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Citibank</title>
<link type="text/css" rel="stylesheet"
	href="webjars/bootstrap/3.0.3/css/bootstrap.min.css" />
<script type="text/javascript" src="webjars/jquery/1.9.0/jquery.min.js"></script>
<script type="text/javascript"
	src="webjars/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</head>

<body>

	<div class="container">

		<img src="<c:url value='/bank.jpg'/>" height="94px">


		<div class="form-horizontal">

			<form action="<c:url value="/login.do"/>" method="post" role="form">


				<div class="form-group">
					<label for="username">Username:</label> <input id="username"
						class="form-control" type='text' name='j_username' value="user1" />
				</div>
				<div class="form-group">
					<label for="password">Password:</label> <input id="password"
						class="form-control" type='text' name='j_password' value="user1" />
				</div>
				<button class="btn btn-primary" type="submit">Login</button>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>

		</div>



	</div>


</body>
</html>
