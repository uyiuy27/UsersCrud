<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ilona
  Date: 20.04.2021
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>User CRUD</title>
</head>
<body>
<%
    response.setHeader("Cache-Control", "no cache, no-store, must-revalidate");
%>
<c:out value="${'Dodano nowego użytkownika'}"></c:out><br>
<button type="button"><a href="/user/list">Powrót</a></button>
<button type="button"><a href="/user/add">Dodaj kolejnego użytkownika</a></button><br>
<button type="button"><a href="/user/logout">Wyloguj</a></button>
</body>
</html>
