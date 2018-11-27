<div class="container" style="margin-top: 50px;">
    <div class="row">
        <div class="col-sm-12">
            <h1>Cambiar contrase�a</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3">
            <p class="text-center">Utilice el siguiente formulario para cambiar su contrase�a. Su contrase�a no puede ser la misma que su nombre de usuario.</p>
            <form method="post" id="passwordForm" action="${pageContext.request.contextPath}/ServletCambiarPass">
                <input type="password" class="input-lg form-control" name="password1" id="password1" placeholder="Contrase�a actual" autocomplete="off">
                <input type="password" class="input-lg form-control" name="password2" id="password2" placeholder="Contrase�a nueva" autocomplete="off">
                <input type="password" class="input-lg form-control" name="password3" id="password3" placeholder="Repita la contrase�a" autocomplete="off">
                <input type="submit" class="col-xs-12 btn btn-primary btn-load btn-lg" data-loading-text="Cambiando contrase�a..." value="Actualizar contrase�a" style="margin-top: 15px;">
            </form>
        </div><!--/col-sm-6-->
    </div><!--/row-->
    <% if(session.getAttribute("Mensaje1") != null && session.getAttribute("Mensaje1").equals("true")){ %>
    <div class="alert alert-success">
        <strong>Actualizada!</strong> La contrase�a se actualiz� correctamente!
    </div>
    <% }
        session.setAttribute("Mensaje1", null); %>
    <% if(session.getAttribute("Error") != null){ 
        if (session.getAttribute("Error").equals("incorrecta")){ %>
        <div class="alert alert-danger">
            <strong>Error!</strong> La contrase�a antigua no es correcta.
        </div>
    <% }else if(session.getAttribute("Error").equals("no coinciden")){ %>
       <div class="alert alert-danger">
           <strong>Error!</strong> Las contrase�as no coinciden.
       </div>
    <% }
        session.setAttribute("Error", null);
     }   
    %>
</div>
