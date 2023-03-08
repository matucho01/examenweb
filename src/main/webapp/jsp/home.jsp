<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Home</title>
<link rel="shortcut icon" href="./assets/f.png" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link rel="stylesheet" href="./css/home.css">
</head>
<header>
	<div class="container-fluid barra">
		<div class="row justify-content-between">
			<div class="col-2 sm-3 logo">
				<img src="./images/Logo_Home.png">
			</div>
			<div class="col-6 sm-6 d-flex justify-content-end">
				<button class="btn button-login" type="submit"
					onclick="location.href='DashboardController?ruta=login'">Login</button>
			</div>
		</div>
	</div>
</header>
<body>
	<div class="">
		<div class="sombra"></div>
		<div class="sombra2"></div>
		<div class="d-flex justify-content-center">
			<img class="ms-5 mt-4 home-img" src="./images/img_home.png" alt="">
			<div>
				<h1 class="ms-4 mt-4 me-4 c-red">Discover your finances</h1>
				<p class="ms-4 me-5 c-white">
					fluxé helps you manage your money <br> <b>quickly</b> and <b
						class="">easily</b>.
				</p>
				<p class="ms-4 me-5 c-blue">
					<b>Managing your money has never been so easy</b>. <br> <br>
				</p>
				<p class="ms-4 me-5 c-white">
					If you have never done it, it is time to start and <br> have a
					good relationship with your money. <br> <br>
				</p>
				<p class="ms-4 me-5 c-blue">
					<b>Invest</b>, <b>analyze</b> and <b>decide</b> with us.
				</p>

			</div>
		</div>
		<h1 class="ms-4 mt-4 me-4 c-red">Our services</h1>
		<div class="d-flex justify-content-evenly carrusel ">
			<div class="">
				<div class="img-car">
					<img src="./images/img_pago.png" alt="">
				</div>
				<p class="w-75 fs-5">Transfer between accounts without
					limitations</p>
			</div>
			<div class="">
				<div class="img-car">
					<img src="./images/img_dinero.png" alt="">
				</div>
				<p class="w-75 fs-5">Create accounts for your different
					necessities</p>
			</div>
			<div>
				<div class="img-car">
					<img src="images/img_finanzas.png" alt="">
				</div>
				<p class="w-75 fs-5">Summary of your money in real time</p>
			</div>
		</div>
	</div>
</body>
</html>