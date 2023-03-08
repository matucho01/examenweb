<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Fluxé | Login</title>
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <title>Login</title>
 <link rel="shortcut icon" href="./assets/f.png"/>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
 <link rel="stylesheet" href="./css/style_login.css">
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <!-- Contenedor izquierdo -->
            <div class="col-5 box_left">
                <div class="row row_logo">
                    <div class="col logo">
                        <img src="./images/logo.png" onclick="location.href='AutorizarController?ruta=ingresar'">
                    </div>
                </div>
                <div class="row row_imagen">
                    <div class="col h-100 box_circle">
                        
                            <div class="circle">
                                <img src="./images/img_inicio.png">
                            </div>
                        
                    </div>
                </div>
            </div>
          <!-- Contenedor derecho -->
          <div class="col-7 vh-100 box_right">
                <div class="row">
                    <div class="col">
                        <h1>Login</h1>
                        <h2>Start managing your money</h2>
                    </div>
                </div>
                <div class="row">
                    <form class="formulario" method="POST" action="AutorizarController?ruta=login">
                        <div class="col">
                            <label for="username" class="fw-bold fs-5">Username</label>
                            <input type="username" class="form-control" name="usuario" placeholder="Type a username" required>
                        </div>
                        <div>
                            <label for="password" class="fw-bold fs-5">Password</label>
                            <input type="password" class="form-control" name="password" placeholder="Type a password" required>
                        </div>
                        <div class="form-check form-switch ">
                            <input class="form-check-input" type="checkbox" id="rememberMe">
                            <label class="form-check-label" for="rememberMe">
                            Remember
                            </label>
                        </div>
                        <div class="col d-flex justify-content-center align-items-center">
                            <button class="btn btn-primary btn-block btn_log" type="submit">Login</button>
                        </div>
                    </form>
                </div>
          </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>