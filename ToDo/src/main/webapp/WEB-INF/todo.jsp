<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TODO</title>
</head>
<body>
<c:if test="${not empty httpServletRequest.remoteUser}" >${httpServletRequest.remoteUser}</c:if>
<c:if test="${not empty msg}" >${msg}</c:if>
<form action="create" method="post">
<input type="text" id="name" name="name"/><br/>
<textarea rows="4" cols="5" id="description" name="description"></textarea><br/>
<button type="submit" >Criar</button><br/>
	<c:forEach var="t" items="${tasks}">
	<input type="checkbox" value="${t.id}" >
				${t.name} - ${t.description}</input><br/>
			</c:forEach>
			
</form>
</body>
</html>