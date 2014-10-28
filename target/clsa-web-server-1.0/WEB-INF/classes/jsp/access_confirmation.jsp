<%@ page
	import="org.springframework.security.core.AuthenticationException"%>
<%@ page
	import="org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter"%>
<%@ page
	import="org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException"%>
<%@ taglib prefix="authz"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Confirm access.</title>

</head>

<body>

	<div class="container">
		<img src="<c:url value='/bank.jpg'/>" height="94px">

		<%
			if (session.getAttribute(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY) != null
					&& !(session
							.getAttribute(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY) instanceof UnapprovedClientAuthenticationException)) {
		%>
		<div class="error">
			<h2>Woops!</h2>

			<p>
				Access could not be granted. (<%=((AuthenticationException) session
						.getAttribute(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY))
						.getMessage()%>)
			</p>
		</div>
		<%
			}
		%>
		<c:remove scope="session"  var="SPRING_SECURITY_LAST_EXCEPTION" />

<%-- 		<authz:authorize  ifAllGranted="ROLE_USER"> --%>
			<h2>Please Confirm</h2>

			<p>
				${client.clientId} will have permission below to access your account:
			</p>
			<ul>
			
			<c:forEach items="${scopes}" var="scope">
						<li>${scope}</li>
					</c:forEach>
			</ul>
			
			<form id="confirmationForm" name="confirmationForm"
				action="<%=request.getContextPath()%>/oauth/authorize" method="post">
				<input name="user_oauth_approval" value="true" type="hidden" />
				<button class="btn btn-primary" type="submit">Submit</button>
			</form>
			
			<form id="confirmationForm" name="confirmationForm"
				action="<%=request.getContextPath()%>/oauth/authorize" method="post">
				<input name="user_oauth_approval" value="false" type="hidden" />
				<button class="btn btn-primary" type="submit">Deny</button>
			</form>

<%-- 		</authz:authorize> --%>


	</div>

</body>
</html>
