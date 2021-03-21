<%@ include file="header.jsp" %>
	<main>
		<div class = "container">
			<h1 class="text-center">Materia</h1>
			<h2>${subject.getName()}</h2>
			<p>Horario: ${subject.getStart_time()}:00 - ${subject.getFinish_time()}:00 hs</p>
			<p>Turno: ${subject.getShift()}</p>
			<p>${subject.getDescription()}</p>
		</div>
	</main>
<%@ include file="footer.jsp" %>