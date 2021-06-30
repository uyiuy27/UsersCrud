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
<body class="bg-gradient-primary">

<div class="container">

    <!-- Outer Row -->
<%--    <div class="row justify-content-center">--%>

        <div class="col-xl-10 col-lg-12 col-md-9">

            <div class="card o-hidden border-0 shadow-lg my-5">
<%--                <div class="card-body p-0">--%>
                    <!-- Nested Row within Card Body -->
<%--                    <div class="row">--%>
<%--                        <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>--%>
<%--                        <div class="col-lg-6">--%>
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Zostałeś wylogowany</h1>
                                </div>
                                <a href="/user/login"><button type="button" class="btn btn-primary btn-user btn-block" >Zaloguj ponownie</button></a>
                            </div>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
            </div>

        </div>

<%--    </div>--%>

</div>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>

</body>
</html>





<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: ilona--%>
<%--  Date: 20.04.2021--%>
<%--  Time: 17:32--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>User CRUD</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--Zostałeś wylogowany.--%>
<%--<button type="button"><a href="/user/login">Zaloguj ponownie</a></button>--%>
<%--</body>--%>
<%--</html>--%>
