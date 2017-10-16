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
        <%@include file="WEB-INF/jspf/segment_include_styles.jspf" %>
    </head>
    <body style="background-image:url('/MusicWiki/img/Guitarra2.jpg'); background-repeat: no-repeat; background-size: 100%" >
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
                                <th class="text-center">Nacimiento/Formación</th>
                                <th class="text-center">Álbumes</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${artistas}" var="artista">
                                <c:set var="artistaID" value="${artistas.indexOf(artista)}" scope="session" />
                                <tr class="${(artistaID%2 != 0)? "warning text-warning":"success text-success"}">
                                    <th scope="row">${artistaID+1}</th>
                                    <td><c:out default="X" value="${artista.nombre}" ></c:out></td>
                                    <td class="text-center"><c:out default="X" value="${artista.fechaNac}" ></c:out></td>
                                    <td class="text-center"><c:out default="X" value="${artista.albumes.size()}" ></c:out></td>
                                    <td class="text-right">
                                        <a href="/MusicWiki/artista/ver?id=${artistaID}" class="btn btn-primary btn-xs text-center" style="width:24px"><span class="oi oi-info"></span></a>
                                        <a href="/MusicWiki/artista/borrar?id=${artistaID}" class="btn btn-danger btn-xs text-center" style="width:24px"><span class="oi oi-trash"></span></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-xs-4 col-xs-offset-2 text-muted text-left">
                    <a href="/MusicWiki/artista/crear" class="btn btn-info">Nuevo</a>
                </div>
                <div class="col-xs-4 text-muted text-right">
                    <a href="/MusicWiki/artista/buscar" class="btn btn-success">Buscar</a>
                </div>
            </div>
        </div>
        <%@include file="WEB-INF/jspf/segment_include_javascript.jspf" %>
    </body>
</html>
