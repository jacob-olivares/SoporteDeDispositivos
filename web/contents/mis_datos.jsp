<%@page import="soporte.business.Personal"%>
<%@page import="soporte.business.Usuario"%>
<form action="${pageContext.request.contextPath}/ServletCargarMisDatos" method="post">
    <table class="tabla">
        <%
            Personal p = (Personal)session.getAttribute("Personal");
            %>
        <tr>
            <td>
                Rut personal:
            </td>
            <td>
                <input type="text" class="form-control form-control" name="rut_personal" style="margin-left: 20px;" value="<%=p.getRut_personal()%>" disabled>
            </td>
        </tr>
        <tr>
            <td>
                Nombre
            </td>
            <td>
                <input type="text" class="form-control form-control" name="nombre" style="margin-left: 20px;" value="<%=p.getNombre()%>" required>
            </td>
        </tr>
        <tr>
            <td>
                Apellido paterno
            </td>
            <td>
                <input type="text" class="form-control form-control" name="ap_pat" value="<%=p.getAp_pat()%>" style="margin-left: 20px;" required>
            </td>
        </tr>
        <tr>
            <td>
                Apellido materno
            </td>
            <td>
                <input type="text" class="form-control form-control" name="ap_mat" value="<%=p.getAp_mat()%>" style="margin-left: 20px;" required>
            </td>
        </tr>
        <tr>
            <td>
                Telefono
            </td>
            <td>
                <input type="text" class="form-control form-control" name="telefono" value="<%=p.getTelefono()%>" style="margin-left: 20px;" required>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><button type="submit" class="btn btn-outline-dark" style="margin-left: 20px; margin-top: 20px;">Actualizar datos</button></td>
        </tr>
    </table>
</form>