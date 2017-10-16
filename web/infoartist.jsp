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
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <h1>${nombre}</h1>
                            <p>Año de formación: ${año}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
