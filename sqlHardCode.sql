use databas;

insert into day(id, description)
value(1, 'lunes'),
(2,'martes'),
(3,'miercoles'),
(4,'jueves'),
(5,'viernes'),
(6,'sabado');

insert into rol(id, description)
value(1, 'admin'),
(2,'student');

insert into teacher(id, active, dni, lastname, name)
value(1, true,700, 'Pereira', 'Juan'),
(2, true,701, 'Jimenez', 'Graciela'),
(3, true,702, 'Gonzales', 'Luciano');

insert into subject(id, finish_time, max_places, name, shift, start_time, description, teacher_id)
value(1, 11, 20, 'Programacion Basica I', 'maniana', 8, 'El programa de la asignatura pretende introducir al alumno en la programación
estructurada y orientada objetos, de manera de capacitarlos en lenguajes, herramientas y
metodologías de programación básicas', 2),
(2, 11, 1, 'Informatica', 'maniana', 8, 'Familiarizar al alumno en los conceptos y términos básicos para obtener
conocimientos referidos a las tecnologías de la información y las comunicaciones.', 3),
(3, 10, 20, 'Base de Datos I', 'tarde', 6, 'El programa de la asignatura pretende introducir al alumno en los conceptos, modelado,
consultas y utilización de base de datos relacionales usados como almacenamiento de
datos y procedimientos para sitios Web.', 2),
(4, 11, 20, 'Programacion Web I', 'maniana', 8, 'El	programa	de	la	asignatura	pretende	introducir	al	alumno	en	el	programación	Web,	de	
manera	de	capacitarlos en	lenguajes,	herramientas	y	metodologías indispensables	para	el
desarrollo	Web.', 1);

insert into schedule(day_id, subject_id, teacher_id)
value(2,1, 3),
(1,2, 2),
(6,3, 1),
(4,4, 2);

insert into user(id, dni, lastname, legajo, name, password, rol_id)
value(1, 100, 'Sanchez', 1, 'Matias', 'student',2),
(2, 101, 'Fagliano', 2,'Santiago', 'admin',1);

select * from day;
select * from enroll;
select * from rol;
select * from subject;
select * from teacher;
select * from user;
select * from schedule;