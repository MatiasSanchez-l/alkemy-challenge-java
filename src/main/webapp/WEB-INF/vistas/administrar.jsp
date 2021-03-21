<%@ include file="header.jsp" %>
	<main>
        <section class="m-3">
            <article class=" justify-content-center mt-4 ancho2">
                <h1 class="text-dark mb-3 text-center">Administrar</h1>
                <c:if test="${editarMateria == true}">
                	<div class="alert alert-success alert-dismissible fade show mt-2" role="alert">
                		<strong>Se edit&oacute; la materia correctamente!</strong>
                		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                	</div>
                </c:if>
                <c:if test="${editarProfesor == true}">
                	<div class="alert alert-success alert-dismissible fade show mt-2" role="alert">
                		<strong>Se edit&oacute; el/la profesor/a correctamente!</strong>
                		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                	</div>
                </c:if>
                <c:if test="${editarMateria == false}">
                	<div class="alert alert-danger alert-dismissible fade show mt-2" role="alert">
                		<strong>Ocurri&oacute; un error al editar la materia.</strong>
                		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                	</div>
                </c:if>
                <c:if test="${editarProfesor == false}">
                	<div class="alert alert-danger alert-dismissible fade show mt-2" role="alert">
                		<strong>Ocurri&oacute; un error al editar profesor/a.</strong>
                		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                	</div>
                </c:if>
                <h3 class="text-center text-md-left text-dark mb-3"><i class="fas fa-school"></i> Materias</h3>
                <c:if test="${not empty schedules}">
                <div class="table-responsive">
                    <table class="table table-bordered" id="mydatatableSchedule">
                    	<thead class="thead-dark">
                    		<tr>
                    			<th scope="col">Nombre</th>
                    			<th scope="col">Dia</th>
                        		<th scope="col">Horario</th>
                        		<th scope="col">Turno</th>
                        		<th scope="col">Profesor</th>
                        		<th scope="col">Cupos</th>
                        		<th></th>
                  			</tr>
                    	</thead>
                        <tbody>
                    			<c:forEach items="${schedules}" var="schedule">
                    			 <c:set var="subject" value="${schedule.getSubject()}"></c:set>
                    			 <c:set var="day" value="${schedule.getDay()}"></c:set>
                        		<tr>
                        			<td><a href="/ChallengeAlkemy/materia/descripcion?id=${subject.getId()}">${subject.getName()}</a></td>
                        			<td>${day.getDescription()}</td>
                            		<td>${subject.getStart_time()}:00 - ${subject.getFinish_time()}:00</td>
                            		<td>${subject.getShift()}</td>
                            		<td>${schedule.getTeacher().getLastname()} ${schedule.getTeacher().getName()}</td>
                            		<td>${subject.getMax_places()}</td>
                            		<td class="dropdown dropleft text-center">
                            			<a class="btn btn-outline-info dropdown-toggle" href="#" role="button" id="dropdownMenuLink${schedule.getId()}" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            			</a>
                            				<div class="dropdown-menu dropdown-menu-right p-2" aria-labelledby="dropdownMenuLink${schedule.getId()}">
                                				<a class="btn btn-success text-light editarScheduleBoton" id="editarSchedule${schedule.getId()}"
                                				 data-toggle="modal" data-target="#editarScheduleModal"  data-schedule="${schedule.getId()}"
                                				 data-name="${subject.getName()}" data-day="${day.getId()}" data-starttime="${subject.getStart_time()}"
                                				 data-finishtime="${subject.getFinish_time()}" data-shift="${subject.getShift()}" data-teacher="${schedule.getTeacher().getId()}"
                                				 data-maxplaces="${subject.getMax_places()}" data-teacher="${schedule.getTeacher().getId()}" type="button">Editar</a>
                            				</div>
                        			</td>
                       			</tr>
                        		</c:forEach>
                			</tbody>
                        <tfoot class="thead-dark">
                        	<tr>
                    			<th scope="col">Nombre</th>
                    			<th scope="col">Dia</th>
                        		<th scope="col">Horario</th>
                        		<th scope="col">Turno</th>
                        		<th scope="col">Profesor</th>
                        		<th scope="col">Cupos</th>
                        		<th></th>
                  			</tr>
                        </tfoot>
                    </table>
                </div>
                </c:if>
            </article>
          	<article class=" justify-content-center mt-4 ancho2">
                <h3 class="text-center text-md-left text-dark mb-3"><i class="fas fa-chalkboard-teacher"></i> Profesores</h3>
                <c:if test="${not empty teachers}">
                <div class="table-responsive">
                    <table class="table table-bordered" id="mydatatableSchedule">
                    	<thead class="thead-dark">
                    		<tr>
                    			<th scope="col">Nombre</th>
                    			<th scope="col">Apellido</th>
                        		<th scope="col">DNI</th>
                        		<th scope="col">Activo</th>
                        		<th></th>
                  			</tr>
                    	</thead>
                        <tbody>
                    			<c:forEach items="${teachers}" var="teacher">
                        		<tr>
                        			<td>${teacher.getName()}</td>
                            		<td>${teacher.getLastname()}</td>
                            		<td>${teacher.getDni()}</td>
                            		<c:if test="${teacher.getActive() == true}">
                            			<td>si</td>
                            		</c:if>
                            		<c:if test="${teacher.getActive() == false}">
                            			<td>no</td>
                            		</c:if>
                            		<td class="dropdown dropleft text-center">
                            			<a class="btn btn-outline-info dropdown-toggle" href="#" role="button" id="dropdownMenuLink${teacher.getId()}" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            			</a>
                            				<div class="dropdown-menu dropdown-menu-right p-2" aria-labelledby="dropdownMenuLink${teacher.getId()}">
                                				<a class="btn btn-success text-light editarTeacherBoton" id="editarSchedule${schedule.getId()}"
                                				 data-toggle="modal" data-target="#editarTeacherModal"  data-teacher="${teacher.getId()}"
                                				 data-name="${teacher.getName()}" data-lastname="${teacher.getLastname()}"
                                				 data-dni="${teacher.getDni()}" data-active="${teacher.getActive()}" type="button">Editar</a>
                            				</div>
                        			</td>
                       			</tr>
                        		</c:forEach>
                			</tbody>
                        <tfoot class="thead-dark">
                        	<tr>
                    			<th scope="col">Nombre</th>
                    			<th scope="col">Apellido</th>
                        		<th scope="col">DNI</th>
                        		<th scope="col">Activo</th>
                        		<th></th>
                  			</tr>
                        </tfoot>
                    </table>
                </div>
                </c:if>
            </article>
        </section>
        <section>
            <div class="modal fade" id="editarScheduleModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title text-dark" id="staticBackdropLabel">Modificar Materia</h5>
                            <button type="button" class="close text-dark" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body container">
                            <form class="formularioModificarMateria" id="formularioModificarMateria" method="POST" action="editarMateria">
                                <div class="form-group">
                                    <label class="text-dark" for="name">Nombre</label>
                                    <input type="text" class="form-control inputName" id="name" name="name" required>
                                </div>
                                <div class="form-group">
                                    <label class="text-dark" for="day">Dia</label>
                                    <select class="form-control text-dark inputDay" id="day" name="day" required>
    									<option value="1">Lunes</option>
      									<option value="2">Martes</option>
      									<option value="3">Miercoles</option>
      									<option value="4">Jueves</option>
      									<option value="5">Viernes</option>
      									<option value="6">Sabado</option>
    								</select>
                                </div>
                                <div class="form-group">
                                    <label class="text-dark" for="startTime">Hora de inicio</label>
                                    <input type="number" class="form-control inputStartTime" id="startTime" name="startTime" required>
                                </div>
                                <div class="form-group">
                                    <label class="text-dark" for="finishTime">Hora de fin</label>
                                    <input type="number" class="form-control inputFinishTime" id="finishTime" name="finishTime" required>
                                </div>
                                <div class="form-group">
                                    <label class="text-dark" for="shift">Turno</label>
                                    <select class="form-control text-dark inputShift" id="shift" name="shift" required>
    									<option value="maniana">Maniana</option>
      									<option value="tarde" selected>Tarde</option>
    								</select>
                                </div>
                                <div class="form-group">
                                    <label class="text-dark" for="teacher">Profesor</label>
                                    <select class="form-control text-dark inputTeacher" id="teacher" name="teacher" required>
    								</select>
                                </div>
                                <div class="form-group">
                                    <label class="text-dark" for="maxPlaces">Cupos</label>
                                    <input type="number" class="form-control inputMaxPlaces" id="maxPlaces" name="maxPlaces" required>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Volver</button>
                                    <input type="hidden" id="scheduleId" name="scheduleId"></label>
                                    <button type="submit" class="btn btn-outline-info">Editar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="editarTeacherModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title text-dark" id="staticBackdropLabel">Modificar Profesor</h5>
                            <button type="button" class="close text-dark" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body container">
                            <form class="formularioModificarProfesor" method="POST" action="editarProfesor">
                                <div class="form-group">
                                    <label class="text-dark" for="name">Nombre</label>
                                    <input type="text" class="form-control inputName" id="name" name="name" required>
                                </div>
                                <div class="form-group">
                                    <label class="text-dark" for="lastname">Apellido</label>
                                    <input type="text" class="form-control inputLastname" id="lastname" name="lastname" required>
                                </div>
                                <div class="form-group">
                                    <label class="text-dark" for="dni">DNI</label>
                                    <input type="text" class="form-control inputDni" id="dni" name="dni" required>
                                </div>
                                <div class="form-group">
                                    <label class="text-dark" for="active">Activo</label>
                                    <div class="form-check">
          								<input class="form-check-input inputActive" type="radio" name="active" id="active1" value="true" checked="checked">
          								<label class="form-check-label" for="active1">
            								Si
          								</label>
        							</div>
        							<div class="form-check">
          								<input class="form-check-input inputActive" type="radio" name="active" id="active2" value="false">
          								<label class="form-check-label" for="active2">
            								No
          								</label>
        							</div>
      							</div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Volver</button>
                                   	<input type="hidden" id="teacherId" name="teacherId">
                                    <button type="submit" class="btn btn-outline-info">Modificar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
        </section>
    </main>
<%@ include file="footer.jsp" %>