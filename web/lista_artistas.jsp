<%-- 
    Document   : lista_artistas.jsp
    Created on : 23/08/2017, 11:23:08 PM
    Author     : Benjamin "12g" La Madrid; Danny Olivares
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
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="open-iconic/css/open-iconic-bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body style="background-image:url('img/Guitarra2.jpg'); background-repeat: no-repeat; background-size: 100%" >
        <div class="container">
            <div class="row">
                <div class="col-xs-8 col-xs-offset-2 text-muted">
                    <br/>
                    <h1 class="text-info">Artistas en la Base de Datos</h1>
                    <table class="table table-hover">
                        <thead class="bg-primary">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Nacimiento/Formación</th>
                                <th>Álbumes</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${artistas}" var="artista">
                                <c:set var="artistaID" value="${artistas.indexOf(artista)}" scope="session" />
                                <tr class="${(artistaID%2 != 0)? "warning text-warning":"success text-success"}">
                                    <th scope="row">${artistaID+1}</th>
                                    <td><c:out default="X" value="${artista.nombre}" ></c:out></td>
                                    <td><c:out default="X" value="${artista.fechaNac}" ></c:out></td>
                                    <td><c:out default="X" value="${artista.albumes.size()}" ></c:out></td>
                                    <td class="text-right">
                                        <a href="verArtista?id=${artistaID}" class="btn btn-primary btn-xs text-center" style="width:24px"><span class="oi oi-info"></span></a>
                                        <a href="editarArtista?id=${artistaID}" class="btn btn-warning btn-xs text-center" style="width:24px"><span class="oi oi-pencil"></span></a>
                                        <a href="borrarArtista?id=${artistaID}" class="btn btn-danger btn-xs text-center" style="width:24px"><span class="oi oi-trash"></span></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <a href="formularioAgregar" class="btn btn-primary">Nuevo</a>
                </div>
            </div>
        </div>
    </body>
</html>
