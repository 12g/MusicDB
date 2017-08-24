<%-- 
    Document   : lista_artistas.jsp
    Created on : 23/08/2017, 11:23:08 PM
    Author     : Benjamin "12g" La Madrid; Danny Olivares
--%>

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
                    <h1 class="text-info">Wiki Instruments</h1>
                    <table class="table">
                        <thead class="bg-primary">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Álbumes</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td class="text-right">
                                    <a href="verArtista" class="btn btn-primary btn-xs">
                                        <span class="oi oi-info"></span>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td class="text-right">
                                    <a href="verArtista" class="btn btn-primary btn-xs">
                                        <span class="oi oi-info"></span>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td>Larry</td>
                                <td>the Bird</td>
                                <td class="text-right">
                                    <a href="verArtista" class="btn btn-primary btn-xs">
                                        <span class="oi oi-info"></span>
                                    </a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
