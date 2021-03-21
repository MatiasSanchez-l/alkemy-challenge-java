<%@ include file="header.jsp" %>
	<main>
		<div class = "container">
			<h1>Materias en curso</h1>
			<c:if test="${empty subjects}"><p>No te encuentras en ninguna materia.</p></c:if>
			<c:if test="${not empty subjects}">
				<div class="album py-5 contenedorAlbum">
                    <div class="container">
                        <div class="row text-center">
                            <c:forEach items="${subjects}" var="subject">
                                <div class="col-12 col-md-4 mb-2 mt-2 card">
                                    <div class="border-info card-body" style="height: fit-content;">
                                        <a class="card-title" href="/ChallengeAlkemy/materia/descripcion?id=${subject.getId()}">${subject.getName()}</a>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
			</c:if>
		</div>
	</main>
<%@ include file="footer.jsp" %>