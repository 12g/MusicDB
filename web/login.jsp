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
        <%@include file="WEB-INF/jspf/segment_include_styles.jspf" %>
    </head>
    <body style="background-image:url('/MusicWiki/img/Guitarra2.jpg'); background-repeat: no-repeat; background-size: 100%" >
        <%@include file="WEB-INF/jspf/segment_header.jspf" %>
        <div class="container">
            <div class="row">
                <div class="col">
                    <br/>
                    <h1 class="text-light">Wiki Instruments</h1>
                    <form action="login/confirmar" method="post">
                        <div class="form-group">
                            <label for="inputEmail">Usuario</label>
                            <input name="email" id="inputEmail" type="email" class="form-control" aria-describedby="emailHelp" placeholder="Ingrese su email..." />
                        </div>
                        <div class="form-group">
                            <label for="inputPassword">Contraseña</label>
                            <input name="password" id="inputPassword" type="password" class="form-control" placeholder="Ingrese una contraseña..." />
                        </div>
                        <input type="submit" class="btn btn-danger" value="Entrar" />
                    </form>
                    <br/>
                    <br/>
                </div>
            </div>
        </div>
        <%@include file="WEB-INF/jspf/segment_footer.jspf" %>
        <%@include file="WEB-INF/jspf/segment_include_javascript.jspf" %>
    </body>
</html>

