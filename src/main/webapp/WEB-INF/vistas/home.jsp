<%@ include file="header.jsp" %>
	<main>
		<div class = "container">
			<c:if test="${usuarioLogueado.getRol().getDescription() == 'student'}">
				<h1 class="text-center mt-2 mb-5">Bienvenido alumno ${usuarioLogueado.getName()}!</h1>
			</c:if>
			<c:if test="${usuarioLogueado.getRol().getDescription() == 'admin'}">
				<h1 class="text-center mt-2 mb-5">Bienvenido admin ${usuarioLogueado.getName()}!</h1>
			</c:if>
			<div class="d-flex flex-wrap justify-content-around">
				<c:if test="${usuarioLogueado.getRol().getDescription() == 'admin'}">
					<a type="button" class="btn btn-info m-2" href="/ChallengeAlkemy/administrar">Administrar</a>
				</c:if>
				<a type="button" class="btn btn-info m-2" href="/ChallengeAlkemy/inscripcion">Inscribirse</a>
				<a type="button" class="btn btn-info m-2" href="/ChallengeAlkemy/materia">Materias</a>
			</div>
		</div>
	</main>
<%@ include file="footer.jsp" %>