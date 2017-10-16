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
        <%@include file="WEB-INF/jspf/segment_include_styles.jspf" %>
    </head>
    <body style="background-image:url('/MusicWiki/img/Guitarra2.jpg'); background-repeat: no-repeat; background-size: 100%" >  
        <div class="container">
            <div class="row">
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <div class="col-xs-12 text-center">
                    <h2 style="color: #ffffff">Borrar Artista?</h2>
                </div>
                <div class=" col-xs-6 text-right">
                    <a href="/MusicWiki/artista/borrar/si" type="button" class="btn btn-danger">Si</a>
                </div>
                
                <div class=" col-xs-6">
                    <a href="/MusicWiki/artista/borrar/no" type="button" class="btn btn-danger">No</a>
                </div>
            </div>
        </div>
        <%@include file="WEB-INF/jspf/segment_include_javascript.jspf" %>
    </body>
</html>
