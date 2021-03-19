package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.User;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioLogin {

	User consultarUsuario(User usuario);
}
