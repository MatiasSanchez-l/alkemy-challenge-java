package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.User;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositoryUser {
	
	User consultarUsuario (User usuario);

	User getUserById(Long id);
}
