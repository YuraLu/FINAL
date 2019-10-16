<%@ page contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:setLocale value="${sessionScope.local}" />
	<fmt:setBundle basename="text" var="rb" />
	<fmt:message bundle="${rb}" key="error.error" var="error" />
	<fmt:message bundle="${rb}" key="error.info404" var="info404" />
	<fmt:message bundle="${rb}" key="button.go_home" var="home" />

	<table align="center" width="70%" cellspacing="0" cellpadding="4">
		<tr>
			<td align="center" width="70">
				<form action="Servlet" method="post">
					<input type="hidden" name="command" value="showAllTests">
					<input type="submit" size="50" value="${home}" />
				</form>
			</td>
		</tr>
	</table>
	<br>
	<br>

	<H1>${error}404.</H1>
	<h2>${info404}</h2>

</body>
</html>