<%--
  Created by IntelliJ IDEA.
  User: ilona
  Date: 20.04.2021
  Time: 16:24
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
Usunięto użytkownika
<button type="button"><a href="/user/list">Powrót</a></button><br>
<button type="button"><a href="/user/logout">Wyloguj</a></button>
</body>
</html>
