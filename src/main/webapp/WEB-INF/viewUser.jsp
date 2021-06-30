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
                        </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    ${userView.id}
                                </td>
                                <td>
                                    ${userView.username}
                                </td>
                                <td>
                                    ${userView.email}
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- Approach -->
    </div>
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <a href="http://localhost:8080/user/list" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"> Wstecz </a>
    </div>
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
</html>




<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: ilona--%>
<%--  Date: 20.04.2021--%>
<%--  Time: 16:39--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>User CRUD</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<%--%>
<%--    response.setHeader("Cache-Control", "no cache, no-store, must-revalidate");--%>
<%--%>--%>
<%--<table>--%>
<%--    <tr>--%>
<%--        <th>--%>
<%--            ID--%>
<%--        </th>--%>
<%--        <td>--%>
<%--            ${userView.id}--%>

<%--        </td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <th>--%>
<%--            Nazwa użytkownika--%>
<%--        </th>--%>
<%--        <td>--%>
<%--                ${userView.username}--%>
<%--        </td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <th>--%>
<%--            E-mail--%>
<%--        </th>--%>
<%--        <td>--%>
<%--            ${userView.email}--%>
<%--        </td>--%>
<%--    </tr>--%>

<%--</table>--%>
<%--<button type="button"><a href="/user/list">Powrót</a></button><br>--%>
<%--<button type="button"><a href="/user/logout">Wyloguj</a></button>--%>
<%--</body>--%>
<%--</html>--%>
