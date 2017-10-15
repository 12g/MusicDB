<%-- 
    Document   : index.jsp
    Created on : 20/08/2017, 08:28:12 PM
    Author     : Benjamin "12g" La Madrid; Danny Olivares
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>  
        <title>Inicio - Wiki Instruments</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="open-iconic/css/open-iconic-bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body style="background-image:url('img/Guitarra2.jpg'); background-repeat: no-repeat; background-size: 100%" >
        <div class="container">
            <div class="row">
                <div class="col">
                    <br/>
                    <h1 class="text-light">Wiki Instruments</h1>
                    <form action="login" method="post">
                        <div class="form-group">
                            <label for="inputEmail">Usuario</label>
                            <input id="inputEmail" type="email" class="form-control" aria-describedby="emailHelp" placeholder="Ingrese su email..." />
                        </div>
                        <div class="form-group">
                            <label for="inputPassword">Contraseña</label>
                            <input id="inputPassword" type="password" class="form-control" placeholder="Ingrese una contraseña..." />
                        </div>
                        <input type="submit" class="btn btn-danger" value="Entrar" />
                    </form>
                    <br/>
                    <br/>
                </div>
            </div>
        </div>
        <%@include file="WEB-INF/jspf/segment_footer.jspf" %>
        <script src="bootstrap/js/jquery-3.2.1.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="bootstrap/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    </body>
</html>

