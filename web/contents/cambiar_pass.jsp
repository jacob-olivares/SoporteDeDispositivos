<div class="container" style="margin-top: 50px;">
    <div class="row">
        <div class="col-sm-12">
            <h1>Cambiar contraseña</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3">
            <p class="text-center">Utilice el siguiente formulario para cambiar su contraseña. Su contraseña no puede ser la misma que su nombre de usuario.</p>
            <form method="post" id="passwordForm" action="${pageContext.request.contextPath}/ServletCambiarPass">
                <input type="password" class="input-lg form-control" name="password1" id="password1" placeholder="Contraseña actual" autocomplete="off">
                <input type="password" class="input-lg form-control" name="password2" id="password2" placeholder="Contraseña nueva" autocomplete="off">
                <input type="password" class="input-lg form-control" name="password3" id="password3" placeholder="Repita la contraseña" autocomplete="off">
                <input type="submit" class="col-xs-12 btn btn-primary btn-load btn-lg" data-loading-text="Cambiando contraseña..." value="Actualizar contraseña" style="margin-top: 15px;">
            </form>
        </div><!--/col-sm-6-->
    </div><!--/row-->
    <% if(session.getAttribute("Mensaje1") != null && session.getAttribute("Mensaje1").equals("true")){ %>
    <div class="alert alert-success">
        <strong>Actualizada!</strong> La contraseña se actualizó correctamente!
    </div>
    <% }
        session.setAttribute("Mensaje1", null); %>
    <% if(session.getAttribute("Error") != null){ 
        if (session.getAttribute("Error").equals("incorrecta")){ %>
        <div class="alert alert-danger">
            <strong>Error!</strong> La contraseña antigua no es correcta.
        </div>
    <% }else if(session.getAttribute("Error").equals("no coinciden")){ %>
       <div class="alert alert-danger">
           <strong>Error!</strong> Las contraseñas no coinciden.
       </div>
    <% }
        session.setAttribute("Error", null);
     }   
    %>
</div>
