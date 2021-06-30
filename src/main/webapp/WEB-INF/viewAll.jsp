<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ilona
  Date: 17.04.2021
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Users CRUD</title>
    <link href="<c:url value="/theme/css/sb-admin-2.css"/>" rel="stylesheet">
    <link href="<c:url value="/theme/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet">
</head>

<body id="page-top">
<%@ include file="/WEB-INF/header.jsp" %>
<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <%--                <div class="d-sm-flex align-items-center justify-content-between mb-4">--%>
    <%--                    <h1 class="h3 mb-0 text-gray-800">Users CRUD</h1>--%>
    <%--                    <a href="/user/logout" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">Wyloguj</a>--%>
    <%--                </div>--%>
    <div class="container-fluid">
        <!-- Page Heading -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Lista użytkowników</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nazwa</th>
                            <th>Email</th>
                            <th>Akcja</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${allUsers}" var="listUser">
                            <tr>
                                <td>
                                        ${listUser.id}
                                </td>
                                <td>
                                        ${listUser.username}
                                </td>
                                <td>
                                        ${listUser.email}
                                </td>
                                <td>
                                    <a href="<c:url value="/user/delete?id=${listUser.id}"/> "class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">Usuń</a>
                                    <a href="<c:url value="/user/edit?id=${listUser.id}"/>"class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">Edytuj</a>
                                    <a href="<c:url value="/user/show?id=${listUser.id}"/>"class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">Wyświetl</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- Approach -->
    </div>
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <a href="http://localhost:8080/user/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">Dodaj
            użytkownika</a>
    </div>
    <%--                <button><a href="http://localhost:8080/user/add">Dodaj</a></button>--%>
    <%--                <br>--%>
    <%--                <button type="button"><a href="/user/logout">Wyloguj</a></button>--%>
    <!-- Approach -->
</div>
</div>
</div>

</div>


<%
    response.setHeader("Cache-Control", "no cache, no-store, must-revalidate");
%>
<!-- /.container-fluid -->
<!-- DataTales Example -->


<%@ include file="/WEB-INF/footer.jsp" %>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="js/demo/chart-area-demo.js"></script>
<script src="js/demo/chart-pie-demo.js"></script>
</body>

<%--<body>--%>

<%--<table>--%>
<%--    <tr>--%>
<%--        <th>--%>
<%--            ID--%>
<%--        </th>--%>
<%--        <th>--%>
<%--            Nazwa użytkownika--%>
<%--        </th>--%>
<%--        <th>--%>
<%--            E-mail--%>
<%--        </th>--%>
<%--        <th>--%>
<%--            Akcja--%>
<%--        </th>--%>
<%--    </tr>--%>
<%--    <c:forEach items="${allUsers}" var="listUser">--%>
<%--        <tr>--%>
<%--            <td>--%>
<%--                    ${listUser.id}--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                    ${listUser.username}--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                    ${listUser.email}--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <a href="<c:url value="/user/delete?id=${listUser.id}"/>">Usuń</a>--%>
<%--                <a href="<c:url value="/user/edit?id=${listUser.id}"/>">Edytuj</a>--%>
<%--                <a href="<c:url value="/user/show?id=${listUser.id}"/>">Wyświetl</a>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>


<%--</body>--%>
</html>
