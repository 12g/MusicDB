<%-- 
    Document   : deleteartist
    Created on : 26-ago-2017, 9:23:57
    Author     : cetecom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>  
        <title>Inicio - Wiki Instruments</title>
        <%@include file="segment/head.jsp" %>
    </head>
    <body style="background-image:url('img/Guitarra2.jpg'); background-repeat: no-repeat; background-size: 100%" >  
        <div class="container">
            <form action="borrar_artista" method="post">
                <div class="row" style="padding: auto">
                    <div class="col-xs-12 text-center">
                        <h2 style="color: #ffffff">¿Está seguro de borrar este artista de los registros?</h2>
                        <input type="hidden" value="${id}" name="id" />
                    </div>
                    <div class="col-xs-6 text-right">
                        <input type="submit" name="confirm" class="btn btn-danger" value="Sí" />
                    </div>
                    <div class="col-xs-6">
                        <a href="listar_artistas" type="button" class="btn btn-success">No</a>
                    </div>
                </div>
            </form>
        </div>
        <%@include file="segment/footer.jsp" %>
        <%@include file="segment/scripts.jsp" %>
    </body>
</html>
