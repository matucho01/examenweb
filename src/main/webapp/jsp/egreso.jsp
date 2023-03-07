<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense</title>
<link rel="stylesheet" href="./css/dashboard.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body class="bg-color">
   <header class="d-flex align-items-center bg-zul">
        <img class="logo p-2" src="./assets/logo.png" alt="logo de la aplicación fluxe">
            <ul class="list-inline d-flex mt-5">
                <li><a href="DashboardController?ruta=ver" class="enlace list-inline-item m-2">Dashboard</a></li>
                <li><a href="RegistrarMovimientoController?ruta=ingreso" class="enlace list-inline-item m-2">Incomes</a></li>
            </ul>
        <div class="ms-auto me-4 p-2 fa-solid fa-user-circle fa-4x"></div>
    </header>
    <div class="container bg-zul w-50 mt-5 border-bottom rounded position-absolute top-50 start-50 translate-middle h-75">
        <div>
            <div class="titulo mt-5">Add a new expense</div>
            <hr class="mb-5">
            <form method="POST" action="RegistrarMovimientoController?ruta=guardarEgreso">
                <fieldset>
                    <div class="start-0 top-50 ms-3">
                        <label class="enlace fw-bold me-3">Concept</label>
                        <input type="text" name="concepto" class="border rounded w-50 mt-3 mb-4 p-2" placeholder="p.ej. Transporte, helado, hamburguesa" required>
                    </div>
                    <div class="d-flex flex-column ">
                        <div class="d-flex justify-content-center mt-2 mb-5">
                            <label class="enlace fw-bold ms-2">Source account</label>
                            <select name="cuentaingresoegreso" class="border rounded w-50 mt-2 me-3">
                                <c:forEach items="${cuentasingresoegreso}" var="cuentaingresoegreso">
                                    <option value="${cuentaingresoegreso.id}" >${cuentaingresoegreso.nombre}</option>
                                </c:forEach>
                            </select>
    
                            <label class="enlace fw-bold me-2">Destination account </label>
                            <select  name="cuentasegreso" class="border rounded mt-2 w-50" >
                                <c:forEach items="${cuentasegreso}" var="cuentaegreso">
                                    <option value="${cuentaegreso.id}" >${cuentaegreso.nombre}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="d-flex w-100">
                            <div class="col-6 ms-2">
                                <label class="enlace fw-bold me-3">Amount</label>
                                <input type="number" name="valor" step=".01" min="0" class="border rounded mt-3 w-50 p-2" id="" placeholder="25.0" required>
                            </div>
                            <div class="me-4 col-6">
                                <label class="enlace fw-bold me-4">Date</label>
                                <input type="date" name="fecha" class="p-2 border rounded mt-3 ms-3 w-50" required>
                            </div>
                        </div>
                        <br>
                        <div class="w-100 d-flex justify-content-center">
                        	<input type="submit" value="Save" class="border rounded w-25 fw-bold m-2 guardar">
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
    <script src="https://kit.fontawesome.com/222f6f8069.js" crossorigin="anonymous"></script>
</body>
</html>