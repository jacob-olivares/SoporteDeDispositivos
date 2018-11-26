
<div class="container" style="margin-left: 30px; margin-top: 20px;">
  <h2>Lista de equipos en taller</h2>
  <p>La siguiente tabla contiene los equipos actualmente en taller:</p>            
  <table class="display" id="tabla">
    <thead>
      <tr>
        <th>ID</th>
        <th>Marca</th>
        <th>Modelo</th>
        <th>Tipo de equipo</th>
        <th>Fecha ingreso</th>
        <th>Fecha entrega</th>
        <th>Descripcion</th>
        <th>Encargado</th>
        <th>Cliente</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="e" items="${equipos}">
        <tr>
            <td>${e.idEquipo}</td>
            <td>${e.modelo}</td>
            <td>${e.marca}</td>
            
        <c:choose>
            <c:when test="${e.tipoEquipo == 1}">
                <td>PC</td>
            </c:when>
            <c:when test="${e.tipoEquipo == 2}">
                <td>Notebook</td>
            </c:when>
            <c:when test="${e.tipoEquipo == 3}">
                <td>All In One</td>
            </c:when>
            <c:when test="${e.tipoEquipo == 4}">
                <td>Smartphone<td>
            </c:when>
            <c:when test="${e.tipoEquipo == 5}">
                <td>Netbook</td>
            </c:when>
        </c:choose>

            <td>${e.fecha_ingreso}</td>
            <td>${e.fecha_salida}</td>
            <td>${e.descripcion}</td>
            <td>${e.rut_encargado}</td>
            <td>${e.rut_cliente}</td>
        </tr>
    </c:forEach>
    </tbody>
  </table>
</div>