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
                window.location = "/ChallengeAlkemy/home";
            }
            
        }).fail(function() {
            console.log("error al cargar AJAX login");
        });
    });

    /************************AJAX DE INSCRIPCION A MATERIAS**********************************/
 $("#formularioInscripcion").submit(function(event) {
    event.preventDefault();
    var post_url = $(this).attr("action");
    var subjectIds = $(this).serialize();
    var subjectIdsArray = [];
    $.each($("input[id^='materiaAInscribirse']:checked"), function(){            
        subjectIdsArray.push($(this).val());
    });


    $.ajax({
        type: 'POST',
        url: post_url,
        data: {
            subjectIds: subjectIds,
        }
    }).done(function(datosEnroll) {
       
        $("#admin").html("");
        $("#enrolled").html("");
        if (datosEnroll.enrolled == true) {
            $("#enrolled")
                .html('<div class="alert alert-success alert-dismissible fade show mt-2" role="alert"><strong>Se inscribio correctamente!</strong><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div>');

                for (let i = 0; i < subjectIdsArray.length; i++) {
                    var subjectId = "#tr"+subjectIdsArray[i];
                    console.log(subjectId);
                    $(subjectId).hide();
                }
        }

        if (datosEnroll.enrolled == false) {
            $("#enrolled")
                .html('<div class="alert alert-danger alert-dismissible fade show mt-2" role="alert"><strong>Ocurrio un error en la inscripcion.</strong><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div>');
        }

        if (datosEnroll.admin == true) {
            $("#admin")
                .html('<div class="alert alert-danger alert-dismissible fade show mt-2" role="alert"><strong>Los admins no se pueden inscribir a materias.</strong><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div>');
        }
        
        
    }).fail(function() {
        console.log("error al cargar AJAX inscripcion");
        });
    });
});