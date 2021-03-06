<%-- 
    Document   : entregar
    Created on : 23-11-2018, 18:27:33
    Author     : jhaco
--%>
<%@page import="soporte.business.Personal"%>
<%@page import="soporte.business.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/ServletCargarMisDatos"></jsp:include>
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
            <%@include file="../../contents/mis_datos.jsp" %>
        </main>

        <footer class="fixed-bottom">
                    <%
            if(session.getAttribute("Modificar")!= null && session.getAttribute("Modificar").equals("true")){ %>
            <div class="alert alert-success">
                <strong>Actualizado!</strong> Los datos se modificaron correctamente!
            </div>
            <% } 
                session.setAttribute("Modificar", null); %>
            <%@include  file="../../partials/footer.jsp" %>
        </footer>
    </body>
</html>
