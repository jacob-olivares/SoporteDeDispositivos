<%-- 
    Document   : index
    Created on : 22-11-2018, 23:43:27
    Author     : jhaco
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="soporte.business.TipoEquipo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include  file="../partials/head.jsp" %>
    </head>
    <body>
        <nav>
            <%@include  file="../partials/menu.jsp" %>
        </nav>
        <main>
            <%
                ArrayList<TipoEquipo> tipos = (ArrayList<TipoEquipo>) request.getAttribute("tipos");
                session.setAttribute("tiposEquipos", tipos);
                %>
        </main>
        <footer class="fixed-bottom">
            <%@include  file="../partials/footer.jsp" %>
        </footer>
    </body>
</html>
