<%-- 
    Document   : login
    Created on : 22-11-2018, 23:43:49
    Author     : jhaco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../partials/head.jsp" %>
    </head>
    <body>
        <div class="container" style="width: 400px; margin-top: 80px;">
            <div class="card card-container">
                <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" style="height: 300px" />
                <p id="profile-name" class="profile-name-card"></p>
                <form class="form-signin" action="${pageContext.request.contextPath}/ServletLogin" method="POST">
                    <span id="reauth-email" class="reauth-email"></span>
                    <input type="text" id="inputEmail" class="form-control" placeholder="username" name="username" required autofocus>
                    <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required>
                    <div id="remember" class="checkbox">
                        <label>
                            <input type="checkbox" value="remember-me"> Remember me
                        </label>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</button>
                </form><!-- /form -->
                <a href="#" class="forgot-password">
                    Forgot the password?
                </a>
            </div><!-- /card-container -->
        </div><!-- /container -->
    </body>
    <% if (request.getAttribute("Mensaje") != null) {%>
    <h1><%=request.getAttribute("Mensaje")%></h1>
    <% }%>
</html>
