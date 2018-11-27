<%-- 
    Document   : entregar
    Created on : 23-11-2018, 18:27:33
    Author     : jhaco
--%>

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
            <%@include file="../../contents/entregar_equipo.jsp" %>
            <%@include file="../../contents/lista_entregar.jsp" %>
        </main>
            <% if (session.getAttribute("Entregado") != null) { %>
            <% if (session.getAttribute("Entregado").equals("true")) { %>
            <div class="alert alert-success">
                <strong>Entregado!</strong> Se ha entregado el equipo correctamente.
            </div>
            <%  }
                    session.setAttribute("Entregado", null);
                }%>
        <footer class="fixed-bottom">
            <%@include  file="../../partials/footer.jsp" %>
        </footer>
    </body>
    <script>
$(document).ready( function () {
    $('#tabla').DataTable();
       
} );
$.extend( $.fn.dataTable.defaults, {
    searching: false,
    ordering:  false
        
} );
        
$('#tabla').dataTable( {
    "pageLength": 5,
    "lengthChange": false
} );
    </script>
    <%@include  file="../../contents/validarRut.jsp" %>
    <%
        session.setAttribute("equiposXRut", null); %>
</html>
