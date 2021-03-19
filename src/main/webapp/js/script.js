$(document).ready(function() {
  /************************AJAX DE LOGIN**********************************/
 $("#formularioLogin").submit(function(event) {
        event.preventDefault();
        var post_url = $(this).attr("action");
        var dni = $("#dni").val();
        var legajo = $("#legajo").val();
        var password = $("#password").val();
        var rol = $("#rol").val();
        $.ajax({
            type: 'POST',
            url: post_url,
            data: {
                dni: dni,
                legajo: legajo,
                password: password,
                rol: rol
            }
        }).done(function(datosLogin) {
            console.log(datosLogin);
            $("#dniVacio").html("");
            $("#legajoVacio").html("");
            $("#passwordVacio").html("");
            $("#rolVacio").html("");
            $("#errorLogin").html("");
            if (datosLogin.dniVacio == true) {
                $("#dniVacio")
                    .html('<div class="alert alert-danger alert-dismissible fade show mt-2" role="alert"><strong>Debe completar dni.</strong><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div>');
            }
            if (datosLogin.legajoVacio == true) {
                $("#legajoVacio")
                    .html('<div class="alert alert-danger alert-dismissible fade show" role="alert"><strong>Debe completar legajo.</strong><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div>');
            }
            if (datosLogin.passwordVacio == true) {
                $("#passwordVacio")
                    .html('<div class="alert alert-danger alert-dismissible fade show" role="alert"><strong>Debe completar password.</strong><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div>');
            }
            if (datosLogin.rolVacio == true) {
                $("#rolVacio")
                    .html('<div class="alert alert-danger alert-dismissible fade show" role="alert"><strong>Debe completar rol.</strong><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div>');
            }
            if (datosLogin.errorLogin == true) {
                $("#errorLogin")
                    .html('<div class="alert alert-danger alert-dismissible fade show" role="alert"><strong>DNI/legajo/contrasenia/tipo incorrecto.</strong><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div>');
            }

            if(datosLogin.legajoVacio== false && datosLogin.passwordVacio == false && datosLogin.rolVacio == false && datosLogin.errorLogin == false 
                && datosLogin.dniVacio == false){
                    console.log("sdas");
                window.location = "/ChallengeAlkemy/home";
            }
            
        }).fail(function() {
            console.log("error al cargar AJAX login");
        });
    });

});