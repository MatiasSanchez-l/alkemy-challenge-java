<%@ include file="header.jsp" %>
	<main>
		<div class = "container">
			<h1>Materias</h1>
			 <c:if test="${not empty subjects}">
                <div class="album py-5 contenedorAlbum">
                    <div class="container">
                        <div class="row text-center">
                            <c:forEach items="${subjects}" var="subject">
                                <div class="col-12 col-md-4">
                                    <div style="height: fit-content;">
                                        <a href="#">${subject.getName()}</a>
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