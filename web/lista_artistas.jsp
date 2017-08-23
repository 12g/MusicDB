<%-- 
    Document   : lista_artistas
    Created on : 23/08/2017, 12:27:21 AM
    Author     : samsung
--%>
voy a dormir benjis
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<% List lista_artistas = (List)session.getAttribute("artistas");
lista_artistas.add();%>
<!DOCTYPE html>
<html>
    <head>  
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        <title>Artistas</title>
    </head>
    <body class="bg-dark text-light" style="background-image:url('img/Guitarra2.jpg'); background-repeat: no-repeat; background-size: 100%" >
        <br>
        <br>
        <h1>Artistas</h1>
        <br>
        <br>
        <br>
        <table class="table table-striped table-inverse ">
            <thead>
              <tr>
                <th>#</th>
                <th>Nombre Artista</th>
                <th>Instagram</th>
                <th>Facebook</th>
              </tr>
            </thead>
            <tbody>
                <tr>
                  <th scope="row">2</th>
                  <td>Slipknot</td>
                  <td>@slipknot</td>
                  <td>Slipknot</td>
                </tr>
                <c:forEach items="${lista_artistas}" var="">
                    <tr>
                      <th scope="row">1</th>
                      <td>Aperfect Circle</td>
                      <td>@pperfectCircle</td>
                      <td>Aperfect Circle Band</td>
                    </tr>
                </c:forEach>
                <tr>
                  <th scope="row">3</th>
                  <td>Elvis</td>
                  <td>@Elvis</td>
                  <td>ElvisTheLeyend</td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
