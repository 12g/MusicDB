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
        <%@include file="/MusicWiki/WEB-INF/jspf/segment_include_styles.jspf" %>
    </head>
    <body style="background-image:url('/MusicWiki/img/Guitarra2.jpg'); background-repeat: no-repeat; background-size: 100%" >
        <div class="container" style="color: #ffffff">
            <div class="row">
                <div class="col-xs-4 col-xs-offset-4" >
                    <br>
                    <h1 style="color: #ffffff" >Nuevo Artista</h1>
                    <br>
                    <br>
                    <br>
                    <form action="" method="get">
                        <div class="form-group">
                            <label for="inputNombre">Nombre</label>
                            <input id="inputNombre" type="text" class="form-control" placeholder="Ingrese un nombre..." />
                            <small class="form-text text-muted">Queremos ser tu página favorita</small>
                        </div>
                        <div class="form-group">
                            <label for="inputAño">Año de Nacimiento/Formación</label>
                            <input id="inputAño" type="number" minlength="4" maxlength="4" class="form-control" value="1940" placeholder="Ingrese un año..." />
                        </div>
                        <div class="form-check">
                            <label>
                                <input type="checkbox" value="esGrupo" />
                                Es un grupo?
                            </label>
                        </div>
                        <button type="submit" class="btn btn-primary">Enviar</button>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="/MusicWiki/WEB-INF/jspf/segment_include_javascript.jspf" %>
    </body>
</html>
