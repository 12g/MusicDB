<%-- 
    Document   : buscar_artistas
    Created on : 25-08-2017, 16:12:04
    Author     : benja
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>  
        <title>Artistas - Wiki Instruments</title>
        <%@include file="WEB-INF/jspf/segment_include_styles.jspf" %>
    </head>
    <body style="background-image:url('/MusicWiki/img/Guitarra2.jpg'); background-repeat: no-repeat; background-size: 100%" >
        <div class="container">
            <div class="row">
                <div class="col-xs-8 col-xs-offset-2 text-muted">
                    <br/>
                    <h1 class="text-light">Wiki Instruments</h1>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <form action="buscarArtistas" method="post">
                                <div class="form-group form-horizontal">
                                    <label for="inputCriterio" class="col-sm-3">Criterio de búsqueda</label> 
                                    <div class="col-sm-9"><input id="inputCriterio" type="text" value="" name="nombre" placeholder="Ingrese un criterio..." class="form-control" /></div>
                                </div>
                                <br>
                                <br>
                                <div class="form-group form-horizontal">
                                    <label for="inputAño" class="col-sm-3">Año de Nacimiento</label>
                                    <div class="col-sm-4">
                                        <select id="inputAño" class="form-control">
                                            <c:forEach begin="1901" end="1999" var="año">
                                                <option value="${año}">${año}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-sm-5 text-right">
                                        <input type="action"  value="Buscar" class="btn btn-success" />
                                    </div>
                                </div>
                                <br>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="WEB-INF/jspf/segment_include_javascript.jspf" %>
    </body>
</html>
