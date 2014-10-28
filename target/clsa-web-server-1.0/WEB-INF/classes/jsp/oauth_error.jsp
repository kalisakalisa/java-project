<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
    <%@ taglib prefix="auth" uri="http://www.springframework.org/security/tags" %>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Citibank</title>
<link type="text/css" rel="stylesheet"
	href="../webjars/bootstrap/3.0.3/css/bootstrap.min.css" />
<script type="text/javascript" src="../webjars/jquery/1.9.0/jquery.min.js"></script>
<script type="text/javascript"
	src="../webjars/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</head>

<body>

	<div class="container">

		<img src="<c:url value='/bank.jpg'/>" height="94px">

		<p>
			<c:out value="${message}" />
			(
			<c:out value="${error.summary}" />
			)
		</p>
		<p>Please go back to your client application and try again, or
			contact the owner and ask for support</p>
	</div>

</body>
</html>
