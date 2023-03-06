<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <div class="bg-black text-white p-3">Contabilidad Personal</div>
        <div class="bg-body-secondary pt-2 pb-1 ps-2">
            <ul class="list-inline">
                <li class="list-inline-item"><a href="ingreso.html">Ingreso</a></li>
                <li class="list-inline-item"><a href="">Egreso</a></li>
                <li class="list-inline-item"><a href="">Transferencia</a></li>
                <li class="list-inline-item"><a href="dashboard.html">Dashboard</a></li>
            </ul>
        </div>

        <div>
            <h1>Reistro de Ingreso ($$)</h1>

            <form>
                <fieldset class="d-flex flex-column">
                    <label>Categoria Ingreso</label>
                    <select>
                        <option>NOMINA</option>
                    </select>
                    <label>Concepto</label>
                    <input type="text" name="concepto">
                    <label>Fecha</label>
                    <input type="date" name="fecha">
                    <label>Valor</label>
                    <input type="text" name="valor" id="">
                    <label>Cuenta acreditada</label>
                    <select>
                        <option>BANCO</option>
                    </select>
                    <br>
                    <input type="submit" value="Guardar">
                </fieldset>
            </form>
        </div>
    </div>
</body>
</html>