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
        <%@include file="segment/head.jsp" %>
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
                                <th class="text-center">Nacimiento/Formación</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${artistas}" var="artista">
                                <c:set var="artistaID" value="${artistas.indexOf(artista)}" scope="session" />
                                <tr class="${(artistaID%2 != 0)? "warning text-warning":"success text-success"}">
                                    <th scope="row">${artistaID+1}</th>
                                    <td><c:out default="X" value="${artista.getNombre()}" ></c:out></td>
                                    <td class="text-center"><c:out default="X" value="${artista.getFechaNacimiento()}" ></c:out></td>
                                    <td class="text-right">
                                        <a href="ver_artista?id=${artistaID}" class="btn btn-primary btn-xs text-center" style="width:24px"><span class="oi oi-info"></span></a>
                                        <a href="borrar_artista?id=${artistaID}" class="btn btn-danger btn-xs text-center" style="width:24px"><span class="oi oi-trash"></span></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-xs-4 col-xs-offset-2 text-muted text-left">
                    <a href="crear_artista" class="btn btn-info">Nuevo</a>
                </div>
                <div class="col-xs-4 text-muted text-right">
                    <a href="buscar_artista" class="btn btn-success">Buscar</a>
                </div>
            </div>
        </div>
        <%@include file="segment/footer.jsp" %>
        <%@include file="segment/scripts.jsp" %>
    </body>
</html>
