<%-- 
    Document   : index.jsp
    Created on : 20/08/2017, 08:28:12 PM
    Author     : Benjamin "12g" La Madrid; Danny Olivares
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>  
        <title>Inicio - Wiki Instruments</title>
        <%@include file="segment/head.jsp" %>
    </head>
    <body style="background-image:url('img/Guitarra2.jpg'); background-repeat: no-repeat; background-size: 100%" >
        <div class="container">
            <div class="row">
                <div class="col">
                    <br/>
                    <h1 class="text-light">Wiki Instruments</h1>
                    <form action="login" method="post">
                        <div class="form-group">
                            <label for="inputEmail">Usuario</label>
                            <input name="email" id="inputEmail" type="email" class="form-control" aria-describedby="emailHelp" placeholder="Ingrese su email..." />
                        </div>
                        <div class="form-group">
                            <label for="inputPassword">Contraseña</label>
                            <input name="password" id="inputPassword" type="password" class="form-control" placeholder="Ingrese una contraseña..." />
                        </div>
                        <button type="submit" class="btn btn-danger">Entrar</button>
                    </form>
                    <br/>
                    <br/>
                </div>
            </div>
        </div>
        <%@include file="segment/footer.jsp" %>
        <%@include file="segment/scripts.jsp" %>
    </body>
</html>

