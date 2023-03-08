<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>(400) Bad request.</title>
  <link rel="shortcut icon" href="./assets/f.png"/>
  <style type="text/css">
    html,
    body {
      margin: 0;
      padding: 0;
      height: 100%;
    }

    body {
      font-family: "Whitney SSm A", "Whitney SSm B", "Helvetica Neue", Helvetica, Arial, Sans-Serif;
      background-color: #ED6666;
      color: #fff;
      -moz-font-smoothing: antialiased;
      -webkit-font-smoothing: antialiased;
    }

    .error-container {
      text-align: center;
      height: 100%;
    }

    @media (max-width: 480px) {
      .error-container {
        position: relative;
        top: 50%;
        height: initial;
        -webkit-transform: translateY(-50%);
        -ms-transform: translateY(-50%);
        transform: translateY(-50%);
      }
    }

    .error-container h1 {
      margin: 0;
      font-size: 130px;
      font-weight: 300;
    }

    @media (min-width: 480px) {
      .error-container h1 {
        position: relative;
        top: 50%;
        -webkit-transform: translateY(-50%);
        -ms-transform: translateY(-50%);
        transform: translateY(-50%);
      }
    }

    @media (min-width: 768px) {
      .error-container h1 {
        font-size: 220px;
      }
    }

    .return {
      color: white;
      font-weight: 400;
      letter-spacing: -0.04em;
      margin: 0;
    }

    @media (min-width: 480px) {
      .return {
        position: absolute;
        width: 100%;
        bottom: 30px;
      }
    }

    .return a {
      padding-bottom: 1px;
      color: #1A2D68;
      text-decoration: none;
      border-bottom: 1px solid #1A2D68;
      -webkit-transition: border-color 0.1s ease-in;
      transition: border-color 0.1s ease-in;
    }

    .return a:hover {
      border-bottom-color: #fff;
    }
  </style>

<body class="vsc-initialized">
  <div class="error-container">
    <h1>404</h1>
    <p class="return">Something went wrong with the transfer. Check the values entered. <br> Take me back to <strong><a href="DashboardController?ruta=ver">dashboard</a></strong></p>
  </div>
</body>
</html>