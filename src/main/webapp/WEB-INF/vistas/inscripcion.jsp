<%@ include file="header.jsp" %>
	<main>
		<div class = "container">
			<h1>Inscripci&oacute;n a materias</h1>
			<div class="col-12">
            	<h4 class="text-center"><span class="text-info">*</span>Materias Disponibles</h4>
            	<c:if test="${not empty subjects}">
            		<form action="validarInscripcion" method="POST" id="formularioInscripcion">
             		<div class="table-responsive">
                		<table class="table" id="mydatatableChoferProforma">
                    		<thead class="thead-dark">
                    			<tr>
                    				<th scope="col">Nombre</th>
                        			<th scope="col">Horario</th>
                        			<th scope="col">Turno</th>
                        			<th scope="col">Cupos</th>
                        			<th scope="col"><i class="fas fa-check-circle"></i></th>
                  				</tr>
                    		</thead>
                    		<tbody>
                    			<c:forEach items="${subjects}" var="subject">
                    			<c:if test="${subject.getMax_places() > 0}">
                        		<tr>
                        			<td><a href="/ChallengeAlkemy/materia/descripcion?id=${subject.getId()}">${subject.getName()}</a></td>
                            		<td>${subject.getStart_time()}:00 - ${subject.getFinish_time()}:00</td>
                            		<td>${subject.getShift()}</td>
                            		<td>${subject.getMax_places()}</td>
                            		<td>
                            			<div class="form-check text-center">
                            				<input class="form-check-input" type="checkbox" name="materiaAInscribirse" id="materiaAInscribirse${subject.getId()}" value="${subject.getId()}">
                                			<label class="form-check-label" for="materiaAInscribirse${subject.getId()}">
                                			</label>
                           				</div>
                            		</td>
                       			</tr>
                       			</c:if>
                        		</c:forEach>
                			</tbody>
            			</table>
        			</div>
        			<div class="text-right">
        				<input type="hidden" value="${usuarioLogueado.getId()}" name="usuarioLogueadoId" id="usuarioLogueadoId">
        				<button type="submit" class="button btn-info">Inscribirse</button>
        			</div>
        			</form>
        		</c:if>
        		<c:if test="${empty subjects}">
        			<p>No se encuentran materias disponibles por el momento.</p>
        		</c:if>
       		</div>
		</div>
	</main>
<%@ include file="footer.jsp" %>