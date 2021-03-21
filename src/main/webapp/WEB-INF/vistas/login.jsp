<%@ include file="header.jsp" %>
	<main>
		 <div class="container" id="login">
            <div class="row">
                <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                    <div class="card card-signin m-3">
                        <div class="card-body">
                            <h4 class="card-title text-center border-bottom">Iniciar sesi&oacute;n
                            </h4>
                            <h5 class="text-danger" id="dniVacio"></h5>
        					<h5 class="text-danger" id="legajoVacio"></h5>
        					<h5 class="text-success" id="passwordVacio"></h5>
        					<h5 class="text-success" id="rolVacio"></h5>
        					<h5 class="text-success" id="errorLogin"></h5>
                            <form action="validar-login" method="POST" id="formularioLogin" class="form-signin">

                                <div class="form-label-group  mb-4">
                                	<label for="dni">*DNI</label>
                                    <input id="dni" name="dni" type="number" class="form-control" placeholder="45621546" />
                                </div>
                                
                                <div class="form-label-group mb-4">
                                	<label for="legajo">*Legajo</label>
                                    <input id="legajo" name="legajo" type="number" class="form-control" placeholder="100" />
                                </div>

                                <div class="form-label-group mb-4">
                                	<label for="password">*Contrasenia</label>
                                    <input type="password" id="password" name="password" class="form-control" placeholder="Contrasenia123" />
                                </div>
                                <div class="form-label-group mb-4">
    								<label for="rol">*Tipo</label>
    								<select class="form-control text-dark" id="rol" name="rol">
    									<option value="admin">Admin</option>
      									<option value="student" selected>Alumno</option>
    								</select>
 							 	</div>
								<button class="btn btn-lg btn-primary btn-block text-uppercase bg-info" type="submit">Iniciar
                                    sesi&oacute;n</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
	</main>
<%@ include file="footer.jsp" %>
