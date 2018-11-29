<%-- 
    Document   : lista
    Created on : 23-11-2018, 18:28:07
    Author     : jhaco
--%>
<jsp:include page="/ServletCargarLista"></jsp:include>
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
            <%@include file="../../contents/lista_equipos.jsp" %>
        </main>

        <footer class="fixed-bottom">
                    <% if(session.getAttribute("Eliminado")!= null){ %>
            <%
                if(session.getAttribute("Eliminado").equals("yes")){ %>
                <div class="alert alert-success" style="height: 40px;">
                    <strong>Eliminado!</strong> Se ha eliminado el equipo.
                </div>
                <% }
                    session.setAttribute("Eliminado", null);
                }%>
                <% if(session.getAttribute("Modify")!= null){ %>
                <% if(session.getAttribute("Modify").equals("yes")) { %>
                <div class="alert alert-success" style="height: 40px;">
                    <strong>Actualizado!</strong> Se ha modificado el equipo.
                </div>
                <% }
                    session.setAttribute("Modify", null);
                }%>
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
    <script type="text/javascript">
    $('.confirmation').on('click', function () {
        return confirm('Confirmar eliminacion de equipo');
    });
</script>
</html>