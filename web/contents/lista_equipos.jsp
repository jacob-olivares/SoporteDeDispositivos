<div class="container" style="margin-left: 30px; margin-top: 20px;">
  <h2>Lista de equipos en taller</h2>
  <p>La siguiente tabla contiene los equipos actualmente en taller:</p>            
  <table class="display" id="tabla">
    <thead>
      <tr>
        <th>ID</th>
        <th>Marca</th>
        <th>Modelo</th>
        <th style="width: 100px;">Tipo equipo</th>
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
            <td>${e.marca}</td>
            <td>${e.modelo}</td>
        <c:choose>
            <c:when test="${e.tipoEquipo == 1}">
                <td style="width: 100px;">PC</td>
            </c:when>
            <c:when test="${e.tipoEquipo == 2}">
                <td style="width: 100px;">Notebook</td>
            </c:when>
            <c:when test="${e.tipoEquipo == 3}">
                <td style="width: 100px;">All In One</td>
            </c:when>
            <c:when test="${e.tipoEquipo == 4}">
                <td style="width: 100px;">Celular</td>
            </c:when>
            <c:when test="${e.tipoEquipo == 5}">
                <td style="width: 100px;">Netbook</td>
            </c:when>
        </c:choose>
            <td style="width: 150px;">${e.fecha_ingreso}</td>
            <td style="width: 150px;">${e.fecha_salida}</td>
            <td style="width: 150px;">${e.descripcion}</td>
            <td>${e.rut_encargado}</td>
            <td style="width: 150px;">${e.rut_cliente}</td>
        </tr>
    </c:forEach>
    </tbody>
  </table>
</div>