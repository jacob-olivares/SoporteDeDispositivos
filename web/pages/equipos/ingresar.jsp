<%-- 
    Document   : ingresar
    Created on : 23-11-2018, 18:24:12
    Author     : jhaco
--%>

<%@page import="soporte.business.Personal"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="soporte.business.TipoEquipo"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/ServletIngresarEquipo"></jsp:include>
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
            <form action="${pageContext.request.contextPath}/ServletIngresarEquipo" method="post">
                <table class="tabla">
                    <tr>
                        <td>Tipo de dispositivo</td>
                        <td>
                            <select class="form-control" name="tipo" style="margin-left: 20px" required>
                                    <% 
                                        ArrayList<TipoEquipo> tipos = (ArrayList<TipoEquipo>)session.getAttribute("tipos");
                                        for(TipoEquipo t: tipos){ 
                                                %>
                                                <option value="<%=t.getIdTipoEquipo()%>"><%=t.getTipo_equipo()%></option>
                                    <% }%>
                                </select>
                        </td>
                        <td><button type="submit" class="btn btn-outline-dark" style="width: 180px; margin-left: 50px;">Ingresar</button></td>
                    </tr>
                    <tr>
                        <td>
                            Marca
                        </td>
                        <td>
                            <input type="text" class="form-control form-control" name="marca" style="margin-left: 20px;" required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Modelo
                        </td>
                        <td>
                            <input type="text" class="form-control form-control" name="modelo" style="margin-left: 20px;" required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Fecha ingreso
                        </td>
                        <td>
                            <input id="datepicker" width="276" name="fecha_ingreso" style="margin-left: 20px;" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Fecha salida estimada
                        </td>
                        <td>
                            <input id="datepicker1" width="276" name="fecha_salida" style="margin-left: 20px;" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Descripcion falla:
                        </td>
                        <td>
                            <textarea class="form-control" name="descripcion" rows="4" id="comment" style="margin-left: 20px;" required></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Encargado
                        </td>
                        <td>
                            <select class="form-control" name="rut_encargado" style="margin-left: 20px" required>
                            <% 
                                ArrayList<Personal> personal = (ArrayList < Personal >)session.getAttribute("personal");
                                for(Personal p : personal){ %>
                                <option value="<%=p.getRut_personal()%>"><%=p.getRut_personal()+" | "+p.getNombre() + " " +p.getAp_pat()%></option>
                            </select>
                            <% }%>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Rut cliente
                        </td>
                        <td>
                            <input type="text" id="rut" name="rut_cliente" required oninput="checkRut(this)" placeholder="Ingrese RUT" class="form-control form-control"
                                   style="margin-left: 20px;">
                        </td>
                    </tr>
                </table>
            </form>
        </main>
        <% if(session.getAttribute("Ingresado")!= null){ %>
        <% if(session.getAttribute("Ingresado").equals("true")){ %>
            <div class="alert alert-success">
                <strong>Ingresado!</strong> Se ha ingresado el equipo a taller.
            </div>
            <%  }
            session.setAttribute("Ingresado", null);
            }%>
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
