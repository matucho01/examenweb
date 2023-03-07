<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fluxé | Tu amigo en finanzas</title>
<link rel="stylesheet" href="./css/dashboard.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
	<header class="d-flex align-items-center bg-zul">
		<img class="logo p-2" src="./assets/logo.png"
			alt="logo de la aplicación fluxe">
		<ul class="list-inline d-flex mt-5">
			<li><a href="DashboardController?ruta=ver"
				class="enlace list-inline-item m-2">Dashboard</a></li>
			<li><a href="RegistrarMovimientoController?ruta=ingreso"
				class="enlace list-inline-item m-2">Incomes</a></li>
			<li><a href="RegistrarMovimientoController?ruta=egreso"
				class="enlace list-inline-item m-2">Expenses</a></li>
		</ul>
		<div class="ms-auto me-4 p-2 fa-solid fa-user-circle fa-4x"></div>
	</header>
	<div>
		<form method="get" action="DashboardController?ruta=ver">
			<span class="ms-2 me-2 fs-subtext fw-bold">Mes:</span> <select name="mes"
				class="border rounded">
				<c:forEach items="${meses}" var="mes">
					<option value="${mes.id}"
						${mes.id== messeleccionado ? 'selected':''}>${mes.nombre}</option>
				</c:forEach>	
			</select>
			<input type="submit" value="Save" >
		</form>
	</div>
	
	<div class="mt-3 mb-3 bg-zul">
		<h2 class="titulo">Incomes and Expenses</h2>
	</div>
	<div class="cards d-flex overflow-x-auto">
		<c:forEach items="${ingresogastos}" var="ingresogasto">
			<div class="m-4 mt-0">
				<div class="d-flex justify-content-between align-items-center mb-0">
					<h2 class="title-card m-2 me-4 mb-0">${ingresogasto.nombre}</h2>
					<div class="fa-solid fa-file-invoice fa-2x ms-5 me-3"></div>
				</div>
				<div
					class="ms-1 mt-3 mb-1 d-flex justify-content-between align-items-center">
					<div class="fs-subtext ms-2">Total</div>
					<div class="content-card c-green">$${ingresogasto.total}</div>
				</div>
			</div>
		</c:forEach>
	</div>
	
	<div class="mt-3 mb-3 bg-zul">
		<h1 class="titulo mt-2">Income</h1>
	</div>
	<div class="cards d-flex overflow-x-auto">
		<c:forEach items="${ingresos}" var="ingreso">
			<div class="m-4 mt-0">
				<div class="d-flex justify-content-between align-items-center mb-0">
					<h2 class="title-card m-2 me-4 mb-0">${ingreso.nombre}</h2>
					<div class="fa-solid fa-file-invoice fa-2x ms-5 me-3"></div>
				</div>
				<div
					class="ms-1 mt-3 mb-1 d-flex justify-content-between align-items-center">
					<div class="fs-subtext ms-2">Total</div>
					<div class="content-card c-green">$${ingreso.totalcalculado}</div>
				</div>
			</div>
		</c:forEach>
	</div>

	<div class="mt-3 mb-3 bg-zul">
		<h2 class="titulo">Expenses</h2>
	</div>
	<div class="cards d-flex overflow-x-auto">
		<c:forEach items="${egresos}" var="egreso">
			<div class="m-4 mt-0">
				<div class="d-flex justify-content-between align-items-center mb-0">
					<h2 class="title-card m-2 me-4 mb-0">${egreso.nombre}</h2>
					<div class="fa-solid fa-file-invoice fa-2x ms-5 me-3"></div>
				</div>
				<div
					class="ms-1 mt-3 mb-1 d-flex justify-content-between align-items-center">
					<div class="fs-subtext ms-2">Total</div>
					<div class="content-card c-red">$${egreso.totalcalculado}</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<footer class="d-flex flex-column align-items-center bg-zul mt-4">
		<div class="enlace m-4">Aplicaciones Web</div>
		<div class="fs-subtext m-3">Grupo 6</div>
	</footer>
	<script src="https://kit.fontawesome.com/222f6f8069.js"
		crossorigin="anonymous"></script>
</body>
</html>