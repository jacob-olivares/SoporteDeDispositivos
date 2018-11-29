<%-- 
    Document   : entregar
    Created on : 23-11-2018, 18:27:33
    Author     : jhaco
--%>
<jsp:include page="/ServletIngresarEquipo"></jsp:include>
    <%@page import="soporte.business.Equipo"%>
<%@page import="soporte.business.TipoEquipo"%>
<%@page import="soporte.business.Personal"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include  file="../../partials/head.jsp" %>
    </head>
    <body>
        <header>
            <%@include  file="../../partials/menu.jsp" %>
        </header>
        <main>
            <%@include  file="../../contents/modificar.jsp" %>
        </main>
        <footer class="fixed-bottom">
            <%@include  file="../../partials/footer.jsp" %>
        </footer>
    </body>
    <script>
        $('#datepicker').datepicker({
            format: 'dd/mm/yyyy',
            uiLibrary: 'bootstrap4'
        });
                
        $('#datepicker1').datepicker({
            format: 'dd/mm/yyyy',
            uiLibrary: 'bootstrap4'
        });
    </script>
    <jsp:include page="../../contents/validarRut.jsp"></jsp:include>
</html>

