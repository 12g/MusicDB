<%-- 
    Document   : infoartist
    Created on : 26-ago-2017, 14:55:07
    Author     : benja
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>  
        <title>Artista - Wiki Instruments</title>
        <%@include file="segment/head.jsp" %>
    </head>
    <body style="background-image:url('/MusicWiki/img/Guitarra2.jpg'); background-repeat: no-repeat; background-size: 100%" >
        <div class="container">
            <div class="row">
                <div class="col-xs-8 col-xs-offset-2 text-muted">
                    <br/>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <h1>${nombre}</h1>
                            <p>Año de formación: ${año}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div
        <%@include file="segment/footer.jsp" %>
        <%@include file="segment/scripts.jsp" %>
    </body>
</html>
