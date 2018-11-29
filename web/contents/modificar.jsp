
<%
    Equipo e = (Equipo) session.getAttribute("eq");
%>
<form action="${pageContext.request.contextPath}/ServletModificarEquipo" method="post">
    <table class="tabla">
        <tr>
            <td>Tipo de dispositivo</td>
            <td>
                <select class="form-control" name="tipo" style="margin-left: 20px" required>
                    <%
                        ArrayList<TipoEquipo> tipos = (ArrayList<TipoEquipo>) session.getAttribute("tipos");
                        for (TipoEquipo t : tipos) {
                    %>
                    <option value="<%=t.getIdTipoEquipo()%>"<% if (t.getIdTipoEquipo() == e.getTipoEquipo()) { %>selected<% }%>><%=t.getTipo_equipo()%></option>
                    <% }%>
                </select>
            </td>
            <td><button type="submit" class="btn btn-outline-dark" style="width: 180px; margin-left: 50px;">Modificar</button></td>
        </tr>
        <tr>
            <td>
                Marca
            </td>
            <td>
                <input type="text" class="form-control form-control" name="marca" style="margin-left: 20px;" value="<%= e.getMarca()%>" required>
            </td>
        </tr>
        <tr>
            <td>
                Modelo
            </td>
            <td>
                <input type="text" class="form-control form-control" name="modelo" style="margin-left: 20px;" value="<%= e.getModelo()%>" required>
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
                <textarea class="form-control" name="descripcion" rows="4" id="comment" style="margin-left: 20px;" required><%= e.getDescripcion()%></textarea>
            </td>
        </tr>
        <tr>
            <td>
                Encargado
            </td>
            <td>
                <select class="form-control" name="rut_encargado" style="margin-left: 20px" required>
                    <%
                        ArrayList<Personal> personal = (ArrayList< Personal>) session.getAttribute("personal");
                        for (Personal p : personal) {%>
                    <option value="<%=p.getRut_personal()%>">
                        <%=p.getRut_personal() + " | " + p.getNombre() + " " + p.getAp_pat()%></option>
                    <% }%>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                Rut cliente
            </td>
            <td>
                <input type="text" id="rut" name="rut_cliente" required oninput="checkRut(this)" placeholder="Ingrese RUT" class="form-control form-control"
                       style="margin-left: 20px;" value="<%=e.getRut_cliente()%>">
            </td>
        </tr>
        <tr>
            <td>
                Precio
            </td>
            <td>
                <input type="number" id="rut" name="precio" class="form-control form-control"
                       style="margin-left: 20px;" value="<%=e.getPrecio()%>" required>
                <input type="text" name="idEquipo" value="<%=e.getIdEquipo()%>" hidden>
            </td>
        </tr>
    </table>
</form>