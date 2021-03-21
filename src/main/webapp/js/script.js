$(document).ready(function() {
    /************************MODIFICAR MATERIA**********************************/
    $(document).on("click", ".editarScheduleBoton", function() {
        var schedule = $(this).data('schedule');
        var day = $(this).data('day');
        var startTime = $(this).data('starttime');
        var finishTime = $(this).data('finishtime');
        var shift = $(this).data('shift');
        var maxPlaces = $(this).data('maxplaces');
        var teacher = $(this).data('teacher');
        var name = $(this).data('name');
        
        $.ajax({
            url: 'getTeachersAjax'
        }).done(function(datosTeachers) {
            for(var property in datosTeachers) {
                $(".formularioModificarMateria .inputTeacher").html(datosTeachers[property]);
            }
            $(".formularioModificarMateria .modal-footer #scheduleId").val(schedule);
            $(".formularioModificarMateria .inputName").val(name);
            $(".formularioModificarMateria .inputDay").val(day);
            $(".formularioModificarMateria .inputStartTime").val(startTime);
            $(".formularioModificarMateria .inputFinishTime").val(finishTime);
            $(".formularioModificarMateria .inputShift").val(shift);
            $(".formularioModificarMateria .inputMaxPlaces").val(maxPlaces);
            $(".formularioModificarMateria .inputTeacher").val(teacher);
        }).fail(function() {
            console.log("error al cargar AJAX modal editar materia");
            });
    });
    /************************MODIFICAR PROFESOR**********************************/
    $(document).on("click", ".editarTeacherBoton", function() {
        var name = $(this).data('name');
        var lastName = $(this).data('lastname');
        var dni = $(this).data('dni');
        var id = $(this).data('teacher');

        $(".formularioModificarProfesor .modal-footer #teacherId").val(id);
        $(".formularioModificarProfesor .inputName").val(name);
        $(".formularioModificarProfesor .inputLastname").val(lastName);
        $(".formularioModificarProfesor .inputDni").val(dni);
    });

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

        if (datosEnroll.error == true) {
            $("#admin")
                .html('<div class="alert alert-danger alert-dismissible fade show mt-2" role="alert"><strong>Ocurrio un error en la inscripcion.</strong><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div>');
        }
        
        
    }).fail(function() {
        console.log("error al cargar AJAX inscripcion");
        });
    });
});