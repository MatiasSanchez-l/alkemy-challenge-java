<%@ include file="header.jsp" %>
	<main>
		<div class = "container">
			<h1>${subject.getName()}</h1>
			<p>Horario: ${subject.getStart_time()}:00 - ${subject.getFinish_time()}:00 hs</p>
			<p>Turno: ${subject.getShift()}</p>
			<p>${subject.getDescription()}</p>
		</div>
	</main>
<%@ include file="footer.jsp" %>