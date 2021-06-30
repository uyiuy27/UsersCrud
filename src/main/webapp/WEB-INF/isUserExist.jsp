<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ilona
  Date: 18.04.2021
  Time: 18:14
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
<c:out value="${'Dodawanie użytkownika nie powiodło się. Użytkownik, którego próbujesz dodać już istnieje lub podano niepoprawne dane.'}"></c:out><br>
<button type="button"><a href="/user/list">Powrót</a></button>
<button type="button"><a href="/user/add">Spróbuj ponownie</a></button><br>
<button type="button"><a href="/user/logout">Wyloguj</a></button>
</body>
</html>
