
            
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand -->
<a class="navbar-brand" href="#">Servicio Técnico</a>

  <!-- Links -->
  <ul class="navbar-nav">
    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="${pageContext.request.contextPath}/pages/equipos/equipos_index.jsp" id="navbardrop" data-toggle="dropdown">
        Equipo
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${pageContext.request.contextPath}/pages/equipos/ingresar.jsp">Ingresar Equipo</a>
        <a class="dropdown-item" href="${pageContext.request.contextPath}/pages/equipos/entregar.jsp">Entregar Equipo</a>
        <a class="dropdown-item" href="${pageContext.request.contextPath}/pages/equipos/lista.jsp">Lista de equipos</a>
      </div>
    </li>
    <!-- Dropdown -->
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="${pageContext.request.contextPath}/pages/equipos/equipos_index.jsp" id="navbardrop2" data-toggle="dropdown">
            Mi cuenta
        </a>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="${pageContext.request.contextPath}/pages/micuenta/misdatos.jsp">Mis datos</a>
            <a class="dropdown-item" href="${pageContext.request.contextPath}/pages/micuenta/cambiarContrasena.jsp">Cambiar Contraseña</a>
            <a class="dropdown-item" href="${pageContext.request.contextPath}/ServletLogin">Salir</a>
        </div>
    </li>
  </ul>
</nav>