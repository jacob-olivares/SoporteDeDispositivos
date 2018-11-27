<form method="get" class="form-inline" action="${pageContext.request.contextPath}/ServletEntregarEquipo" style="margin-top: 50px; margin-left: 400px;">
    <label for="rut_cliente" class="mr-sm-2">Rut cliente:</label>
    <input type="text" id="rut_cliente" name="rut_cliente" required oninput="checkRut(this)" placeholder="Ingrese RUT" class="form-control form-control"
           style="margin-left: 20px;">
    <button type="submit" class="btn btn-primary mb-2" style="margin-left: 20px; width: 100px;" >Buscar</button>
</form>