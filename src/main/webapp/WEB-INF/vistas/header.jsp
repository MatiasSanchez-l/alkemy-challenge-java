<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1" %>
            <!DOCTYPE html>
            <html lang="es">
				<head>
					<meta charset="ISO-8859-1">
					<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
					<title>${title}</title>
					<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
					<script 
						src="https://code.jquery.com/jquery-3.6.0.js"
						integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
						crossorigin="anonymous">
					</script>
				</head>
				<body>
					<div>
					<nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom border-secondary">
  						<a class="navbar-brand" href="/ChallengeAlkemy/home">Alkemy</a>
  						<c:if test="${not empty usuarioLogueado}">
  							<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    							<span class="navbar-toggler-icon"></span>
 						 	</button>
  							<div class="collapse navbar-collapse justify-content-end" id="navbarNav">
    							<ul class="navbar-nav">
    								<li class="nav-item">
    									<a class="nav-link font-weight-bold">${usuarioLogueado.getName()} ${usuarioLogueado.getLastname()}</a>
    								</li>
    								<c:if test="${usuarioLogueado.getRol().getDescription() == 'admin'}">
      									<li class="nav-item">
        									<a class="nav-link" href="/ChallengeAlkemy/administrar">Administrar</a>
      									</li>
      								</c:if>
    								<c:if test="${usuarioLogueado.getRol().getDescription() == 'student' || usuarioLogueado.getRol().getDescription() == 'admin'}">
      									<li class="nav-item">
        									<a class="nav-link" href="/ChallengeAlkemy/inscripcion">Inscripci&oacute;n a Materias</a>
      									</li>
      									<li class="nav-item">
        									<a class="nav-link" href="/ChallengeAlkemy/materia">Ver Materias</a>
      									</li>
      									<li class="nav-item">
        									<a class="nav-link" href="/ChallengeAlkemy/materias-inscriptas">Materias En Curso</a>
      									</li>
      								</c:if>
      								<li class="nav-item">
        								<a class="nav-link active" href="cerrarSesion">Cerrar sesi&oacute;n</a>
      								</li>
    							</ul>
  							</div>
  						</c:if>
					</nav>
				</div>