<%-- 
    Document   : formulario
    Created on : 26-ago-2017, 8:50:18
    Author     : cetecom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>  
        <title>Inicio - Wiki Instruments</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="open-iconic/css/open-iconic-bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body style="background-image:url('img/Guitarra2.jpg'); background-repeat: no-repeat; background-size: 100%" >



        <div class="container" style="color: #ffffff">
            <div class="row">
                <div class="col-xs-4 col-xs-offset-4" >
                    <br>
                    <h1 style="color: #ffffff" >Nuevo Artista</h1>
                    <br>
                    <br>
                    <br>

                    <form>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Nombre Banda</label>
                            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Año De Formaciòn</label>
                            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                        </div>
                        <div class="form-check">
                            <label class="form-check-label">
                                <input type="checkbox" class="form-check-input">
                                Es Grupo o no?
                            </label>
                        </div>
                        <button type="submit" class="btn btn-primary">Enviar</button>
                    </form>
                </div>
            </div>



        </div>
    </body>
</html>
