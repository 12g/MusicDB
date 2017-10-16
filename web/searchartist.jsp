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
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="../open-iconic/css/open-iconic-bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body style="background-image:url('img/Guitarra2.jpg'); background-repeat: no-repeat; background-size: 100%" >
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
        <script src="bootstrap/js/jquery-3.2.1.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="bootstrap/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    </body>
</html>
