    <%-- 
    Document   : formulario
    Created on : 26-ago-2017, 8:50:18
    Author     : cetecom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>  
        <title>Nuevo - Wiki Instruments</title>
        <%@include file="segment/head.jsp" %>
    </head>
    <body style="background-image:url('img/Guitarra2.jpg'); background-repeat: no-repeat; background-size: 100%" >
        <div class="container" style="color: #ffffff">
            <div class="row">
                <div class="col-xs-4 col-xs-offset-4" >
                    <br>
                    <h1 style="color: #ffffff" >Nuevo Artista</h1>
                    <br>
                    <br>
                    <br>
                    <form action="crear_artista" method="post">
                        <div class="form-group">
                            <label for="inputNombre">Nombre</label>
                            <input name="nombre" id="inputNombre" type="text" class="form-control" placeholder="Ingrese un nombre..." />
                        </div>
                        <div class="form-group">
                            <label for="inputAño">Año de Nacimiento/Formación</label>
                            <input name="ano" id="inputAño" type="number" minlength="4" maxlength="4" class="form-control" placeholder="2000" placeholder="Ingrese un año..." />
                        </div>
                        <button type="submit"  class="btn btn-primary">Enviar</button>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="segment/footer.jsp" %>
        <%@include file="segment/scripts.jsp" %>
    </body>
</html>
